package dev.mrsterner.alchimia.common.block.cedar;

import dev.mrsterner.alchimia.common.registry.AlchimiaEntityTypes;
import net.minecraft.block.entity.ChestBlockEntity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AlchimiaChestBlockEntity extends ChestBlockEntity {
    public final Type type;
    public final boolean trapped;

    public AlchimiaChestBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, Type type, boolean trapped) {
        super(blockEntityType, blockPos, blockState);
        this.type = type;
        this.trapped = trapped;
    }

    public AlchimiaChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(AlchimiaEntityTypes.KHEMEIA_CHEST, blockPos, blockState, Type.CEDAR, false);
    }

    @Override
    protected void onInvOpenOrClose(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
        super.onInvOpenOrClose(world, pos, state, oldViewerCount, newViewerCount);
        if (trapped && world != null) {
            world.updateNeighborsAlways(pos.down(), getCachedState().getBlock());
        }
    }

    public enum Type {
        CEDAR;
    }
}
