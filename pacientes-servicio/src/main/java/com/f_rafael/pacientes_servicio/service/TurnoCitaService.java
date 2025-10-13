package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.TurnoCitaDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.EstadoTurno;
import com.f_rafael.pacientes_servicio.model.TurnoCita;
import com.f_rafael.pacientes_servicio.repository.ITurnoCitaRepository;
import com.f_rafael.pacientes_servicio.utils.TurnoCitaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TurnoCitaService implements ITurnoCitaService{

    private ITurnoCitaRepository repository;
    private TurnoCitaMapper mapper;
    @Override
    public TurnoCitaDto buscarPorId(Long id) {
        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return mapper.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<TurnoCitaDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public TurnoCitaDto guardar(TurnoCita turnoCita) {
        if(turnoCita.getPaciente() == null || turnoCita.getFechaSolicitud() == null || turnoCita.getFechaTurno() == null || turnoCita.getInicio() == null || turnoCita.getEstado() == null){
            throw new CampoNuloException("Algunos campos no pueden ser nulos");
        }
        return mapper.obtenerDto(repository.save(turnoCita));
    }

    @Override
    public TurnoCitaDto actualizar(TurnoCita turnoCita) {

        if(turnoCita.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }
        return this.guardar(turnoCita);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public List<TurnoCitaDto> buscarPorPaciente(Long dni) {
        return mapper.obtenerListaDto(repository.buscarPorPaciente(dni));
    }

    @Override
    public List<TurnoCitaDto> buscarPorFechaTurno(LocalDate fechaTurno) {
        return mapper.obtenerListaDto(repository.buscarPorFechaTurno(fechaTurno));
    }

    @Override
    public List<TurnoCitaDto> buscarPorEstado(EstadoTurno estado) {
        return mapper.obtenerListaDto(repository.buscarPorEstado(estado.toString()));
    }

    @Override
    public List<TurnoCitaDto> buscarPorProfesional(Long id) {
        return mapper.obtenerListaDto(repository.findByProfesionalId(id));
    }
}
