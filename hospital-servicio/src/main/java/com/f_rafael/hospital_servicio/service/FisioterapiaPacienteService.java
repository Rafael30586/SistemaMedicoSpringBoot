package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.FisioterapiaPacienteDto;
import com.f_rafael.hospital_servicio.dto.PacienteDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.DatoIncorrectoException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.FisioterapiaPacienteMapper;
import com.f_rafael.hospital_servicio.model.FisioterapiaPaciente;
import com.f_rafael.hospital_servicio.repository.IFisioterapiaPacienteRepository;
import com.f_rafael.hospital_servicio.repository.IPacienteClient;
import com.f_rafael.hospital_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class FisioterapiaPacienteService implements IFisioterapiaPacienteService{

    private IFisioterapiaPacienteRepository repository;
    private FisioterapiaPacienteMapper mapper;
    private Verificador verificador;
    private IPacienteClient pacienteClient;

    @Override
    public FisioterapiaPacienteDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Fisioterapia para paciente no encontrada")));
    }

    @Override
    public List<FisioterapiaPacienteDto> buscarTodas() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public FisioterapiaPacienteDto guardar(FisioterapiaPaciente fisioterapiaPaciente) {

        if(fisioterapiaPaciente.getPacienteId() == null || fisioterapiaPaciente.getInicio() == null){
            throw new CampoNuloException("Algunos campos de fisioterapia para paciente no pueden ser nulos");
        }
        return mapper.obtenerDto(repository.save(fisioterapiaPaciente));
    }

    @Override
    public FisioterapiaPacienteDto actualizar(FisioterapiaPaciente fisioterapiaPaciente) {

        if(fisioterapiaPaciente.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }
        return this.guardar(fisioterapiaPaciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("La fisioterapia para paciente solicitada no se encuntra");
        }

        repository.deleteById(id);
    }

    @Override
    public List<FisioterapiaPacienteDto> buscarPorPaciente(Long idODni, String opcion) {
        List<FisioterapiaPacienteDto> listaParaRetornar = new LinkedList<>();
        List<FisioterapiaPaciente> informacionTratamientos;
        PacienteDto informacionPaciente;

        if(!verificador.esIdODni(opcion)) throw new DatoIncorrectoException("Las opciones disponibles son id y dni");

        if(opcion.equals("id")){
            listaParaRetornar = mapper.obtenerListaDto(repository.findByPacienteId(idODni));
            System.gc();
        }

        if(opcion.equals("dni")){
            informacionTratamientos = repository.findAll();
            informacionPaciente = pacienteClient.buscarPorDni(idODni);

            for(FisioterapiaPaciente fp : informacionTratamientos){
                if(fp.getPacienteId().equals(informacionPaciente.getId())){
                    listaParaRetornar.add(mapper.obtenerDto(fp));
                }
            }
        }

        return listaParaRetornar;
    }

    @Override
    public List<FisioterapiaPacienteDto> buscarPorFechaDeInicio(LocalDate desde, LocalDate hasta) {
        return mapper.obtenerListaDto(repository.buscarPorFechaDeInicio(desde,hasta));
    }

    @Override
    public List<FisioterapiaPacienteDto> buscarPorFechaDeFinal(LocalDate desde, LocalDate hasta) {
        return mapper.obtenerListaDto(repository.buscarPorFechaDeFinal(desde,hasta));
    }

    @Override
    public FisioterapiaPacienteDto modificarPaciente(Long id, Long idODni, String opcion) {
        FisioterapiaPaciente tratamientoParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento no e ncontrado"));

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
    public FisioterapiaPacienteDto modificarFechaDeInicio(Long id, LocalDate inicio) {
        FisioterapiaPaciente tratamientoParaActualizar = devolverPorId(id);

        if(tratamientoParaActualizar.getFin() != null && tratamientoParaActualizar.getFin().isBefore(inicio)){
            throw new DatoIncorrectoException("La fecha de inicio debe ser anterior a la fecha de final");
        }

        tratamientoParaActualizar.setInicio(inicio);

        return this.actualizar(tratamientoParaActualizar);
    }

    @Override
    public FisioterapiaPacienteDto modificareFechaDeFinal(Long id, LocalDate fin) {
        FisioterapiaPaciente tratamientoParaActualizar = devolverPorId(id);

        if(tratamientoParaActualizar.getInicio().isAfter(fin)){
            throw new DatoIncorrectoException("La fecha de final no piuede ser anterior a la fecha de inicio");
        }

        tratamientoParaActualizar.setFin(fin);

        return this.actualizar(tratamientoParaActualizar);
    }

    public FisioterapiaPaciente devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento no encontrado"));
    }
}
