package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.dto.LocalidadDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CONTACTO-SERVICIO")
public interface ILocalidadClient {

    @GetMapping("/localidades/{id}")
    public LocalidadDto obtenerInformacionDeLocalidad(@PathVariable Long id);
}
