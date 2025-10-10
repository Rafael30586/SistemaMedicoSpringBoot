package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.TurnoEstudioDto;
import com.f_rafael.pacientes_servicio.model.TurnoEstudio;

import java.util.List;

public interface ITurnoEstudioService {
    public TurnoEstudioDto buscarPorId(Long id);
    public List<TurnoEstudioDto> buscarTodos();
    public TurnoEstudioDto guardar(TurnoEstudio turnoEstudio);
    public TurnoEstudioDto actualizar(TurnoEstudio turnoEstudio);
    public void borrarPorId(Long id);
}
