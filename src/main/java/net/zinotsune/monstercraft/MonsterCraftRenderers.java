package net.zinotsune.monstercraft;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.zinotsune.monstercraft.entity.client.*;

public class MonsterCraftRenderers {
	// no way to do a cool map loop for this unfortunately, since you can't store ctors in hashmaps
	public static void registerRenderers() {
		EntityRendererRegistry.register(MonsterCraftEntities.APTONOTH, AptonothRenderer::new);
		EntityRendererRegistry.register(MonsterCraftEntities.FELYNE, FelyneRenderer::new);
	}
}
