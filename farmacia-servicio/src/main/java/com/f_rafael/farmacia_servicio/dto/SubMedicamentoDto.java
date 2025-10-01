package com.f_rafael.farmacia_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public class SubMedicamentoDto {
    private Long id;
    private String principioActivo;
    private String formaFarmaceutica;
    private String administracion;
    private String marca;
}
