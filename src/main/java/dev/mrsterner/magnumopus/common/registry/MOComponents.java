package dev.mrsterner.magnumopus.common.registry;

import dev.mrsterner.magnumopus.MagnumOpus;
import dev.mrsterner.magnumopus.common.components.BodyComponent;
import dev.mrsterner.magnumopus.common.components.IBody;
import dev.mrsterner.magnumopus.common.components.IMind;
import dev.mrsterner.magnumopus.common.components.MindComponent;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class MOComponents implements EntityComponentInitializer, WorldComponentInitializer {
    public static final ComponentKey<IBody> BODY_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(MagnumOpus.MODID, "body"), IBody.class);
    public static final ComponentKey<IMind> MIND_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(MagnumOpus.MODID, "mind"), IMind.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.beginRegistration(PlayerEntity.class, BODY_COMPONENT).impl(BodyComponent.class).end(BodyComponent::new);
        registry.beginRegistration(PlayerEntity.class, MIND_COMPONENT).impl(MindComponent.class).end(MindComponent::new);
    }

    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {

    }
}
