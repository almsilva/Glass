package io.geekmind.glass.laf.theme;

import io.geekmind.glass.laf.typography.Roboto;

import java.awt.*;

/**
 * Default theme for Glass LaF with light colors.
 *
 * @author Andre Silva
 */
public final class GlassLightTheme implements GlassTheme {

    private static GlassLightTheme thisInstance;

    public static GlassTheme getInstance() {
        if (null == thisInstance) {
            thisInstance = new GlassLightTheme();
        }
        return thisInstance;
    }

    private GlassLightTheme() { }

    @Override
    public Color backgroundColor() {
        return Color.WHITE;
    }

    @Override
    public Color foregroundColor() {
        return Color.decode("#222222");
    }

    @Override
    public Font regularFont() {
        return Roboto.REGULAR.deriveFont(textSize());
    }

    @Override
    public Float textSize() {
        return 14F;
    }
}
