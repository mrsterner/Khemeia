package dev.mrsterner.khemeia.client.model;

import dev.mrsterner.khemeia.Khemeia;
import dev.mrsterner.khemeia.common.item.KhemeiaBlockItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DwarfInAFlaskItemModel extends AnimatedGeoModel<KhemeiaBlockItem> {
    @Override
    public Identifier getAnimationFileLocation(KhemeiaBlockItem entity) {
        return new Identifier(Khemeia.MODID, "animations/dwarf_in_a_flask.animation.json");
    }

    @Override
    public Identifier getModelLocation(KhemeiaBlockItem animatable) {
        return new Identifier(Khemeia.MODID, "geo/dwarf_in_a_flask.geo.json");
    }

    @Override
    public Identifier getTextureLocation(KhemeiaBlockItem entity) {
        return new Identifier(Khemeia.MODID, "textures/block/dwarf_in_a_flask.png");
    }
}