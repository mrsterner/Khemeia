package dev.mrsterner.alchimia.common.utils;

import dev.mrsterner.alchimia.Alchimia;
import dev.mrsterner.alchimia.common.registry.AlchimiaShaders;
import dev.mrsterner.alchimia.mixin.RenderLayerAccessor;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.function.Function;

public class AlchimiaRenderHelper extends RenderLayer{

    public AlchimiaRenderHelper(String name, VertexFormat vertexFormat, VertexFormat.DrawMode drawMode, int expectedBufferSize, boolean hasCrumbling, boolean translucent, Runnable startAction, Runnable endAction) {
        super(name, vertexFormat, drawMode, expectedBufferSize, hasCrumbling, translucent, startAction, endAction);
        throw new UnsupportedOperationException("Should not be instantiated");
    }

    private static RenderLayer makeLayer(String name, VertexFormat format, VertexFormat.DrawMode mode, int bufSize, boolean hasCrumbling, boolean sortOnUpload, RenderLayer.MultiPhaseParameters glState) {
        return RenderLayerAccessor.callOf(name, format, mode, bufSize, hasCrumbling, sortOnUpload, glState);
    }

    private static RenderLayer makeLayer(String name, VertexFormat format, VertexFormat.DrawMode mode, int bufSize, RenderLayer.MultiPhaseParameters glState) {
        return makeLayer(name, format, mode, bufSize, false, false, glState);
    }


    private static final Function<Identifier, RenderLayer> DOPPLEGANGER = Util.memoize(texture -> {
        // [VanillaCopy] entity_translucent, with own shader
        RenderLayer.MultiPhaseParameters glState = RenderLayer.MultiPhaseParameters.builder()
        .shader(new RenderPhase.Shader(AlchimiaShaders::theTruth))
        .texture(new RenderPhase.Texture(texture, false, false))
        .transparency(TRANSLUCENT_TRANSPARENCY)
        .cull(DISABLE_CULLING)
        .lightmap(ENABLE_LIGHTMAP)
        .overlay(ENABLE_OVERLAY_COLOR)
        .build(true);
        return makeLayer(Alchimia.MODID + "theTruth", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, VertexFormat.DrawMode.QUADS, 256, true, true, glState);
    });

    public static RenderLayer getTheTruthLayer(Identifier texture) {
        return DOPPLEGANGER.apply(texture);
    }
}
