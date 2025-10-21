package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.PsicoterapiaPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPsicoterapiaPacienteRepository extends JpaRepository<PsicoterapiaPaciente, Long> {
}
