package com.gearborn.motors.api.controllersFx;

import com.gearborn.motors.api.JavaFxSpringApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Escenas {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void cargarLogin(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(JavaFxSpringApp.class.getResource("/com/gearborn/motors/api/fxml/login.fxml"));
            root = fxmlLoader.load();

            // Obtener tamaño de pantalla
            Rectangle2D limitePantalla = Screen.getPrimary().getVisualBounds();
            double ancho = 450;
            double alto = 575;

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            scene = new Scene(root, ancho, alto);
            stage.setScene(scene);

            stage.setX(limitePantalla.getMinX() + (limitePantalla.getWidth() - ancho) / 2);
            stage.setY(limitePantalla.getMinY() + (limitePantalla.getHeight() - alto) / 2);

            stage.show();

        } catch (IOException e) {
            System.err.println("Error al cambiar de escena:\n " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void cargarMenu(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(JavaFxSpringApp.class.getResource("/com/gearborn/motors/api/fxml/Menu.fxml"));
            root = fxmlLoader.load();

            // Obtener tamaño de pantalla
            Rectangle2D limitePantalla = Screen.getPrimary().getVisualBounds();
            double ancho = limitePantalla.getWidth() * 0.8;
            double alto = limitePantalla.getHeight() * 0.8;

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            scene = new Scene(root, ancho, alto);
            stage.setScene(scene);

            stage.setX(limitePantalla.getMinX() + (limitePantalla.getWidth() - ancho) / 2);
            stage.setY(limitePantalla.getMinY() + (limitePantalla.getHeight() - alto) / 2);

            stage.show();

        } catch (IOException e) {
            System.err.println("Error al cambiar de escena:\n " + e.getMessage());
            e.printStackTrace();
        }
    }
}
