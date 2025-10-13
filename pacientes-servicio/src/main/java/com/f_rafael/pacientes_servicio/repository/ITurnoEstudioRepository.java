package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.model.TurnoEstudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITurnoEstudioRepository extends JpaRepository<TurnoEstudio, Long> {

    @Query("SELECT te FROM TurnoEstudio te WHERE te.fechaTurno = :fechaTurno")
    public List<TurnoEstudio> buscarPorFechaTurno(@Param("fechaTurno") LocalDate fechaTurno);
    @Query("SELECT te FROM TurnoEstudio te WHERE te.estado = :estado")
    public List<TurnoEstudio> buscarPorEstado(@Param("estado") String estado);
    public List<TurnoEstudio> findByEstudioId(Long id);
}
