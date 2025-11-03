package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.RadioTerapiaPacienteDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.DatoIncorrectoException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.RadioterapiaPacienteMapper;
import com.f_rafael.hospital_servicio.model.RadioterapiaPaciente;
import com.f_rafael.hospital_servicio.repository.IPacienteClient;
import com.f_rafael.hospital_servicio.repository.IRadioterapiaPacienteRepository;
import com.f_rafael.hospital_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class RadioterapiaPacienteService implements IRadioterapiaPacienteService {

    private IRadioterapiaPacienteRepository repository;
    private RadioterapiaPacienteMapper mapper;
    private Verificador verificador;
    private IPacienteClient pacienteClient;

    @Override
    public RadioTerapiaPacienteDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento por radio terapia no encontrado")));
    }

    @Override
    public List<RadioTerapiaPacienteDto> buscarTodas() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public RadioTerapiaPacienteDto guardar(RadioterapiaPaciente radioTerapiaPaciente) {

        if(radioTerapiaPaciente.getPacienteId() == null || radioTerapiaPaciente.getInicio() == null){
            throw new CampoNuloException("Algunos campos de tratamiento por radioterapia no pueden ser nulos");
        }
        return mapper.obtenerDto(repository.save(radioTerapiaPaciente));
    }

    @Override
    public RadioTerapiaPacienteDto actualizar(RadioterapiaPaciente radioTerapiaPaciente) {

        if(radioTerapiaPaciente.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo duarnte una actualización");
        }

        return this.guardar(radioTerapiaPaciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("El tratamiento por radio terapia no ha sido encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public List<RadioTerapiaPacienteDto> buscarPorPaciente(Long idODni, String opcion) {
        List<RadioTerapiaPacienteDto> listaParaRetornar = new LinkedList<>();
        List<RadioterapiaPaciente> informacionTratamientos;

        if(!verificador.esIdODni(opcion)){
            System.gc();
            throw new DatoIncorrectoException("Las opciones disponibles son id y dni");
        }

        if(opcion.equals("id")){
            listaParaRetornar = mapper.obtenerListaDto(repository.findByPacienteId(idODni));
            System.gc();
        }

        if(opcion.equals("dni")){
            informacionTratamientos = repository.findAll();

            for(RadioterapiaPaciente rp : informacionTratamientos){
                if(rp.getPacienteId().equals(pacienteClient.buscarPorDni(idODni).getId())){
                    listaParaRetornar.add(mapper.obtenerDto(rp));
                }
            }
        }
        return listaParaRetornar;
    }

    @Override
    public List<RadioTerapiaPacienteDto> buscarPorFechaInicio(LocalDate desde, LocalDate hasta) {
        return mapper.obtenerListaDto(repository.buscarPorFechaDeInicio(desde,hasta));
    }

    @Override
    public List<RadioTerapiaPacienteDto> buscarPorFechaFinal(LocalDate desde, LocalDate hasta) {
        return mapper.obtenerListaDto(repository.buscarPorFechaDeFinal(desde,hasta));
    }
}
