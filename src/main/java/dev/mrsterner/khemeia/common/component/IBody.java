package dev.mrsterner.khemeia.common.component;

import dev.mrsterner.khemeia.common.body.BodyParts;
import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;

import java.util.Map;


public interface IBody extends ComponentV3, ServerTickingComponent {
    void setBodyPart(BodyParts bodyPart, boolean b);
    Map<BodyParts, Boolean> getBodyPart();
    boolean hasBodyPart(BodyParts bodyPart);

}


