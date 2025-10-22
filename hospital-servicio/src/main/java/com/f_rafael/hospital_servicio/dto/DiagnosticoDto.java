package com.f_rafael.hospital_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DiagnosticoDto {
    private Long id;
    private String nombre;
    private Set<String> sintomas;
    private Set<String> signos;
}
