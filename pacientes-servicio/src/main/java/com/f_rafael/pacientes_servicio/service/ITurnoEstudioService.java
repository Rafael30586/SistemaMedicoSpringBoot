package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.TurnoEstudioDto;
import com.f_rafael.pacientes_servicio.model.EstadoTurno;
import com.f_rafael.pacientes_servicio.model.TurnoEstudio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ITurnoEstudioService {
    public TurnoEstudioDto buscarPorId(Long id);
    public List<TurnoEstudioDto> buscarTodos();
    public TurnoEstudioDto guardar(TurnoEstudio turnoEstudio);
    public TurnoEstudioDto actualizar(TurnoEstudio turnoEstudio);
    public void borrarPorId(Long id);
    public List<TurnoEstudioDto> buscarPorPaciente(Long dni);
    public List<TurnoEstudioDto> buscarPorFechaTurno(LocalDate fechaTurno);
    public List<TurnoEstudioDto> buscarPorEstado(String estado);
    public List<TurnoEstudioDto> buscarPorEstudioId(Long id);
    public TurnoEstudioDto actualizarPaciente(Long id, Long idODniPaciente, String opcion);
    public TurnoEstudioDto actualizarFechaSolicitud(Long id, LocalDate fechaSolicitud);
    public TurnoEstudioDto actualizarFechaTurno(Long id, LocalDate fechaTurno);
    public TurnoEstudioDto actualizarHorario(Long id, LocalTime inicio, LocalTime fin);
    public TurnoEstudioDto actualizarEstado(Long id, String estado);
    public TurnoEstudioDto actualizarCobertura(Long id, String cobertura);
    public TurnoEstudioDto actualizarEstudio(Long id, Long estudioId);
}
