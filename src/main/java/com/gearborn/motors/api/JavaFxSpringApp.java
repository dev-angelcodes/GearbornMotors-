package com.gearborn.motors.api;

import com.gearborn.motors.api.controllersFx.FxController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Esta clase lanza JavaFX y también inicia el contexto de Spring.
 * Es el punto de entrada principal de la aplicación.
 */

@SpringBootApplication // Activa el escaneo de componentes: controllers, services, repos, etc.
public class JavaFxSpringApp extends Application {

    private ConfigurableApplicationContext springContext;

    @Override
    public void init() {
        // Iniciar Spring Boot usando esta misma clase como base
        springContext = new SpringApplicationBuilder(JavaFxSpringApp.class).run();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Obtener el controlador JavaFX desde el contexto de Spring
        FxController controller = springContext.getBean(FxController.class);
        controller.start(primaryStage); // Mostrar ventana inicial (menu.fxml)
    }

    @Override
    public void stop() {
        // Cerrar el contexto de Spring correctamente
        springContext.close();
    }

    public static void main(String[] args) {
        launch(args); // Lanza JavaFX
    }
}
