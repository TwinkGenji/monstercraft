package net.zinotsune.monstercraft.entity.client;

import net.minecraft.util.Identifier;
import net.zinotsune.monstercraft.MonsterCraftMod;
import net.zinotsune.monstercraft.entity.FelyneEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FelyneModel extends AnimatedGeoModel<FelyneEntity> {

	@Override
	public Identifier getModelResource(FelyneEntity object) {
		return new Identifier(MonsterCraftMod.MOD_ID, "geo/felyne.geo.json");
	}

	@Override
	public Identifier getTextureResource(FelyneEntity object) {
		return new Identifier(MonsterCraftMod.MOD_ID, "textures/entity/felyne/felyne.png");
	}

	@Override
	public Identifier getAnimationResource(FelyneEntity animatable) {
		return new Identifier(MonsterCraftMod.MOD_ID, "animations/felyne.animation.json");
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void setLivingAnimations(FelyneEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		// TODO: head tracking
	}
}
