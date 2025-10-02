package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.Dosis;

import java.util.List;

public interface IDosisService {

    public Dosis buscarPorId(Long id);
    public List<Dosis> buscarTodas();
    public Dosis guardar(Dosis dosis);
    public Dosis actualizar(Dosis dosis);
    public void borrarPorId(Long id);
    public Dosis buscarPorCantidadUnidadEIntervalo(float cantidad, String nombreUnidad, int intervalo);
}
