package com.f_rafael.hospital_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medicamento_paciente")
public class MedicamentoPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "paciente_id")
    private Long pacienteId;
    @ManyToOne
    @JoinColumn(nullable = false, name = "tratamiento_farmacológico_id")
    private TratamientoFarmacologico tratamientoFarmacologico;
    private LocalDate inicio;
    private LocalDate fin;
}
