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
    public PrincipioActivoDto buscarPorNombre(String nombre);
    public List<PrincipioActivoDto> buscarPorAccionTerapeutica(String nombreAccionTerapeutica);
    public PrincipioActivoDto modificarNombre(Long id, String nombre);
    public PrincipioActivoDto agregarAccionTerapeutica(Long id, Long accionTerapeuticaId);
    public PrincipioActivoDto quitarAccionTerapeutica(Long id, Long accionTerapeuticaId);
}
