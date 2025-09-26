package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.Dosis;

import java.util.List;
import java.util.Optional;

public interface IDosisService {
    public Optional<Dosis> buscarPorId(Long id);
    public List<Dosis> buscarTodas();
    public Dosis guardar(Dosis dosis);
    public Dosis actualizar(Dosis dosis);
    public void borrarPorId(Long id);
}
