package com.f_rafael.farmacia_servicio.repository;

import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccionTerapeuticaRepository extends JpaRepository<AccionTerapeutica, Long> {
}
