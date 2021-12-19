package dev.mrsterner.alchimia;

import dev.mrsterner.alchimia.client.ClientTickHandler;
import dev.mrsterner.alchimia.client.renderer.DwarfInAFlaskBlockRenderer;
import dev.mrsterner.alchimia.client.renderer.MagnumOpusItemRenderer;
import dev.mrsterner.alchimia.client.renderer.TheTruthEntityRenderer;
import dev.mrsterner.alchimia.common.registry.AlchimiaEntityTypes;
import dev.mrsterner.alchimia.common.registry.AlchimiaObjects;
import dev.mrsterner.alchimia.common.registry.SpriteIdentifierRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import static net.minecraft.client.render.TexturedRenderLayers.CHEST_ATLAS_TEXTURE;

public class AlchimiaClient implements ClientModInitializer {
	public static final SpriteIdentifier CEDAR_CHEST = new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier(Alchimia.MODID, "entity/chest/cedar"));
	public static final SpriteIdentifier TRAPPED_CEDAR_CHEST = new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier(Alchimia.MODID, "entity/chest/trapped_cedar"));
	public static final SpriteIdentifier CEDAR_CHEST_LEFT = new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier(Alchimia.MODID, "entity/chest/cedar_left"));
	public static final SpriteIdentifier TRAPPED_CEDAR_CHEST_LEFT = new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier(Alchimia.MODID, "entity/chest/trapped_cedar_left"));
	public static final SpriteIdentifier CEDAR_CHEST_RIGHT = new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier(Alchimia.MODID, "entity/chest/cedar_right"));
	public static final SpriteIdentifier TRAPPED_CEDAR_CHEST_RIGHT = new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier(Alchimia.MODID, "entity/chest/trapped_cedar_right"));

	@Override
	public void onInitializeClient() {
		GeoItemRenderer.registerItemRenderer(AlchimiaObjects.DWARF_IN_A_FLASK_BLOCK.asItem(), new dev.mrsterner.alchimia.client.renderer.DwarfInAFlaskItemRenderer());
		BlockEntityRendererRegistry.register(AlchimiaEntityTypes.DWARF_IN_A_FLASK_BLOCK_ENTITY, (BlockEntityRendererFactory.Context rendererDispatcherIn) -> new DwarfInAFlaskBlockRenderer());
		BlockRenderLayerMap.INSTANCE.putBlock(AlchimiaObjects.DWARF_IN_A_FLASK_BLOCK, RenderLayer.getCutout());
		BlockEntityRendererRegistry.register(AlchimiaEntityTypes.KHEMEIA_CHEST, ChestBlockEntityRenderer::new);
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(CEDAR_CHEST);
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(TRAPPED_CEDAR_CHEST);
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(CEDAR_CHEST_LEFT);
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(TRAPPED_CEDAR_CHEST_LEFT);
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(CEDAR_CHEST_RIGHT);
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(TRAPPED_CEDAR_CHEST_RIGHT);

		// ColorProvider
		ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) ->
		view != null && pos != null ? BiomeColors.getFoliageColor(view, pos) :
		FoliageColors.getDefaultColor(), AlchimiaObjects.CEDAR_LEAVES);

		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex == 0 ? 0x3f4f3b : 0xffffff, AlchimiaObjects.CEDAR_LEAVES.asItem());

		GeoItemRenderer.registerItemRenderer(AlchimiaObjects.MAGNUM_OPUS, new MagnumOpusItemRenderer());
		EntityRendererRegistry.register(AlchimiaEntityTypes.THE_TRUTH, TheTruthEntityRenderer::new);
		ClientTickEvents.END_CLIENT_TICK.register(ClientTickHandler::clientTickEnd);

	}
}
