package net.zinotsune.monstercraft;

import java.util.LinkedHashMap;
import java.util.Map;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer.Builder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zinotsune.monstercraft.entity.AptonothEntity;

public class MonsterCraftEntities {
	private static final Map<Identifier, EntityType<? extends LivingEntity>> ENTITIES = new LinkedHashMap<>();
	private static final Map<Identifier, Builder> ATTRIBUTES = new LinkedHashMap<>();

	// TODO: add dimensions elsewhere to more properly support parts
	public static final EntityType<AptonothEntity> APTONOTH = add("aptonoth", FabricEntityTypeBuilder.create(
		SpawnGroup.CREATURE, AptonothEntity::new).dimensions(EntityDimensions.fixed(2.5f, 3f)).build(), AptonothEntity.setAttributes());

	private static <E extends EntityType<? extends LivingEntity>> E add(String name, E entity, Builder builder) {
		ENTITIES.put(new Identifier(MonsterCraftMod.MOD_ID, name), entity);
		ATTRIBUTES.put(new Identifier(MonsterCraftMod.MOD_ID, name), builder);
		return entity;
	}

	public static void registerEntities() {
		for (Identifier id : ENTITIES.keySet()) {
			Registry.register(Registry.ENTITY_TYPE, id, ENTITIES.get(id));
			FabricDefaultAttributeRegistry.register(ENTITIES.get(id), ATTRIBUTES.get(id));
		}

	}
}
