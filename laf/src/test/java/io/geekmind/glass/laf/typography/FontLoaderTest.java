package io.geekmind.glass.laf.typography;

import io.geekmind.glass.laf.typography.exception.UnloadableFontException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class FontLoaderTest {

    @Test
    public void loadTrueTypeFont_WithValidFontFile_ReturnsNewFontInstance() {
        Font result = FontLoader.loadTrueTypeFont(
            FontLoaderTest.class.getResourceAsStream("/fonts/Roboto/Roboto-Thin.ttf")
        );
        assertThat(result).isNotNull();
    }

    @Test
    public void loadTrueTypeFont_WithInvalidFontFile_ThrowsUnloadableFontException() {
        assertThatThrownBy(() -> FontLoader.loadTrueTypeFont(
            FontLoader.class.getResourceAsStream("/fonts/InvalidFontFile.ttf")
        )).isInstanceOf(UnloadableFontException.class).hasCauseInstanceOf(FontFormatException.class);
    }

    @Test
    public void loadTrueTypeFont_WithIOExceptionWhenAccessingTheInputStream_ThrowsUnloadableFontException() throws IOException {
        InputStream fakeInputStream = mock(InputStream.class);
        IOException fakeIOException = new IOException("Fake Exception");
        doThrow(fakeIOException)
            .when(fakeInputStream).read(any());

        assertThatThrownBy(() -> FontLoader.loadTrueTypeFont(fakeInputStream))
            .isInstanceOf(UnloadableFontException.class)
            .hasCause(fakeIOException)
            .hasMessage("It was not possible to load the desired true type font due the following exception: Fake Exception");
    }

}