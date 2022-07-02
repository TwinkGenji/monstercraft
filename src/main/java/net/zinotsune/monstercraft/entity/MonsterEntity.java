package net.zinotsune.monstercraft.entity;

import java.util.UUID;

import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.zinotsune.monstercraft.MonsterCraftMod;
import net.zinotsune.monstercraft.item.KinshipStoneItem;

public abstract class MonsterEntity extends TameableEntity implements Angerable {
	@Nullable
	private UUID angryAt;
	private int angerTime;

	public MonsterEntity(EntityType<? extends MonsterEntity> entityType, World world) {
		super(entityType, world);
		// TODO: parts (use Ender Dragon as reference)
	}

	public abstract float getWildMaxHealth();
	public abstract float getTameMaxHealth();
	public abstract Item getTameItem();
	public abstract boolean isTameItem(Item item);
	public abstract boolean canBeTamed();

	public int getFoodHealth(Item item) {
		try {
			return item.getFoodComponent().getHunger();
		} catch (NullPointerException x) {
			return 0;
		}
	}

	@Override
	public int getAngerTime() {
		return angerTime;
	}

	@Override
	public void setAngerTime(int time) {
		angerTime = time;
	}

	@Override
	public UUID getAngryAt() {
		return angryAt;
	}

	@Override
	public void setAngryAt(UUID target) {
		angryAt = target;
	}

	@Override
	public void chooseRandomAngerTime() {
		setAngerTime(300);
	}

	@Override
	public PassiveEntity createChild(ServerWorld world, PassiveEntity child) {
		// override this on subclasses that can breed
		return null;
	}

	@Override
	public void setTamed(boolean tamed) {
		super.setTamed(tamed);
		if (tamed) {
			getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(getTameMaxHealth());
			setHealth(getTameMaxHealth());
		} else {
			getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(getWildMaxHealth());
		}
	}

	@Override
	public ActionResult interactMob(PlayerEntity player, Hand hand) {
		ItemStack stack = player.getStackInHand(hand);
		// account for lag
		if (world.isClient) {
			return isTamed() || (isTameItem(stack.getItem()) && !isTamed() && !hasAngerTime()) ? ActionResult.CONSUME : ActionResult.PASS;
		}
		// taming item
		if (isTameItem(stack.getItem()) && !isTamed()) {
			if (canBeTamed()) {
				setOwner(player);
				navigation.stop();
				setTarget(null);
				//setSitting(true);
				linkKinshipStone(player, stack);
				world.sendEntityStatus(this, EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES);
			} else {
				world.sendEntityStatus(this, EntityStatuses.ADD_NEGATIVE_PLAYER_REACTION_PARTICLES);
			}
		}
		// food item
		// using vanilla behavior so this is mutually exclusive with breeding
		else if (isBreedingItem(stack) && isTamed() && getHealth() < getMaxHealth()) {
			if (!player.getAbilities().creativeMode) {
				stack.decrement(1);
			}
			heal(getFoodHealth(stack.getItem()));
			return ActionResult.SUCCESS;
		}
		// breeding item
		else if (isBreedingItem(stack)) {
			// TODO: breeding (seriously this code is a mess)
		}
		return super.interactMob(player, hand);
	}

	protected void linkKinshipStone(PlayerEntity player, ItemStack stone) {
		if (stone.getItem() instanceof KinshipStoneItem) {
			NbtCompound nbt = stone.getOrCreateNbt();
			nbt.putUuid("MonstieUUID", getUuid());
			nbt.putUuid("OwnerUUID", player.getUuid());
			stone.setNbt(nbt);
		}
	}
}
