package com.f_rafael.farmacia_servicio.repository;

import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAccionTerapeuticaRepository extends JpaRepository<AccionTerapeutica, Long> {

    public Optional<AccionTerapeutica> findByNombre(String nombre);

    @Query("SELECT at FROM AccionTerapeutica at WHERE at.descripcion LIKE '%:secuencia%'")
    public List<AccionTerapeutica> buscarPorSecuenciaEnDescripcion(@Param("secuencia") String secuencia);
}
