package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.model.ObraSocial;

import java.util.List;

public interface IObraSocialService {
    public ObraSocial buscarPorId(Long id);
    public List<ObraSocial> buscarTodas();
    public ObraSocial buscarPorNombre(String nombre);
    public ObraSocial guardar(ObraSocial obraSocial);
    public ObraSocial actualizar(ObraSocial obraSocial);
    public void borrarPorId(Long id);
}
