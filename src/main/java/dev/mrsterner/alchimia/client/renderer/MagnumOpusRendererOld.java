package dev.mrsterner.alchimia.client.renderer;

import dev.mrsterner.alchimia.Alchimia;
import dev.mrsterner.alchimia.client.ClientTickHandler;
import dev.mrsterner.alchimia.common.item.MagnumOpusItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BookModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

public class MagnumOpusRendererOld {
    private static BookModel model = null;
    public static final SpriteIdentifier TEXTURE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(Alchimia.MODID,"item/journal_default"));


    private static BookModel getModel() {
        if (model == null) {
            model = new BookModel(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(EntityModelLayers.BOOK));
        }
        return model;
    }

    public static void doRender(ItemStack stack, boolean leftHanded, MatrixStack ms, VertexConsumerProvider buffers, int light, float partialTicks) {
        ms.push();

        float ticks = ClientTickHandler.ticksWithLexicaOpen;
        if (ticks > 0 && ticks < 10) {
            if (MagnumOpusItem.isOpen()) {
                ticks += partialTicks;
            } else {
                ticks -= partialTicks;
            }
        }

        if (!leftHanded) {
            ms.translate(0.3F + 0.02F * ticks, 0.125F + 0.01F * ticks, -0.2F - 0.035F * ticks);
            ms.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180F + ticks * 6));
        } else {
            ms.translate(0.1F - 0.02F * ticks, 0.125F + 0.01F * ticks, -0.2F - 0.035F * ticks);
            ms.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(200F + ticks * 10));
        }
        ms.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(-0.3F + ticks * 2.85F));
        float opening = MathHelper.clamp(ticks / 12F, 0, 1);

        float pageFlipTicks = ClientTickHandler.pageFlipTicks;
        if (pageFlipTicks > 0) {
            pageFlipTicks -= ClientTickHandler.partialTicks;
        }

        float pageFlip = pageFlipTicks / 5F;

        float leftPageAngle = MathHelper.fractionalPart(pageFlip + 0.25F) * 1.6F - 0.3F;
        float rightPageAngle = MathHelper.fractionalPart(pageFlip + 0.75F) * 1.6F - 0.3F;
        var model = getModel();
        model.setPageAngles(ClientTickHandler.total, MathHelper.clamp(leftPageAngle, 0.0F, 1.0F), MathHelper.clamp(rightPageAngle, 0.0F, 1.0F), opening);
        System.out.println(TEXTURE);
        VertexConsumer buffer = TEXTURE.getVertexConsumer(buffers, RenderLayer::getEntitySolid);
        model.render(ms, buffer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);


        ms.pop();
    }
}
