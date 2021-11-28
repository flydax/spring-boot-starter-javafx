package com.flydax.archetype.spring_boot_starter_javafx.text.config;

import com.flydax.archetype.spring_boot_starter_javafx.text.LocaleText;
import com.flydax.archetype.spring_boot_starter_javafx.text.LocaleTextImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class LocaleTextConfiguration {
    @Bean
    @ConditionalOnMissingBean(LocaleText.class)
    public LocaleText localeText(ResourceBundleMessageSource messageSource) {
        return new LocaleTextImpl(messageSource);
    }
}
