package dev.mrsterner.magnumopus.mixin;

import dev.mrsterner.magnumopus.common.body.BodyParts;
import dev.mrsterner.magnumopus.common.registry.MOComponents;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin<T extends LivingEntity, M extends EntityModel<T>> extends EntityRenderer<T> implements FeatureRendererContext<T, M> {
    protected LivingEntityRendererMixin(EntityRendererFactory.Context ctx) {
        super(ctx);
    }
    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/LivingEntityRenderer;setupTransforms(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/client/util/math/MatrixStack;FFF)V"))
    private void init(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if(livingEntity instanceof PlayerEntity player){
            if(!MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.RIGHTLEG) && !MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.LEFTLEG)){
                matrixStack.translate(0,-0.75,0);
                if(!MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.TORSO) && !MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.LEFTARM) && !MOComponents.BODY_COMPONENT.get(player).hasBodyPart(BodyParts.RIGHTARM)){
                    matrixStack.translate(0,-0.65,0);
                }
            }
        }
    }
}
