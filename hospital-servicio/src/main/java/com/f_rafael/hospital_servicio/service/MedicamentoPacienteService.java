package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.MedicamentoPacienteDto;
import com.f_rafael.hospital_servicio.dto.PacienteDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.DatoIncorrectoException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.MedicamentoPacienteMapper;
import com.f_rafael.hospital_servicio.model.MedicamentoPaciente;
import com.f_rafael.hospital_servicio.repository.IMedicamentoClient;
import com.f_rafael.hospital_servicio.repository.IMedicamentoPacienteRepository;
import com.f_rafael.hospital_servicio.repository.IPacienteClient;
import com.f_rafael.hospital_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class MedicamentoPacienteService implements IMedicamentoPacienteService{
    private MedicamentoPacienteMapper mapper;
    private IMedicamentoPacienteRepository repository;
    private Verificador verificador;
    private IPacienteClient pacienteClient;
    private IMedicamentoClient medicamentoClient;
    @Override
    public MedicamentoPacienteDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento con medicamentoso no encontrado")));
    }

    @Override
    public List<MedicamentoPacienteDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public MedicamentoPacienteDto guardar(MedicamentoPaciente medicamentoPaciente) {

        if(medicamentoPaciente.getMedicamentoId() == null || medicamentoPaciente.getPacienteId() == null || medicamentoPaciente.getInicio() == null || medicamentoPaciente.getDosisId() == null){
            throw new CampoNuloException("Algunos campois de tratamiento medicamentoso no pueden ser nulos");
        }
        return mapper.obtenerDto(repository.save(medicamentoPaciente));
    }

    @Override
    public MedicamentoPacienteDto actualizar(MedicamentoPaciente medicamentoPaciente) {
        if(medicamentoPaciente.getDosisId() == null){
            throw new CampoNuloException("El id durante una actualización no puede ser nulo");
        }

        return this.guardar(medicamentoPaciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Tratamiento medicamentoso no encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public List<MedicamentoPacienteDto> buscarPorPaciente(Long idODni, String opcion) {
        List<MedicamentoPacienteDto> listaParaRetornar = new LinkedList<>();
        List<MedicamentoPaciente> informacionTratamientos;
        PacienteDto paciente;

        if(!verificador.esIdODni(opcion)) {
            System.gc();
            throw new DatoIncorrectoException("Las opciones pueden ser id o dni");
        }

        if(idODni.equals("id")){
            listaParaRetornar = mapper.obtenerListaDto(repository.findByPacienteId(idODni));
            System.gc();
        }

        if(idODni.equals("dni")){
            informacionTratamientos = repository.findAll();
            paciente = pacienteClient.buscarPorDni(idODni);

            for(MedicamentoPaciente mp : informacionTratamientos){
                if(mp.getPacienteId().equals(paciente.getId())){
                    listaParaRetornar.add(mapper.obtenerDto(mp));
                }
            }

        }

        return listaParaRetornar;
    }

    @Override
    public List<MedicamentoPacienteDto> buscarPorPrincipioActivo(String principioActivo) {
        List<MedicamentoPacienteDto> listaParaRetornar = new LinkedList<>();
        List<MedicamentoPaciente> informacionTratamientos = repository.findAll();

        for(MedicamentoPaciente mp : informacionTratamientos){
            if(medicamentoClient.buscarPorId(mp.getMedicamentoId()).getPrincipioActivo().equals(principioActivo)){
                listaParaRetornar.add(mapper.obtenerDto(mp));
            }
        }

        return listaParaRetornar;
    }

    @Override
    public List<MedicamentoPacienteDto> buscarPorFechaDeInicio(LocalDate desde, LocalDate hasta) {
        return mapper.obtenerListaDto(repository.buscarPorFechaDeInicio(desde,hasta));
    }

    @Override
    public List<MedicamentoPacienteDto> BuscarPorFechaDeFinal(LocalDate desde, LocalDate hasta) {
        return mapper.obtenerListaDto(repository.buscarPorFechaDeFinal(desde,hasta));
    }
}
