package io.geekmind.glass.laf.typography;

import java.awt.Font;

/**
 * Provides access to the Roboto family fonts.
 *
 * @author Andre Silva
 */
public final class Roboto {

    public static Font REGULAR = FontLoader.loadTrueTypeFont(
            Roboto.class.getResourceAsStream("/fonts/Roboto/Roboto-Regular.ttf")
    );

    public static Font BOLD = FontLoader.loadTrueTypeFont(
            Roboto.class.getResourceAsStream("/fonts/Roboto/Roboto-Bold.ttf")
    );

    public static Font ITALIC = FontLoader.loadTrueTypeFont(
            Roboto.class.getResourceAsStream("/fonts/Roboto/Roboto-Italic.ttf")
    );

    private Roboto() { }

}
