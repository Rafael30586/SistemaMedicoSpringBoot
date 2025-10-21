package com.f_rafael.hospital_servicio.service;


import com.f_rafael.hospital_servicio.dto.CirugiaPacienteDto;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.CirugiaPacienteMapper;
import com.f_rafael.hospital_servicio.model.CirugiaPaciente;
import com.f_rafael.hospital_servicio.repository.ICirugiaPacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CirugiaPacienteService implements ICirugiaPacienteService{

    private CirugiaPacienteMapper mapper;
    private ICirugiaPacienteRepository repository;
    @Override
    public CirugiaPacienteDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento quirúrgico para paciente no encontrado"))); // Agregar excepción para lanzar
    }

    @Override
    public List<CirugiaPacienteDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public CirugiaPacienteDto guardar(CirugiaPaciente cirugiaPaciente) {
        return mapper.obtenerDto(repository.save(cirugiaPaciente));
    }

    @Override
    public CirugiaPacienteDto actualizar(CirugiaPaciente cirugiaPaciente) {
        return this.guardar(cirugiaPaciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Tratamiento quirúrgico para paciente no encontrado");
        }

        repository.deleteById(id);
    }
}
