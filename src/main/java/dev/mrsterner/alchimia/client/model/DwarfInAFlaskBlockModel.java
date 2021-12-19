package dev.mrsterner.alchimia.client.model;

import dev.mrsterner.alchimia.Alchimia;
import dev.mrsterner.alchimia.common.block.blockentity.DwarfInAFlaskBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DwarfInAFlaskBlockModel extends AnimatedGeoModel<DwarfInAFlaskBlockEntity> {

    @Override
    public Identifier getModelLocation(DwarfInAFlaskBlockEntity object) {
        return new Identifier(Alchimia.MODID, "geo/dwarf_in_a_flask.geo.json");
    }

    @Override
    public Identifier getTextureLocation(DwarfInAFlaskBlockEntity object) {
        return new Identifier(Alchimia.MODID, "textures/block/dwarf_in_a_flask.png");
    }

    @Override
    public Identifier getAnimationFileLocation(DwarfInAFlaskBlockEntity animatable) {
        return new Identifier(Alchimia.MODID, "animations/dwarf_in_a_flask.animation.json");
    }
}