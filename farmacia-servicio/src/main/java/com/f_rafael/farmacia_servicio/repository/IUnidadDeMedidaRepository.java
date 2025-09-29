package com.f_rafael.farmacia_servicio.repository;

import com.f_rafael.farmacia_servicio.model.UnidadDeMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUnidadDeMedidaRepository extends JpaRepository<UnidadDeMedida,Long> {

    public Optional<UnidadDeMedida> findByNombre(String nombre);
    public Optional<UnidadDeMedida> findBySimbolo(String simbolo);
}
