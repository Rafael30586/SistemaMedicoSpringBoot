package com.f_rafael.hospital_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentoDto {
    private Long id;
    private PrincipioActivoDto principioActivo;
    private FormaFarmaceuticaDto formaFarmaceutica;
    private AdministracionFarmacoDto administracion;
    private MarcaMedicamentoDto marca;
}
