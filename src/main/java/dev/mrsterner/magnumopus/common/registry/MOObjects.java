package dev.mrsterner.magnumopus.common.registry;

import dev.mrsterner.magnumopus.common.items.MODebugItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import static dev.mrsterner.magnumopus.common.utils.MOUtils.*;

public class MOObjects {
    public static final Item PHILOSOPHERS_STONE = register("philosophers_stone", new Item(gen()));
    public static final Item MO_DEBUG_STICK = register("mo_debug_stick", new MODebugItem(gen()));






    public static void init() {
        BLOCKS.keySet().forEach(block -> Registry.register(Registry.BLOCK, BLOCKS.get(block), block));
        BLOCK_ENTITY_TYPES.keySet().forEach(blockEntityType -> Registry.register(Registry.BLOCK_ENTITY_TYPE, BLOCK_ENTITY_TYPES.get(blockEntityType), blockEntityType));
        FLUIDS.keySet().forEach(fluid -> Registry.register(Registry.FLUID, FLUIDS.get(fluid), fluid));
        ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));
    }
}
