package io.geekmind.glass.laf.component;

import io.geekmind.glass.laf.drawing.AntiAliasingHelper;
import io.geekmind.glass.laf.theme.GlassTheme;

import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicRootPaneUI;
import java.awt.Graphics;

public class GlassRootPaneUI extends BasicRootPaneUI {

    private final GlassTheme theme;

    public static ComponentUI createUI(JComponent component) {
        return new GlassRootPaneUI();
    }

    public GlassRootPaneUI() {
        this.theme = (GlassTheme)UIManager.get("theme.active");
    }

    @Override
    public void installUI(JComponent component) {
        super.installUI(component);

        JRootPane pane = (JRootPane)component;
        pane.setBackground(theme.backgroundColor());
        pane.setForeground(theme.foregroundColor());
        pane.setOpaque(Boolean.TRUE);
        pane.setFont(theme.regularFont());
    }

    @Override
    public void paint(Graphics graphics, JComponent component) {
        super.paint(AntiAliasingHelper.applyAntiAliasing(graphics), component);
    }
}
