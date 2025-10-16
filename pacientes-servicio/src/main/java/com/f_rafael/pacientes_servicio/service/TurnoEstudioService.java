package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.TurnoEstudioDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.DatoIncorrectoException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.Cobertura;
import com.f_rafael.pacientes_servicio.model.EstadoTurno;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.model.TurnoEstudio;
import com.f_rafael.pacientes_servicio.repository.IPacienteRepository;
import com.f_rafael.pacientes_servicio.repository.ITurnoEstudioRepository;
import com.f_rafael.pacientes_servicio.mapper.TurnoEstudioMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class TurnoEstudioService implements ITurnoEstudioService{

    private ITurnoEstudioRepository repository;
    private TurnoEstudioMapper mapper;
    private IPacienteRepository pacienteRepository;
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
    public List<TurnoEstudioDto> buscarPorPaciente(Long dni) {
        List<TurnoEstudioDto> listaARetornar = new LinkedList<>();
        List<TurnoEstudio> informacionTurnosEstudios = repository.findAll();

        for(TurnoEstudio te : informacionTurnosEstudios){
            if(te.getPaciente().getDni() == dni){
                listaARetornar.add(mapper.obtenerDto(te));
            }
        }
        return listaARetornar;
    }


    @Override
    public List<TurnoEstudioDto> buscarPorFechaTurno(LocalDate fechaTurno) {
        return mapper.obtenerListaDto(repository.buscarPorFechaTurno(fechaTurno));
    }

    @Override
    public List<TurnoEstudioDto> buscarPorEstado(String estado) {
        return mapper.obtenerListaDto(repository.buscarPorEstado(estado.toUpperCase()));
    }

    @Override
    public List<TurnoEstudioDto> buscarPorEstudioId(Long estudioId) {
        return mapper.obtenerListaDto(repository.findByEstudioId(estudioId));
    }

    @Override
    public TurnoEstudioDto actualizarPaciente(Long id, Long pacienteDni) {
        TurnoEstudio turnoParaEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no encontrado"));
        Paciente pacienteParaAsignar = pacienteRepository.findByDni(pacienteDni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no enconmtrado"));

        turnoParaEditar.setPaciente(pacienteParaAsignar);

        return this.guardar(turnoParaEditar);
    }

    @Override
    public TurnoEstudioDto actualizarFechaSolicitud(Long id, LocalDate fechaSolicitud) {
        TurnoEstudio turnoParaEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no wencontrado"));

        turnoParaEditar.setFechaSolicitud(fechaSolicitud);

        return this.guardar(turnoParaEditar);
    }

    @Override
    public TurnoEstudioDto actualizarFechaTurno(Long id, LocalDate fechaTurno) {
        TurnoEstudio turnoParaEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no wencontrado"));

        turnoParaEditar.setFechaTurno(fechaTurno);

        return this.guardar(turnoParaEditar);

    }

    @Override
    public TurnoEstudioDto actualizarHorario(Long id, LocalTime inicio, LocalTime fin) {
        TurnoEstudio turnoParaEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no wencontrado"));

        if(fin.isBefore(inicio)){
            throw new DatoIncorrectoException("El horario de fin debe ser posterior al horario de inicio");
        }

        turnoParaEditar.setInicio(inicio);
        turnoParaEditar.setFin(fin);

        return this.guardar(turnoParaEditar);
    }

    @Override
    public TurnoEstudioDto actualizarEstado(Long id, String estado) {
        TurnoEstudio turnoParaEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no wencontrado"));
        EstadoTurno[] estados = EstadoTurno.values();
        boolean estadoExiste = false;

        for(EstadoTurno et : estados){
            if(et.toString().equals(estado)){
                estadoExiste = true;
            }
        }

        if(estadoExiste){
            turnoParaEditar.setEstado(EstadoTurno.valueOf(estado.toUpperCase()));
        }

        return this.guardar(turnoParaEditar);
    }

    @Override
    public TurnoEstudioDto actualizarCobertura(Long id, String cobertura) {
        TurnoEstudio turnoParaEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no wencontrado"));
        Cobertura[] coberturas = Cobertura.values();
        boolean coberturaExiste = false;

        for(Cobertura c : coberturas){
            if(c.toString().equals(cobertura)){
                coberturaExiste = true;
            }
        }

        if(coberturaExiste){
            turnoParaEditar.setCobertura(Cobertura.valueOf(cobertura));
        }

        return this.guardar(turnoParaEditar);
    }

    @Override
    public TurnoEstudioDto actualizarEstudio(Long id, Long estudioId) { // Realizar validación para saber si el estudio existe en el otro microservicio
        TurnoEstudio turnoParaEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no wencontrado"));

        turnoParaEditar.setEstudioId(estudioId);

        return this.guardar(turnoParaEditar);
    }
}
