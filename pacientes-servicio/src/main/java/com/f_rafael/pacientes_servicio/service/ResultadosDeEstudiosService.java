package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.ResultadoDeEstudiosDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.ResultadosDeEstudios;
import com.f_rafael.pacientes_servicio.repository.IResultadoDeEstudiosRepository;
import com.f_rafael.pacientes_servicio.utils.ResultadosDeEstudiosMap;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ResultadosDeEstudiosService implements IResultadosDeEstudiosService{

    private IResultadoDeEstudiosRepository repository;
    private ResultadosDeEstudiosMap map;


    @Override
    public ResultadoDeEstudiosDto buscarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return map.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<ResultadoDeEstudiosDto> buscartodos() {
        return map.obtenerListaDto(repository.findAll());
    }

    @Override
    public ResultadoDeEstudiosDto guardar(ResultadosDeEstudios resultadosDeEstudios) {

        if(resultadosDeEstudios.getPaciente() == null || resultadosDeEstudios.getEstudios() == null || resultadosDeEstudios.getCobertura() == null || resultadosDeEstudios.getUrlInforme() == null){
            throw new CampoNuloException("Hay campos que no pueden ser nulos");
        } // Averiguar como hacer con el tema de los estudiso ya que puede que no existan en el otro microservicio

        return map.obtenerDto(repository.save(resultadosDeEstudios));
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
}
