package dev.mrsterner.magnumopus.common.components;

import dev.mrsterner.magnumopus.common.alchemy.AlchemyType;
import dev.mrsterner.magnumopus.common.body.BodyParts;
import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public interface IBody extends ComponentV3, ServerTickingComponent {
    void setBodyPart(BodyParts bodyPart, boolean b);
    Map<BodyParts, Boolean> getBodyPart();
    boolean hasBodyPart(BodyParts bodyPart);
}
