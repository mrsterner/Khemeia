package dev.mrsterner.alchimia.client;

import dev.mrsterner.alchimia.common.item.MagnumOpusItem;
import net.minecraft.client.MinecraftClient;

public final class ClientTickHandler {

    private ClientTickHandler() {}

    public static int ticksWithLexicaOpen = 0;
    public static int pageFlipTicks = 0;
    public static int ticksInGame = 0;
    public static float partialTicks = 0;
    public static float delta = 0;
    public static float total = 0;

    public static void calcDelta() {
        float oldTotal = total;
        total = ticksInGame + partialTicks;
        delta = total - oldTotal;
    }

    public static void renderTick(float renderTickTime) {
        partialTicks = renderTickTime;
    }

    public static void clientTickEnd(MinecraftClient mc) {
        int ticksToOpen = 10;
        if (MagnumOpusItem.isOpen()) {
            if (ticksWithLexicaOpen < 0) {
                ticksWithLexicaOpen = 0;
            }
            if (ticksWithLexicaOpen < ticksToOpen) {
                ticksWithLexicaOpen++;
            }
            if (pageFlipTicks > 0) {
                pageFlipTicks--;
            }
        } else {
            pageFlipTicks = 0;
            if (ticksWithLexicaOpen > 0) {
                if (ticksWithLexicaOpen > ticksToOpen) {
                    ticksWithLexicaOpen = ticksToOpen;
                }
                ticksWithLexicaOpen--;
            }
        }
        calcDelta();
    }

    public static void notifyPageChange() {
        if (pageFlipTicks == 0) {
            pageFlipTicks = 5;
        }
    }

}