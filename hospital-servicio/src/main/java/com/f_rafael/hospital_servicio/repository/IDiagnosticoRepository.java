package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDiagnosticoRepository extends JpaRepository<Diagnostico, Long> {

    public Optional<Diagnostico> findByNombre(String nombre);
}
