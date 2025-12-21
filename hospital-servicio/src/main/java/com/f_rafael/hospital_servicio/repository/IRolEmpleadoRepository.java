package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.RolEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRolEmpleadoRepository extends JpaRepository<RolEmpleado, Long> {

    public Optional<RolEmpleado> findByNombre(String nombre);
    @Query("SELECT re FROM RolEmpleado re LEFT JOIN FETCH re.sector WHERE re.sector.nombre = :sector")
    public List<RolEmpleado> buscarPorSector(String sector);
}
