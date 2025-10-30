package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.FisioterapiaPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IFisioterapiaPacienteRepository extends JpaRepository<FisioterapiaPaciente, Long> {

    public List<FisioterapiaPaciente> findByPacienteId(Long id);
    @Query("SELECT fp FROM FisioterapiaPaciente fp WHERE fp.inicio BETWEEN :desde AND :hasta")
    public List<FisioterapiaPaciente> buscarPorFechaDeInicio(@Param("desde")LocalDate desde,@Param("hasta") LocalDate hasta);
    @Query("SELECT fp FROM FisioterapiaPaciente fp WHERE fp.fin BETWEEN :desde AND :hasta")
    public List<FisioterapiaPaciente> buscarPorFechaDeFinal(@Param("desde")LocalDate desde,@Param("hasta") LocalDate hasta);

}
