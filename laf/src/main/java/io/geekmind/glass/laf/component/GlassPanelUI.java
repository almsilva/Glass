package io.geekmind.glass.laf.component;

import io.geekmind.glass.laf.drawing.AntiAliasingHelper;
import io.geekmind.glass.laf.theme.GlassTheme;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.Graphics;

public class GlassPanelUI extends BasicPanelUI {

    private final GlassTheme theme;

    public static ComponentUI createUI(JComponent component) {
        return new GlassPanelUI();
    }

    public GlassPanelUI() {
        this.theme = (GlassTheme)UIManager.get("theme.active");
    }

    @Override
    public void installUI(JComponent component) {
        super.installUI(component);

        JPanel panel = (JPanel)component;
        panel.setOpaque(Boolean.TRUE);
        panel.setBorder(null);
        panel.setBackground(this.theme.backgroundColor());
        panel.setForeground(this.theme.foregroundColor());
        panel.setFont(this.theme.regularFont());
    }

    @Override
    public void paint(Graphics graphics, JComponent component) {
        super.paint(AntiAliasingHelper.applyAntiAliasing(graphics), component);
    }
}
