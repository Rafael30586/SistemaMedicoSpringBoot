package com.f_rafael.lugares_servicio.repository;

import com.f_rafael.lugares_servicio.model.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocalidadRepository extends JpaRepository<Localidad, Long> {
}
