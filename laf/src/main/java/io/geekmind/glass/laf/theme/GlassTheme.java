package io.geekmind.glass.laf.theme;

import java.awt.*;

/**
 * Defines the common structure to any theme implementation to be used together with the look and feel.
 *
 * @author Andre Silva
 */
public interface GlassTheme {

    /**
     * Returns the default theme background color. It is widely used by all the components rendered as opaque.
     * @return {@link Color} instance to be used as default background color.
     */
    Color backgroundColor();

    /**
     * Returns the default theme foreground color. Mainly used for text and borders.
     * @return {@link Color} instance to be used as default foreground color.
     */
    Color foregroundColor();

    /**
     * Returns the {@link Font} to be used to render regular texts.
     * @return {@link Font} instance to be used to render regular texts.
     */
    Font regularFont();

    /**
     * Returns the regular text size.
     * @return Regular text size.
     */
    Float textSize();


}
