package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;

import java.util.List;
import java.util.Optional;

public interface IPrincipioActivoService {
    public Optional<PrincipioActivo> buscarPorId(Long id);
    public List<PrincipioActivo> buscarTodas();
    public PrincipioActivo guardar(PrincipioActivo principioActivo);
    public PrincipioActivo actualizar(PrincipioActivo principioActivo);
    public void borrarPorId(Long id);
}
