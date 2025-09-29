package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.MarcaMedicamento;

import java.util.List;
import java.util.Optional;

public interface IMarcaMedicamentoService {
    public Optional<MarcaMedicamento> buscarPorId(Long id);
    public List<MarcaMedicamento> buscarTodas();
    public MarcaMedicamento guardar(MarcaMedicamento marca);
    public MarcaMedicamento actualizar(MarcaMedicamento marca);
    public void borrarPorId(Long id);
    public Optional<MarcaMedicamento> buscarPorNombre(String nombre);
}
