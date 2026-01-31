package com.f_rafael.hospital_servicio.service;


import com.f_rafael.hospital_servicio.dto.CirugiaPacienteDto;
import com.f_rafael.hospital_servicio.dto.PacienteDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.DatoIncorrectoException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.CirugiaPacienteMapper;
import com.f_rafael.hospital_servicio.mapper.StringMapper;
import com.f_rafael.hospital_servicio.model.CirugiaPaciente;
import com.f_rafael.hospital_servicio.model.TratamientoQuirurgico;
import com.f_rafael.hospital_servicio.repository.ICirugiaPacienteRepository;
import com.f_rafael.hospital_servicio.repository.IPacienteClient;
import com.f_rafael.hospital_servicio.repository.ITratamientoQuirurgicoRepository;
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
    private ITratamientoQuirurgicoRepository tratamientoQuirurgicoRepository;
    private StringMapper stringMapper;

    @Override
    public CirugiaPacienteDto buscarPorId(Long id) {
        return mapper.obtenerDto(devolverPorId(id)); // Agregar excepción para lanzar
    }

    @Override
    public List<CirugiaPacienteDto> buscarTodas() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public CirugiaPacienteDto guardar(CirugiaPaciente cirugiaPaciente) {
        TratamientoQuirurgico cirugia = cirugiaPaciente.getCirugia();

        if(cirugiaPaciente.getCirugia() == null || cirugiaPaciente.getPacienteId() == null || cirugiaPaciente.getFecha() == null || cirugiaPaciente.getInicio() == null){
            throw new DatoIncorrectoException("Algunos datos no pueden ser nulos");
        }

        pacienteClient.buscarPacientePorId(cirugiaPaciente.getPacienteId());

        if(cirugiaPaciente.getFin() != null){
            verificador.esAnterior(cirugiaPaciente.getInicio(), cirugiaPaciente.getFin());
        }

        tratamientoQuirurgicoRepository.findById(cirugia.getId()).orElseThrow(()-> new EntidadNoEncontradaException("Cirugía no encontrada"));

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

        verificador.esIdODni(opcion);

        if(opcion.equals("id")){
            listaParaRetornar = mapper.obtenerListaDto(repository.findByPacienteId(idODni));
        }

        if(opcion.equals("dni")){
            informacionTratamientos = repository.findAll();
            informacionPaciente = pacienteClient.buscarPacientePorDni(idODni);

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
        String cirugiaSinGuiones = stringMapper.quitarGuionesBajos(cirugia);
        return mapper.obtenerListaDto(repository.buscarPorCirugia(cirugiaSinGuiones));
    }

    @Override
    public List<CirugiaPacienteDto> buscarPorPeriodo(LocalDate desde, LocalDate hasta) {
        return mapper.obtenerListaDto(repository.buscarPorPeriodo(desde,hasta));
    }

    @Override
    public CirugiaPacienteDto modificarPaciente(Long id, Long idODni, String opcion) {
        CirugiaPaciente tratamientoParaActualizar = devolverPorId(id);

        verificador.esIdODni(opcion);

        if(opcion.equals("id")){
            tratamientoParaActualizar.setPacienteId(idODni);
        }

        if(opcion.equals("dni")){
            tratamientoParaActualizar.setPacienteId(pacienteClient.buscarPacientePorDni(idODni).getId());
        }

        return this.actualizar(tratamientoParaActualizar);
    }

    @Override
    public CirugiaPacienteDto modificarCirugia(Long id, Long cirugiaId) {
        CirugiaPaciente tratamientoParaEditar = devolverPorId(id);
        TratamientoQuirurgico cirugiaParaAsignar = new TratamientoQuirurgico();
        cirugiaParaAsignar.setId(cirugiaId);

        tratamientoParaEditar.setCirugia(cirugiaParaAsignar);

        return this.actualizar(tratamientoParaEditar);
    }

    @Override
    public CirugiaPacienteDto modificarFecha(Long id, LocalDate fecha) {
        CirugiaPaciente tratamientoParaActualizar = devolverPorId(id);
        tratamientoParaActualizar.setFecha(fecha);

        return this.actualizar(tratamientoParaActualizar);
    }

    @Override
    public CirugiaPacienteDto modificarHoraInicio(Long id, LocalTime inicio) {
        CirugiaPaciente tratamientoParaActualizar = devolverPorId(id);
        verificador.esAnterior(inicio, tratamientoParaActualizar.getFin());
        tratamientoParaActualizar.setInicio(inicio);

        return this.actualizar(tratamientoParaActualizar);
    }

    @Override
    public CirugiaPacienteDto modificarHoraFinal(Long id, LocalTime fin) {
        CirugiaPaciente tratamientoParaActualizar = devolverPorId(id);
        verificador.esAnterior(tratamientoParaActualizar.getInicio(), fin);
        tratamientoParaActualizar.setFin(fin);

        return this.actualizar(tratamientoParaActualizar);
    }

    public CirugiaPaciente devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento no encontrado"));
    }
}
