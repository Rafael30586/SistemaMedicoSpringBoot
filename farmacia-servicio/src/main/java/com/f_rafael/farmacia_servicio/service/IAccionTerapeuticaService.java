package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.AccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.dto.DescripcionDto;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;

import java.util.List;


public interface IAccionTerapeuticaService {
    public AccionTerapeuticaDto buscarPorId(Long id);
    public List<AccionTerapeuticaDto> buscarTodas();
    public AccionTerapeuticaDto guardar(AccionTerapeutica accionTerapeutica);
    public AccionTerapeuticaDto actualizar(AccionTerapeutica accionTerapeutica);
    public void borrarPorId(Long id);
    public AccionTerapeuticaDto buscarPorNombre(String nombre);
    public List<AccionTerapeuticaDto> buscarPorSecuenciaEnDescripcion(String secuencia);
    public AccionTerapeuticaDto modificarNombre(Long id, String nombre);
    public AccionTerapeuticaDto modificarDescripcion(Long id, DescripcionDto descripcion);
}
