package net.mrscauthd.beyond_earth.common.painting;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mrscauthd.beyond_earth.BeyondEarth;

public class ModPaintings {
    /** PAINTINGS */
    public static final PaintingVariant PAINTING_THE_MILKY_WAY = registerPainting("the_milky_way",  new PaintingVariant(64, 48));
    public static final PaintingVariant PAINTING_SUN = registerPainting("sun",  new PaintingVariant(80, 80));
    public static final PaintingVariant PAINTING_EARTH = registerPainting("earth",  new PaintingVariant(32, 32));
    public static final PaintingVariant PAINTING_MOON = registerPainting("moon",  new PaintingVariant(16, 16));
    public static final PaintingVariant PAINTING_MARS = registerPainting("mars",  new PaintingVariant(32, 32));
    public static final PaintingVariant PAINTING_MERCURY = registerPainting("mercury",  new PaintingVariant(16, 16));
    public static final PaintingVariant PAINTING_VENUS = registerPainting("venus",  new PaintingVariant(32, 32));
    public static final PaintingVariant PAINTING_NEPTUNE = registerPainting("neptune",  new PaintingVariant(48, 48));
    public static final PaintingVariant PAINTING_SATURN = registerPainting("saturn",  new PaintingVariant(64, 48));
    public static final PaintingVariant PAINTING_JUPITER = registerPainting("jupiter",  new PaintingVariant(48, 48));
    public static final PaintingVariant PAINTING_PLUTO = registerPainting("pluto",  new PaintingVariant(16, 16));
    public static final PaintingVariant PAINTING_URANUS = registerPainting("uranus",  new PaintingVariant(48, 48));
    public static final PaintingVariant PAINTING_PROXIMA_CENTAURY = registerPainting("proxima_centaury",  new PaintingVariant(64, 64));
    public static final PaintingVariant PAINTING_GLACIO = registerPainting("glacio",  new PaintingVariant(32, 32));


    private static PaintingVariant registerPainting(String name, PaintingVariant paintingMotive){
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(BeyondEarth.MOD_ID, name), paintingMotive);
    }

    public static void registerPaintings(){
        BeyondEarth.LOGGER.info("Registering Paintings for " + BeyondEarth.MOD_ID);
    }
}
