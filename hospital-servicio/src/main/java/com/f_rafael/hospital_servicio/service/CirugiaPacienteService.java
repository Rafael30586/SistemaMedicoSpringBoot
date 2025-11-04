package com.f_rafael.hospital_servicio.service;


import com.f_rafael.hospital_servicio.dto.CirugiaPacienteDto;
import com.f_rafael.hospital_servicio.dto.PacienteDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.DatoIncorrectoException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.CirugiaPacienteMapper;
import com.f_rafael.hospital_servicio.model.CirugiaPaciente;
import com.f_rafael.hospital_servicio.model.TratamientoQuirurgico;
import com.f_rafael.hospital_servicio.repository.ICirugiaPacienteRepository;
import com.f_rafael.hospital_servicio.repository.IPacienteClient;
import com.f_rafael.hospital_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class CirugiaPacienteService implements ICirugiaPacienteService{

    private CirugiaPacienteMapper mapper;
    private ICirugiaPacienteRepository repository;
    private Verificador verificador;
    private IPacienteClient pacienteClient;

    @Override
    public CirugiaPacienteDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento quirúrgico para paciente no encontrado"))); // Agregar excepción para lanzar
    }

    @Override
    public List<CirugiaPacienteDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public CirugiaPacienteDto guardar(CirugiaPaciente cirugiaPaciente) {
        return mapper.obtenerDto(repository.save(cirugiaPaciente));
    }

    @Override
    public CirugiaPacienteDto actualizar(CirugiaPaciente cirugiaPaciente) {

        if(cirugiaPaciente.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");

        }
        return this.guardar(cirugiaPaciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Tratamiento quirúrgico para paciente no encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public List<CirugiaPacienteDto> buscarPorPaciente(Long idODni, String opcion) {
        List<CirugiaPacienteDto> listaParaRetornar = new LinkedList<>();
        List<CirugiaPaciente> informacionTratamientos;
        PacienteDto informacionPaciente;

        if(!verificador.esIdODni(opcion)) throw new DatoIncorrectoException("La opción debe ser id o dni");

        if(opcion.equals("id")){
            listaParaRetornar = mapper.obtenerListaDto(repository.findByPacienteId(idODni));
        }

        if(opcion.equals("dni")){
            informacionTratamientos = repository.findAll();
            informacionPaciente = pacienteClient.buscarPorDni(idODni);

            for(CirugiaPaciente cp : informacionTratamientos){
                if(cp.getPacienteId().equals(informacionPaciente.getId())){
                    listaParaRetornar.add(mapper.obtenerDto(cp));
                }
            }
        }
        return listaParaRetornar;
    }

    @Override
    public List<CirugiaPacienteDto> buscarPorCirugia(String cirugia) {
        return mapper.obtenerListaDto(repository.buscarPorCirugia(cirugia));
    }

    @Override
    public List<CirugiaPacienteDto> buscarPorPeriodo(LocalDate desde, LocalDate hasta) {
        return mapper.obtenerListaDto(repository.buscarPorPeriodo(desde,hasta));
    }

    @Override
    public CirugiaPacienteDto modificarPaciente(Long id, Long idODni, String opcion) {
        CirugiaPaciente tratamientoParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento no encontrado"));

        if(!verificador.esIdODni(opcion)){
            throw new DatoIncorrectoException("Las opciones disponibles son id y dni");
        }

        if(opcion.equals("id")){
            tratamientoParaActualizar.setPacienteId(idODni);
        }

        if(opcion.equals("dni")){
            tratamientoParaActualizar.setPacienteId(pacienteClient.buscarPorDni(idODni).getId());
        }

        return this.actualizar(tratamientoParaActualizar);
    }

    @Override
    public CirugiaPacienteDto modificarCirugia(Long id, Long cirugiaId) {
        CirugiaPaciente tratamientoParaEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento no encontrado"));
        TratamientoQuirurgico cirugiaParaAsignar = new TratamientoQuirurgico();
        cirugiaParaAsignar.setId(cirugiaId);

        tratamientoParaEditar.setCirugia(cirugiaParaAsignar);

        return this.actualizar(tratamientoParaEditar);
    }

    @Override
    public CirugiaPacienteDto modificarFecha(Long id, LocalDate fecha) {
        CirugiaPaciente tratamientoParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento no encontrado"));
        tratamientoParaActualizar.setFecha(fecha);

        return this.actualizar(tratamientoParaActualizar);
    }

    @Override
    public CirugiaPacienteDto modificarHoraInicio(Long id, LocalTime inicio) {
        CirugiaPaciente tratamientoParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento no encontrado"));
        tratamientoParaActualizar.setInicio(inicio);

        return this.actualizar(tratamientoParaActualizar);
    }

    @Override
    public CirugiaPacienteDto modificarHoraFinal(Long id, LocalTime fin) {
        CirugiaPaciente tratamientoParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento no encontrado"));
        tratamientoParaActualizar.setFin(fin);
        
        return this.actualizar(tratamientoParaActualizar);
    }
}
