package com.f_rafael.farmacia_servicio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "acciones_terapeuticas")
public class AccionTerapeutica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nombre;
    private String descripcion;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "accionesTerapeuticas") // Acá en mapped by va el nombre de el atributo de la clase que es la dueña de la relación
    Set<PrincipioActivo> principiosActivos;
}
