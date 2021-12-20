package dev.mrsterner.alchimia.common.events;

import dev.mrsterner.alchimia.common.body.BodyParts;
import dev.mrsterner.alchimia.common.registry.AlchimiaComponents;
import dev.mrsterner.alchimia.common.utils.AlchimiaUtils;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.server.world.ServerWorld;

public class AlchimiaEvents implements ServerTickEvents.StartWorldTick {

    public void init() {
        ServerTickEvents.START_WORLD_TICK.register(this);
    }

    @Override
    public void onStartTick(ServerWorld serverWorld) {
        serverWorld.getPlayers().stream().forEach(serverPlayerEntity -> {
            if(AlchimiaUtils.ifMissingLegs(serverPlayerEntity)){
                serverPlayerEntity.dropItem(serverPlayerEntity.getEquippedStack(EquipmentSlot.LEGS).getItem(), 1);
                serverPlayerEntity.getEquippedStack(EquipmentSlot.LEGS).decrement(1);
                serverPlayerEntity.dropItem(serverPlayerEntity.getEquippedStack(EquipmentSlot.FEET).getItem(), 1);
                serverPlayerEntity.getEquippedStack(EquipmentSlot.FEET).decrement(1);
            }
            if(!AlchimiaComponents.BODY_COMPONENT.get(serverPlayerEntity).hasBodyPart(BodyParts.TORSO)){
                serverPlayerEntity.dropItem(serverPlayerEntity.getEquippedStack(EquipmentSlot.CHEST).getItem(), 1);
                serverPlayerEntity.getEquippedStack(EquipmentSlot.CHEST).decrement(1);
            }
            if(!AlchimiaComponents.BODY_COMPONENT.get(serverPlayerEntity).hasBodyPart(BodyParts.HEAD)){
                serverPlayerEntity.dropItem(serverPlayerEntity.getEquippedStack(EquipmentSlot.HEAD).getItem(), 1);
                serverPlayerEntity.getEquippedStack(EquipmentSlot.HEAD).decrement(1);
            }
        });
    }
}
