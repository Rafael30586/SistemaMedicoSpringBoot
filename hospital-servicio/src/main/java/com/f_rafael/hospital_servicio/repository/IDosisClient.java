package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.dto.DosisDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FARMACIA-SERVICIO")
public interface IDosisClient {

    @GetMapping("/dosis/{id}")
    public DosisDto buscarPorId(@PathVariable Long id);
}
