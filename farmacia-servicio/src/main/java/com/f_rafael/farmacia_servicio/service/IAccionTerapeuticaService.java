package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.AccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;

import java.util.List;
import java.util.Optional;

public interface IAccionTerapeuticaService {
    public AccionTerapeuticaDto buscarPorId(Long id);
    public List<AccionTerapeuticaDto> buscarTodas();
    public AccionTerapeuticaDto guardar2(AccionTerapeutica accionTerapeutica);
    public AccionTerapeuticaDto actualizar2(AccionTerapeutica accionTerapeutica);
    public void borrarPorId2(Long id);
    public AccionTerapeuticaDto buscarPorNombre2(String nombre);
    public List<AccionTerapeuticaDto> buscarPorSecuenciaEnDescripcion2(String secuencia);
    public void modificarNombre(Long id, String nombre);
}
