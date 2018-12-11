package io.geekmind.glass.laf.drawing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.Map;

/**
 * Provides an easy way to ensure that the graphics are being rendered using the proper anti-aliasing algorithm.
 *
 * @author Andre Silva
 */
public final class AntiAliasingHelper {

    static {
        System.setProperty ("awt.useSystemAAFontSettings", "on");
        System.setProperty ("swing.aatext", "true");
        System.setProperty ("sun.java2d.xrender", "true");
    }

    /**
     * Active the anti-aliasing rendering hint for the received {@link Graphics} instance.
     * @param graphics  {@link Graphics} instance to have the anti-aliasing rendering hint activated.
     * @return Same {@link Graphics} instance, but with the anti-aliasing rendering hint activated now.
     */
    @SuppressWarnings("unchecked")
    public static Graphics applyAntiAliasing(Graphics graphics) {
        if (!(graphics instanceof Graphics2D)) {
            return graphics;
        }

        Map<RenderingHints.Key, Object> hints = (Map<RenderingHints.Key, Object>)Toolkit
            .getDefaultToolkit()
            .getDesktopProperty("awt.font.desktophints");
        hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        ((Graphics2D)graphics).addRenderingHints(hints);
        return graphics;
    }

    private AntiAliasingHelper() { }

}
