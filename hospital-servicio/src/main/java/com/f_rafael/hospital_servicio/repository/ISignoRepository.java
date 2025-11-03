package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.Signo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISignoRepository extends JpaRepository<Signo, Long> {

    public Optional<Signo> findByNombre(String nombre);
    public List<Signo> findAllByDescripcionContainingIgnoreCase(String secuencia);
}
