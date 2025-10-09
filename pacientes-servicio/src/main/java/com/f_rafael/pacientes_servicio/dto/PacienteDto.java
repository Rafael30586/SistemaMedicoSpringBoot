package com.f_rafael.pacientes_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class PacienteDto {
    private Long id;
    private Long dni;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private List<NumeroTelefonicoDto> telefonos;
    private LocalDate fechaNacimiento;
    private LocalidadDto lugarNacimiento;
    private DireccionDto domicilio;
    private ObraSocialDto obraSocial;
}
