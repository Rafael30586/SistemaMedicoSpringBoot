package com.f_rafael.hospital_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter @Getter
@Table(name = "empleados")
public class Empleado { // Un empleado del hospital
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long dni;
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
    private Long domicilioId;
    private Set<Long> telefonosId;
    @Column(name = "matricula_profesional",unique = true)
    private String matriculaPorfesional;
    @ManyToOne
    private RolEmpleado rol;
    private Float salario;
}
