package com.f_rafael.farmacia_servicio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Column(nullable = false)
    private Float cantidad;
    @ManyToOne
    @JoinColumn(
            nullable = false
    )
    private UnidadDeMedida unidad;
    @Column(name = "intervalo_horas", nullable = false)
    @JsonProperty("intervalo_en_horas")
    private Integer intervaloHoras;
}
