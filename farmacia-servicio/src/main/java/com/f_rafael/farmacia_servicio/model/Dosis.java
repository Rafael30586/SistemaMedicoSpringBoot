package com.f_rafael.farmacia_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "dosis")
public class Dosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float cantidad;
    @ManyToOne
    private UnidadDeMedida unidad;
    @Column(name = "intervalo_horas")
    private Integer intervaloHoras;
}
