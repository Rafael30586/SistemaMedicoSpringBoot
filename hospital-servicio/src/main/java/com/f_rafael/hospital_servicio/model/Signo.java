package com.f_rafael.hospital_servicio.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "signos")
@Getter @Setter
public class Signo { // A diferencia de los síntomas, se pueden medir, ejemplo: fiebre
    private Long id;
    private String nombre;
    private Medicion medicion;
    @ManyToMany(mappedBy = "signos")
    private Diagnostico diagnosticos;
}
