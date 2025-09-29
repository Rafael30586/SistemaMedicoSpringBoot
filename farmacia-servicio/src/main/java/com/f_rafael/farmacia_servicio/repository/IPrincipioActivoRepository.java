package com.f_rafael.farmacia_servicio.repository;

import com.f_rafael.farmacia_servicio.model.PrincipioActivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPrincipioActivoRepository extends JpaRepository<PrincipioActivo, Long> {

    public Optional<PrincipioActivo> findByNombre(String nombre);

}
