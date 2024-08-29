package net.poultryman.tutorialmod.registry;

import net.poultryman.tutorialmod.CopperHornInstrument;
import net.poultryman.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class CopperHornRegistries {
    public static final RegistryKey<Registry<CopperHornInstrument>> INSTRUMENT_KEY = RegistryKey.ofRegistry(TutorialMod.id("copper_horn_instrument"));
    public static final DefaultedRegistry<CopperHornInstrument> INSTRUMENT = FabricRegistryBuilder.createDefaulted(INSTRUMENT_KEY, TutorialMod.id("great_copper_horn")).buildAndRegister();
}
