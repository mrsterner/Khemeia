package dev.mrsterner.magnumopus.common.utils;

import dev.mrsterner.magnumopus.MagnumOpus;
import dev.mrsterner.magnumopus.common.body.BodyParts;
import dev.mrsterner.magnumopus.common.registry.MOComponents;
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

public class MOUtils {

    public static EntityDimensions getBodyHitbox(PlayerEntity player){
        if(!MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.HEAD)){
            return EntityDimensions.changing(0.6F, 1.45F);
        } else if(
        !MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.TORSO) &&
        !MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.RIGHTARM) &&
        !MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.LEFTARM) &&
        !MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.LEFTLEG) &&
        !MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.RIGHTLEG)){
            return EntityDimensions.changing(0.5F, 0.5F);

        }else if(!MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.LEFTLEG) && !MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.RIGHTLEG)) {
            return EntityDimensions.changing(0.6F, 1.15F);
        }
        return EntityDimensions.changing(0.6F, 1.8F);
    }
    public static float getEyesHeight(PlayerEntity player){
        if(
        !MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.TORSO) &&
        !MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.RIGHTARM) &&
        !MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.LEFTARM) &&
        !MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.LEFTLEG) &&
        !MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.RIGHTLEG)){
            return 0.25F;

        }else if(!MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.LEFTLEG) && !MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.RIGHTLEG)) {
            return 0.85F;
        }
        return 1.62F;
    }



    //Registry

    public static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    public static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();
    public static final Map<FlowableFluid, Identifier> FLUIDS = new LinkedHashMap<>();
    public static final Map<BlockEntityType<?>, Identifier> BLOCK_ENTITY_TYPES = new LinkedHashMap<>();

    public static <T extends BlockEntity> BlockEntityType<T> register(String id, BlockEntityType<T> type) {
        BLOCK_ENTITY_TYPES.put(type, new Identifier(MagnumOpus.MODID, id));
        return type;
    }

    public static <T extends Block> T register(String name, T block, boolean createItem) {
        BLOCKS.put(block, new Identifier(MagnumOpus.MODID, name));
        if (createItem) {
            ITEMS.put(new BlockItem(block, gen()), BLOCKS.get(block));
        }
        return block;
    }

    public static <T extends Item> T register(String name, T item) {
        ITEMS.put(item, new Identifier(MagnumOpus.MODID, name));
        return item;
    }

    public static Item.Settings gen() {
        return new Item.Settings().group(MagnumOpus.MAGNUM_OPUS_GROUP);
    }
}
