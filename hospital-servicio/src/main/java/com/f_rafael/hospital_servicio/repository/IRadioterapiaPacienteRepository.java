package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.RadioterapiaPaciente;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IRadioterapiaPacienteRepository extends JpaRepository<RadioterapiaPaciente, Long> {

    public List<RadioterapiaPaciente> findByPacienteId(Long id);
    @Query("SELECT rp FROM RadioterapiaPaciente rp WHERE rp.inicio BETWEEN :desde AND :hasta")
    public List<RadioterapiaPaciente> buscarPorFechaDeInicio(@Param("desde")LocalDate desde, @Param("hasta") LocalDate hasta);
    @Query("SELECT rp FROM RadioterapiaPaciente rp WHERE rp.fin BETWEEN :desde AND :hasta")
    public List<RadioterapiaPaciente> buscarPorFechaDeFinal(@Param("desde")LocalDate desde, @Param("hasta") LocalDate hasta);
}
