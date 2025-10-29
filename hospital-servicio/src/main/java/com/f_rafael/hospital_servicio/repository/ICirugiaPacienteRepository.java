package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.CirugiaPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICirugiaPacienteRepository extends JpaRepository<CirugiaPaciente, Long> {

    public List<CirugiaPaciente> findByPacienteId(Long id);

    @Query("SELECT cp FROM CirugiaPaciente cp LEFT JOIN FETCH cp.cirugia WHERE cp.cirugia.nombre = :cirugia")
    public List<CirugiaPaciente> buscarPorCirugia(@Param("cirugia") String cirugia);
}
