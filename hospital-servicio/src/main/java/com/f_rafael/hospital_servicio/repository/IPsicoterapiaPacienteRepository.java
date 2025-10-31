package com.f_rafael.hospital_servicio.repository;


import com.f_rafael.hospital_servicio.model.PsicoterapiaPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPsicoterapiaPacienteRepository extends JpaRepository<PsicoterapiaPaciente, Long> {

    public List<PsicoterapiaPaciente> findByPacienteId(Long id);
    @Query("SELECT pp FROM PsicoterapiaPaciente pp WHERE pp.inicio BETWEEN :desde AND :hasta")
    public List<PsicoterapiaPaciente> buscarPorFechaDeInicio(LocalDate desde, LocalDate hasta);
    @Query("SELECT pp FROM PsicoterapiaPaciente pp WHERE pp.fin BETWEEN :desde AND :hasta")
    public List<PsicoterapiaPaciente> buscarPorFechaDeFinal(LocalDate desde, LocalDate hasta);
}
