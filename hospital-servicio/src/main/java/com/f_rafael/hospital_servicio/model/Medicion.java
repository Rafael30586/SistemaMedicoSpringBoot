package com.f_rafael.hospital_servicio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mediciones")
@Entity
public class Medicion {
    private Long id;
    private String nombre;
    private String descripcion;
}
