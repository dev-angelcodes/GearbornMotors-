package com.gearborn.motors.api.controllersFx;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class MenuController {

    public Label presentation;

    public void initialize() {
        presentation.setText("En GearBorn Motors no solo vendemos vehículos, conectamos personas con su próximo destino." +
                "Te acompañamos en cada paso: ya sea que estés comprando tu primer coche," + 
                "vendiendo uno de confianza o buscando una nueva experiencia al volante.");
    }


    public void login(ActionEvent event) {

    }
}
