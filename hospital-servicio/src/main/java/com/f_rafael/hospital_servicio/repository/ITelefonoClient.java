package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.dto.NumeroTelefonicoDto;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient(name = "CONTACTO-SERVICIO")
public interface ITelefonoClient { // Interfaz para borrar

    @GetMapping("/numeros-telefonicos/{id}")
    public NumeroTelefonicoDto obtenerInformacionNumeroTelefonico(@PathVariable Long id);

}
