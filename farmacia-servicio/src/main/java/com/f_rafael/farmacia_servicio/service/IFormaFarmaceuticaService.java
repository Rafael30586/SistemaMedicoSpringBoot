package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;

import java.util.List;
import java.util.Optional;

public interface IFormaFarmaceuticaService {
    public Optional<FormaFarmaceutica> buscarPorId(Long id);
    public List<FormaFarmaceutica> buscarTodas();
    public FormaFarmaceutica guardar(FormaFarmaceutica formaFarmaceutica);
    public FormaFarmaceutica actualizar(FormaFarmaceutica formaFarmaceutica);
    public void borrarPorId(Long id);
    public Optional<FormaFarmaceutica> buscarPorNombre(String nombre);
}
