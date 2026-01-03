package com.f_rafael.lugares_servicio.service;

import com.f_rafael.lugares_servicio.model.Direccion;
import com.f_rafael.lugares_servicio.model.Localidad;

import java.util.List;
import java.util.Optional;

public interface IDireccionService {
    public Direccion buscarPorId(Long id);
    public List<Direccion> buscarTodas();
    public Direccion guardar(Direccion direccion);
    public Direccion actualizar(Direccion direccion);
    public void borrarPorId(Long id);
    public List<Direccion> buscarPorLocalidad(String localidad);
    public List<Direccion> buscarPorProvincia(String provincia);
    public void editarCalle(Long id,String calle);
    public void editarAltura(Long id, Integer altura);
    public void editarDepartamento(Long id, String departamento);
    public void editarLocalidad(Long id, Long localidadId);

}
