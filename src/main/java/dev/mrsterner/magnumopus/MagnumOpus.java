package dev.mrsterner.magnumopus;

import dev.mrsterner.magnumopus.common.registry.MOObjects;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MagnumOpus implements ModInitializer {

	public static final String MODID = "thermus";
	public static final ItemGroup MAGNUM_OPUS_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, MODID), () -> new ItemStack(MOObjects.PHILOSOPHERS_STONE));

	@Override
	public void onInitialize() {
	}
}
