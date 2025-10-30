package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.EstudioMedico;
import org.apache.commons.configuration.plist.XMLPropertyListConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEstudioMedicoRepository extends JpaRepository<EstudioMedico, Long> {

    public Optional<EstudioMedico> findByNombre(String nombre);
    @Query("SELECT em FROM EstudioMedico em LEFT JOIN FETCH em.clasificacion WHERE em.clasificacion.nombre = :clasificacion")
    public List<EstudioMedico> buscarPorClasificacion(String clasificacion);
}
