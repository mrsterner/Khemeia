package dev.mrsterner.alchimia.client.model;

import dev.mrsterner.alchimia.Alchimia;
import dev.mrsterner.alchimia.common.item.AlchimiaBlockItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DwarfInAFlaskItemModel extends AnimatedGeoModel<AlchimiaBlockItem> {
    @Override
    public Identifier getAnimationFileLocation(AlchimiaBlockItem entity) {
        return new Identifier(Alchimia.MODID, "animations/dwarf_in_a_flask.animation.json");
    }

    @Override
    public Identifier getModelLocation(AlchimiaBlockItem animatable) {
        return new Identifier(Alchimia.MODID, "geo/dwarf_in_a_flask.geo.json");
    }

    @Override
    public Identifier getTextureLocation(AlchimiaBlockItem entity) {
        return new Identifier(Alchimia.MODID, "textures/block/dwarf_in_a_flask.png");
    }
}