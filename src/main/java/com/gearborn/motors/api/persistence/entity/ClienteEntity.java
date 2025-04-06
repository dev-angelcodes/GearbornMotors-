package com.gearborn.motors.api.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import java.util.List;


@Entity
@Table(name = "clientes")
//Generamos - LOS GETTER, SETTERS Y EL CONSTRUCTOR VACIO
@Getter @Setter @NoArgsConstructor
public class ClienteEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    @ColumnTransformer(write = "MD5(?)")// Aplicar MD5 para encriptar la contraseña
    private String contrasena;

    @Column(nullable = false, length = 20, unique = true)
    private String dni;

    @Column(length = 50)
    private String direccion;

    @Column(nullable = false)
    private Integer telefono;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    //Al principio el cliente puede no poner si va a ser cliente o proveedor
    @Column(nullable = true, columnDefinition = "ENUM('cliente','proveedor', 'ambos')")
    private String tipo;

    private String observaciones;

                        // ===================== RELACIONES =======================
    //En este caso, el mappedBy hace referencia a la variable cliente de la clase MovimientoEntity
    @OneToMany(mappedBy = "cliente")
    private List<MovimientoEntity> movimientos;


    /// CONSTRUCTOR
    public ClienteEntity(String nombre, String contrasena, String dni, String direccion, Integer telefono, String email, String observaciones) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.observaciones = observaciones;
    }
}