package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.model.EstudioMedicoClasificacion;

import java.util.List;

public interface IEstudioMedicoClasificacionService {
    public EstudioMedicoClasificacion buscarPorId(Long id);
    public List<EstudioMedicoClasificacion> buscarTodas();
    public EstudioMedicoClasificacion guardar(EstudioMedicoClasificacion clasificacion);
    public EstudioMedicoClasificacion actualizar(EstudioMedicoClasificacion clasificacion);
    public void borrarPorId(Long id);
    public EstudioMedicoClasificacion buscarPorNombre(String nombre);
    public EstudioMedicoClasificacion modificarNombre(Long id, String nombre);
}
