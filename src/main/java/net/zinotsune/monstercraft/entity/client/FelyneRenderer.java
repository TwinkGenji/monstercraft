package net.zinotsune.monstercraft.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.util.Identifier;
import net.zinotsune.monstercraft.MonsterCraftMod;
import net.zinotsune.monstercraft.entity.FelyneEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FelyneRenderer extends GeoEntityRenderer<FelyneEntity> {

	public FelyneRenderer(Context ctx) {
		super(ctx, new FelyneModel());
	}

	@Override
	public Identifier getTextureResource(FelyneEntity instance) {
		return new Identifier(MonsterCraftMod.MOD_ID, "textures/entity/felyne/felyne.png");
	}
	
}
