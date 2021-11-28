package com.flydax.archetype.spring_boot_starter_javafx.stage;

import javafx.stage.Stage;
import lombok.Getter;

@Getter
public class InvalidStageException extends RuntimeException {
    private final Stage stage;

    public InvalidStageException(Stage stage, String message) {
        super(message);
        this.stage = stage;
    }

    public InvalidStageException(Stage stage, String message, Throwable cause) {
        super(message, cause);
        this.stage = stage;
    }
}
