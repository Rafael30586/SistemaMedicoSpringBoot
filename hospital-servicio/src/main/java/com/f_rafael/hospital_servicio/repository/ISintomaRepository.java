package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.Sintoma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ISintomaRepository extends JpaRepository<Sintoma, Long> {

    public Optional<Sintoma> findByNombre(String nombre);
}
