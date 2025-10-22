package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.DiagnosticoDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.DiagnosticoMapper;
import com.f_rafael.hospital_servicio.model.Diagnostico;
import com.f_rafael.hospital_servicio.repository.IDiagnosticoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiagnosticoService implements IDiagnosticoService{

    private DiagnosticoMapper mapper;

    private IDiagnosticoRepository repository;
    @Override
    public DiagnosticoDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Diagnostico no encontrado")));
    }

    @Override
    public List<DiagnosticoDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public DiagnosticoDto guardar(Diagnostico diagnostico) {

        if(diagnostico.getNombre() == null){
            throw new CampoNuloException("El nombre del diagnóstico no puede ser nulo");
        }

        return mapper.obtenerDto(repository.save(diagnostico));
    }

    @Override
    public DiagnosticoDto actualizar(Diagnostico diagnostico) {
        return this.guardar(diagnostico);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("El diagnóstico para borrar no se ha encontrado");
        }

        repository.deleteById(id);
    }
}
