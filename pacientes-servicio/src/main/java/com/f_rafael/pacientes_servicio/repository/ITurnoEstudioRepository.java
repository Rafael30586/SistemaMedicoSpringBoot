package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.model.TurnoEstudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoEstudioRepository extends JpaRepository<TurnoEstudio, Long> {
}
