package com.flydax.archetype.spring_boot_starter_javafx;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.stage.Stage;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.flydax.archetype.spring_boot_starter_javafx.view.ViewManager;

public abstract class SpringJavaFXApplication extends Application {
    /**
     * The application context created by the JavaFX starter.
     * This context will only be available once the {@link #init()} has been invoked by JavaFX.
     */
    protected ConfigurableApplicationContext applicationContext;

    /**
     * Launch a JavaFX application with for the given class and program arguments.
     *
     * @param appClass The class to launch the JavaFX application for.
     * @param args     The program arguments.
     */
    @SuppressWarnings("unused")
    public static void launch(Class<? extends Application> appClass, String... args) {
        Application.launch(appClass, args);
    }

    /**
     * Launch a JavaFX application with for the given class and program arguments.
     *
     * @param appClass       The class to launch the JavaFX application for.
     * @param preloaderClass The class to use as the preloader of the JavaFX application.
     * @param args           The program arguments.
     */
    @SuppressWarnings("unused")
    public static void launch(Class<? extends Application> appClass, Class<? extends Preloader> preloaderClass, String... args) {
        System.setProperty("javafx.preloader", preloaderClass.getName());
        Application.launch(appClass, args);
    }

    /**
     * Launch a JavaFX application with the given program arguments.
     *
     * @param args The program arguments.
     */
    @SuppressWarnings("unused")
    public static void launch(String... args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        Parameters parameters = getParameters();
        SpringApplication application = new SpringApplication(this.getClass());

        application.setBannerMode(Banner.Mode.OFF);
        application.setHeadless(false);

        applicationContext = application.run(parameters.getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewManager viewManager = applicationContext.getBean(ViewManager.class);
        viewManager.registerPrimaryStage(primaryStage);
    }

    @Override
    public void stop() throws Exception {
        applicationContext.close();
        System.exit(0);
    }
}
