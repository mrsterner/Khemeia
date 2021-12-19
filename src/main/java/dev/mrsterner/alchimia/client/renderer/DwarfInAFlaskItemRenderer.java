package dev.mrsterner.alchimia.client.renderer;

import dev.mrsterner.alchimia.client.model.DwarfInAFlaskItemModel;
import dev.mrsterner.alchimia.common.item.AlchimiaBlockItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class DwarfInAFlaskItemRenderer extends GeoItemRenderer<AlchimiaBlockItem> {
    public DwarfInAFlaskItemRenderer() {
        super(new DwarfInAFlaskItemModel());
    }
}
