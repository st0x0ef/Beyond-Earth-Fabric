package com.st0x0ef.beyond_earth.client.renderers.types;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.function.Function;

public class TranslucentArmorType extends RenderLayer {
    public TranslucentArmorType(String name, VertexFormat vertexFormat, VertexFormat.DrawMode drawMode, int expectedBufferSize, boolean hasCrumbling, boolean translucent, Runnable startAction, Runnable endAction) {
        super(name, vertexFormat, drawMode, expectedBufferSize, hasCrumbling, translucent, startAction, endAction);
    }

    private static final Function<Identifier, RenderLayer> TRANSLUCENT_ARMOR = Util.memoize((p_173206_) -> {
        RenderLayer.MultiPhaseParameters state = MultiPhaseParameters.builder().program(ARMOR_CUTOUT_NO_CULL_PROGRAM).texture(new Texture(p_173206_, false, false)).transparency(TRANSLUCENT_TRANSPARENCY).cull(DISABLE_CULLING).lightmap(ENABLE_LIGHTMAP).overlay(ENABLE_OVERLAY_COLOR).layering(VIEW_OFFSET_Z_LAYERING).build(true);
        return RenderLayer.of("translucent_armor", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, VertexFormat.DrawMode.QUADS, 256, true, false, state);
    });

    public static RenderLayer translucentArmor(Identifier id) {
        return TRANSLUCENT_ARMOR.apply(id);
    }
}
