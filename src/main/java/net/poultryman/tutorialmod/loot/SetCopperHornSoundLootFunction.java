package net.poultryman.tutorialmod.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.poultryman.tutorialmod.CopperHornInstrument;
import net.poultryman.tutorialmod.TutorialMod;
import net.poultryman.tutorialmod.item.custom.CopperHornItem;
import net.poultryman.tutorialmod.registry.CopperHornRegistries;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.function.ConditionalLootFunction;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.registry.tag.TagKey;

import java.util.List;

public class SetCopperHornSoundLootFunction extends ConditionalLootFunction {
    public static final MapCodec<SetCopperHornSoundLootFunction> CODEC = RecordCodecBuilder.mapCodec(
            instance -> addConditionsField(instance)
                    .and(TagKey.codec(CopperHornRegistries.INSTRUMENT_KEY).fieldOf("options").forGetter(function -> function.instrumentTagKey))
                    .apply(instance, SetCopperHornSoundLootFunction::new)
    );
    final TagKey<CopperHornInstrument> instrumentTagKey;

    SetCopperHornSoundLootFunction(List<LootCondition> lootConditions, TagKey<CopperHornInstrument> tagKey) {
        super(lootConditions);
        this.instrumentTagKey = tagKey;
    }

    @Override
    public LootFunctionType<SetCopperHornSoundLootFunction> getType() {

        return TutorialMod.SET_COPPER_HORN_INSTRUMENT;
    }

    @Override
    public ItemStack process(ItemStack stack, LootContext context) {
        CopperHornItem.setRandomInstrumentFromTag(stack, this.instrumentTagKey, context.getRandom());
        return stack;
    }

    public static Builder<?> builder(TagKey<CopperHornInstrument> tagKey) {
        return SetCopperHornSoundLootFunction.builder((List<LootCondition> lootConditions) -> new SetCopperHornSoundLootFunction(lootConditions, tagKey));
    }
}
