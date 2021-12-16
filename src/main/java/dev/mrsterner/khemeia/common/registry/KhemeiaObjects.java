package dev.mrsterner.khemeia.common.registry;

import dev.mrsterner.khemeia.Khemeia;
import dev.mrsterner.khemeia.common.block.cedar.*;
import dev.mrsterner.khemeia.common.block.DwarfInAFlaskBlock;
import dev.mrsterner.khemeia.common.block.blockentity.DwarfInAFlaskBlockEntity;
import dev.mrsterner.khemeia.common.item.KhemeiaDebugItem;
import dev.mrsterner.khemeia.common.world.generator.tree.CedarSaplingGenerator;
import dev.mrsterner.khemeia.mixin.BlocksMixin;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.item.TallBlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static dev.mrsterner.khemeia.common.utils.KhemeiaUtils.*;
import static net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings.copyOf;

public class KhemeiaObjects {
    public static final Item PHILOSOPHERS_STONE = register("philosophers_stone", new Item(gen()));
    public static final Item ICHOR = register("ichor", new Item(gen()));
    public static final Item ICHORCLOTH = register("ichorcloth", new Item(gen()));
    public static final Item ICHORIUM = register("ichorium", new Item(gen()));
    public static final Item ICHORIUM_PICKAXE = register("ichorium_pickaxe", new Item(gen()));
    public static final Item ICHORIUM_AXE = register("ichorium_axe", new Item(gen()));
    public static final Item ICHORIUM_SWORD = register("ichorium_sword", new Item(gen()));
    public static final Item ICHORIUM_SHOVEL = register("ichorium_shovel", new Item(gen()));
    public static final Item ICHORIUM_HOE = register("ichorium_hoe", new Item(gen()));
    public static final Item SOUL_OF_GREED = register("soul_of_greed", new Item(gen()));
    public static final Item SOUL_OF_PRIDE = register("soul_of_pride", new Item(gen()));
    public static final Item SOUL_OF_WRATH = register("soul_of_wrath", new Item(gen()));
    public static final Item SOUL_OF_ENVY = register("soul_of_envy", new Item(gen()));
    public static final Item SOUL_OF_LUST = register("soul_of_lust", new Item(gen()));
    public static final Item SOUL_OF_GLUTTONY = register("soul_of_gluttony", new Item(gen()));
    public static final Item SOUL_OF_SLOTH = register("soul_of_sloth", new Item(gen()));
    public static final Item SOUL_OF_NETHER = register("soul_of_nether", new Item(gen()));
    public static final Item SOUL_OF_END = register("soul_of_end", new Item(gen()));
    public static final Item OUROBOURUS = register("ouroboros", new Item(gen()));
    public static final Item MO_DEBUG_STICK = register("mo_debug_stick", new KhemeiaDebugItem(gen()));

    public static final Block STRIPPED_CEDAR_LOG = register("stripped_cedar_log", new PillarBlock(copyOf(Blocks.OAK_LOG)), true);
    public static final Block STRIPPED_CEDAR_WOOD = register("stripped_cedar_wood", new PillarBlock(copyOf(STRIPPED_CEDAR_LOG)), true);
    public static final Block CEDAR_LOG = register("cedar_log", new CedarLogBlock(() -> STRIPPED_CEDAR_LOG, MapColor.BROWN, copyOf(STRIPPED_CEDAR_LOG)), true);
    public static final Block CEDAR_WOOD = register("cedar_wood", new CedarLogBlock(() -> STRIPPED_CEDAR_WOOD, MapColor.BROWN, copyOf(STRIPPED_CEDAR_LOG)), true);
    public static final Block CEDAR_PLANKS = register("cedar_planks", new Block(copyOf(Blocks.OAK_PLANKS)), true);
    public static final Block CEDAR_SLAB = register("cedar_slab", new SlabBlock(copyOf(Blocks.OAK_SLAB)), true);
    public static final Block CEDAR_FENCE = register("cedar_fence", new FenceBlock(copyOf(Blocks.OAK_FENCE)), true);
    public static final Block CEDAR_FENCE_GATE = register("cedar_fence_gate", new FenceGateBlock(copyOf(Blocks.OAK_FENCE_GATE)), true);
    public static final Block CEDAR_LEAVES = register("cedar_leaves", BlocksMixin.callCreateLeavesBlock(BlockSoundGroup.GRASS), true);
    public static final Block CEDAR_SAPLING = register("cedar_sapling", new CedarSaplingBlock(new CedarSaplingGenerator(), copyOf(Blocks.OAK_SAPLING)), true);
    public static final Block POTTED_CEDAR_SAPLING = register("potted_cedar_sapling", new FlowerPotBlock(CEDAR_SAPLING, copyOf(Blocks.POTTED_OAK_SAPLING)), false);
    public static final Block CEDAR_PRESSURE_PLATE = register("cedar_pressure_plate", new CedarPressurePlateBlock(copyOf(Blocks.OAK_PRESSURE_PLATE)), true);
    public static final Block CEDAR_BUTTON = register("cedar_button", new CedarButtonBlock(copyOf(Blocks.OAK_BUTTON)), true);
    public static final Block CEDAR_TRAPDOOR = register("cedar_trapdoor", new CedarTrapdoorBlock(copyOf(Blocks.OAK_TRAPDOOR)), true);
    public static final Block CEDAR_DOOR = register("cedar_door", new CedarDoorBlock(copyOf(Blocks.OAK_DOOR)), false);
    public static final Item CEDAR_DOOR_ITEM = register("cedar_door", new TallBlockItem(CEDAR_DOOR, gen()));
    public static final Block CEDAR_CHEST = register("cedar_chest", new CedarChestBlock(copyOf(Blocks.CHEST), () -> KhemeiaEntityTypes.CEDAR_CHEST_BLOCK_ENTITY, false), true);
    public static final Block TRAPPED_CEDAR_CHEST = register("trapped_cedar_chest", new CedarChestBlock(copyOf(Blocks.CHEST), () -> KhemeiaEntityTypes.CEDAR_CHEST_BLOCK_ENTITY, true), true);
    private static final Identifier CEDAR_SIGN_TEXTURE = new Identifier(Khemeia.MODID, "entity/sign/cedar");
    public static final CedarSignBlock CEDAR_SIGN = register("cedar_sign", new CedarSignBlock(CEDAR_SIGN_TEXTURE, copyOf(Blocks.OAK_SIGN)), false);
    public static final Block CEDAR_WALL_SIGN = register("cedar_wall_sign", new CedarWallSignBlock(CEDAR_SIGN_TEXTURE, copyOf(Blocks.OAK_WALL_SIGN)), false);
    public static final Item CEDAR_SIGN_ITEM = register("cedar_sign", new SignItem(gen().maxCount(16), CEDAR_SIGN, CEDAR_WALL_SIGN));

    public static final Block DWARF_IN_A_FLASK_BLOCK = registerBlockItem("dwarf_in_a_flask", new DwarfInAFlaskBlock(FabricBlockSettings.of(Material.GLASS).hardness(2.0F).breakInstantly()), true);




    public static void init() {
        BLOCKS.keySet().forEach(block -> Registry.register(Registry.BLOCK, BLOCKS.get(block), block));
        BLOCK_ENTITY_TYPES.keySet().forEach(blockEntityType -> Registry.register(Registry.BLOCK_ENTITY_TYPE, BLOCK_ENTITY_TYPES.get(blockEntityType), blockEntityType));
        FLUIDS.keySet().forEach(fluid -> Registry.register(Registry.FLUID, FLUIDS.get(fluid), fluid));
        ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));
    }
}
