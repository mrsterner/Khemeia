package dev.mrsterner.alchimia.client.renderer;

import dev.mrsterner.alchimia.client.model.MagnumOpusItemModel;
import dev.mrsterner.alchimia.common.item.MagnumOpusItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class MagnumOpusItemRenderer extends GeoItemRenderer<MagnumOpusItem> {
    public MagnumOpusItemRenderer() {
        super(new MagnumOpusItemModel());
    }
}
