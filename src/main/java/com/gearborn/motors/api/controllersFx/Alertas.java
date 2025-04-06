package com.gearborn.motors.api.controllersFx;

import javafx.scene.control.Alert;

public class Alertas {
    public static void error(String titulo, String cabercero, String contenido){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(titulo);
        a.setHeaderText(cabercero);
        a.setContentText(contenido);
        a.showAndWait();
    }

    public static void info(String titulo, String cabercero, String contenido){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(titulo);
        a.setHeaderText(cabercero);
        a.setContentText(contenido);
        a.showAndWait();
    }

}
