package com.gearborn.motors.api.controllersFx;

import com.gearborn.motors.api.util.SpringFXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FxController {

    @Autowired
    private SpringFXMLLoader springFXMLLoader;

    public void start(Stage stage) throws Exception {
        // Cargar FXML usando Spring
        Parent root = (Parent) springFXMLLoader.load("/com/gearborn/motors/api/fxml/menu.fxml");

        // Obtener tamaño de pantalla
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double width = screenBounds.getWidth() * 0.8;
        double height = screenBounds.getHeight() * 0.8;

        Scene scene = new Scene(root, width, height);
        stage.setTitle("GearBorn Motors");

        try {
            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/gearborn/motors/api/imgs/logoAPP.jpg")));
            stage.getIcons().add(icon);
        } catch (NullPointerException e) {
            System.err.println("Error al cargar el icono.");
        }

        stage.setX(screenBounds.getMinX() + (screenBounds.getWidth() - width) / 2);
        stage.setY(screenBounds.getMinY() + (screenBounds.getHeight() - height) / 2);

        stage.setScene(scene);
        stage.show();
    }
}
