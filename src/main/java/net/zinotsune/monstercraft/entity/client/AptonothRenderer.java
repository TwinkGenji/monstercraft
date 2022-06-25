package net.zinotsune.monstercraft.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.util.Identifier;
import net.zinotsune.monstercraft.MonsterCraftMod;
import net.zinotsune.monstercraft.entity.AptonothEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AptonothRenderer extends GeoEntityRenderer<AptonothEntity> {

	public AptonothRenderer(Context ctx) {
		super(ctx, new AptonothModel());
	}

	@Override
	public Identifier getTextureResource(AptonothEntity instance) {
		return new Identifier(MonsterCraftMod.MOD_ID, "textures/entity/aptonoth/aptonoth.png");
	}
	
}
