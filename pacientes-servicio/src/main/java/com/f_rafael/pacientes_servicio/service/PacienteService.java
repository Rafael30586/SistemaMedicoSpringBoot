package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.PacienteDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.DatoIncorrectoException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.repository.IDireccionClient;
import com.f_rafael.pacientes_servicio.repository.ILocalidadClient;
import com.f_rafael.pacientes_servicio.repository.INumeroTelefonicoClient;
import com.f_rafael.pacientes_servicio.repository.IPacienteRepository;
import com.f_rafael.pacientes_servicio.mapper.PacienteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class PacienteService implements IPacienteService{

    private IPacienteRepository repository;
    private PacienteMapper mapper;
    private INumeroTelefonicoClient numeroTelefonicoClient;
    private ILocalidadClient localidadClient;
    private IDireccionClient direccionClient;

    @Override
    public PacienteDto buscarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return mapper.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<PacienteDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public PacienteDto guardar(Paciente paciente) {

        if(paciente.getPrimerNombre() == null || paciente.getApellidoPaterno() == null || paciente.getFechaNacimiento() == null || paciente.getLugarNacimientoId() == null || paciente.getDni() == null){
            throw new CampoNuloException("Algunos campos no pueden ser nulos");
        }

        return mapper.obtenerDto(repository.save(paciente));
    }

    @Override
    public PacienteDto actualizar(Paciente paciente) {

        if (paciente.getId() == null) {
            throw new CampoNuloException("El id no puede ser nulo");
        }

        return this.guardar(paciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public PacienteDto buscarPorDni(Long dni) {
        return mapper.obtenerDto(repository.findByDni(dni).orElseThrow(() -> new EntidadNoEncontradaException("Entidad no encontrada")));
    }

    @Override
    public List<PacienteDto> buscarPorNombre(String nombre) {
        return mapper.obtenerListaDto(repository.buscarPorNombre(nombre));
    }

    @Override
    public List<PacienteDto> buscarPorApellido(String apellido) {
        return mapper.obtenerListaDto(repository.buscarPorApellido(apellido));
    }

    @Override
    public PacienteDto buscarPorEmail(String email) {
        return mapper.obtenerDto(repository.findByEmail(email).orElseThrow(()-> new EntidadNoEncontradaException("Entidad no encontrada")));
    }

    @Override
    public PacienteDto buscarPorNumeroTelefonico(String numero) {
        Long telefonoId = numeroTelefonicoClient.buscarPorNumero(numero).getId();
        PacienteDto dtoARetornar = buscarPorTelefonoId(telefonoId);

        return dtoARetornar;
    }

    @Override
    public List<PacienteDto> buscarPorIntervaloNacimiento(Integer desde, Integer hasta) {
        if(desde > hasta){
            throw new DatoIncorrectoException("El primer dato del intervalo debe ser menor que el segundo");
        }

        if(hasta > LocalDate.now().getYear() || desde < (LocalDate.now().getYear()-120)){
            throw new DatoIncorrectoException("Se ha superado el límite del año de nacimiento");
        }

        return mapper.obtenerListaDto(repository.buscarPorIntervaloNacimiento(desde,hasta));
    }

    @Override
    public List<PacienteDto> buscarPorLugarNacimiento(String localidad) {
        List<PacienteDto> listaARetornar = new LinkedList<>();
        List<Paciente> informacionPacientes = repository.findAll();

        for(Paciente p : informacionPacientes){
            if(localidadClient.obtenerInformacionDeLocalidad(p.getLugarNacimientoId()).getNombre().equals(localidad)){
                listaARetornar.add(mapper.obtenerDto(p));
            }
        }

        return listaARetornar;
    }

    @Override
    public List<PacienteDto> buscarPorDomicilio(String calle) {
        List<PacienteDto> listaARetornar = new LinkedList<>();
        List<Paciente> informacionPacientes = repository.findAll();

        for(Paciente p : informacionPacientes){
            if(direccionClient.obtenerInformacionDireccion(p.getDireccionId()).getCalle().equals(calle)){
                listaARetornar.add(mapper.obtenerDto(p));
            }
        }
        return listaARetornar;
    }

    private PacienteDto buscarPorTelefonoId(Long id){
        List<Paciente> pacientes = repository.findAll();
        PacienteDto dtoARetornar;
        Set<Long> telefonosId;

        for(Paciente p : pacientes){
            if(p.getTelefonosId() != null){
                telefonosId = p.getTelefonosId();

                for(Long tid : telefonosId){
                    if(tid.equals(id)){
                        dtoARetornar = mapper.obtenerDto(p);
                        return dtoARetornar;
                    }
                }
            }
        }

        throw new EntidadNoEncontradaException("El número telefónico no corresponde a ningún paciente");
    }
}
