package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.dto.MedicoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOSPITAL-SERVICIO")
public interface IMedicoClient {

    @GetMapping("/empleados/{id}")
    public MedicoDto obtenerInformacionMedico(@PathVariable Long id);
}
