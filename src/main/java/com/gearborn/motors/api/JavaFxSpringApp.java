package com.gearborn.motors.api;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import com.gearborn.motors.api.controllersFx.FxController;

import java.io.IOException;

/*Esta clase lanza JavaFX y también inicia el contexto de Spring.
 * Es el punto de entrada de la aplicación.*/

public class JavaFxSpringApp extends Application {

    private ConfigurableApplicationContext springContext;

    @Override
    public void init() {
        springContext = new SpringApplicationBuilder(Lanzador.class).run();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FxController controller = springContext.getBean(FxController.class);
        controller.start(primaryStage);
    }

    @Override
    public void stop() {
        springContext.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
