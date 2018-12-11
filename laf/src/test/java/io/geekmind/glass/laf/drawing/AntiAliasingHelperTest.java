package io.geekmind.glass.laf.drawing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.runners.MockitoJUnitRunner;

import javax.swing.DebugGraphics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AntiAliasingHelperTest {

    @Captor
    public ArgumentCaptor<Map<RenderingHints.Key, Object>> renderingHintsCaptor;

    @Test
    public void applyAntiAliasing_WithNonGraphics2DInstance_ReturnsSameInstance() {
        Graphics fakeGraphics = mock(DebugGraphics.class);
        Graphics result = AntiAliasingHelper.applyAntiAliasing(fakeGraphics);
        assertThat(result).isSameAs(fakeGraphics);
    }

    @Test
    public void applyAntiAliasing_WithGraphics2DInstance_ActivateAntiAliasingRenderingHint() {
        Graphics2D fakeGraphics = mock(Graphics2D.class);
        doNothing()
            .when(fakeGraphics).addRenderingHints(anyMap());

        Graphics result = AntiAliasingHelper.applyAntiAliasing(fakeGraphics);
        assertThat(result).isSameAs(fakeGraphics);

        verify(fakeGraphics).addRenderingHints(this.renderingHintsCaptor.capture());
        assertThat(this.renderingHintsCaptor.getValue())
            .hasEntrySatisfying(
                RenderingHints.KEY_ANTIALIASING,
                (value) -> value.equals(RenderingHints.VALUE_ANTIALIAS_ON)
            );
    }

}