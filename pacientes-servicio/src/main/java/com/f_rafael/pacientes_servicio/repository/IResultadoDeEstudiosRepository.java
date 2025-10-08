package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.model.ResultadosDeEstudios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResultadoDeEstudiosRepository extends JpaRepository<ResultadosDeEstudios, Long> {
}
