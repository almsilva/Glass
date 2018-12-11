package io.geekmind.glass.laf.typography;

import io.geekmind.glass.laf.typography.exception.UnloadableFontException;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Provides helper methods to load fonts from filesystem.
 *
 * @author Andre Silva
 */
public final class FontLoader {

    private FontLoader() { }

    /**
     * Loads a new true-type font from an open {@link java.io.InputStream}. If, for any reason, it is not possible to
     * load the font or parse it, a {@link UnloadableFontException} will be thrown.
     *
     * @param fontInputStream   {@link java.io.InputStream} instance to access the font file.
     * @return A new {@link Font} with the desired font loaded.
     */
    public static Font loadTrueTypeFont(InputStream fontInputStream) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, fontInputStream);
        } catch (FontFormatException | IOException ex) {
            throw new UnloadableFontException(
                String.format("It was not possible to load the desired true type font due the following exception: %s", ex.getMessage()),
                ex
            );
        }
    }

}
