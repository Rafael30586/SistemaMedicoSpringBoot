package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISedeRepository extends JpaRepository<Sede, Long> {
}
