package com.f_rafael.farmacia_servicio.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "principios_activos")
public class PrincipioActivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nombre;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "principios_activos_acciones_terapeuticas",
            joinColumns = @JoinColumn(name = "principio_activo_id"),
            inverseJoinColumns = @JoinColumn(name = "accion_terapeutica_id")
    )
    private Set<AccionTerapeutica> accionesTerapeuticas;
    @ManyToMany(mappedBy = "principiosActivos")
    private Set<Medicamento> medicamentos;

}
