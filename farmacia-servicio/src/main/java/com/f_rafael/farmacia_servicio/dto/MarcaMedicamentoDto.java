package com.f_rafael.farmacia_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class MarcaMedicamentoDto {
    private Long id;
    private String nombre;
    private Set<SubMedicamentoDto> medicamentos;
}
