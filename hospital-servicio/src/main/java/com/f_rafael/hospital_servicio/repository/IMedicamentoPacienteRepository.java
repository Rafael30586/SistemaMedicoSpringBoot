package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.MedicamentoPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicamentoPacienteRepository extends JpaRepository<MedicamentoPaciente, Long> {
}
