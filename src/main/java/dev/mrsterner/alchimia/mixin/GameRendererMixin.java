package dev.mrsterner.alchimia.mixin;

import dev.mrsterner.alchimia.common.registry.AlchimiaShaders;
import net.minecraft.client.gl.Program;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.Shader;
import net.minecraft.resource.ResourceManager;
import com.mojang.datafixers.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(
    method = "loadShaders",
    at = @At(
    value = "INVOKE_ASSIGN",
    target = "Lcom/google/common/collect/Lists;newArrayListWithCapacity(I)Ljava/util/ArrayList;",
    remap = false
    ),
    locals = LocalCapture.CAPTURE_FAILHARD
    )
    private void loadShaders(ResourceManager resourceManager, CallbackInfo ci, List<Program> _programsToClose, List<Pair<Shader, Consumer<Shader>>> shadersToLoad)
    throws IOException {
        AlchimiaShaders.init(resourceManager, shadersToLoad);
    }

}