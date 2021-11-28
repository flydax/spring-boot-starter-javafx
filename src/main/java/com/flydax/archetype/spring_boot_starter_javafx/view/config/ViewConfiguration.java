package com.flydax.archetype.spring_boot_starter_javafx.view.config;

import com.flydax.archetype.spring_boot_starter_javafx.text.LocaleText;
import com.flydax.archetype.spring_boot_starter_javafx.view.ViewLoader;
import com.flydax.archetype.spring_boot_starter_javafx.view.ViewLoaderImpl;
import com.flydax.archetype.spring_boot_starter_javafx.view.ViewManager;
import com.flydax.archetype.spring_boot_starter_javafx.view.ViewManagerImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ViewConfiguration {
    @Bean
    @ConditionalOnMissingBean(ViewLoader.class)
    public ViewLoader viewLoader(ApplicationContext applicationContext, ViewManager viewManager, LocaleText localeText) {
        return new ViewLoaderImpl(applicationContext, viewManager, localeText);
    }

    @Bean
    @ConditionalOnMissingBean(ViewManager.class)
    public ViewManager viewManager(ConfigurableApplicationContext applicationContext) {
        return new ViewManagerImpl(applicationContext);
    }
}
