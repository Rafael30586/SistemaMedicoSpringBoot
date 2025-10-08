package com.f_rafael.pacientes_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resultados_estudios")
public class ResultadosDeEstudios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    @ManyToOne
    private Paciente paciente;
    @Enumerated(EnumType.STRING)
    private Cobertura cobertura;
    @ElementCollection
    @CollectionTable(name = "resultado_estudios_estudio_id", joinColumns = @JoinColumn(name = "resultado_estudios_id"))
    private List<Long> estudios;
    private String urlInforme;
}
