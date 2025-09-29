package com.f_rafael.farmacia_servicio.repository;

import com.f_rafael.farmacia_servicio.model.Dosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDosisRepository extends JpaRepository<Dosis, Long> {

    // public Optional<Dosis> findByCantidadAndUnidadAndIntervaloHoras(float cantidad, String unidad, int intervaloHoras);

    @Query("SELECT d FROM Dosis d LEFT JOIN FETCH d.unidad " +
            "WHERE d.cantidad = :cantidad AND d.intervaloHoras = :intervalo AND d.unidad.nombre = :nombreUnidad")
    public Optional<Dosis> buscarPorCantidadUnidadEIntervalo(@Param("cantidad") float cantidad,
                                                             @Param("nombreUnidad") String nombreUnidad,
                                                             @Param("intervalo") int intervalo);
}
