package com.f_rafael.lugares_servicio.repository;

import com.f_rafael.lugares_servicio.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProvinciaRepository extends JpaRepository<Provincia, Long> {

    public Optional<Provincia> findByNombre(String nombre);
}
