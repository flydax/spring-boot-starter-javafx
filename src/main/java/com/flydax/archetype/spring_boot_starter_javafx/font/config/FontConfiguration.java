package com.flydax.archetype.spring_boot_starter_javafx.font.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.flydax.archetype.spring_boot_starter_javafx.font.FontRegistry;
import com.flydax.archetype.spring_boot_starter_javafx.font.FontRegistryImpl;

@Configuration
public class FontConfiguration {
    @Bean
    @ConditionalOnMissingBean(FontRegistry.class)
    public FontRegistry fontRegistry() {
        return FontRegistryImpl.getInstance();
    }
}
