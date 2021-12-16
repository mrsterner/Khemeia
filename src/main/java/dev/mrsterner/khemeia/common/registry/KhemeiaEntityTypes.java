package dev.mrsterner.khemeia.common.registry;

import dev.mrsterner.khemeia.common.block.blockentity.DwarfInAFlaskBlockEntity;
import dev.mrsterner.khemeia.common.block.cedar.CedarChestBlockEntity;
import dev.mrsterner.khemeia.common.block.cedar.KhemeiaChestBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;

import static dev.mrsterner.khemeia.common.utils.KhemeiaUtils.register;

public class KhemeiaEntityTypes {
    public static final BlockEntityType<KhemeiaChestBlockEntity> KHEMEIA_CHEST = register("khemeia_chest", FabricBlockEntityTypeBuilder.create(KhemeiaChestBlockEntity::new, KhemeiaObjects.CEDAR_CHEST, KhemeiaObjects.TRAPPED_CEDAR_CHEST).build(null));

    public static final BlockEntityType<CedarChestBlockEntity> CEDAR_CHEST_BLOCK_ENTITY = register("cedar_chest", FabricBlockEntityTypeBuilder.create(CedarChestBlockEntity::new, KhemeiaObjects.CEDAR_CHEST, KhemeiaObjects.TRAPPED_CEDAR_CHEST).build(null));
    public static final BlockEntityType<DwarfInAFlaskBlockEntity> DWARF_IN_A_FLASK_BLOCK_ENTITY = register("dwarf_in_a_flask_block_entity", FabricBlockEntityTypeBuilder.create(DwarfInAFlaskBlockEntity::new, KhemeiaObjects.DWARF_IN_A_FLASK_BLOCK).build(null));

}
