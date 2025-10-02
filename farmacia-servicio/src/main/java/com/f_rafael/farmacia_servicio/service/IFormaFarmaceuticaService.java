package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.FormaFarmaceuticaDto;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;

import java.util.List;
import java.util.Optional;

public interface IFormaFarmaceuticaService {
    public Optional<FormaFarmaceutica> buscarPorId(Long id);
    public FormaFarmaceuticaDto buscarPorId2(Long id);
    public List<FormaFarmaceutica> buscarTodas();
    public List<FormaFarmaceuticaDto> buscarTodas2();
    public FormaFarmaceutica guardar(FormaFarmaceutica formaFarmaceutica);
    public FormaFarmaceuticaDto guardar2(FormaFarmaceutica formaFarmaceutica);
    public FormaFarmaceutica actualizar(FormaFarmaceutica formaFarmaceutica);
    public FormaFarmaceuticaDto actualizar2(FormaFarmaceutica formaFarmaceutica);
    public void borrarPorId(Long id);
    public void borrarPorId2(Long id);
    public Optional<FormaFarmaceutica> buscarPorNombre(String nombre);
    public FormaFarmaceuticaDto buscarPorNombre2(String nombre);
}
