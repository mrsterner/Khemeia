package dev.mrsterner.khemeia.common.utils;

import dev.mrsterner.khemeia.Khemeia;
import dev.mrsterner.khemeia.common.body.BodyParts;
import dev.mrsterner.khemeia.common.item.KhemeiaBlockItem;
import dev.mrsterner.khemeia.common.registry.KhemeiaComponents;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public class KhemeiaUtils {

    public static boolean ifMissingArmsLegsTorso(PlayerEntity player){
        return !KhemeiaComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.TORSO) &&
               !KhemeiaComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.RIGHTARM) &&
               !KhemeiaComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.LEFTARM) &&
               !KhemeiaComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.LEFTLEG) &&
               !KhemeiaComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.RIGHTLEG);
    }

    public static boolean ifMissingLegs(PlayerEntity player){
        return !KhemeiaComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.LEFTLEG) &&
               !KhemeiaComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.RIGHTLEG);
    }



    //Registry

    public static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    public static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();
    public static final Map<FlowableFluid, Identifier> FLUIDS = new LinkedHashMap<>();
    public static final Map<BlockEntityType<?>, Identifier> BLOCK_ENTITY_TYPES = new LinkedHashMap<>();

    public static <T extends BlockEntity> BlockEntityType<T> register(String id, BlockEntityType<T> type) {
        BLOCK_ENTITY_TYPES.put(type, new Identifier(Khemeia.MODID, id));
        return type;
    }

    public static <T extends Block> T register(String name, T block, boolean createItem) {
        BLOCKS.put(block, new Identifier(Khemeia.MODID, name));
        if (createItem) {
            ITEMS.put(new BlockItem(block, gen()), BLOCKS.get(block));
        }
        return block;
    }
    public static <T extends Block> T registerBlockItem(String name, T block, boolean createItem) {
        BLOCKS.put(block, new Identifier(Khemeia.MODID, name));
        if (createItem) {
            ITEMS.put(new KhemeiaBlockItem(block, gen()), BLOCKS.get(block));
        }
        return block;
    }

    public static <T extends Item> T register(String name, T item) {
        ITEMS.put(item, new Identifier(Khemeia.MODID, name));
        return item;
    }

    public static Item.Settings gen() {
        return new Item.Settings().group(Khemeia.KHEMEIA_GROUP);
    }
}
