package com.f_rafael.farmacia_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdministracionFarmacoDto {
    private Long id;
    private String via;
    private Set<SubMedicamentoDto> medicamentos;
}
