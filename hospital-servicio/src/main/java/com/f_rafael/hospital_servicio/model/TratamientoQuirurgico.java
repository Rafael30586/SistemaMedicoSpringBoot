package com.f_rafael.hospital_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "tratamientos_quirurgicos")
public class TratamientoQuirurgico { // Tratamiento quirúrgico
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Lob
    private String descripcion;
}
