package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.ResultadoDeEstudiosDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.ResultadosDeEstudios;
import com.f_rafael.pacientes_servicio.repository.IEstudioClient;
import com.f_rafael.pacientes_servicio.repository.IResultadoDeEstudiosRepository;
import com.f_rafael.pacientes_servicio.mapper.ResultadosDeEstudiosMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class ResultadosDeEstudiosService implements IResultadosDeEstudiosService{

    private IResultadoDeEstudiosRepository repository;
    private ResultadosDeEstudiosMapper mapper;
    private IEstudioClient estudioClient;


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

        if(resultadosDeEstudios.getPaciente() == null || resultadosDeEstudios.getEstudios() == null || resultadosDeEstudios.getCobertura() == null || resultadosDeEstudios.getUrlInforme() == null){
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
        List<Long> listaDeEstudios;

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
}
