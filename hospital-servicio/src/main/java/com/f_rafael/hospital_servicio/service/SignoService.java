package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.SignoDto;
import com.f_rafael.hospital_servicio.dto.UnidadDeMedidaDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.SignoMapper;
import com.f_rafael.hospital_servicio.model.Signo;
import com.f_rafael.hospital_servicio.repository.ISignoRepository;
import com.f_rafael.hospital_servicio.repository.IUnidadDeMedidaClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class SignoService implements ISignoService{

    private ISignoRepository repository;
    private SignoMapper mapper;
    private IUnidadDeMedidaClient unidadDeMedidaClient;

    @Override
    public SignoDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Signo no encontrado")));
    }

    @Override
    public List<SignoDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public SignoDto guardar(Signo signo) {

        if(signo.getNombre() == null || (signo.getValorMinimo() == null && signo.getValorMaximo() == null)){
            throw new CampoNuloException("Algunos campos de signo no pueden ser nulos");
        }

        return mapper.obtenerDto(repository.save(signo));
    }

    @Override
    public SignoDto actualizar(Signo signo) {

        if(signo.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }

        return this.guardar(signo);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Signo no encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public SignoDto buscarPorNombre(String nombre) {
        return mapper.obtenerDto(repository.findByNombre(nombre).orElseThrow(()-> new EntidadNoEncontradaException("Signo no encontrado")));
    }

    @Override
    public List<SignoDto> buscarPorUnidad(String unidad) {
        List<SignoDto> listaParaRetornar = new LinkedList<>();
        List<Signo> informacionSignos = repository.findAll();
        UnidadDeMedidaDto unidadParaBuscar = unidadDeMedidaClient.buscarPorNombre(unidad);

        for(Signo s : informacionSignos){
            if(s.getUnidadId().equals(unidadParaBuscar.getId())){
                listaParaRetornar.add(mapper.obtenerDto(s));
            }
        }

        return listaParaRetornar;
    }

    @Override
    public List<SignoDto> buscarPorDescripcion(String secuencia) {
        return mapper.obtenerListaDto(repository.findAllByDescripcionContainingIgnoreCase(secuencia));
    }
}
