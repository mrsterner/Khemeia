package dev.mrsterner.alchimia.mixin;

import dev.mrsterner.alchimia.client.ClientTickHandler;
import dev.mrsterner.alchimia.common.registry.AlchimiaObjects;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemRenderer.class)
public class ItemInHandRendererMixin {
    @Inject(method = "renderItem", at = @At("HEAD"), cancellable = true)
    private void renderFirstPersonItem(LivingEntity livingEntity, ItemStack stack, ModelTransformation.Mode transformType, boolean leftHanded, MatrixStack poseStack, VertexConsumerProvider buffers, int light, CallbackInfo ci) {
        /*
        if (livingEntity instanceof PlayerEntity player && player.getMainHandStack().isOf(AlchimiaObjects.MAGNUM_OPUS)) {
            dev.mrsterner.alchimia.client.renderer.MagnumOpusRendererOld.doRender(stack, leftHanded, poseStack, buffers, light, ClientTickHandler.partialTicks);
            ci.cancel();
        }

         */
    }
}
