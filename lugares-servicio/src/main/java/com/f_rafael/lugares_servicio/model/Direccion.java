package com.f_rafael.lugares_servicio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "direcciones")
public class Direccion {
    private Long id;
    private String calle;
    private Integer altura;
    private String departamento;
    @ManyToOne
    private Localidad localidad;
}
