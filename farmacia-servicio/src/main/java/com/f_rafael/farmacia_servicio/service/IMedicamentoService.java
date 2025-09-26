package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.Medicamento;

import java.util.List;
import java.util.Optional;

public interface IMedicamentoService {
    public Optional<Medicamento> buscarPorId(Long id);
    public List<Medicamento> buscarTodas();
    public Medicamento guardar(Medicamento medicamento);
    public Medicamento actualizar(Medicamento medicamento);
    public void borrarPorId(Long id);
}
