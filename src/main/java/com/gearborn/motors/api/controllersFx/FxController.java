package com.gearborn.motors.api.controllersFx;

import com.gearborn.motors.api.JavaFxSpringApp;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class FxController {

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JavaFxSpringApp.class.getResource("/com/gearborn/motors/api/fxml/menu.fxml"));

        // Obtener tamaño de pantalla
        Rectangle2D limitePantalla = Screen.getPrimary().getVisualBounds();
        double ancho = limitePantalla.getWidth() * 0.8;
        double alto = limitePantalla.getHeight() * 0.8;

        // Configurar la escena dinamica
        Scene scene = new Scene(fxmlLoader.load(), ancho, alto);
        stage.setTitle("GearBorn Motors");

        try {
            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/gearborn/motors/api/imgs/logoAPP.jpg")));
            stage.getIcons().add(icon);
        } catch (NullPointerException e) {
            System.err.println("Error al cargar el icono.");
        }

        // Centrar la ventana
        stage.setX(limitePantalla.getMinX() + (limitePantalla.getWidth() - ancho) / 2);
        stage.setY(limitePantalla.getMinY() + (limitePantalla.getHeight() - alto) / 2);

        stage.setScene(scene);
        stage.show();
    }
}