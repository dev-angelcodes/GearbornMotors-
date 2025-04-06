package com.gearborn.motors.api.controllersFx;

import com.gearborn.motors.api.util.SpringFXMLLoader;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Escenas {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Autowired
    private SpringFXMLLoader springFXMLLoader;

    public void cargarLogin(ActionEvent event) {
        try {
            root = (Parent) springFXMLLoader.load("/com/gearborn/motors/api/fxml/login.fxml");

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            double ancho = 450;
            double alto = 575;

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, ancho, alto);
            stage.setScene(scene);

            stage.setX(screenBounds.getMinX() + (screenBounds.getWidth() - ancho) / 2);
            stage.setY(screenBounds.getMinY() + (screenBounds.getHeight() - alto) / 2);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarRegistro(ActionEvent event) {
        try {
            root = (Parent) springFXMLLoader.load("/com/gearborn/motors/api/fxml/registro.fxml");

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            double ancho = 675;
            double alto = 700;

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, ancho, alto);
            stage.setScene(scene);

            stage.setX(screenBounds.getMinX() + (screenBounds.getWidth() - ancho) / 2);
            stage.setY(screenBounds.getMinY() + (screenBounds.getHeight() - alto) / 2);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarMenu(ActionEvent event) {
        try {
            root = (Parent) springFXMLLoader.load("/com/gearborn/motors/api/fxml/Menu.fxml");

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            double ancho = screenBounds.getWidth() * 0.8;
            double alto = screenBounds.getHeight() * 0.8;

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, ancho, alto);
            stage.setScene(scene);

            stage.setX(screenBounds.getMinX() + (screenBounds.getWidth() - ancho) / 2);
            stage.setY(screenBounds.getMinY() + (screenBounds.getHeight() - alto) / 2);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
