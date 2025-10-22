package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.DiagnosticoDto;
import com.f_rafael.hospital_servicio.model.Diagnostico;

import java.util.List;

public interface IDiagnosticoService {

    public DiagnosticoDto buscarPorId(Long id);
    public List<DiagnosticoDto> buscarTodos();
    public DiagnosticoDto guardar(Diagnostico diagnostico);
    public DiagnosticoDto actualizar(Diagnostico diagnostico);
    public void borrarPorId(Long id);
}
