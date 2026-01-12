package com.f_rafael.farmacia_servicio.repository;

import com.f_rafael.farmacia_servicio.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMedicamentoRepository extends JpaRepository<Medicamento, Long> {
/*
    @Query("SELECT m FROM Medicamento m LEFT JOIN FETCH m.principioActivo WHERE m.principioActivo.nombre = :nombre")
    public List<Medicamento> buscarPorPrincipioActivo(@Param("nombre") String nombre);*/

    @Query("SELECT m FROM Medicamento m LEFT JOIN FETCH m.formaFarmaceutica WHERE m.formaFarmaceutica.nombre = :nombre")
    public List<Medicamento> buscarPorFormaFarmaceutica(@Param("nombre") String nombre);

    @Query("SELECT m FROM Medicamento m LEFT JOIN FETCH m.administracion WHERE m.administracion.via = :via")
    public List<Medicamento> buscarPorAdministracion(@Param("via") String via);

    @Query("SELECT m FROM Medicamento m LEFT JOIN FETCH m.marca WHERE m.marca.nombre = :nombre")
    public List<Medicamento> buscarPorMarca(@Param("nombre") String nombre);
}
