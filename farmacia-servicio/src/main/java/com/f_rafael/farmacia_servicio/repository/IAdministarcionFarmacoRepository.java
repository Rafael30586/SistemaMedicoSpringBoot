package com.f_rafael.farmacia_servicio.repository;

import com.f_rafael.farmacia_servicio.model.AdministracionFarmaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAdministarcionFarmacoRepository extends JpaRepository<AdministracionFarmaco, Long> {

    public Optional<AdministracionFarmaco> findByVia(String via);
}
