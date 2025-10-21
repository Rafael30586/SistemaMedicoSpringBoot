package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.model.TurnoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITurnoCitaRepository extends JpaRepository<TurnoCita, Long> {

    @Query("SELECT tc FROM TurnoCita tc LEFT JOIN FETCH Paciente p WHERE p.dni = :dni")
    public List<TurnoCita> buscarPorPaciente(Long dni);

    @Query("SELECT tc FROM TurnoCita tc WHERE tc.fechaTurno = :fechaTurno")
    public List<TurnoCita> buscarPorFechaTurno(LocalDate fechaTurno);

    @Query("SELECT tc FROM TurnoCita tc WHERE tc.estado = :estado")
    public List<TurnoCita> buscarPorEstado(String estado);

    public List<TurnoCita> findByProfesionalId(Long id);

    @Query("SELECT tc FROM TurnoCita tc WHERE tc.fechaTurno BETWEEN :desde AND :hasta")
    public List<TurnoCita> buscarPorPeriodo(LocalDate desde, LocalDate hasta);
}
