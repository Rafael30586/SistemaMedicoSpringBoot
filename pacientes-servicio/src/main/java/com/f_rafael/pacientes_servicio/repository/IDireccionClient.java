package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.dto.DireccionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient(name = "CONTACTO-SERVICIO")
public interface IDireccionClient {

    @GetMapping("/direcciones/{id}")
    public DireccionDto obtenerInformacionDireccion(@PathVariable Long id);
}
