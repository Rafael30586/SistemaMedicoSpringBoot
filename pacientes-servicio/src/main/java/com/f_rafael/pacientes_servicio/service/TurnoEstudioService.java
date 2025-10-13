package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.TurnoEstudioDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.EstadoTurno;
import com.f_rafael.pacientes_servicio.model.TurnoEstudio;
import com.f_rafael.pacientes_servicio.repository.ITurnoEstudioRepository;
import com.f_rafael.pacientes_servicio.utils.TurnoEstudioMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TurnoEstudioService implements ITurnoEstudioService{

    private ITurnoEstudioRepository repository;
    private TurnoEstudioMapper mapper;
    @Override
    public TurnoEstudioDto buscarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return mapper.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<TurnoEstudioDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public TurnoEstudioDto guardar(TurnoEstudio turnoEstudio) {

        if(turnoEstudio.getFechaTurno() == null || turnoEstudio.getFechaSolicitud() == null || turnoEstudio.getInicio() == null || turnoEstudio.getEstado() == null || turnoEstudio.getPaciente() == null){
            throw new CampoNuloException("Algunos campos no pueden ser nulos");
        }

        return mapper.obtenerDto(repository.save(turnoEstudio));
    }

    @Override
    public TurnoEstudioDto actualizar(TurnoEstudio turnoEstudio) {

        if(turnoEstudio.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }
        return this.guardar(turnoEstudio);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public List<TurnoEstudioDto> buscarPorFechaTurno(LocalDate fechaTurno) {
        return mapper.obtenerListaDto(repository.buscarPorFechaTurno(fechaTurno));
    }

    @Override
    public List<TurnoEstudioDto> buscarPorEstado(EstadoTurno estado) {
        return mapper.obtenerListaDto(repository.buscarPorEstado(estado.toString()));
    }
}
