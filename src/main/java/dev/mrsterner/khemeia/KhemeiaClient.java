package dev.mrsterner.khemeia;

import dev.mrsterner.khemeia.client.renderer.DwarfInAFlaskBlockRenderer;
import dev.mrsterner.khemeia.common.registry.KhemeiaObjects;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;

public class KhemeiaClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		BlockEntityRendererRegistry.register(KhemeiaObjects.DWARF_IN_A_FLASK_BLOCK_ENTITY, (BlockEntityRendererFactory.Context rendererDispatcherIn) -> new DwarfInAFlaskBlockRenderer());
		BlockRenderLayerMap.INSTANCE.putBlock(KhemeiaObjects.DWARF_IN_A_FLASK_BLOCK, RenderLayer.getCutout());
	}
}
