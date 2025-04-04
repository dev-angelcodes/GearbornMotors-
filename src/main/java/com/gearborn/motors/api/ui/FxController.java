package com.gearborn.motors.api.ui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class FxController {

    public void start(Stage stage) {
        Label label = new Label("Bienvenido a GearBorn Motors");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.setTitle("App JavaFX + Spring Boot");
        stage.show();
    }
}
