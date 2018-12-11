package io.geekmind.glass.laf;

import io.geekmind.glass.laf.component.GlassPanelUI;
import io.geekmind.glass.laf.component.GlassRootPaneUI;
import io.geekmind.glass.laf.theme.GlassLightTheme;
import io.geekmind.glass.laf.theme.GlassTheme;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 * Glass look and feel is a minimalist, flat and clean look and feel for Java Swing applications, highly inspired by
 * Bootstrap framework.
 *
 * @author Andre Silva
 */
public final class GlassLookAndFeel extends MetalLookAndFeel {

    public static GlassLookAndFeel newInstance() {
        return new GlassLookAndFeel(GlassLightTheme.getInstance());
    }

    private GlassLookAndFeel(GlassTheme theme) {
        UIManager.put("theme.active", theme);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getID() {
        return "GlassLookAndFeel";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
       return "Glass Look and Feel";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "Minimalist, flat and clean look and feel.";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isNativeLookAndFeel() {
        return Boolean.FALSE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSupportedLookAndFeel() {
        return Boolean.TRUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initClassDefaults(UIDefaults table) {
        super.initClassDefaults(table);
        table.put("PanelUI", GlassPanelUI.class.getCanonicalName());
        table.put("RootPaneUI", GlassRootPaneUI.class.getCanonicalName());

    }
}
