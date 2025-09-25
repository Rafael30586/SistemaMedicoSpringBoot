package com.f_rafael.lugares_servicio.repository;

import com.f_rafael.lugares_servicio.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDireccionRepository extends JpaRepository<Direccion, Long> {
}
