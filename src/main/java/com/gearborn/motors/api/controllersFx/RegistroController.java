package com.gearborn.motors.api.controllersFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistroController {

    @FXML public TextField nombre, email, dni, direccion, telefono, observaciones;

    @FXML public PasswordField contrasena;

    public void registro() {
        String nombre = this.nombre.getText().trim();
        String contrasena = this.contrasena.getText().trim();
        String email = this.email.getText().trim();
        String dni = this.dni.getText().trim();

        if(nombre.isEmpty() || contrasena.isEmpty() || email.isEmpty() || dni.isEmpty()) {
            Alertas.error("Error", "Campos vacios",
                    "Por favor, completa todos los campos que tienen \uD83D\uDD38.");
        }

    }

    public void irLogin(ActionEvent event) {
        Escenas escenas = new Escenas();
        escenas.cargarLogin(event);
    }
}
