package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.dto.DosisDto;
import com.f_rafael.hospital_servicio.dto.MedicamentoDto;
import com.f_rafael.hospital_servicio.dto.UnidadDeMedidaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "FARMACIA-SERVICIO")
public interface IFarmaciaClient {

    @GetMapping("/dosis/{id}")
    public DosisDto buscarDosisPorId(@PathVariable Long id);

    @GetMapping("/medicamentos/{id}")
    public MedicamentoDto buscarMedicamentoPorId(@PathVariable Long id);

    @GetMapping("/unidades-de-medida/{id}")
    public UnidadDeMedidaDto buscarUnidadPorId(@PathVariable Long id);

    @GetMapping("/unidades-de-medida/nombre")
    public UnidadDeMedidaDto buscarUnidadPorNombre(@RequestParam String nombre);
}
