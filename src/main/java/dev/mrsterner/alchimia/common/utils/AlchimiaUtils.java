package dev.mrsterner.alchimia.common.utils;

import dev.mrsterner.alchimia.Alchimia;
import dev.mrsterner.alchimia.common.body.BodyParts;
import dev.mrsterner.alchimia.common.item.AlchimiaBlockItem;
import dev.mrsterner.alchimia.common.registry.AlchimiaComponents;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class AlchimiaUtils {

    private static LinkedHashSet<Integer> disabledSlots = new LinkedHashSet<>();
    public static boolean isDisabled(int slot) {
        return disabledSlots.contains(slot);
    }

    public static void lockSlot(int slot) {
        disabledSlots.add(slot);
    }

    public static void unlockSlot(int slot) {
        disabledSlots.remove(slot);
    }

    public static boolean ifMissingArmsLegsTorso(PlayerEntity player){
        return !AlchimiaComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.TORSO) &&
               !AlchimiaComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.RIGHTARM) &&
               !AlchimiaComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.LEFTARM) &&
               !AlchimiaComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.LEFTLEG) &&
               !AlchimiaComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.RIGHTLEG);
    }

    public static boolean ifMissingLegs(PlayerEntity player){
        return !AlchimiaComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.LEFTLEG) &&
               !AlchimiaComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.RIGHTLEG);
    }

    public static void removeBodyPart(PlayerEntity player, BodyParts bodyParts){
        AlchimiaComponents.BODY_COMPONENT.get(player).setBodyPart(bodyParts, false);
        switch (bodyParts){
            case STOMACH -> {}
            case EYES -> {}
            case LEFTLEG -> {}
            case RIGHTLEG -> {}
            case LEFTARM -> {
                player.dropItem(player.getOffHandStack(), false);
                lockSlot(40);
            }
            case RIGHTARM -> {player.dropItem(player.getMainHandStack(), false);}
            case TORSO -> {}
            case HEAD -> {}
        }
    }


    //Registry

    public static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    public static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();
    public static final Map<FlowableFluid, Identifier> FLUIDS = new LinkedHashMap<>();
    public static final Map<BlockEntityType<?>, Identifier> BLOCK_ENTITY_TYPES = new LinkedHashMap<>();
    public static final Map<EntityType<?>, Identifier> ENTITY_TYPES = new LinkedHashMap<>();

    public static <T extends BlockEntity> BlockEntityType<T> register(String id, BlockEntityType<T> type) {
        BLOCK_ENTITY_TYPES.put(type, new Identifier(Alchimia.MODID, id));
        return type;
    }

    public static <T extends Entity> EntityType<T> register(String name, EntityType<T> type) {
        ENTITY_TYPES.put(type, new Identifier(Alchimia.MODID, name));
        return type;
    }

    public static <T extends Block> T register(String name, T block, boolean createItem) {
        BLOCKS.put(block, new Identifier(Alchimia.MODID, name));
        if (createItem) {
            ITEMS.put(new BlockItem(block, gen()), BLOCKS.get(block));
        }
        return block;
    }
    public static <T extends Block> T registerBlockItem(String name, T block, boolean createItem) {
        BLOCKS.put(block, new Identifier(Alchimia.MODID, name));
        if (createItem) {
            ITEMS.put(new AlchimiaBlockItem(block, gen()), BLOCKS.get(block));
        }
        return block;
    }

    public static <T extends Item> T register(String name, T item) {
        ITEMS.put(item, new Identifier(Alchimia.MODID, name));
        return item;
    }

    public static Item.Settings gen() {
        return new Item.Settings().group(Alchimia.KHEMEIA_GROUP);
    }
}
