package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.model.ObraSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IObraSocialRepository extends JpaRepository<ObraSocial, Long> {

    public Optional<ObraSocial> findByNombre(String nombre);
}
