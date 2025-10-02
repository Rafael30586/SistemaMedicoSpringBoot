package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.Dosis;
import com.f_rafael.farmacia_servicio.model.UnidadDeMedida;

import java.util.List;
import java.util.Optional;

public interface IDosisService {
    public Optional<Dosis> buscarPorId(Long id);
    public Dosis buscarPorId2(Long id);
    public List<Dosis> buscarTodas();
    public Dosis guardar(Dosis dosis);
    public Dosis actualizar(Dosis dosis);
    public Dosis actualizar2(Dosis dosis);
    public void borrarPorId(Long id);
    public Optional<Dosis> buscarPorCantidadUnidadEIntervalo(float cantidad, String nombreUnidad, int intervalo);
    public Dosis buscarPorCantidadUnidadEIntervalo2(float cantidad, String nombreUnidad, int intervalo);
}
