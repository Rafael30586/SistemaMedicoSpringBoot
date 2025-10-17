package com.f_rafael.pacientes_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class SubPacienteDto {
    private Long id;
    private Long dni;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private Set<String> telefonos;
    private LocalDate fechaNacimiento;
    private LocalidadDto lugarNacimiento;
}
