package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.FormaFarmaceuticaDto;
import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;

import java.util.List;

public interface IFormaFarmaceuticaService {
    public FormaFarmaceuticaDto buscarPorId(Long id);
    public List<FormaFarmaceuticaDto> buscarTodas();
    public FormaFarmaceuticaDto guardar(FormaFarmaceutica formaFarmaceutica);
    public FormaFarmaceuticaDto actualizar(FormaFarmaceutica formaFarmaceutica);
    public void borrarPorId(Long id);
    public FormaFarmaceuticaDto buscarPorNombre(String nombre);
    public FormaFarmaceuticaDto modificarNombre(Long id, String nombre);
}
