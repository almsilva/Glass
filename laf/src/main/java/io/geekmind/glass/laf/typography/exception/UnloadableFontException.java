package io.geekmind.glass.laf.typography.exception;

/**
 * Thrown when any unexpected event occurs when the application tries to load a font.
 *
 * @author Andre Silva
 */
public class UnloadableFontException extends RuntimeException {

    public UnloadableFontException(String message, Throwable cause) {
        super(message, cause);
    }

}
