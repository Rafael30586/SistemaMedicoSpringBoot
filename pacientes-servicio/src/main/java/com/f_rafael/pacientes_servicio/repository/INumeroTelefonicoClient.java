package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.dto.NumeroTelefonicoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CONTACTO-SERVICIO")
public interface INumeroTelefonicoClient {

    @GetMapping("/numeros-telefonicos/{id}")
    public NumeroTelefonicoDto obtenerInformacionDeNumerosTelefonicos(@PathVariable Long id);
}
