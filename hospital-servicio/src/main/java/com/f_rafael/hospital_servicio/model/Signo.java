package com.f_rafael.hospital_servicio.model;


import jakarta.persistence.*;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nombre;
    @Column(name = "valor_minimo")
    private Double valorMinimo;
    @Column(name = "valor_maximo")
    private Double valorMaximo;
    private Long unidadId;
    @Column(nullable = false, length = 65536, columnDefinition = "text")
    @Lob
    private String descripcion;
    //@ManyToOne
    //@JoinColumn(name = "medicion_id")
    //private Medicion medicion;
    @ManyToMany(mappedBy = "signos")
    private Diagnostico diagnosticos;
}
