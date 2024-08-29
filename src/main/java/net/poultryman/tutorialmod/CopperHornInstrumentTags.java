package net.poultryman.tutorialmod;

import net.poultryman.tutorialmod.registry.CopperHornRegistries;
import net.minecraft.registry.tag.TagKey;

public interface CopperHornInstrumentTags {
    TagKey<CopperHornInstrument> REGULAR_COPPER_HORNS = of("regular_copper_horns");
    TagKey<CopperHornInstrument> SCREAMING_COPPER_HORNS = of("screaming_copper_horns");
    TagKey<CopperHornInstrument> COPPER_HORNS = of("copper_horns");

    private static TagKey<CopperHornInstrument> of(String id) {
        return TagKey.of(CopperHornRegistries.INSTRUMENT_KEY, TutorialMod.id(id));
    }
}
