package net.poultryman.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DebugStickStateComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class WrenchItem extends Item {
    public WrenchItem(Settings settings) {
        super(settings);
    }
    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        if (!world.isClient) {
            this.use(miner, state, world, pos, false, miner.getStackInHand(Hand.OFF_HAND));
        }

        return false;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity playerEntity = context.getPlayer();
        World world = context.getWorld();
        if (!world.isClient && playerEntity != null) {
            BlockPos blockPos = context.getBlockPos();
            context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
            if (!this.use(playerEntity, world.getBlockState(blockPos), world, blockPos, true, context.getStack())) {
                return ActionResult.FAIL;
            }
        }

        return ActionResult.success(world.isClient);
    }

    private boolean use(PlayerEntity player, BlockState state, WorldAccess world, BlockPos pos, boolean update, ItemStack stack) {
            {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            RegistryEntry<Block> registryEntry = state.getRegistryEntry();
            StateManager<Block, BlockState> stateManager = registryEntry.value().getStateManager();
            Collection<Property<?>> collection = stateManager.getProperties();
                {
                DebugStickStateComponent debugStickStateComponent = stack.get(DataComponentTypes.DEBUG_STICK_STATE);
                if (debugStickStateComponent == null) {
                    return false;
                } else {
                    Property<?> property = (Property<?>)debugStickStateComponent.properties().get(registryEntry);
                    if (update) {
                        if (property == null) {
                            property = (Property<?>)collection.iterator().next();
                        }

                        BlockState blockState = cycle(state, property, player.shouldCancelInteraction());
                        world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS | Block.FORCE_STATE);

                    } else {
                        property = cycle(collection, property, player.shouldCancelInteraction());
                        stack.set(DataComponentTypes.DEBUG_STICK_STATE, debugStickStateComponent.with(registryEntry, property));

                    }

                    return true;
                }
            }
        }
    }

    private static <T extends Comparable<T>> BlockState cycle(BlockState state, Property<T> property, boolean inverse) {
        return state.with(property, cycle(property.getValues(), state.get(property), inverse));

    }

    private static <T> T cycle(Iterable<T> elements, @Nullable T current, boolean inverse) {
        return inverse ? Util.previous(elements, current) : Util.next(elements, current);
    }



    private static <T extends Comparable<T>> String getValueString(BlockState state, Property<T> property) {
        return property.name(state.get(property));
    }

}
