package com.f_rafael.pacientes_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class SedeDto { // Hay que agregar un campo que sea SubObraSocialDto
    private Long id;
    private DireccionDto direccion;
    private Set<NumeroTelefonicoDto> telefonos;
}
