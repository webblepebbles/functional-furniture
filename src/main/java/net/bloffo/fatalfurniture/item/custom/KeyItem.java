package net.bloffo.fatalfurniture.item.custom;

import net.bloffo.fatalfurniture.block.custom.DrawersBlock;
import net.bloffo.fatalfurniture.component.ModDataComponentTypes;
import net.bloffo.fatalfurniture.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.List;

public class KeyItem extends Item {

    private static final String LINKED_POS = "linked_pos";

    public KeyItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity playerEntity = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (DrawersBlock.canlock(blockState)) {
            if (!context.getStack().contains(ModDataComponentTypes.POSITION)) {
                /*change sounds here once you've made sounds*/
                world.playSound(playerEntity, blockPos, ModSounds.CUSHION_RUSTLES, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
                world.setBlockState(blockPos, blockState.with(DrawersBlock.LOCKED, true), Block.NOTIFY_ALL_AND_REDRAW);
                world.emitGameEvent(playerEntity, GameEvent.BLOCK_CHANGE, blockPos);
                context.getStack().set(ModDataComponentTypes.POSITION, context.getBlockPos());
                return ActionResult.success(world.isClient());
            }
        } else {
            if (DrawersBlock.canunlock(blockState)) {
                if (!context.getStack().contains(ModDataComponentTypes.POSITION)) return ActionResult.FAIL;
                BlockPos POS = context.getStack().get(ModDataComponentTypes.POSITION);
                if (POS.equals(blockPos)) {
                    /*change sounds here once you've made sounds*/
                    world.playSound(playerEntity, blockPos, ModSounds.CUSHION_RUSTLES, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
                    world.setBlockState(blockPos, blockState.with(DrawersBlock.LOCKED, false), Block.NOTIFY_ALL_AND_REDRAW);
                    world.emitGameEvent(playerEntity, GameEvent.BLOCK_CHANGE, blockPos);
                    context.getStack().remove(ModDataComponentTypes.POSITION);
                    return ActionResult.success(world.isClient());
                }
            } else {
                return ActionResult.FAIL;
            }
        }
        return ActionResult.FAIL;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(stack.get(ModDataComponentTypes.POSITION) != null){
            tooltip.add(Text.literal("Unlocks " + stack.get(ModDataComponentTypes.POSITION)));
        }
    }
}

