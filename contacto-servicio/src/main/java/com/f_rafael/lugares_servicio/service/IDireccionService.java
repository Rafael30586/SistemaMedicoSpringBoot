package com.f_rafael.lugares_servicio.service;

import com.f_rafael.lugares_servicio.model.Direccion;
import com.f_rafael.lugares_servicio.model.Localidad;

import java.util.List;
import java.util.Optional;

public interface IDireccionService {
    public Optional<Direccion> buscarPorId(Long id);
    public List<Direccion> buscarTodas();
    public Direccion guardar(Direccion direccion);
    public Direccion actualizar(Direccion direccion);
    public void borrarPorId(Long id);
    public List<Direccion> buscarPorLocalidad(String localidad);
    public List<Direccion> buscarPorProvincia(String provincia);

}
