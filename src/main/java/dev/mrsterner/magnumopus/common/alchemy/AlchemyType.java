package dev.mrsterner.magnumopus.common.alchemy;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

import java.util.Locale;

public enum AlchemyType {
    NONE((server, player, handler1, buf, responseSender) -> {}),
    TECTONIC((server, player, handler1, buf, responseSender) -> {}),
    ALKAHESTRY((server, player, handler1, buf, responseSender) -> {});

    public ServerPlayNetworking.PlayChannelHandler handler;
    AlchemyType(ServerPlayNetworking.PlayChannelHandler handlerIn){
        handler = handlerIn;
    }
    @Override
    public String toString() {
        return "alchemy."+name().toLowerCase(Locale.ROOT);
    }
}
