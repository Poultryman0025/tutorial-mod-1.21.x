package net.poultryman.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.poultryman.tutorialmod.TutorialMod;
import net.poultryman.tutorialmod.block.ModBlocks;

public class ModItemGroups {
public static final ItemGroup Lost_Items_Group = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(TutorialMod.MOD_ID, "lost_items"), FabricItemGroup.builder().icon(()-> new ItemStack(moditems.Ruby))
                .displayName(Text.translatable("ItemGroup.tutorialmod.lost_items"))
                        .entries((displayContext, entries) ->
                        {
                            entries.add(moditems.Ruby);
                            entries.add(moditems.Horse_Saddle);
                            entries.add(moditems.Crystallized_Honey);
                            entries.add(moditems.Wrench);
                            entries.add(moditems.COPPER_HORN);
                            entries.add(ModBlocks.Crystallized_Honey_Block);
                            entries.add(ModBlocks.Rose);
                            entries.add(ModBlocks.Cyan_Flower);
                            entries.add(ModBlocks.Deepslate_Ruby_Ore);
                            entries.add(ModBlocks.Ruby_Ore);
                            entries.add(ModBlocks.Ruby_Block);
                            entries.add(ModBlocks.Nether_Reactor_Core);
                            entries.add(ModBlocks.Gear_Cog);
                        })

                .build());

    public static void registerItemGroups()
    {
        TutorialMod.LOGGER.info("register Item Groups for " + TutorialMod.MOD_ID);
    }

}
