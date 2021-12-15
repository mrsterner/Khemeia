package dev.mrsterner.khemeia.client.renderer;

import dev.mrsterner.khemeia.client.model.DwarfInAFlaskItemModel;
import dev.mrsterner.khemeia.common.item.KhemeiaBlockItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class DwarfInAFlaskItemRender extends GeoItemRenderer<KhemeiaBlockItem> {
    public DwarfInAFlaskItemRender() {
        super(new DwarfInAFlaskItemModel());
    }
}
