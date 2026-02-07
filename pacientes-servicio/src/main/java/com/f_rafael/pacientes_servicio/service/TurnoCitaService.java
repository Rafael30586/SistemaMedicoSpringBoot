package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.TurnoCitaDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.DatoIncorrectoException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.Cobertura;
import com.f_rafael.pacientes_servicio.model.EstadoTurno;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.model.TurnoCita;
import com.f_rafael.pacientes_servicio.repository.IHospitalClient;
import com.f_rafael.pacientes_servicio.repository.IPacienteRepository;
import com.f_rafael.pacientes_servicio.repository.ITurnoCitaRepository;
import com.f_rafael.pacientes_servicio.mapper.TurnoCitaMapper;
import com.f_rafael.pacientes_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TurnoCitaService implements ITurnoCitaService{

    private ITurnoCitaRepository repository;
    private TurnoCitaMapper mapper;
    private IPacienteRepository pacienteRepository;
    private Verificador verificador;
    private IHospitalClient hospitalClient;
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
        Paciente paciente = turnoCita.getPaciente();
        Long profesionalId = turnoCita.getProfesionalId();
        LocalDate fechaSolicitud = turnoCita.getFechaSolicitud();
        LocalDate fechaTurno = turnoCita.getFechaTurno();
        LocalTime inicio = turnoCita.getInicio();
        LocalTime fin = turnoCita.getFin();

        if(paciente == null || fechaSolicitud == null || fechaTurno == null || inicio == null || turnoCita.getEstado() == null || profesionalId == null){
            throw new CampoNuloException("Algunos campos no pueden ser nulos");
        }

        if(!pacienteRepository.existsById(paciente.getId())){
            throw new DatoIncorrectoException("El id no corresponde a ningún paciente de la base de datos.");
        }

        verificador.esAnterior(fechaSolicitud,fechaTurno);

        if(fin != null){
            verificador.esAnterior(inicio,fin);
        }

        hospitalClient.obtenerMedicoPorId(profesionalId);
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
    public List<TurnoCitaDto> buscarPorPeriodo(LocalDate desde, LocalDate hasta) {
        return mapper.obtenerListaDto(repository.buscarPorPeriodo(desde,hasta));
    }

    @Override
    public List<TurnoCitaDto> buscarPorEstado(String estado) {
        EstadoTurno[] estados = EstadoTurno.values();
        EstadoTurno estadoParaBuscar;
        boolean existe = false;

        for(EstadoTurno et : estados){
            if(et.toString().equals(estado)){
                estadoParaBuscar = et;
                existe = true;
                return mapper.obtenerListaDto(repository.buscarPorEstado(estadoParaBuscar));
            }
        }

        if(!existe) throw new DatoIncorrectoException("El estado con corresponde a ninguno de la base de datos");

        return List.of(new TurnoCitaDto());
    }

    @Override
    public List<TurnoCitaDto> buscarPorProfesional(Long id) {
        return mapper.obtenerListaDto(repository.findByProfesionalId(id));
    }

    @Override
    public TurnoCitaDto actualizarPaciente(Long id, Long idODniPaciente, String opcion) {
        TurnoCita turnoParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no encontrado"));
        Paciente pacienteParaAsignar = new Paciente();

        if(!verificador.idODni(opcion)){
            throw new DatoIncorrectoException("La opción debe ser id o dni");
        }

        if(opcion.equals("id")){
            pacienteParaAsignar = pacienteRepository.findById(idODniPaciente).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        if(opcion.equals("dni")){
            pacienteParaAsignar = pacienteRepository.findByDni(idODniPaciente).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        turnoParaActualizar.setPaciente(pacienteParaAsignar);

        return this.actualizar(turnoParaActualizar);
    }

    @Override
    public TurnoCitaDto actualizarFechaSolicitud(Long id, LocalDate fechaSolicitud) {
        TurnoCita turnoParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no encontrado"));

        verificador.esAnterior(fechaSolicitud,turnoParaActualizar.getFechaTurno());

        turnoParaActualizar.setFechaSolicitud(fechaSolicitud);

        return this.actualizar(turnoParaActualizar);
    }

    @Override
    public TurnoCitaDto actualizarHorario(Long id, LocalTime inicio, LocalTime fin) {
        TurnoCita turnoParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no encontrado"));

        if(inicio.isAfter(fin)){
            throw new DatoIncorrectoException("El horario de inicio debe ser anterior al horario de final");
        }

        verificador.esAnterior(inicio,fin);

        turnoParaActualizar.setInicio(inicio);
        turnoParaActualizar.setFin(fin);

        return this.actualizar(turnoParaActualizar);
    }

    @Override
    public TurnoCitaDto actualizarEstado(Long id, String estado) {
        TurnoCita turnoParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no encontrado"));
        boolean estadoExiste = false;
        EstadoTurno[] estados = EstadoTurno.values();
        String estadoEnMayusculas = estado.toUpperCase();

        for(EstadoTurno et : estados){
            if(et.toString().equals(estadoEnMayusculas)) estadoExiste = true;
        }

        if(!estadoExiste){
            throw new DatoIncorrectoException("El estado del turno es incorrecto");
        }

        EstadoTurno estadoParaAsignar = EstadoTurno.valueOf(estado.toUpperCase());
        turnoParaActualizar.setEstado(estadoParaAsignar);

        return this.actualizar(turnoParaActualizar);
    }

    @Override
    public TurnoCitaDto actualizarCobertura(Long id, String cobertura) {
        TurnoCita turnoParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Turno no encontrado"));
        boolean coberturaExiste = false;
        Cobertura[] coberturas = Cobertura.values();
        String coberturaEnMayusculas = cobertura.toUpperCase();

        for(Cobertura c : coberturas){
            if(c.toString().equals(coberturaEnMayusculas)) coberturaExiste = true;
        }

        if(!coberturaExiste){
            throw new DatoIncorrectoException("La cobertura es incorrecta");
        }

        Cobertura coberturaParaAsignar = Cobertura.valueOf(cobertura.toUpperCase());
        turnoParaActualizar.setCobertura(coberturaParaAsignar);

        return this.actualizar(turnoParaActualizar);
    }
}
