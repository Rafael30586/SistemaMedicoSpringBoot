package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.AccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;

import java.util.List;
import java.util.Optional;

public interface IAccionTerapeuticaService {
    public Optional<AccionTerapeutica> buscarPorId(Long id);
    public List<AccionTerapeutica> buscarTodas();
    public AccionTerapeutica guardar(AccionTerapeutica accionTerapeutica);
    public AccionTerapeutica actualizar(AccionTerapeutica accionTerapeutica);
    public void borrarPorId(Long id);
    public Optional<AccionTerapeutica> buscarPorNombre(String nombre);
    public List<AccionTerapeutica> buscarPorSecuenciaEnDescripcion(String secuencia);
}
