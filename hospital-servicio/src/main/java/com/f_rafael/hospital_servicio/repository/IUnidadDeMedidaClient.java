package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.dto.UnidadDeMedidaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FARMACIA-SERVICIO")
public interface IUnidadDeMedidaClient {

    @GetMapping("unidades-de-medida/{id}")
    public UnidadDeMedidaDto buscarPorId(@PathVariable("id") Long id);
}
