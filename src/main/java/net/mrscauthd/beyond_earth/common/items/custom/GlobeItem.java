package net.mrscauthd.beyond_earth.common.items.custom;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;

public class GlobeItem extends BlockItem {
    private final Identifier texture;
    public GlobeItem(Block block, Settings settings, Identifier texture) {
        super(block, settings);
        this.texture = texture;
    }

    public Identifier getTexture() {
        return texture;
    }
}
