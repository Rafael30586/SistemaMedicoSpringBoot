package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.dto.EstudioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOSPITAL_SERVICIO")
public interface IEstudioClient {

    @GetMapping("/estudios/{id}")
    public EstudioDto obtenerInformacionEstudio(@PathVariable("id") Long id);
}
