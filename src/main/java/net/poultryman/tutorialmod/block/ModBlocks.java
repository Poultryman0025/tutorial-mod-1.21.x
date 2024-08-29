package net.poultryman.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.poultryman.tutorialmod.TutorialMod;

public class ModBlocks
{
    public static final Block Ruby_Block = registerBlock("ruby_block",
            new Block(AbstractBlock.Settings.create().strength(5.0f)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block Ruby_Ore = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));


    public static final Block Deepslate_Ruby_Ore = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 6),
                    (AbstractBlock.Settings.create().strength(4f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool())));

    public static final Block Crystallized_Honey_Block = registerBlock("crystallized_honey_block",
            new Block(AbstractBlock.Settings.create().strength(0.6f).sounds(BlockSoundGroup.CORAL)));

    public static final Block Nether_Reactor_Core = registerBlock("nether_reactor_core",
            new Block(AbstractBlock.Settings.create().strength(3.0f).sounds(BlockSoundGroup.BONE).requiresTool()));


    public static final Block Rose = registerBlock("rose",
            new FlowerBlock(StatusEffects.NIGHT_VISION, 10,
                    FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));

    public static final Block Potted_Rose = registerBlock("potted_rose",
            new FlowerBlock(StatusEffects.NIGHT_VISION, 10,
                    FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));

    public static final Block Cyan_Flower = registerBlock("cyan_flower",
            new FlowerBlock(StatusEffects.NIGHT_VISION, 10,
                    FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));

    public static final Block Potted_Cyan_Flower = registerBlock("potted_cyan_flower",
            new FlowerBlock(StatusEffects.NIGHT_VISION, 10,
                    FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));

    public static final Block Gear_Cog = registerBlock("gear_cog",
            new RedstoneWireBlock(AbstractBlock.Settings.create().noCollision()
                    .breakInstantly().pistonBehavior(PistonBehavior.DESTROY)));



    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block)
    {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks()
    {
        TutorialMod.LOGGER.info("registering Mod Blocks for " + TutorialMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries ->
        {
            entries.add(ModBlocks.Ruby_Block);
            entries.add(ModBlocks.Ruby_Ore);
            entries.add(ModBlocks.Deepslate_Ruby_Ore);
            entries.add(ModBlocks.Crystallized_Honey_Block);
            entries.add(ModBlocks.Nether_Reactor_Core);
            entries.add(ModBlocks.Rose);
            entries.add(ModBlocks.Cyan_Flower);
            entries.add(ModBlocks.Gear_Cog);

        });
    }

}
