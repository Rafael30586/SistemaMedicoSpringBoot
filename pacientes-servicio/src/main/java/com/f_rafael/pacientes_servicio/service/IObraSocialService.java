package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.ObraSocialDto;
import com.f_rafael.pacientes_servicio.model.ObraSocial;


import java.util.List;

public interface IObraSocialService {
    public ObraSocialDto buscarPorId(Long id);
    public List<ObraSocialDto> buscarTodas();
    public ObraSocialDto buscarPorNombre(String nombre);
    public ObraSocialDto guardar(ObraSocial obraSocial);
    public ObraSocialDto actualizar(ObraSocial obraSocial);
    public void borrarPorId(Long id);
}
