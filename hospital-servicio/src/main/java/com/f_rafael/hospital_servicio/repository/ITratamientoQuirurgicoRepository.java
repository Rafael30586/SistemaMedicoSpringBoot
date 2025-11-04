package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.TratamientoQuirurgico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITratamientoQuirurgicoRepository extends JpaRepository<TratamientoQuirurgico, Long> {

    public Optional<TratamientoQuirurgico> findByNombre(String nombre);
    public List<TratamientoQuirurgico> findAllByDescripcionContaining(String secuencia);
}
