package net.poultryman.tutorialmod.mixin.datafixer;

import com.mojang.serialization.Dynamic;
import net.minecraft.datafixer.fix.ItemStackComponentizationFix;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStackComponentizationFix.class)

public class ItemStackComponentizationFixMixin {
    @Inject(method = "fixStack", at = @At("TAIL"))
    private static void fixStackCopperHorn(ItemStackComponentizationFix.StackData data, Dynamic<?> dynamic, CallbackInfo ci) {
        if (data.itemEquals("tutorialmod:copper_horn")) {
            data.moveToComponent("instrument", "tutorialmod:copper_horn_instrument");
        }
    }
}
