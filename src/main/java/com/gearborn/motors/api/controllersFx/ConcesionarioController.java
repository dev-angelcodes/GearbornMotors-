package com.gearborn.motors.api.controllersFx;

import javafx.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ConcesionarioController {

    @Autowired
    private Escenas escenas;


    public void irLog(ActionEvent event) {
        escenas.cargarLogin(event);
    }
}
