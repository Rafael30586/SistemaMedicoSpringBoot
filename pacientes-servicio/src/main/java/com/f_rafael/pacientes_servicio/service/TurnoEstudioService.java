package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.TurnoEstudioDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.DatoIncorrectoException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.Cobertura;
import com.f_rafael.pacientes_servicio.model.EstadoTurno;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.model.TurnoEstudio;
import com.f_rafael.pacientes_servicio.repository.IHospitalClient;
import com.f_rafael.pacientes_servicio.repository.IPacienteRepository;
import com.f_rafael.pacientes_servicio.repository.ITurnoEstudioRepository;
import com.f_rafael.pacientes_servicio.mapper.TurnoEstudioMapper;
import com.f_rafael.pacientes_servicio.utils.Verificador;
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
    private Verificador verificador;
    private IHospitalClient hospitalClient;

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
        LocalDate fechaSolicitud = turnoEstudio.getFechaSolicitud();
        LocalDate fechaTurno = turnoEstudio.getFechaTurno();
        LocalTime inicio = turnoEstudio.getInicio();
        LocalTime fin = turnoEstudio.getFin();
        Paciente paciente = turnoEstudio.getPaciente();
        Long estudioId = turnoEstudio.getEstudioId();

        if(fechaTurno == null || fechaSolicitud == null || inicio == null || turnoEstudio.getEstado() == null || paciente == null || estudioId == null || turnoEstudio.getCobertura() == null){
            throw new CampoNuloException("Algunos campos no pueden ser nulos");
        }

        verificador.esAnterior(fechaSolicitud, fechaTurno);

        if(fin != null){
            verificador.esAnterior(inicio, fin);
        }

        if(!pacienteRepository.existsById(paciente.getId())){
            throw new DatoIncorrectoException("El id no corresponde a ningún paciente de la base de datos");
        }

        hospitalClient.obtenerEstudioPorId(estudioId);

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
            if(te.getPaciente().getDni().equals(dni)){
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
    public List<TurnoEstudioDto> buscarPorPeriodo(LocalDate desde, LocalDate hasta) {
        return mapper.obtenerListaDto(repository.buscarPorPeriodo(desde,hasta));
    }

    @Override
    public List<TurnoEstudioDto> buscarPorEstado(String estado) {
        EstadoTurno[] estadosTurno = EstadoTurno.values();
        String estadoEnMayusculas = estado.toUpperCase();
        EstadoTurno estadoTurno = EstadoTurno.EN_PROCESO;

        for(EstadoTurno et : estadosTurno){
            if(et.toString().equals(estadoEnMayusculas)) estadoTurno = et;
        }

        return mapper.obtenerListaDto(repository.buscarPorEstado(estadoTurno));
    }

    @Override
    public List<TurnoEstudioDto> buscarPorEstudioId(Long estudioId) {
        return mapper.obtenerListaDto(repository.findByEstudioId(estudioId));
    }

    @Override
    public TurnoEstudioDto actualizarPaciente(Long id, Long idODniPaciente, String opcion) {
        TurnoEstudio turnoParaEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no encontrado"));
        Paciente pacienteParaAsignar = new Paciente();

        if(!verificador.idODni(opcion)){
            throw new DatoIncorrectoException("La opción tiene que ser id o dni");
        }

        if(opcion.equals("id")){
            pacienteParaAsignar = pacienteRepository.findById(idODniPaciente).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        if(opcion.equals("dni")){
            pacienteParaAsignar = pacienteRepository.findByDni(idODniPaciente).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no enconmtrado"));
        }

        turnoParaEditar.setPaciente(pacienteParaAsignar);

        return this.actualizar(turnoParaEditar);
    }

    @Override
    public TurnoEstudioDto actualizarFechaSolicitud(Long id, LocalDate fechaSolicitud) {
        TurnoEstudio turnoParaEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no encontrado"));

        verificador.esAnterior(fechaSolicitud,turnoParaEditar.getFechaTurno());

        turnoParaEditar.setFechaSolicitud(fechaSolicitud);

        return this.actualizar(turnoParaEditar);
    }

    @Override
    public TurnoEstudioDto actualizarFechaTurno(Long id, LocalDate fechaTurno) {
        TurnoEstudio turnoParaEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no encontrado"));

        turnoParaEditar.setFechaTurno(fechaTurno);

        return this.actualizar(turnoParaEditar);

    }

    @Override
    public TurnoEstudioDto actualizarHorario(Long id, LocalTime inicio, LocalTime fin) {
        TurnoEstudio turnoParaEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no encontrado"));

        if(fin.isBefore(inicio)){
            throw new DatoIncorrectoException("El horario de fin debe ser posterior al horario de inicio");
        }

        turnoParaEditar.setInicio(inicio);
        turnoParaEditar.setFin(fin);

        return this.actualizar(turnoParaEditar);
    }

    @Override
    public TurnoEstudioDto actualizarEstado(Long id, String estado) {
        TurnoEstudio turnoParaEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no encontrado"));
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

        return this.actualizar(turnoParaEditar);
    }

    @Override
    public TurnoEstudioDto actualizarCobertura(Long id, String cobertura) {
        TurnoEstudio turnoParaEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no encontrado"));
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

        return this.actualizar(turnoParaEditar);
    }

    @Override
    public TurnoEstudioDto actualizarEstudio(Long id, Long estudioId) { // Realizar validación para saber si el estudio existe en el otro microservicio
        TurnoEstudio turnoParaEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no encontrado"));

        turnoParaEditar.setEstudioId(estudioId);

        return this.actualizar(turnoParaEditar);
    }
}
