package dev.mrsterner.alchimia.common.registry;

import net.minecraft.client.render.Shader;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class AlchimiaShaders {
    private static Shader theThruth;

    public static void init(ResourceManager resourceManager, List<Pair<Shader, Consumer<Shader>>> registrations) throws IOException {
        registrations.add(Pair.of(
        new Shader(resourceManager, "alchimia__thetruth", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL),
        inst -> theThruth = inst)
        );
    }
    public static Shader theTruth() {
        return theThruth;
    }

}
