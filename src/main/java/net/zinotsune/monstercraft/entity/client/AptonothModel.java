package net.zinotsune.monstercraft.entity.client;

import net.minecraft.util.Identifier;
import net.zinotsune.monstercraft.MonsterCraftMod;
import net.zinotsune.monstercraft.entity.AptonothEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AptonothModel extends AnimatedGeoModel<AptonothEntity> {

	@Override
	public Identifier getModelResource(AptonothEntity object) {
		return new Identifier(MonsterCraftMod.MOD_ID, "geo/aptonoth.geo.json");
	}

	@Override
	public Identifier getTextureResource(AptonothEntity object) {
		return new Identifier(MonsterCraftMod.MOD_ID, "textures/entity/aptonoth/aptonoth.png");
	}

	@Override
	public Identifier getAnimationResource(AptonothEntity animatable) {
		return new Identifier(MonsterCraftMod.MOD_ID, "animations/aptonoth.animation.json");
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setLivingAnimations(AptonothEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		// TODO: head tracking
	}
}
