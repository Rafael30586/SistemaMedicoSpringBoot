package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.dto.EstudioDto;
import com.f_rafael.pacientes_servicio.dto.MedicoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOSPITAL-SERVICIO")
public interface HospitalClient {

    @GetMapping("/estudios/{id}")
    public EstudioDto obtenerEstudioPorId(@PathVariable Long id);

    @GetMapping("/empleados/{id}")
    public MedicoDto obtenerMedicoPorId(@PathVariable Long id);
}
