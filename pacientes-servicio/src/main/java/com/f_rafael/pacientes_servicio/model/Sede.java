package com.f_rafael.pacientes_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "sedes")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long direccionId;
    @ElementCollection
    @CollectionTable(name = "sede_telefono_id", joinColumns = @JoinColumn(name = "sede_id"))
    private Set<Long> telefonosId;
    @ManyToOne
    private ObraSocial obraSocial;
}
