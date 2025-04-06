package com.gearborn.motors.api.controllersFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MenuController {

    @FXML public Label presentation;

    @Autowired private Escenas escenas;

    public void initialize() {
        presentation.setText("En GearBorn Motors no solo vendemos vehículos, conectamos personas con su próximo destino. " +
                "Te acompañamos en cada paso: ya sea que estés comprando tu primer coche, vendiendo uno de confianza o buscando una nueva experiencia al volante.");
    }

    public void irLogin(ActionEvent event) {
        escenas.cargarLogin(event);
    }
}
