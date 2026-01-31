package com.f_rafael.hospital_servicio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "cirugia_paciente")
public class CirugiaPaciente { // Una cirugía realizada a un paciente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "paciente_id", nullable = false)
    private Long pacienteId;
    @ManyToOne
    @JoinColumn(nullable = false, name = "cirugía_id")
    private TratamientoQuirurgico cirugia;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha;
    private LocalTime inicio;
    private LocalTime fin;
}
