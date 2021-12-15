package dev.mrsterner.khemeia;

import dev.mrsterner.khemeia.common.registry.KhemeiaObjects;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Khemeia implements ModInitializer {

	public static final String MODID = "khemeia";
	public static final ItemGroup KHEMEIA_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, MODID), () -> new ItemStack(KhemeiaObjects.PHILOSOPHERS_STONE));
	public static KhemeiaConfig config;

	@Override
	public void onInitialize() {
		AutoConfig.register(KhemeiaConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(KhemeiaConfig.class).getConfig();
		KhemeiaObjects.init();
	}
}
