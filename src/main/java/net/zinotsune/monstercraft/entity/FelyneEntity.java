package net.zinotsune.monstercraft.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.ai.goal.WanderAroundPointOfInterestGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.zinotsune.monstercraft.MonsterCraftItems;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class FelyneEntity extends MonsterEntity implements IAnimatable {
	private AnimationFactory factory = new AnimationFactory(this);
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("walk"));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("sit"));
		return PlayState.CONTINUE;
	}

	public FelyneEntity(EntityType<? extends MonsterEntity> entityType, World world) {
		super(entityType, world);
	}

	public static DefaultAttributeContainer.Builder setAttributes() {
		return AnimalEntity.createMobAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 20d)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0f)
			.add(EntityAttributes.GENERIC_ATTACK_SPEED, 0f)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6f);
	}

	protected void initGoals() {
		this.goalSelector.add(0, new SwimGoal(this));
		this.goalSelector.add(1, new WanderAroundPointOfInterestGoal(this, 0.75f, false));
		this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.75f, 1));
		this.goalSelector.add(3, new LookAroundGoal(this));
		//this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8f));
		// uncomment that once head tracking is added in FelyneModel
	}

	@Override
	public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
		// TODO: breeding
		return null;
	}

	@Override
	public void registerControllers(AnimationData animationData) {
		animationData.addAnimationController(new AnimationController<FelyneEntity>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}

	@Override
	public float getWildMaxHealth() {
		return 20;
	}

	@Override
	public float getTameMaxHealth() {
		return 50;
	}

	@Override
	public Item getTameItem() {
		// TODO: taming with felvine
		return null;
	}

	@Override
	public boolean isTameItem(Item item) {
		return item.equals(getTameItem());
	}

	@Override
	public boolean canBeTamed() {
		// tameable small monsters don't require combat first
		return true;
	}

	// TODO: sounds
}
