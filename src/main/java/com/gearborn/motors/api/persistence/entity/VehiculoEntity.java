package com.gearborn.motors.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "vehiculos")
//Generamos - LOS GETTER, SETTERS Y EL CONSTRUCTOR VACIO
@Getter @Setter @NoArgsConstructor
public class VehiculoEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehiculo;

    @Column(nullable = false, length = 50)
    private String marca;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(nullable = false, length = 20)
    private String matricula;

    @Column(nullable = false)
    private Integer anio;

    @Column(nullable = false)
    private Integer km;

    @Column(name = "tipo_vehiculo", nullable = false)
    private boolean coche;

    @Column(nullable = false, length = 50)
    private String color;

    @Column(nullable = false, length = 50)
    private String tipoCombustible;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCambio tipoCambio;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoVehiculo estado;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaCompra;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime fechaVenta;

    @Column(name = "imagen")
    private String nombreImg;

    private String observaciones;


                            // ===================== RELACIONES =======================
    //En este caso, el mappedBy hace referencia a la variable vehiculo de la clase MovimientoEntity
    @OneToMany(mappedBy = "vehiculo")
    private List<MovimientoEntity> movimientos;

    //En este caso, el mappedBy hace referencia a la variable vehiculo de la clase GastoEntity
    @OneToMany(mappedBy = "vehiculo")
    private List<GastoEntity> gastos;



    //-------------Metodos para los enumerados---------------
    enum TipoCambio {
        MANUAL,
        AUTOMATICO,
        ELECTRICO,
        SECUENCIAL,
        DOBLE_EMBRAGUE
    }

    enum EstadoVehiculo {
        DISPONIBLE,
        VENDIDO,
        RESERVADO
    }
}
