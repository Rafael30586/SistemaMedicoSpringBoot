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
    private Long id;
    private Paciente paciente;
    private Boolean cobertura;
    @ElementCollection
    @CollectionTable(name = "resultado_estudios_estudio_id", joinColumns = @JoinColumn(name = "resultado_estudios_id"))
    private List<Long> estudios;
    private String informe;
}
