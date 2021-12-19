package dev.mrsterner.alchimia.common.registry;

import dev.mrsterner.alchimia.common.block.blockentity.DwarfInAFlaskBlockEntity;
import dev.mrsterner.alchimia.common.block.cedar.CedarChestBlockEntity;
import dev.mrsterner.alchimia.common.block.cedar.AlchimiaChestBlockEntity;
import dev.mrsterner.alchimia.common.entity.TheTruthEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

import static dev.mrsterner.alchimia.common.utils.AlchimiaUtils.*;

public class AlchimiaEntityTypes {
    public static final BlockEntityType<AlchimiaChestBlockEntity> KHEMEIA_CHEST = register("alchimia_chest", FabricBlockEntityTypeBuilder.create(AlchimiaChestBlockEntity::new, AlchimiaObjects.CEDAR_CHEST, AlchimiaObjects.TRAPPED_CEDAR_CHEST).build(null));

    public static final BlockEntityType<CedarChestBlockEntity> CEDAR_CHEST_BLOCK_ENTITY = register("cedar_chest", FabricBlockEntityTypeBuilder.create(CedarChestBlockEntity::new, AlchimiaObjects.CEDAR_CHEST, AlchimiaObjects.TRAPPED_CEDAR_CHEST).build(null));
    public static final BlockEntityType<DwarfInAFlaskBlockEntity> DWARF_IN_A_FLASK_BLOCK_ENTITY = register("dwarf_in_a_flask_block_entity", FabricBlockEntityTypeBuilder.create(DwarfInAFlaskBlockEntity::new, AlchimiaObjects.DWARF_IN_A_FLASK_BLOCK).build(null));
    public static final EntityType<TheTruthEntity> THE_TRUTH = register("the_truth", FabricEntityTypeBuilder.<TheTruthEntity>create(SpawnGroup.CREATURE, TheTruthEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.8F)).trackRangeBlocks(10).build());


    public static void init(){
        ENTITY_TYPES.keySet().forEach(entityType -> Registry.register(Registry.ENTITY_TYPE, ENTITY_TYPES.get(entityType), entityType));
        FabricDefaultAttributeRegistry.register(THE_TRUTH, TheTruthEntity.createAttributes());
    }
}
