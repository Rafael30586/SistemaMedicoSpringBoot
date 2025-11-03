package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISectorRepository extends JpaRepository<Sector, Long> {

    public Optional<Sector> findByNombre(String nombre);
}
