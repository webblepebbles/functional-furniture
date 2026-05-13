package net.bloffo.fatalfurniture.item.custom;

import net.bloffo.fatalfurniture.block.custom.CouchBlock;
import net.bloffo.fatalfurniture.block.custom.CushionBlock;
import net.bloffo.fatalfurniture.block.custom.PouffeBlock;
import net.bloffo.fatalfurniture.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class KnifeItem extends ToolItem {
    public KnifeItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }
    public static AttributeModifiersComponent createAttributeModifiers(ToolMaterial material, int baseAttackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, baseAttackDamage + material.getAttackDamage(), EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ATTACK_SPEED,
                        new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .build();
    }
    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity playerEntity = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (CouchBlock.canaddKnife(blockState)) {
            world.playSound(playerEntity, blockPos, ModSounds.CUSHION_RUSTLES, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
            world.setBlockState(blockPos, blockState.with(CouchBlock.KNIFE, true), Block.NOTIFY_ALL_AND_REDRAW);
            world.emitGameEvent(playerEntity, GameEvent.BLOCK_CHANGE, blockPos);
            System.out.println("knife");
            if (playerEntity != null) {
                context.getStack().decrement(1);
            }

            return ActionResult.success(world.isClient());
        }
        if (PouffeBlock.canaddKnife(blockState)) {
            world.playSound(playerEntity, blockPos, ModSounds.CUSHION_RUSTLES, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
            world.setBlockState(blockPos, blockState.with(PouffeBlock.KNIFE, true), Block.NOTIFY_ALL_AND_REDRAW);
            world.emitGameEvent(playerEntity, GameEvent.BLOCK_CHANGE, blockPos);
            if (playerEntity != null) {
                context.getStack().decrement(1);
            }

            return ActionResult.success(world.isClient());
        }
        if (CushionBlock.canaddKnife(blockState)) {
            world.playSound(playerEntity, blockPos, ModSounds.CUSHION_RUSTLES, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
            world.setBlockState(blockPos, blockState.with(CushionBlock.KNIFE, true), Block.NOTIFY_ALL_AND_REDRAW);
            world.emitGameEvent(playerEntity, GameEvent.BLOCK_CHANGE, blockPos);
            if (playerEntity != null) {
                context.getStack().decrement(1);
            }

            return ActionResult.success(world.isClient());
        }
        else {
            return ActionResult.FAIL;
        }
    }
}

