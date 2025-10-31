package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.MedicamentoPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMedicamentoPacienteRepository extends JpaRepository<MedicamentoPaciente, Long> {

    public MedicamentoPaciente findByPacienteId(Long id);
    @Query("SELECT mp FROM MedicamentoPaciente mp WHERE mp.inicio BETWEEN :desde AND :hasta")
    public List<MedicamentoPaciente> buscarPorFechaDeInicio(@Param("desde")LocalDate desde, @Param("hasta") LocalDate hasta);
    @Query("SELECT mp FROM MedicamentoPaciente mp WHERE mp.fin BETWEEN :desde AND :hasta")
    public List<MedicamentoPaciente> buscarPorFechaDeFinal(@Param("desde")LocalDate desde, @Param("hasta") LocalDate hasta);
}
