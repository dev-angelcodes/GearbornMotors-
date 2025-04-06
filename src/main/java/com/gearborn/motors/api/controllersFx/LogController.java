package com.gearborn.motors.api.controllersFx;

import com.gearborn.motors.api.persistence.entity.ClienteEntity;
import com.gearborn.motors.api.service.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LogController {


    @Autowired private Escenas escenas;
    @Autowired private LoginService loginService;

    @FXML public ImageView logo;
    @FXML public TextField usuario;
    @FXML public PasswordField contrasena;

    public void initialize() {
        Image img = new Image(String.valueOf(getClass().getResource("/com/gearborn/motors/api/imgs/logoAPP.jpg")));
        logo.setPreserveRatio(true);
        logo.setFitWidth(100);
        logo.setFitHeight(100);
        logo.setImage(img);
    }

    public void irMenu(ActionEvent event) {
        escenas.cargarMenu(event);
    }

    public void irRegistro(ActionEvent event) {
        escenas.cargarRegistro(event);
    }

    public void inicioSesion(ActionEvent event) {
        /*escenas.cargarLogin(event);*/
        String email = usuario.getText().trim();

        //Verificamos que el email este en la bd
        ClienteEntity cliente = loginService.findByEmail(email);
        if(cliente != null){
            String contrasenaEncriptada = LoginService.encriptarMD5(contrasena.getText().trim());

            if(contrasenaEncriptada.equals(cliente.getContrasena())){
                System.out.println("Inicio de sesión exitoso");
            }else{
                Alertas.error("Error", "Contraseña incorrecta", "");
            }
        }
    }
}
