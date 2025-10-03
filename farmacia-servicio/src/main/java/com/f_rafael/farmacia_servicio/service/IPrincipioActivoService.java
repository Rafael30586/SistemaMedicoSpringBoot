package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.PrincipioActivoDto;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;

import java.util.List;

public interface IPrincipioActivoService {
    public PrincipioActivoDto buscarPorId(Long id);
    public List<PrincipioActivoDto> buscarTodos();
    public PrincipioActivoDto guardar(PrincipioActivo principioActivo);
    public PrincipioActivoDto actualizar(PrincipioActivo principioActivo);
    public void borrarPorId(Long id);
    public List<PrincipioActivoDto> buscarPorAccionTerapeutica(String nombreAccionTerapeutica);
    public void agregarAccionTerapeutica(Long id, Long accionTerapeuticaId);
    public void quitarAccionTerapeutica(Long id, Long accionTerapeuticaId);
}
