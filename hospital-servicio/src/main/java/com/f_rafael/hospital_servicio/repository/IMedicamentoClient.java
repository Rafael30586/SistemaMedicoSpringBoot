package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.dto.MedicamentoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FARMACIA-SERVICIO")
public interface IMedicamentoClient {

    @GetMapping("/medicamentos/{id}")
    public MedicamentoDto buscarPorId(@PathVariable("id") Long id);
}
