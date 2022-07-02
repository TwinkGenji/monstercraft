package net.zinotsune.monstercraft;

import java.util.LinkedHashMap;
import java.util.Map;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.zinotsune.monstercraft.item.KinshipStoneItem;

public class MonsterCraftItems {
	private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

	//public static final ItemGroup BLOCKITEMS = FabricItemGroupBuilder.create(new Identifier(MonsterCraftMod.MOD_ID, "blocks")).build();
	public static final ItemGroup CONSUMABLES = FabricItemGroupBuilder.create(new Identifier(MonsterCraftMod.MOD_ID, "consumables")).icon(() -> getConsumablesIcon()).build();
	//public static final ItemGroup EQUIPMENT = FabricItemGroupBuilder.create(new Identifier(MonsterCraftMod.MOD_ID, "equipment")).build();
	public static final ItemGroup MATERIALS = FabricItemGroupBuilder.create(new Identifier(MonsterCraftMod.MOD_ID, "materials")).icon(() -> getMaterialsIcon()).build();
	public static final ItemGroup CARVES = FabricItemGroupBuilder.create(new Identifier(MonsterCraftMod.MOD_ID, "carves")).icon(() -> getCarvesIcon()).build();
	public static final ItemGroup KINSHIP_STONES = FabricItemGroupBuilder.create(new Identifier(MonsterCraftMod.MOD_ID, "kinship_stones")).icon(() -> getKinshipStonesIcon()).build();

