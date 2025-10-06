package com.f_rafael.lugares_servicio.repository;

import com.f_rafael.lugares_servicio.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPaisRepository extends JpaRepository<Pais, Long> {

    public Optional<Pais> findByNombre(String nombre);
}
