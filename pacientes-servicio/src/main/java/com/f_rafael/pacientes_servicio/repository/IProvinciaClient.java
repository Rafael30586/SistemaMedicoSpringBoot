package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.dto.ProvinciaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CONTACTO-SERVICIO")
public interface IProvinciaClient {

    @GetMapping("/provicnias/{id}")
    public ProvinciaDto obtenerInformacionDeProvincia(@PathVariable Long id);

}
