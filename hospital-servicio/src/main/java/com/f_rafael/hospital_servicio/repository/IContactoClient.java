package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.dto.DireccionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CONTACTO-SERVICIO")
public interface IContactoClient {

    @GetMapping("/direcciones/{id}")
    public DireccionDto buscarDireccionPorId(@PathVariable Long id);
}
