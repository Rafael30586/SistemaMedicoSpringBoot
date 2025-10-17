package com.f_rafael.pacientes_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class NumeroTelefonicoDto { // Este dto ya no sirve. Hay que borrarlo
    private Long id;
    private String numero;
    private String tipo;
}
