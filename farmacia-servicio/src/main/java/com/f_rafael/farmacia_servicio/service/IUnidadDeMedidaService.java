package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.UnidadDeMedida;

import java.util.List;

public interface IUnidadDeMedidaService {
    public UnidadDeMedida buscarPorId(Long id);
    public List<UnidadDeMedida> buscarTodas();
    public UnidadDeMedida guardar(UnidadDeMedida unidad);
    public UnidadDeMedida actualizar(UnidadDeMedida unidad);
    public void borrarPorId(Long id);
    public UnidadDeMedida buscarPorNombre(String nombre);
    public UnidadDeMedida buscarPorSimbolo(String simbolo);
    public UnidadDeMedida modificarNombre(Long id, String nombre);
    public UnidadDeMedida modificarSimbolo(Long id, String simbolo);
}
