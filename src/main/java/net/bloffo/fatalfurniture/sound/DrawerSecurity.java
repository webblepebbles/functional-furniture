package net.bloffo.fatalfurniture.sound;

import net.bloffo.fatalfurniture.FatalFurniture;
import net.bloffo.fatalfurniture.block.custom.DrawersBlock;
import net.bloffo.fatalfurniture.block.entity.custom.DrawersBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DrawerSecurity {
    public static void lockDrawer(World world, BlockPos pos, PlayerEntity player) {
        BlockState state = world.getBlockState(pos);
        BlockEntity be = world.getBlockEntity(pos);
        if (!(be instanceof DrawersBlockEntity drawers)) {
            return;
        }        DefaultedList<ItemStack> saved = DefaultedList.ofSize(drawers.getItems().size(), ItemStack.EMPTY);
        for (int i = 0; i < drawers.getItems().size(); i++) {
            saved.set(i, drawers.getItems().get(i).copy());
        }
        logContents(saved, pos, world.getRegistryManager());
        world.removeBlockEntity(pos);
        world.setBlockState(pos, state.with(DrawersBlock.LOCKED, true), Block.NOTIFY_ALL_AND_REDRAW);
        BlockEntity newBe = world.getBlockEntity(pos);
        if (newBe instanceof DrawersBlockEntity newDrawers) {
            for (int i = 0; i < saved.size(); i++) {
                newDrawers.getItems().set(i, saved.get(i));
            }
            newDrawers.markDirty();
        }
    }

    public static void unlockDrawer(World world, BlockPos pos, PlayerEntity player) {
        BlockState state = world.getBlockState(pos);
        BlockEntity be = world.getBlockEntity(pos);
        if (!(be instanceof DrawersBlockEntity drawers)) {
            return;
        }
        DefaultedList<ItemStack> saved = DefaultedList.ofSize(drawers.getItems().size(), ItemStack.EMPTY);
        for (int i = 0; i < drawers.getItems().size(); i++) {
            saved.set(i, drawers.getItems().get(i).copy());
        }
        world.removeBlockEntity(pos);
        world.setBlockState(pos, state.with(DrawersBlock.LOCKED, false), Block.NOTIFY_ALL_AND_REDRAW);
        BlockEntity newBe = world.getBlockEntity(pos);
        if (newBe instanceof DrawersBlockEntity newDrawers) {
            for (int i = 0; i < saved.size(); i++) {
                newDrawers.getItems().set(i, saved.get(i));
            }
            newDrawers.markDirty();
        }
    }

    private static void logContents(DefaultedList<ItemStack> items, BlockPos pos, RegistryWrapper.WrapperLookup registryLookup) {
        FatalFurniture.LOGGER.info("Drawer locked at " + pos.getX() + " " + pos.getY() + " " + pos.getZ() + " with " + items.size() + " slots");
        for (ItemStack stack : items) {
            if (!stack.isEmpty()) {
                FatalFurniture.LOGGER.info("  Item: " + stack.getCount() + "x " + stack.getName().getString());
                NbtElement nbt = stack.encode(registryLookup);
                if (nbt != null) {
                    FatalFurniture.LOGGER.info("  NBT: " + nbt.toString());
                }
            }
        }
    }
}

