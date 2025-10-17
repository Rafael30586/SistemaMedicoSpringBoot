package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISedeRepository extends JpaRepository<Sede, Long> {

    @Query("SELECT s FROM Sede s LEFT JOIN FETCH s.telefonos t WHERE t = :numero")
    public Optional<Sede> buscarPorNumeroTelefonico(@Param("numero") String numero);
}
