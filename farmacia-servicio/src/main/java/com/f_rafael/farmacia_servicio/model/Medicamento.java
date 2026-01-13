package com.f_rafael.farmacia_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "medicamentos")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToMany
    @JoinTable(
            name = "medicamento_principio_activo",
            joinColumns = @JoinColumn(name = "medicamento_id"),
            inverseJoinColumns = @JoinColumn(name = "principio_activo_id")
    )
    private Set<PrincipioActivo> principiosActivos;
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
