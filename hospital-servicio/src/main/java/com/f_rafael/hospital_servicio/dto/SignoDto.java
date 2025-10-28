package com.f_rafael.hospital_servicio.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class SignoDto {
    private Long id;
    private String nombre;
    private Double valorMinimo;
    private Double valorMaximo;
    private UnidadDeMedidaDto unidad;
    private String descripcion;
    private Set<String> diagnosticos;
}
