package dev.mrsterner.alchimia.client.model;

import dev.mrsterner.alchimia.Alchimia;
import dev.mrsterner.alchimia.common.item.MagnumOpusItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MagnumOpusItemModel extends AnimatedGeoModel<MagnumOpusItem> {
    @Override
    public Identifier getAnimationFileLocation(MagnumOpusItem entity) {
        return new Identifier(Alchimia.MODID, "animations/magnum_opus.animation.json");
    }

    @Override
    public Identifier getModelLocation(MagnumOpusItem animatable) {
        return new Identifier(Alchimia.MODID, "geo/magnum_opus.geo.json");
    }

    @Override
    public Identifier getTextureLocation(MagnumOpusItem entity) {
        return new Identifier(Alchimia.MODID, "textures/item/magnum_opus.png");
    }
}