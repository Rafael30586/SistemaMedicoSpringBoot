package com.f_rafael.pacientes_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class SedeDto {
    private Long id;
    private DireccionDto direccion;
    private Set<NumeroTelefonicoDto> telefonos;
    private SubObraSocialDto obraSocial;
}
