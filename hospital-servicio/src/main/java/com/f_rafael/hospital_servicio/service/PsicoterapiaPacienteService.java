package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.PacienteDto;
import com.f_rafael.hospital_servicio.dto.PsicoterapiaPacienteDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.DatoIncorrectoException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.PsicoterapiaPacienteMapper;
import com.f_rafael.hospital_servicio.model.PsicoterapiaPaciente;
import com.f_rafael.hospital_servicio.repository.IPacienteClient;
import com.f_rafael.hospital_servicio.repository.IPsicoterapiaPacienteRepository;
import com.f_rafael.hospital_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class PsicoterapiaPacienteService implements IPsicoterapiaPacienteService{

    private PsicoterapiaPacienteMapper mapper;
    private IPsicoterapiaPacienteRepository repository;
    private Verificador verificador;
    private IPacienteClient pacienteClient;
    @Override
    public PsicoterapiaPacienteDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("El tratamiento no se ha encontrado")));
    }

    @Override
    public List<PsicoterapiaPacienteDto> buscarTodas() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public PsicoterapiaPacienteDto guardar(PsicoterapiaPaciente psicoterapiaPaciente) {

        if(psicoterapiaPaciente.getPacienteId() == null || psicoterapiaPaciente.getInicio() == null){
            throw new CampoNuloException("Algunos campos de tratamiento por psicoterapia no pueden ser nulos");
        }

        return mapper.obtenerDto(repository.save(psicoterapiaPaciente));
    }

    @Override
    public PsicoterapiaPacienteDto actualizar(PsicoterapiaPaciente psicoterapiaPaciente) {

        if(psicoterapiaPaciente.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }

        return this.guardar(psicoterapiaPaciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Tratamiento por psicoterapia no encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public List<PsicoterapiaPacienteDto> buscarPorPaciente(Long idODni, String opcion) {
        List<PsicoterapiaPacienteDto> listaParaRetornar = new LinkedList<>();
        List<PsicoterapiaPaciente> informacionTratamientos;
        PacienteDto informacionPaciente;

        verificador.esIdODni(opcion);

        if(opcion.equals("id")){
            listaParaRetornar = mapper.obtenerListaDto(repository.findByPacienteId(idODni));
            System.gc();
        }

        if(opcion.equals("dni")){
            informacionTratamientos = repository.findAll();
            informacionPaciente = pacienteClient.buscarPorDni(idODni);

            for(PsicoterapiaPaciente pp : informacionTratamientos){
                if(pp.getPacienteId().equals(informacionPaciente.getId())){
                    listaParaRetornar.add(mapper.obtenerDto(pp));
                }
            }
        }

        return listaParaRetornar;
    }

    @Override
    public List<PsicoterapiaPacienteDto> buscarPorFechaDeInicio(LocalDate desde, LocalDate hasta) {
        return mapper.obtenerListaDto(repository.buscarPorFechaDeInicio(desde,hasta));
    }

    @Override
    public List<PsicoterapiaPacienteDto> buscarPorFechaDeFinal(LocalDate desde, LocalDate hasta) {
        return mapper.obtenerListaDto(repository.buscarPorFechaDeFinal(desde,hasta));
    }
}
