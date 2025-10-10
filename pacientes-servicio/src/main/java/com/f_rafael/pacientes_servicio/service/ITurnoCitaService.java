package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.TurnoCitaDto;
import com.f_rafael.pacientes_servicio.model.TurnoCita;

import java.util.List;

public interface ITurnoCitaService {
    public TurnoCitaDto buscarPorId(Long id);
    public List<TurnoCitaDto> buscarTodos();
    public TurnoCitaDto guardar(TurnoCita turnoCita);
    public TurnoCitaDto actualizar(TurnoCita turnoCita);
    public void borrarPorId(Long id);
}
