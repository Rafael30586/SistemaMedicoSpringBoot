package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.MarcaMedicamentoDto;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.MarcaMedicamento;

import java.util.List;
import java.util.Optional;

public interface IMarcaMedicamentoService {
    public Optional<MarcaMedicamento> buscarPorId(Long id);
    public MarcaMedicamentoDto buscarPorId2(Long id);
    public List<MarcaMedicamento> buscarTodas();
    public List<MarcaMedicamentoDto> buscarTodas2();
    public MarcaMedicamento guardar(MarcaMedicamento marca);
    public MarcaMedicamentoDto guardar2(MarcaMedicamento marca);
    public MarcaMedicamento actualizar(MarcaMedicamento marca);
    public MarcaMedicamentoDto actualizar2(MarcaMedicamento marca);
    public void borrarPorId(Long id);
    public void borrarPorId2(Long id);
    public Optional<MarcaMedicamento> buscarPorNombre(String nombre);
    public MarcaMedicamentoDto buscarPorNombre2(String nombre);
}
