package com.f_rafael.farmacia_servicio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Setter
@NoArgsConstructor
@Getter
public class PrincipioActivoDto {
    private Long id;
    private String nombre;
    private Set<SubAccionTerapeuticaDto> accionesTerapeuticas;
    private Set<SubMedicamentoDto> medicamentos;
}
