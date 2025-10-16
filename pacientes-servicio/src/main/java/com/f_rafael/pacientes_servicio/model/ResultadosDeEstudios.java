package com.f_rafael.pacientes_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resultados_estudios")
public class ResultadosDeEstudios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero; // Cambiar a id
    @ManyToOne
    private Paciente paciente;
    //@Enumerated(EnumType.STRING)
    //private Cobertura cobertura; // Quitar este atributo y colocárselo  a la entidad Turno
    @ElementCollection
    @CollectionTable(name = "resultado_estudios_estudio_id", joinColumns = @JoinColumn(name = "resultado_estudios_id"))
    private Set<Long> estudios;
    private String urlInforme;
}
