package com.f_rafael.lugares_servicio.service;

import com.f_rafael.lugares_servicio.model.Localidad;

import java.util.List;
import java.util.Optional;

public interface ILocalidadService {

    public Localidad buscarPorId(Long id);
    public List<Localidad>  buscarTodas();
    public Localidad guardar(Localidad localidad);
    public Localidad actualizar(Localidad localidad);
    public void borrarPorId(Long id);
    public void cambiarNombre(Long id, String nombre);
    public void cambiarProvincia(Long id, Long idProvincia);
    
}
