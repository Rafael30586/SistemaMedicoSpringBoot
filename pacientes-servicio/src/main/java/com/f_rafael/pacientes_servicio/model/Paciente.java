package com.f_rafael.pacientes_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "pacientes")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private Long dni;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    @Column(unique = true)
    private String email;
    @ElementCollection
    @CollectionTable(name = "paciente_telefono_id", joinColumns = @JoinColumn(name = "paciente_id"))
    private Set<Long> telefonosId;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    private Long lugarNacimientoId;
    private Long direccionId;
    @ManyToOne
    private ObraSocial2 obraSocial;

}
