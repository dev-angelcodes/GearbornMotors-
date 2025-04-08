package com.gearborn.motors.api.controllersFx;

import com.gearborn.motors.api.persistence.entity.VehiculoEntity;
import com.gearborn.motors.api.service.VehiculoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class ConcesionarioController {

    @FXML
    public VBox vehiculosContainer;
    @FXML
    public ImageView fotoPerf;
    @Autowired
    private Escenas escenas;
    @Autowired
    private VehiculoService vehiculoService;


    public void initialize() {
        System.out.println("Estas en la escena -> Concesionario");
        //----------------Cargamos cuantos vehículos tenemos en la bd, y por lo tanto cuandos coches se van a mostrar
        List<VehiculoEntity> vehiculos = vehiculoService.findAll();

        for(VehiculoEntity v : vehiculos){
            HBox hBox = crearHBox(v);
            vehiculosContainer.getChildren().add(hBox);
        }

        //Evento Foto Perfil User
        eventoPerfil();
    }

    private void eventoPerfil() {

        String ruta = "/com/gearborn/motors/api/imgs/user.png";
        Image img = new Image(String.valueOf(getClass().getResource(ruta)));
        fotoPerf.setPreserveRatio(true);
        fotoPerf.setFitWidth(50);
        fotoPerf.setFitHeight(50);
        fotoPerf.setImage(img);


        fotoPerf.setOnMouseClicked(event -> {
            System.out.println("Imagen clickeada");
        });

    }

    private HBox crearHBox(VehiculoEntity v) {

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.getStyleClass().add("Border");

        // Cargar imagen
        ImageView imagen = new ImageView();
        imagen.setFitWidth(155);
        imagen.setFitHeight(100);
        imagen.setPreserveRatio(true);
        try {
            String ruta = "/com/gearborn/motors/api/imgs/" + v.getNombreImg();
            imagen.setImage(new Image(String.valueOf(getClass().getResource(ruta))));
        }catch (Exception e){
            System.out.println("Imagen no encontrada: " + v.getNombreImg());
            //Usar una imagen por defecto
            String ruta = "/com/gearborn/motors/api/imgs/vDefault.png";
            imagen.setImage(new Image(String.valueOf(getClass().getResource(ruta))));
        }

        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getStyleClass().add("VBoxVehiculoSize");

        Label nombre = new Label(v.getMarca() + ", " + v.getModelo());
        nombre.getStyleClass().add("nombreVehiculo");
        Label desc = new Label("Año: " + v.getAnio()
                                + "\nKilometraje: " + v.getKm()
                                + "\nColor: " + v.getColor()
                                + "\nObservaciones: " + v.getObservaciones()
        );

        vbox.getChildren().addAll(nombre, desc);
        hbox.getChildren().addAll(imagen, vbox);

        return hbox;
    }

    private void VehiculoSave() {
        VehiculoEntity coche = new VehiculoEntity();

        vehiculoService.save(coche);
    }

    private void mostrarVehiculo() {

    }

    public void irLog(ActionEvent event) {
        escenas.cargarLogin(event);
    }
}
