package dev.mrsterner.magnumopus.common.components;

import dev.mrsterner.magnumopus.common.alchemy.AlchemyKnowledge;
import dev.mrsterner.magnumopus.common.alchemy.AlchemyType;
import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;

public interface IMind extends ComponentV3, ServerTickingComponent {
    AlchemyType getAlchemyType();
    void setAlchemyType(AlchemyType alchemyType);
    void addAlchemyKnowledge(AlchemyKnowledge alchemyKnowledge);
}
