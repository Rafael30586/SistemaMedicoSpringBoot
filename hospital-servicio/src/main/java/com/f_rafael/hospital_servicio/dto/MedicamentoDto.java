package com.f_rafael.hospital_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentoDto {
    private Long id;
    private Set<PrincipioActivoDto> principiosActivos;
    private FormaFarmaceuticaDto formaFarmaceutica;
    private AdministracionFarmacoDto administracion;
    private MarcaMedicamentoDto marca;
}
