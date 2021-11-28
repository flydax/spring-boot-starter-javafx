package com.flydax.archetype.spring_boot_starter_javafx;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.flydax.archetype.spring_boot_starter_javafx.font.config.FontConfiguration;
import com.flydax.archetype.spring_boot_starter_javafx.text.config.LocaleTextConfiguration;
import com.flydax.archetype.spring_boot_starter_javafx.view.config.ViewConfiguration;

/**
 * The auto configuration for JavaFX.
 */
@Configuration
@Import({
        FontConfiguration.class,
        LocaleTextConfiguration.class,
        ViewConfiguration.class
})
public class JavaFxAutoConfiguration {
}
