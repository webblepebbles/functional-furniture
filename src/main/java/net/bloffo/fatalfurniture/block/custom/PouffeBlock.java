package net.bloffo.fatalfurniture.block.custom;

import com.mojang.serialization.MapCodec;
import net.bloffo.fatalfurniture.entity.ModEntities;
import net.bloffo.fatalfurniture.entity.custom.CushionEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class PouffeBlock extends Block {
    public static final MapCodec<PouffeBlock> CODEC = createCodec(PouffeBlock::new);
    private static final VoxelShape SHAPE = Block.createCuboidShape(3, 0, 3, 13, 7, 13);
    public static final BooleanProperty KNIFE = BooleanProperty.of("knife");

    public PouffeBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(KNIFE, false));
    }

    private static final RegistryKey<DamageType> KNIFESIT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
            Identifier.of("fatalfurniture", "knifedamage"));

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            Entity entity = null;
            List<CushionEntity> entities = world.getEntitiesByType(ModEntities.CUSHION, new Box(pos), cushion -> true);
            if (entities.isEmpty()) {
                if (!player.isSneaking()) {
                    world.playSound(null, pos, SoundEvents.BLOCK_WOOL_STEP, SoundCategory.BLOCKS, 1.0F,
                            world.getRandom().nextFloat() * 0.4F + 0.8F);
                    entity = ModEntities.CHAIR.spawn((ServerWorld) world, pos, SpawnReason.TRIGGERED);
                    if (state.get(KNIFE)) {
                        assert entity != null;

                        ServerWorld serverWorld = (ServerWorld) world;
                        DamageSource source = serverWorld.getDamageSources().create(KNIFESIT);
                        player.damage(source, 4.0F);
                    }
                }
            } else {
                entity = entities.get(-1);
            }

            player.startRiding(entity);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public static boolean canaddKnife(BlockState state) {
        return state.isIn(BlockTags.WOOL, statex -> statex.contains(KNIFE))
                && !state.get(KNIFE);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(KNIFE);
    }
}
