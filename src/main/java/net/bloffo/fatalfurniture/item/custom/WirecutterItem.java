package net.bloffo.fatalfurniture.item.custom;

import net.bloffo.fatalfurniture.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class WirecutterItem extends Item {
    private static final Map<Block, Block> WirecutterMap =
            Map.of(
                    ModBlocks.LAMP, ModBlocks.RIGGEDLAMP
            );
    public WirecutterItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        if (WirecutterMap.containsKey(clickedBlock))
            if (!world.isClient) {
                world.setBlockState(context.getBlockPos(), WirecutterMap.get(clickedBlock).getDefaultState());
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
                world.playSound(null, context.getBlockPos(), SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS);
                return ActionResult.SUCCESS;
            }

        return super.useOnBlock(context);
    }
}
