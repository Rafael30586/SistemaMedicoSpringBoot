package com.f_rafael.farmacia_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "medicamentos")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "principio_activo")
    private PrincipioActivo principioActivo;
    @Column(name = "forma_farmaceutica")
    private FormaFarmaceutica formaFarmaceutica;
    private AdministracionFarmaco administracion;
    private MarcaMedicamento marca;
}
