package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.EstudioMedicoClasificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEstudioMedicoClasificacionRepository extends JpaRepository<EstudioMedicoClasificacion, Long> {

    public Optional<EstudioMedicoClasificacion> findByNombre(String nombre);
}
