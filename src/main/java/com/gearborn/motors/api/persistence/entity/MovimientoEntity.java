package com.gearborn.motors.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos")
//Generamos - LOS GETTER, SETTERS Y EL CONSTRUCTOR VACIO
@Getter @Setter @NoArgsConstructor
public class MovimientoEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimiento;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fecha;

    @Column(nullable = false, columnDefinition = "Decimal(9,2)")
    private Double precio;

    @Column(name = "forma_pago", nullable = false)
    private String formaPago;

    //Indicamos si es una compra o una venta de la empresa
    @Column(nullable = false)
    private boolean venta;

    @Column(nullable = false)
    private boolean garantia;

                        // ===================== RELACIONES =======================
    //FK -> Tabla vehiculos
    @ManyToOne
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id", nullable = false)
    private VehiculoEntity vehiculo;

    //FK -> Tabla clientes
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    private ClienteEntity cliente;


}
