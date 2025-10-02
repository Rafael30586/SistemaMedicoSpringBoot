package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.PrincipioActivoDto;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;

import java.util.List;
import java.util.Optional;

public interface IPrincipioActivoService {
    public Optional<PrincipioActivo> buscarPorId(Long id);
    public PrincipioActivoDto buscarPorId2(Long id);
    public List<PrincipioActivo> buscarTodos();
    public List<PrincipioActivoDto> buscarTodos2();
    public PrincipioActivo guardar(PrincipioActivo principioActivo);
    public PrincipioActivoDto guardar2(PrincipioActivo principioActivo);
    public PrincipioActivo actualizar(PrincipioActivo principioActivo);
    public PrincipioActivoDto actualizar2(PrincipioActivo principioActivo);
    public void borrarPorId(Long id);
    public void borrarPorId2(Long id);
    public List<PrincipioActivo> buscarPorAccionTerapeutica(String nombreAccionTerapeutica);
    public List<PrincipioActivoDto> buscarPorAccionTerapeutica2(String nombreAccionTerapeutica);
}
