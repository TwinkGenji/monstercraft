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
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class AptonothEntity extends AnimalEntity implements IAnimatable {
	private AnimationFactory factory = new AnimationFactory(this);
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("walk"));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle"));
		return PlayState.CONTINUE;
	}

	public AptonothEntity(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

	public static DefaultAttributeContainer.Builder setAttributes() {
		return AnimalEntity.createMobAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 20d)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8f)
			.add(EntityAttributes.GENERIC_ATTACK_SPEED, 2f)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
	}

	protected void initGoals() {
		this.goalSelector.add(0, new SwimGoal(this));
		this.goalSelector.add(1, new WanderAroundPointOfInterestGoal(this, 0.75f, false));
		this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.75f, 1));
		this.goalSelector.add(3, new LookAroundGoal(this));
		//this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8f));
		// uncomment that once head tracking is added in AptonothModel
	}

	@Override
	public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
		// TODO: breeding
		return null;
	}

	@Override
	public void registerControllers(AnimationData animationData) {
		animationData.addAnimationController(new AnimationController<AptonothEntity>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}

	// TODO: sounds
}
