package dev.mrsterner.alchimia.common.registry;

import dev.mrsterner.alchimia.Alchimia;
import dev.mrsterner.alchimia.common.component.BodyComponent;
import dev.mrsterner.alchimia.common.component.IMind;
import dev.mrsterner.alchimia.common.component.MindComponent;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class AlchimiaComponents implements EntityComponentInitializer, WorldComponentInitializer {
    public static final ComponentKey<BodyComponent> BODY_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(Alchimia.MODID, "body"), BodyComponent.class);
    public static final ComponentKey<IMind> MIND_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(Alchimia.MODID, "mind"), IMind.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.beginRegistration(PlayerEntity.class, BODY_COMPONENT).respawnStrategy(RespawnCopyStrategy.ALWAYS_COPY).end(BodyComponent::new);
        registry.beginRegistration(PlayerEntity.class, MIND_COMPONENT).impl(MindComponent.class).end(MindComponent::new);

    }

    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {

    }
}
