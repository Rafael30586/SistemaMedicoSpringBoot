package com.f_rafael.farmacia_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FormaFarmaceuticaDto {
    private Long id;
    private String nombre;
    private Set<SubMedicamentoDto> medicamento;
}
