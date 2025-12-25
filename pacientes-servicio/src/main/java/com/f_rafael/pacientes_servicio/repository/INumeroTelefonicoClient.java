package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.dto.NumeroTelefonicoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

// @FeignClient(name = "CONTACTO-SERVICIO")
public interface INumeroTelefonicoClient { // Esta interface ya no sirve. Borrarla

    @GetMapping("/numeros-telefonicos/{id}")
    public NumeroTelefonicoDto buscarPorId(@PathVariable Long id);
    @GetMapping("/numeros-telefonicos")
    public NumeroTelefonicoDto buscarPorNumero(@RequestParam String numero);
}
