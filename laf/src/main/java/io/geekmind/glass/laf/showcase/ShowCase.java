package io.geekmind.glass.laf.showcase;

import io.geekmind.glass.laf.GlassLookAndFeel;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.*;

public class ShowCase extends JFrame {

    public static void main(String... args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(GlassLookAndFeel.newInstance());
        ShowCase showCase = new ShowCase();
        showCase.initializeLayout().setVisible(Boolean.TRUE);
    }

    private ShowCase initializeLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Glass Look and Feel Showcase");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setLayout(new BorderLayout());
        return this;
    }

}
