package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.dto.PacienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PACIENTES-SERVICIO")
public interface IPacienteClient {

    @GetMapping("/pacientes/{id}")
    public PacienteDto buscarPacientePorId(@PathVariable Long id);

    @GetMapping("/pacientes/{dni}")
    public PacienteDto buscarPacientePorDni(@PathVariable Long dni);
}
