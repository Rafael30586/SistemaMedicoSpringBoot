package com.f_rafael.pacientes_servicio.mapper;

import com.f_rafael.pacientes_servicio.dto.EstudioDto;
import com.f_rafael.pacientes_servicio.dto.ResultadoDeEstudiosDto;
import com.f_rafael.pacientes_servicio.model.ResultadosDeEstudios;
import com.f_rafael.pacientes_servicio.repository.IEstudioClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class ResultadosDeEstudiosMapper {

    private SubPacienteMapper subPacienteMapper;
    private IEstudioClient estudioClient;

    public ResultadoDeEstudiosDto obtenerDto(ResultadosDeEstudios informacionResultado){
        ResultadoDeEstudiosDto dtoARetornar = new ResultadoDeEstudiosDto();
        Set<Long> estudiosId;
        List<EstudioDto> estudiosparaAsignar = new LinkedList<>();

        dtoARetornar.setNumero(informacionResultado.getNumero());
        // dtoARetornar.setCobertura(informacionResultado.getCobertura());
        dtoARetornar.setUrlInforme(informacionResultado.getUrlInforme());
        dtoARetornar.setPaciente(subPacienteMapper.obtenerDto(informacionResultado.getPaciente()));

        if(informacionResultado.getEstudios() != null){
            estudiosId = informacionResultado.getEstudios();

            for(Long id : estudiosId){
                estudiosparaAsignar.add(estudioClient.obtenerInformacionEstudio(id));
            }
            dtoARetornar.setEstudios(estudiosparaAsignar);
        }

        return dtoARetornar;
    }

    public List<ResultadoDeEstudiosDto> obtenerListaDto(Collection<ResultadosDeEstudios> informacionResultados){
        List<ResultadoDeEstudiosDto> listaARetornar = new LinkedList<>();

        for(ResultadosDeEstudios rde : informacionResultados){
            listaARetornar.add(obtenerDto(rde));
        }

        return listaARetornar;
    }
}
