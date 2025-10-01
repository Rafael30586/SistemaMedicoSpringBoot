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
@Table(name = "medicamentos")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(
            name = "principio_activo_id",
            nullable = false
    )
    private PrincipioActivo principioActivo;
    @ManyToOne
    @JoinColumn(
            name = "forma_farmaceutica_id"
    )
    private FormaFarmaceutica formaFarmaceutica;
    @ManyToOne
    @JoinColumn(
            name = "administracion_id"
    )
    private AdministracionFarmaco administracion;
    @ManyToOne
    @JoinColumn(
            name = "marca_id"
    )
    private MarcaMedicamento marca;
}
