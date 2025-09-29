package com.f_rafael.farmacia_servicio.repository;

import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFormaFarmaceuticaRepository extends JpaRepository<FormaFarmaceutica, Long> {

    public Optional<FormaFarmaceutica> findByNombre(String nombre);
}
