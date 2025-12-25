package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.dto.DireccionDto;
import com.f_rafael.pacientes_servicio.dto.LocalidadDto;
import com.f_rafael.pacientes_servicio.dto.ProvinciaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CONTACTO-SERVICIO")
public interface IContactoClient {

    @GetMapping("/direcciones/{id}")
    public DireccionDto obtenerDireccionPorId(@PathVariable Long id);

    @GetMapping("/localidades/{id}")
    public LocalidadDto obtenerLocalidadPorId(@PathVariable Long id);

    @GetMapping("/provincias/{id}")
    public ProvinciaDto obtenerProvinciaporId(@PathVariable Long id);
}
