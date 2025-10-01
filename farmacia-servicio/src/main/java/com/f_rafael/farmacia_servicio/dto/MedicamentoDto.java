package com.f_rafael.farmacia_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentoDto {
    private Long id;
    private SubPrincipioActivoDto principioActivo;
    private SubFormaFarmaceuticaDto formaFarmaceutica;
    private SubAdministracionFarmacoDto administracion;
    private SubMarcaMedicamentoDto marca;
}
