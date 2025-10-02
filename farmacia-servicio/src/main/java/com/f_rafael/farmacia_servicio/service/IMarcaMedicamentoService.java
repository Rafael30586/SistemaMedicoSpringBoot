package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.MarcaMedicamentoDto;
import com.f_rafael.farmacia_servicio.model.MarcaMedicamento;

import java.util.List;

public interface IMarcaMedicamentoService {
    public MarcaMedicamentoDto buscarPorId(Long id);
    public List<MarcaMedicamentoDto> buscarTodas();
    public MarcaMedicamentoDto guardar(MarcaMedicamento marca);
    public MarcaMedicamentoDto actualizar(MarcaMedicamento marca);
    public void borrarPorId(Long id);
    public MarcaMedicamentoDto buscarPorNombre(String nombre);
}
