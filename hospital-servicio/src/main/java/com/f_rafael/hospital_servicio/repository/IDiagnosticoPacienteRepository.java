package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.DiagnosticoPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDiagnosticoPacienteRepository extends JpaRepository<DiagnosticoPaciente, Long> {

    @Query("SELECT dp FROM DiagnosticoPaciente dp WHERE dp.pacienteId = :idPaciente")
    public List<DiagnosticoPaciente> buscarPorPaciente(@Param("idPaciente") Long idPaciente);
}
