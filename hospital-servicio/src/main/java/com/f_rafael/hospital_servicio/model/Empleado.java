package com.f_rafael.hospital_servicio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter @Getter
@Table(name = "empleados")
public class Empleado {
    private Long id;
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Column(unique = true)
    private String email;
    @Column(name = "matricula_profesional",unique = true)
    private String matriculaPorfesional;
    @ManyToOne
    private RolEmpleado rol;
}
