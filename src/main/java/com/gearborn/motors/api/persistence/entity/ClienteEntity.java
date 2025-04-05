package com.gearborn.motors.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(nullable = false, length = 20, unique = true)
    private String dni;

    @Column(length = 50)
    private String direccion;

    private Integer telefono;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, columnDefinition = "ENUM('cliente','proveedor', 'ambos')")
    private String tipo;

    private String observaciones;

                        // ===================== RELACIONES =======================
    //En este caso, el mappedBy hace referencia a la variable cliente de la clase MovimientoEntity
    @OneToMany(mappedBy = "cliente")
    private List<MovimientoEntity> movimientos;

}