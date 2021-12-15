package dev.mrsterner.khemeia.client.renderer;

import dev.mrsterner.khemeia.client.model.DwarfInAFlaskBlockModel;
import dev.mrsterner.khemeia.common.block.blockentity.DwarfInAFlaskBlockEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class DwarfInAFlaskBlockRenderer extends GeoBlockRenderer<DwarfInAFlaskBlockEntity> {
    public DwarfInAFlaskBlockRenderer() {
        super(new DwarfInAFlaskBlockModel());
    }

    @Override
    public RenderLayer getRenderType(DwarfInAFlaskBlockEntity animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
    }


}