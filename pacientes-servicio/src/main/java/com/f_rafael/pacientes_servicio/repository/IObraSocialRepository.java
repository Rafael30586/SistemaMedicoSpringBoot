package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.model.ObraSocial2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IObraSocialRepository extends JpaRepository<ObraSocial2, Long> {

    public Optional<ObraSocial2> findByNombre(String nombre);
}
