package com.gearborn.motors.api.controllersFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class LogController {

    @FXML public ImageView logo;

    public void initialize() {
        Image img = new Image(String.valueOf(getClass().getResource("/com/gearborn/motors/api/imgs/logoAPP.jpg")));
        logo.setPreserveRatio(true);
        logo.setFitWidth(100);
        logo.setFitHeight(100);
        logo.setImage(img);
    }

    public void irMenu(ActionEvent event) {
        Escenas escena = new Escenas();
        escena.cargarMenu(event);
    }

    public void irRegistro(ActionEvent event) {
        Escenas escenas = new Escenas();
        escenas.cargarRegistro(event);
    }
}
