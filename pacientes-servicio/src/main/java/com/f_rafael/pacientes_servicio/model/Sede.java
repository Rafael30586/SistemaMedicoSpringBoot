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
    private Long direccionId;
    @ElementCollection
    private Set<Long> telefonoId;
}
