package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.ResultadoDeEstudiosDto;
import com.f_rafael.pacientes_servicio.model.ResultadosDeEstudios;

import java.util.List;

public interface IResultadosDeEstudiosService {
    public ResultadoDeEstudiosDto buscarPorId(Long id);
    public List<ResultadoDeEstudiosDto> buscartodos();
    public ResultadoDeEstudiosDto guardar(ResultadosDeEstudios resultadosDeEstudios);
    public ResultadoDeEstudiosDto actualizar(ResultadosDeEstudios resultadosDeEstudios);
    public void borrarPorId(Long id);
    public List<ResultadoDeEstudiosDto> buscarPorPaciente(Long dni);
    public List<ResultadoDeEstudiosDto> buscarPorEstudio(String estudio);
    public ResultadoDeEstudiosDto actualizarPaciente(Long id,Long dniPaciente);
    public ResultadoDeEstudiosDto agregarEstudio(Long id, Long estudioId);
    public ResultadoDeEstudiosDto quitarEstudio(Long id, Long estudioId);
    public ResultadoDeEstudiosDto actualizarUrlInforme(Long id, String urlInforme);
}
