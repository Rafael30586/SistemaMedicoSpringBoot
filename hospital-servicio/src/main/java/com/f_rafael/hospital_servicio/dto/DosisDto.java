package com.f_rafael.hospital_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class DosisDto {
    private Long id;
    private Float cantidad;
    private UnidadDeMedidaDto unidad;
    private Integer intervaloHoras;
}