	// Consumables
	public static final Item RAW_DINO_MEAT = add("raw_dino_meat", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(1.8f).meat().build()).group(CONSUMABLES)));
	public static final Item COOKED_DINO_MEAT = add("cooked_dino_meat", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(8).saturationModifier(12.8f).meat().build()).group(CONSUMABLES)));

	// Materials (Ores)
	public static final Item DRAGONVEIN_CRYSTAL = add("dragonvein_crystal", new Item(new FabricItemSettings().group(MATERIALS)));

	// Carves (Small monsters, generic)
	public static final Item WARM_PELT = add("warm_pelt", new Item(new FabricItemSettings().group(MATERIALS)));
	public static final Item SHARP_CLAW = add("sharp_claw", new Item(new FabricItemSettings().group(MATERIALS)));

	// Carves (Sacs)
	public static final Item MONSTER_FLUID = add("monster_fluid", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item FLAME_SAC = add("flame_sac", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item AQUA_SAC = add("aqua_sac", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item ELECTRO_SAC = add("electro_sac", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item FROST_SAC = add("frost_sac", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item POISON_SAC = add("poison_sac", new Item(new FabricItemSettings().group(CARVES)));
	//public static final Item PARALYSIS_SAC = add("paralysis_sac", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item SLEEP_SAC = add("sleep_sac", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item SCREAMER_SAC = add("screamer_sac", new Item(new FabricItemSettings().group(CARVES)));

	// Carves (Gems, etc)
	public static final Item BIRD_WYVERN_GEM = add("bird_wyvern_gem", new Item(new FabricItemSettings().group(CARVES).rarity(Rarity.UNCOMMON)));
	public static final Item WYVERN_GEM = add("wyvern_gem", new Item(new FabricItemSettings().group(CARVES).rarity(Rarity.UNCOMMON)));
	public static final Item BEAST_GEM = add("beast_gem", new Item(new FabricItemSettings().group(CARVES).rarity(Rarity.UNCOMMON)));
	public static final Item ELDER_DRAGON_BLOOD = add("elder_dragon_blood", new Item(new FabricItemSettings().group(CARVES).rarity(Rarity.UNCOMMON)));
	public static final Item LARGE_ELDER_DRAGON_GEM = add("large_elder_dragon_gem", new Item(new FabricItemSettings().group(CARVES).rarity(Rarity.RARE)));

	// Carves (T0, herbivores)
	public static final Item APTONOTH_TAIL = add("aptonoth_tail", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item APCEROS_SHELL = add("apceros_shell", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item POPO_TONGUE = add("popo_tongue", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item KELBI_HORN = add("kelbi_horn", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item ANTEKA_ANTLER = add("anteka_antler", new Item(new FabricItemSettings().group(CARVES)));

	// Carves (T0, bugs)
	public static final Item VESPOID_SHELL = add("vespoid_shell", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item VESPOID_WING = add("vespoid_wing", new Item(new FabricItemSettings().group(CARVES)));
	// third vespoid drop????
	public static final Item BNAHABRA_SHELL = add("bnahabra_shell", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item BNAHABRA_WING = add("bnahabra_wing", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item BNAHABRA_STINGER = add("bnahabra_stinger", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item HORNETAUR_SHELL = add("hornetaur_shell", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item HORNETAUR_WING = add("hornetaur_wing", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item HORNETAUR_HEAD = add("hornetaur_head", new Item(new FabricItemSettings().group(CARVES)));

	// Carves (T0, pack members)
	public static final Item VELOCIPREY_SCALE = add("velociprey_scale", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item VELOCIPREY_HIDE = add("velociprey_hide", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item BULLFANGO_PELT = add("bullfango_pelt", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item BULLFANGO_HEAD = add("bullfango_head", new Item(new FabricItemSettings().group(CARVES)));

	// Carves (T1)
	// bird wyvern, raptor
	public static final Item VELOCIDROME_HIDE = add("velocidrome_hide", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item VELOCIDROME_CLAW = add("velocidrome_claw", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item VELOCIDROME_HEAD = add("velocidrome_head", new Item(new FabricItemSettings().group(CARVES)));

	// Carves (T2)
	// fanged beast, artiodactyl
	public static final Item BULLDROME_HIDE = add("bulldrome_hide", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item BULLDROME_TUSK = add("bulldrome_tusk", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item BULLDROME_SCALP = add("bulldrome_scalp", new Item(new FabricItemSettings().group(CARVES)));
	// fanged beast, ursid
	public static final Item ARZUROS_PELT = add("arzuros_pelt", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item ARZUROS_SHELL = add("arzuros_shell", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item ARZUROS_CARAPACE = add("arzuros_carapace", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item ARZUROS_BRACE = add("arzuros_brace", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item LAGOMBI_PELT = add("lagombi_pelt", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item LAGOMBI_PLASTRON = add("lagombi_plastron", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item LAGOMBI_ICECLAW = add("lagombi_iceclaw", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item LAGOMBI_EAR = add("lagombi_ear", new Item(new FabricItemSettings().group(CARVES)));

	// Carves (T3)
	// flying wyvern, true
	public static final Item RATHIAN_SCALE = add("rathian_scale", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item RATHIAN_SHELL = add("rathian_shell", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item RATHIAN_WEBBING = add("rathian_webbing", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item RATH_WINGTALON = add("rath_wingtalon", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item RATH_MEDULLA = add("rath_medulla", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item RATHIAN_SPIKE = add("rathian_spike", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item RATHIAN_RUBY = add("rathian_ruby", new Item(new FabricItemSettings().group(CARVES).rarity(Rarity.UNCOMMON)));

	// Carves (T4)
	// flying wyvern, true
	public static final Item RATHALOS_SCALE = add("rathalos_scale", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item RATHALOS_SHELL = add("rathalos_shell", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item RATHALOS_WEBBING = add("rathalos_webbing", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item RATHALOS_TAIL = add("rathalos_tail", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item RATHALOS_RUBY = add("rathalos_ruby", new Item(new FabricItemSettings().group(CARVES).rarity(Rarity.UNCOMMON)));
	public static final Item DIABLOS_SHELL = add("diablos_shell", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item DIABLOS_FANG = add("diablos_fang", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item DIABLOS_RIDGE = add("diablos_ridge", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item DIABLOS_HORN = add("diablos_horn", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item BLOS_MEDULLA = add("blos_medulla", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item DIABLOS_TAILCASE = add("diablos_tailcase", new Item(new FabricItemSettings().group(CARVES)));
	// flying wyvern, pseudo
	public static final Item TIGREX_SCALE = add("tigrex_scale", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item TIGREX_SHELL = add("tigrex_shell", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item TIGREX_CLAW = add("tigrex_claw", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item TIGREX_FANG = add("tigrex_fang", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item TIGREX_SCALP = add("tigrex_scalp", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item TIGREX_TAIL = add("tigrex_tail", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item TIGREX_MAW = add("tigrex_maw", new Item(new FabricItemSettings().group(CARVES).rarity(Rarity.UNCOMMON)));
	public static final Item NARGACUGA_SCALE = add("nargacuga_scale", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item NARGACUGA_BLACKFUR = add("nargacuga_blackfur", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item NARGACUGA_TAILSPIKE = add("nargacuga_tailspike", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item NARGACUGA_FANG = add("nargacuga_fang", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item NARGACUGA_CUTWING = add("nargacuga_cutwing", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item NARGACUGA_TAIL = add("nargacuga_tail", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item NARGACUGA_MEDULLA = add("nargacuga_medulla", new Item(new FabricItemSettings().group(CARVES).rarity(Rarity.UNCOMMON)));
	public static final Item BARIOTH_SHELL = add("barioth_shell", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item BARIOTH_PELT = add("barioth_pelt", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item BARIOTH_SPIKE = add("barioth_spike", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item AMBER_FANG = add("amber_fang", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item BARIOTH_CLAW = add("barioth_claw", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item BARIOTH_TAIL = add("barioth_tail", new Item(new FabricItemSettings().group(CARVES)));
	// fanged wyvern, pseudo
	public static final Item FULGURBUG = add("fulgurbug", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item ZINOGRE_SHELL = add("zinogre_shell", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item ZINOGRE_ELECTROFUR = add("zinogre_electrofur", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item ZINOGRE_SHOCKER = add("zinogre_shocker", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item ZINOGRE_HORN = add("zinogre_horn", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item ZINOGRE_CLAW = add("zinogre_claw", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item ZINOGRE_TAIL = add("zinogre_tail", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item ZINOGRE_JASPER = add("zinogre_jasper", new Item(new FabricItemSettings().group(CARVES).rarity(Rarity.UNCOMMON)));
	// leviathan, true
	public static final Item LAGIACRUS_SCALE = add("lagiacrus_scale", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item LAGIACRUS_HIDE = add("lagiacrus_hide", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item LAGIACRUS_CLAW = add("lagiacrus_claw", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item LAGIACRUS_HORN = add("lagiacrus_horn", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item SHELL_SHOCKER = add("shell_shocker", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item LAGIACRUS_TAIL = add("lagiacrus_tail", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item LAGIACRUS_SAPPHIRE = add("lagiacrus_sapphire", new Item(new FabricItemSettings().group(CARVES).rarity(Rarity.UNCOMMON)));
	
	// Carves (T5)
	// elder dragon
	public static final Item KIRIN_FINEHIDE = add("kirin_finehide", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item KIRIN_THUNDERTAIL = add("kirin_thundertail", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item KIRIN_SILVERMANE = add("kirin_silvermane", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item KIRIN_AZURE_HORN = add("kirin_azure_horn", new Item(new FabricItemSettings().group(CARVES).rarity(Rarity.RARE)));
	// TODO: a ton more kirin drops jfc

	// Carves (T6)
	// elder dragon
	public static final Item DAORA_SHARD = add("daora_shard", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item DAORA_CORTEX = add("daora_cortex", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item DAORA_HARDCLAW = add("daora_hardclaw", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item DAORA_HARDHORN = add("daora_hardhorn", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item DAORA_FELLWING = add("daora_fellwing", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item DAORA_LASH = add("daora_lash", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item DAORA_GEM = add("daora_gem", new Item(new FabricItemSettings().group(CARVES).rarity(Rarity.RARE)));

	// Carves (T7)
	// elder dragon
	public static final Item XENOJIIVA_SOULSCALE = add("xenojiiva_soulscale", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item XENOJIIVA_SHELL = add("xenojiiva_shell", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item XENOJIIVA_CLAW = add("xenojiiva_claw", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item XENOJIIVA_HORN = add("xenojiiva_horn", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item XENOJIIVA_WING = add("xenojiiva_wing", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item XENOJIIVA_VEIL = add("xenojiiva_veil", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item XENOJIIVA_TAIL = add("xenojiiva_tail", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item XENOJIIVA_GEM = add("xenojiiva_gem", new Item(new FabricItemSettings().group(CARVES).rarity(Rarity.RARE)));

	// Carves (T8)
	// elder dragon
	public static final Item SAFIJIIVA_SHARD = add("safijiiva_shard", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item SAFIJIIVA_CORTEX = add("safijiiva_cortex", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item SAFIJIIVA_HARDCLAW = add("safijiiva_hardclaw", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item SAFIJIIVA_HARDHORN = add("safijiiva_hardhorn", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item SAFIJIIVA_FELLWING = add("safijiiva_fellwing", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item PULSING_DRAGONSHELL = add("pulsing_dragonshell", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item SAFIJIIVA_LASH = add("safijiiva_lash", new Item(new FabricItemSettings().group(CARVES)));
	public static final Item ZIONIUM_CRYSTAL = add("zionium_crystal", new Item(new FabricItemSettings().group(CARVES).rarity(Rarity.EPIC)));

	// Kinship Stones
	public static final Item WYVERN_TEAR = add("wyvern_tear", new Item(new FabricItemSettings().group(MATERIALS)));
	public static final Item LARGE_WYVERN_TEAR = add("large_wyvern_tear", new Item(new FabricItemSettings().group(MATERIALS)));
	public static final Item BEAST_TEAR = add("beast_tear", new Item(new FabricItemSettings().group(MATERIALS)));
	public static final Item LARGE_BEAST_TEAR = add("large_beast_tear", new Item(new FabricItemSettings().group(MATERIALS)));
	public static final Item OLD_DRAGON_TREASURE = add("old_dragon_treasure", new Item(new FabricItemSettings().group(MATERIALS)));
	public static final Item KINSHIP_STONE = add("kinship_stone", new Item(new FabricItemSettings().group(KINSHIP_STONES)));
	public static final Item KINSHIP_STONE_APTONOTH = add("kinship_stone_aptonoth", new KinshipStoneItem(new FabricItemSettings().group(KINSHIP_STONES).maxCount(1)));
	public static final Item KINSHIP_STONE_RATHIAN = add("kinship_stone_rathian", new KinshipStoneItem(new FabricItemSettings().group(KINSHIP_STONES).maxCount(1)));
	public static final Item KINSHIP_STONE_RATHALOS = add("kinship_stone_rathalos", new KinshipStoneItem(new FabricItemSettings().group(KINSHIP_STONES).maxCount(1)));
	public static final Item KINSHIP_STONE_NARGACUGA = add("kinship_stone_nargacuga", new KinshipStoneItem(new FabricItemSettings().group(KINSHIP_STONES).maxCount(1)));

	private static <I extends Item> I add(String name, I item) {
		ITEMS.put(new Identifier(MonsterCraftMod.MOD_ID, name), item);
		return item;
	}

	private static ItemStack getConsumablesIcon() {
		// TODO: change to potion?
		return COOKED_DINO_MEAT.getDefaultStack();
	}

	private static ItemStack getMaterialsIcon() {
		return DRAGONVEIN_CRYSTAL.getDefaultStack();
	}

	private static ItemStack getCarvesIcon() {
		return VELOCIPREY_HIDE.getDefaultStack();
	}

	private static ItemStack getKinshipStonesIcon() {
		return KINSHIP_STONE.getDefaultStack();
	}

	public static void registerItems() {
		for (Identifier id : ITEMS.keySet()) {
			Registry.register(Registry.ITEM, id, ITEMS.get(id));
		}
	}
}
