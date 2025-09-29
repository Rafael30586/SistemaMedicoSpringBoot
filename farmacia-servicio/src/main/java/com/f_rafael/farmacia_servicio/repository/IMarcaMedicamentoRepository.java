package com.f_rafael.farmacia_servicio.repository;

import com.f_rafael.farmacia_servicio.model.MarcaMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMarcaMedicamentoRepository extends JpaRepository<MarcaMedicamento, Long> {
    public Optional<MarcaMedicamento> findByNombre(String nombre);
}
