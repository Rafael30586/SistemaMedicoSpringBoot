package com.f_rafael.hospital_servicio.dto;

import com.f_rafael.hospital_servicio.model.RolEmpleado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class EmpleadoDto {
    private Long id;
    private Long dni;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private DireccionDto domicilio;
    private Set<String> telefonos;
    private String matriculaProfesional;
    private RolEmpleado rol;
    private Float salario;
}
