package dev.mrsterner.khemeia;

import dev.mrsterner.khemeia.client.renderer.DwarfInAFlaskBlockRenderer;
import dev.mrsterner.khemeia.client.renderer.DwarfInAFlaskItemRender;
import dev.mrsterner.khemeia.common.registry.KhemeiaEntityTypes;
import dev.mrsterner.khemeia.common.registry.KhemeiaObjects;
import dev.mrsterner.khemeia.common.registry.SpriteIdentifierRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import static net.minecraft.client.render.TexturedRenderLayers.CHEST_ATLAS_TEXTURE;

public class KhemeiaClient implements ClientModInitializer {
	public static final SpriteIdentifier CEDAR_CHEST = new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier(Khemeia.MODID, "entity/chest/cedar"));
	public static final SpriteIdentifier TRAPPED_CEDAR_CHEST = new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier(Khemeia.MODID, "entity/chest/trapped_cedar"));
	public static final SpriteIdentifier CEDAR_CHEST_LEFT = new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier(Khemeia.MODID, "entity/chest/cedar_left"));
	public static final SpriteIdentifier TRAPPED_CEDAR_CHEST_LEFT = new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier(Khemeia.MODID, "entity/chest/trapped_cedar_left"));
	public static final SpriteIdentifier CEDAR_CHEST_RIGHT = new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier(Khemeia.MODID, "entity/chest/cedar_right"));
	public static final SpriteIdentifier TRAPPED_CEDAR_CHEST_RIGHT = new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier(Khemeia.MODID, "entity/chest/trapped_cedar_right"));

	@Override
	public void onInitializeClient() {
		GeoItemRenderer.registerItemRenderer(KhemeiaObjects.DWARF_IN_A_FLASK_BLOCK.asItem(), new DwarfInAFlaskItemRender());
		BlockEntityRendererRegistry.register(KhemeiaEntityTypes.DWARF_IN_A_FLASK_BLOCK_ENTITY, (BlockEntityRendererFactory.Context rendererDispatcherIn) -> new DwarfInAFlaskBlockRenderer());
		BlockRenderLayerMap.INSTANCE.putBlock(KhemeiaObjects.DWARF_IN_A_FLASK_BLOCK, RenderLayer.getCutout());
		BlockEntityRendererRegistry.register(KhemeiaEntityTypes.KHEMEIA_CHEST, ChestBlockEntityRenderer::new);
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(CEDAR_CHEST);
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(TRAPPED_CEDAR_CHEST);
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(CEDAR_CHEST_LEFT);
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(TRAPPED_CEDAR_CHEST_LEFT);
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(CEDAR_CHEST_RIGHT);
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(TRAPPED_CEDAR_CHEST_RIGHT);
	}
}
