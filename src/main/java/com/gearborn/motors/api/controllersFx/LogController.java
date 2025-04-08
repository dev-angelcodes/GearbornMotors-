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
        //Obtenemos el Email y encriptamos la contraseña introducida
        String email = usuario.getText().trim();

        String contrasenaEncriptada = LoginService.encriptarMD5(contrasena.getText().trim());

        //Verificamos que el email este en la bd
        ClienteEntity cliente = loginService.findByEmail(email);
        if(cliente != null && contrasenaEncriptada.equals(cliente.getContrasena())){
            escenas.cargarConcesionario(event);
        }else{
            Alertas.warning("Warning", "Error al iniciar sesión", "Verifica que el " +
                    "nombre de usuario y la contraseña sean correctos.");

            //SOLO LA CARGO PARA TESTEAR(ACORDARSE DE BORRAR)
            escenas.cargarConcesionario(event);
        }
    }
}
