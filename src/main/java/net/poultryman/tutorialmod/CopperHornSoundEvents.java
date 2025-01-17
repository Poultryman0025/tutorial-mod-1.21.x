package net.poultryman.tutorialmod;

import com.google.common.collect.ImmutableList;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;

import java.util.stream.IntStream;

public class CopperHornSoundEvents {
    public static final ImmutableList<RegistryEntry.Reference<SoundEvent>> COPPER_HORN_BASS_SOUNDS = CopperHornSoundEvents.registerCopperHornSounds(CopperHornSoundType.BASS);
    public static final ImmutableList<RegistryEntry.Reference<SoundEvent>> COPPER_HORN_HARMONY_SOUNDS = CopperHornSoundEvents.registerCopperHornSounds(CopperHornSoundType.HARMONY);
    public static final ImmutableList<RegistryEntry.Reference<SoundEvent>> COPPER_HORN_MELODY_SOUNDS = CopperHornSoundEvents.registerCopperHornSounds(CopperHornSoundType.MELODY);

    private static ImmutableList<RegistryEntry.Reference<SoundEvent>> registerCopperHornSounds(CopperHornSoundType type) {
        return IntStream.range(0, 10).mapToObj(variant ->
                CopperHornSoundEvents.registerReference("item.copper_horn.sound." + type.value + "." + variant)
        ).collect(ImmutableList.toImmutableList());
    }

    private static RegistryEntry.Reference<SoundEvent> registerReference(String id) {
        return Registry.registerReference(Registries.SOUND_EVENT, TutorialMod.id(id), SoundEvent.of(TutorialMod.id(id)));
    }

    private enum CopperHornSoundType {
        BASS("bass"),
        HARMONY("harmony"),
        MELODY("melody");

        public final String value;

        CopperHornSoundType(String value) {
            this.value = value;
        }
    }
}
