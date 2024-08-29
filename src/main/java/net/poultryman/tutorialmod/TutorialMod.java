package net.poultryman.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.component.ComponentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.poultryman.tutorialmod.block.ModBlocks;
import net.poultryman.tutorialmod.item.ModItemGroups;
import net.poultryman.tutorialmod.item.custom.CopperHornItem;
import net.poultryman.tutorialmod.item.moditems;
import net.poultryman.tutorialmod.loot.SetCopperHornSoundLootFunction;
import net.poultryman.tutorialmod.recipe.CopperHornRecipe;
import net.poultryman.tutorialmod.registry.CopperHornRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Item COPPER_HORN;
	public static final RecipeSerializer<CopperHornRecipe> COPPER_HORN_RECIPE;
	public static final LootFunctionType<SetCopperHornSoundLootFunction> SET_COPPER_HORN_INSTRUMENT;
	public static final ComponentType<RegistryEntry<CopperHornInstrument>> INSTRUMENT_COMPONENT;
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		CopperHornInstruments.registerAndGetDefault(CopperHornRegistries.INSTRUMENT);
		Registry.register(Registries.DATA_COMPONENT_TYPE, TutorialMod.id("copper_horn_instrument"), INSTRUMENT_COMPONENT);
		Registry.register(Registries.ITEM, id("copper_horn"), TutorialMod.COPPER_HORN);
		Registry.register(Registries.RECIPE_SERIALIZER, TutorialMod.id("copper_horn_recipe"), TutorialMod.COPPER_HORN_RECIPE);
		ModItemGroups.registerItemGroups();
		moditems.onInitialize();
		ModBlocks.registerModBlocks();
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((entries) -> {
			for (RegistryEntry<CopperHornInstrument> registryEntry : CopperHornRegistries.INSTRUMENT.iterateEntries(CopperHornInstrumentTags.COPPER_HORNS))
			{
				entries.addAfter(Items.GOAT_HORN, CopperHornItem.getStackForInstrument(TutorialMod.COPPER_HORN, registryEntry));
			}
		});

		LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
			if (key.equals(LootTables.PILLAGER_OUTPOST_CHEST)) {
				tableBuilder.pool(LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.conditionally(RandomChanceLootCondition.builder(0.3f).build())
						.with(ItemEntry.builder(COPPER_HORN))
						.apply(SetCopperHornSoundLootFunction.builder(CopperHornInstrumentTags.REGULAR_COPPER_HORNS))
				);
			}
		});
	}
	public static Identifier id(String path)
	{
		return Identifier.of(MOD_ID, path);
	}

	static
	{
		COPPER_HORN = new CopperHornItem(new Item.Settings().maxCount(1),
				CopperHornInstrumentTags.COPPER_HORNS);
		COPPER_HORN_RECIPE = new SpecialRecipeSerializer<>(CopperHornRecipe::new);
		SET_COPPER_HORN_INSTRUMENT = Registry.register(Registries.LOOT_FUNCTION_TYPE, TutorialMod.id("set_instrument"), new LootFunctionType<>(SetCopperHornSoundLootFunction.CODEC));
		INSTRUMENT_COMPONENT = ComponentType.<RegistryEntry<CopperHornInstrument>>builder().codec(CopperHornInstrument.ENTRY_CODEC).packetCodec(CopperHornInstrument.ENTRY_PACKET_CODEC).cache().build();
	}
}