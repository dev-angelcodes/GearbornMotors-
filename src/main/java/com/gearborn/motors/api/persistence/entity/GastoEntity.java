package com.gearborn.motors.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "gastos")
//Generamos - LOS GETTER, SETTERS Y EL CONSTRUCTOR VACIO
@Getter @Setter @NoArgsConstructor
public class GastoEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer idGasto;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false, length = 100)
    private String concepto;

    @Column(nullable = false, columnDefinition = "Decimal(9,2)")
    private Double importe;

    @Column(nullable = false, length = 100)
    private String nombreProveedor;

    private String observaciones;

    // ===================== RELACIONES =======================

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id", nullable = false)
    private VehiculoEntity vehiculo;
}
