package net.poultryman.tutorialmod;

import net.minecraft.registry.entry.RegistryEntry;
import net.poultryman.tutorialmod.registry.CopperHornRegistries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public interface CopperHornInstruments {
    int COPPER_HORN_USE_DURATION = 70;
    
    RegistryKey<CopperHornInstrument> GREAT_COPPER_HORN = CopperHornInstruments.of("great_copper_horn");
    RegistryKey<CopperHornInstrument> OLD_COPPER_HORN = CopperHornInstruments.of("old_copper_horn");
    RegistryKey<CopperHornInstrument> PURE_COPPER_HORN = CopperHornInstruments.of("pure_copper_horn");
    RegistryKey<CopperHornInstrument> MUMBLE_COPPER_HORN = CopperHornInstruments.of("mumble_copper_horn");
    RegistryKey<CopperHornInstrument> DRY_COPPER_HORN = CopperHornInstruments.of("dry_copper_horn");
    RegistryKey<CopperHornInstrument> CLEAR_COPPER_HORN = CopperHornInstruments.of("clear_copper_horn");
    RegistryKey<CopperHornInstrument> FRESH_COPPER_HORN = CopperHornInstruments.of("fresh_copper_horn");
    RegistryKey<CopperHornInstrument> SECRET_COPPER_HORN = CopperHornInstruments.of("secret_copper_horn");
    RegistryKey<CopperHornInstrument> FEARLESS_COPPER_HORN = CopperHornInstruments.of("fearless_copper_horn");
    RegistryKey<CopperHornInstrument> SWEET_COPPER_HORN = CopperHornInstruments.of("sweet_copper_horn");

    private static RegistryKey<CopperHornInstrument> of(String id) {
        return RegistryKey.of(CopperHornRegistries.INSTRUMENT_KEY, TutorialMod.id(id));
    }

    static void registerAndGetDefault(Registry<CopperHornInstrument> registry) {
        Registry.register(registry, GREAT_COPPER_HORN, new CopperHornInstrument((RegistryEntry)CopperHornSoundEvents.COPPER_HORN_BASS_SOUNDS.get(0), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(0), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(0), 70, 256.0F));
        Registry.register(registry, OLD_COPPER_HORN, new CopperHornInstrument((RegistryEntry)CopperHornSoundEvents.COPPER_HORN_BASS_SOUNDS.get(1), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(1), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(1), 70, 256.0F));
        Registry.register(registry, PURE_COPPER_HORN, new CopperHornInstrument((RegistryEntry)CopperHornSoundEvents.COPPER_HORN_BASS_SOUNDS.get(2), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(2), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(2), 70, 256.0F));
        Registry.register(registry, MUMBLE_COPPER_HORN, new CopperHornInstrument((RegistryEntry)CopperHornSoundEvents.COPPER_HORN_BASS_SOUNDS.get(3), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(3), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(3), 70, 256.0F));
        Registry.register(registry, DRY_COPPER_HORN, new CopperHornInstrument((RegistryEntry)CopperHornSoundEvents.COPPER_HORN_BASS_SOUNDS.get(4), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(4), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(4), 70, 256.0F));
        Registry.register(registry, CLEAR_COPPER_HORN, new CopperHornInstrument((RegistryEntry)CopperHornSoundEvents.COPPER_HORN_BASS_SOUNDS.get(5), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(5), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(5), 70, 256.0F));
        Registry.register(registry, FRESH_COPPER_HORN, new CopperHornInstrument((RegistryEntry)CopperHornSoundEvents.COPPER_HORN_BASS_SOUNDS.get(6), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(6), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(6), 70, 256.0F));
        Registry.register(registry, SECRET_COPPER_HORN, new CopperHornInstrument((RegistryEntry)CopperHornSoundEvents.COPPER_HORN_BASS_SOUNDS.get(7), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(7), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(7), 70, 256.0F));
        Registry.register(registry, FEARLESS_COPPER_HORN, new CopperHornInstrument((RegistryEntry)CopperHornSoundEvents.COPPER_HORN_BASS_SOUNDS.get(8), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(8), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(8), 70, 256.0F));
        Registry.register(registry, SWEET_COPPER_HORN, new CopperHornInstrument((RegistryEntry)CopperHornSoundEvents.COPPER_HORN_BASS_SOUNDS.get(9), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(9), (RegistryEntry)CopperHornSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(9), 70, 256.0F));
    }
}
