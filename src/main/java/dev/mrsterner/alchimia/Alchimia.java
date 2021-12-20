package dev.mrsterner.alchimia;

import dev.mrsterner.alchimia.common.events.AlchimiaEvents;
import dev.mrsterner.alchimia.common.registry.AlchimiaEntityTypes;
import dev.mrsterner.alchimia.common.registry.AlchimiaObjects;
import dev.mrsterner.alchimia.common.registry.AlchimiaWorldGenerators;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Alchimia implements ModInitializer {

	public static final String MODID = "alchimia";
	public static final ItemGroup KHEMEIA_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, MODID), () -> new ItemStack(AlchimiaObjects.PHILOSOPHERS_STONE));
	public static AlchimiaConfig config;
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	AlchimiaEvents alchimiaEvents = new AlchimiaEvents();

	@Override
	public void onInitialize() {
		AutoConfig.register(AlchimiaConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(AlchimiaConfig.class).getConfig();
		AlchimiaObjects.init();
		AlchimiaEntityTypes.init();
		AlchimiaWorldGenerators.init();
		alchimiaEvents.init();



	}
}
