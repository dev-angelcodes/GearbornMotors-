package com.gearborn.motors.api.controllersFx;

import com.gearborn.motors.api.persistence.entity.ClienteEntity;
import com.gearborn.motors.api.service.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RegistroController {

    @Autowired private LoginService loginService;
    @Autowired private Escenas escenas;

    @FXML public TextField nombre, email, dni, direccion, telefono, observaciones;
    @FXML public PasswordField contrasena;

    public void registro() {
        String nombre = this.nombre.getText().trim();
        String contrasena = this.contrasena.getText().trim();
        String email = this.email.getText().trim();
        String dni = this.dni.getText().trim();
        String telefonoString = this.telefono.getText().trim();

        if (nombre.isEmpty() || contrasena.isEmpty() || email.isEmpty() || dni.isEmpty() || telefonoString.isEmpty()) {
            Alertas.error("Error", "Campos vacíos", "Por favor, completa todos los campos que tienen 🔸.");
        } else {
            if(!email.endsWith("@gmail.com") && !email.endsWith("@hotmail.com")) {
                Alertas.warning("Warning", "Email inválido", "El email solo soporta @gmail.com o @hotmail.com");
            }else{
                try {
                    Integer telefono = Integer.parseInt(telefonoString);
                    ClienteEntity cliente = new ClienteEntity(nombre, contrasena, dni, direccion.getText().trim(), telefono, email, observaciones.getText().trim());
                    loginService.save(cliente);
                    Alertas.info("Éxito", "Registro completado", "¡Bienvenido!");
                } catch (NumberFormatException e) {
                    Alertas.error("Error", "Teléfono inválido", "Debe contener solo números.");
                }
            }
        }
    }

    public void irLogin(ActionEvent event) {
        escenas.cargarLogin(event);
    }
}
