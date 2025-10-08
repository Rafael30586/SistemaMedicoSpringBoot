package com.f_rafael.hospital_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PacienteDto {
    private Long id;
    private Long dni;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private List<NumeroTelefonicoDto> telefono;
    private LocalDate fechaNacimiento;
    private Long lugarNacimientoId;
    private Long direccionId;
    private ObraSocialDto obraSocial;
}
