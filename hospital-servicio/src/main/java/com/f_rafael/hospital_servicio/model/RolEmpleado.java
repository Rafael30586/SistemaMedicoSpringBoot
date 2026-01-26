package com.f_rafael.hospital_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles_empleado")
public class RolEmpleado { // El rol que desempeña un empleado, ej: cirugano, cardiólogo, cocinero, etc
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre; // Cardiólogo, cirujano, secretario, etc.
    @ManyToOne
    private Sector sector;

}
