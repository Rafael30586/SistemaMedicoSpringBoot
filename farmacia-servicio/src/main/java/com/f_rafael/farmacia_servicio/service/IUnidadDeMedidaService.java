package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.UnidadDeMedida;

import java.util.List;
import java.util.Optional;

public interface IUnidadDeMedidaService {
    public Optional<UnidadDeMedida> buscarPorId(Long id);
    public List<UnidadDeMedida> buscarTodas();
    public UnidadDeMedida guardar(UnidadDeMedida unidad);
    public UnidadDeMedida actualizar(UnidadDeMedida unidad);
    public void borrarPorId(Long id);
    public Optional<UnidadDeMedida> buscarPorNombre(String nombre);
    public Optional<UnidadDeMedida> buscarPorSimbolo(String simbolo);
}
