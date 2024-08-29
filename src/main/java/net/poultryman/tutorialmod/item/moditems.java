package net.poultryman.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DebugStickStateComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.poultryman.tutorialmod.*;
import net.poultryman.tutorialmod.item.custom.CopperHornItem;
import net.poultryman.tutorialmod.item.custom.WrenchItem;

public class moditems {
    public static final Item Ruby = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item Crystallized_Honey = registerItem("crystallized_honey", new Item(new Item.Settings()));
    public static final Item Horse_Saddle = registerItem("horse_saddle", new Item(new Item.Settings()));
    public static final Item Wrench = registerItem("wrench", new WrenchItem(new Item.Settings()
            .component(DataComponentTypes.DEBUG_STICK_STATE, DebugStickStateComponent.DEFAULT).rarity(Rarity.RARE)
            .maxCount(1).maxDamage(128)));
    public static final Item COPPER_HORN = new CopperHornItem(new Item.Settings().maxCount(1), CopperHornInstrumentTags.COPPER_HORNS);
    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }
    public static void onInitialize()
    {
        TutorialMod.LOGGER.info("Registering Mod Items for" + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->
        {
            entries.add(Ruby);
            entries.add(Crystallized_Honey);
            entries.add(Horse_Saddle);
            entries.add(Wrench);
        });
    }
}
