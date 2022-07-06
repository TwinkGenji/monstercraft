package net.zinotsune.monstercraft.item;

import java.util.List;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.zinotsune.monstercraft.MonsterCraftItems;
import net.zinotsune.monstercraft.entity.MonsterEntity;

public class KinshipStoneItem extends Item {

	private MonsterEntity monstie;

	public KinshipStoneItem(Settings settings) {
		super(settings.group(MonsterCraftItems.KINSHIP_STONES));
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext ctx) {
		super.appendTooltip(stack, world, tooltip, ctx);
		NbtCompound nbt = stack.getOrCreateNbt();
		if (nbt.containsUuid("OwnerUUID")) {
			PlayerEntity owner = world.getPlayerByUuid(nbt.getUuid("OwnerUUID"));
			// TODO: cache player name to account for offline players
			Text ownerName = owner == null ? Text.literal("???") : owner.getName();
			tooltip.add(Text.translatable("item.monstercraft.kinship_stone.tooltip", ownerName).formatted(Formatting.AQUA));
		}
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		NbtCompound nbt = user.getStackInHand(hand).getOrCreateNbt();
		// return early if the stone is unused or doesn't belong to its holder
		if ((!nbt.containsUuid("OwnerUUID") || !nbt.getUuid("OwnerUUID").equals(user.getUuid()))) return TypedActionResult.fail(user.getStackInHand(hand));
		if (world.isClient()) return TypedActionResult.consume(user.getStackInHand(hand));
		ServerWorld server = (ServerWorld) world;
		if (nbt.containsUuid("OwnerUUID")  && nbt.getUuid("OwnerUUID").equals(user.getUuid())) {
			if (monstie == null) {
				monstie = (MonsterEntity)server.getEntity(nbt.getUuid("MonstieUUID"));
				if (monstie == null) {
					return TypedActionResult.fail(user.getStackInHand(hand));
				}
			}
			if (monstie.getWorld() != user.getWorld()) {
				monstie.detach();
				MonsterEntity other = monstie;
				monstie = (MonsterEntity)other.getType().create(server);
				if (monstie != null) {
					monstie.copyFrom(other);
					other.setRemoved(RemovalReason.CHANGED_DIMENSION);
					server.onDimensionChanged(monstie);
				}
			}
			monstie.setPosition(user.getPos());
			return TypedActionResult.success(user.getStackInHand(hand));
		}
		return super.use(world, user, hand);
	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		NbtCompound nbt = stack.getOrCreateNbt();
		return nbt.containsUuid("MonstieUUID") ? Rarity.UNCOMMON : Rarity.COMMON;
	}
}
