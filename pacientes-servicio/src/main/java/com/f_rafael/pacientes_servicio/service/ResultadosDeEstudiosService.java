package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.ResultadoDeEstudiosDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.DatoIncorrectoException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.model.ResultadosDeEstudios;
import com.f_rafael.pacientes_servicio.repository.IEstudioClient;
import com.f_rafael.pacientes_servicio.repository.IPacienteRepository;
import com.f_rafael.pacientes_servicio.repository.IResultadoDeEstudiosRepository;
import com.f_rafael.pacientes_servicio.mapper.ResultadosDeEstudiosMapper;
import com.f_rafael.pacientes_servicio.utils.VerificadorOpciones;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ResultadosDeEstudiosService implements IResultadosDeEstudiosService{

    private IResultadoDeEstudiosRepository repository;
    private ResultadosDeEstudiosMapper mapper;
    private IEstudioClient estudioClient;
    private IPacienteRepository pacienteRepository;
    private VerificadorOpciones verificador;


    @Override
    public ResultadoDeEstudiosDto buscarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return mapper.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<ResultadoDeEstudiosDto> buscartodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public ResultadoDeEstudiosDto guardar(ResultadosDeEstudios resultadosDeEstudios) {

        if(resultadosDeEstudios.getPaciente() == null || resultadosDeEstudios.getEstudios() == null || resultadosDeEstudios.getUrlInforme() == null){
            throw new CampoNuloException("Hay campos que no pueden ser nulos");
        } // Averiguar como hacer con el tema de los estudiso ya que puede que no existan en el otro microservicio

        return mapper.obtenerDto(repository.save(resultadosDeEstudios));
    }

    @Override
    public ResultadoDeEstudiosDto actualizar(ResultadosDeEstudios resultadosDeEstudios) {
        if(resultadosDeEstudios.getNumero() == null){
            throw new CampoNuloException("El número de estudio no puede ser nulo");
        }
        return this.guardar(resultadosDeEstudios);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public List<ResultadoDeEstudiosDto> buscarPorPaciente(Long dni) {
        List<ResultadosDeEstudios> informacionResultadosDeEstudios = repository.findAll();
        List<ResultadoDeEstudiosDto> listaaRetornar = new LinkedList<>();

        for(ResultadosDeEstudios rde : informacionResultadosDeEstudios){
            if(rde.getPaciente().getDni() == dni){
                listaaRetornar.add(mapper.obtenerDto(rde));
            }
        }
        return listaaRetornar;
    }

    @Override
    public List<ResultadoDeEstudiosDto> buscarPorEstudio(String nombreEstudio){
        List<ResultadosDeEstudios> informacionResultadosDeEstudios = repository.findAll();
        List<ResultadoDeEstudiosDto> listaARetornar = new LinkedList<>();
        Set<Long> listaDeEstudios;

        for(ResultadosDeEstudios rde : informacionResultadosDeEstudios){
            listaDeEstudios = rde.getEstudios();

            for(Long id : listaDeEstudios){
                if(estudioClient.obtenerInformacionEstudio(id).getNombre().equals(nombreEstudio)){
                    listaARetornar.add(mapper.obtenerDto(rde));
                }
            }
        }

        return listaARetornar;
    }

    @Override
    public ResultadoDeEstudiosDto actualizarPaciente(Long id, Long idODniPaciente, String opcion) {
        Paciente pacienteParaAsignar = new Paciente();
        ResultadosDeEstudios resultadoParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("REsultados no encontrados"));

        if(!verificador.idODni(opcion)){
            throw new DatoIncorrectoException("La opción debe ser id o dni");
        }

        if(opcion.equals("id")){
            pacienteParaAsignar = pacienteRepository.findById(idODniPaciente).orElseThrow(()->new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        if(opcion.equals("dni")){
            pacienteParaAsignar = pacienteRepository.findByDni(idODniPaciente).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        resultadoParaActualizar.setPaciente(pacienteParaAsignar);

        return this.guardar(resultadoParaActualizar);
    }

    @Override
    public ResultadoDeEstudiosDto agregarEstudio(Long id, Long estudioId) {
        ResultadosDeEstudios resultadoParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Resultados no encontrados"));
        Set<Long> estudiosIds = resultadoParaActualizar.getEstudios();

        estudiosIds.add(estudioId); // Realizar validación para saber si el estudio existe en el otro microservicio
        resultadoParaActualizar.setEstudios(estudiosIds);

        return this.guardar(resultadoParaActualizar);
    }

    @Override
    public ResultadoDeEstudiosDto quitarEstudio(Long id, Long estudioId) {
        ResultadosDeEstudios resultadoParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Resultados no encontrados"));
        Set<Long> estudiosIds = resultadoParaActualizar.getEstudios();

        estudiosIds.remove(estudioId); // Corroborar si esto funciona. Puede que no. Si no funciona habrá que iterar para remover el objeto.
        resultadoParaActualizar.setEstudios(estudiosIds);

        return this.guardar(resultadoParaActualizar);
    }

    @Override
    public ResultadoDeEstudiosDto actualizarUrlInforme(Long id, String urlInforme) {
        ResultadosDeEstudios resultadoParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Resultados no encontrados"));
        resultadoParaActualizar.setUrlInforme(urlInforme);

        return this.guardar(resultadoParaActualizar);
    }
}
