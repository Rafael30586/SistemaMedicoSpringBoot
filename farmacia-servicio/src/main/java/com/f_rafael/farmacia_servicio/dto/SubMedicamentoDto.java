package com.f_rafael.farmacia_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SubMedicamentoDto {
    private Long id;
    private String principioActivo;
    private String formaFarmaceutica;
    private String administracion;
    private String marca;
}
