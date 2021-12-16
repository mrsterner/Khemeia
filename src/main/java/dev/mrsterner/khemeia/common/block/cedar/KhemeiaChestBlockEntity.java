package dev.mrsterner.khemeia.common.block.cedar;

import dev.mrsterner.khemeia.common.registry.KhemeiaEntityTypes;
import net.minecraft.block.entity.ChestBlockEntity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KhemeiaChestBlockEntity extends ChestBlockEntity {
    public final Type type;
    public final boolean trapped;

    public KhemeiaChestBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, Type type, boolean trapped) {
        super(blockEntityType, blockPos, blockState);
        this.type = type;
        this.trapped = trapped;
    }

    public KhemeiaChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(KhemeiaEntityTypes.KHEMEIA_CHEST, blockPos, blockState, Type.CEDAR, false);
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
