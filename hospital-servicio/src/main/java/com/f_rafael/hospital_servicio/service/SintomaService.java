package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.SintomaDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.SintomaMapper;
import com.f_rafael.hospital_servicio.mapper.StringMapper;
import com.f_rafael.hospital_servicio.model.Sintoma;
import com.f_rafael.hospital_servicio.repository.ISintomaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class SintomaService implements ISintomaService{

    private ISintomaRepository repository;
    private SintomaMapper mapper;
    private StringMapper stringMapper;

    @Override
    public SintomaDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Sintoma no encontrado")));
    }

    @Override
    public List<SintomaDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public SintomaDto guardar(Sintoma sintoma) {

        if(sintoma.getNombre() == null){
            throw new CampoNuloException("El síntoma debe tener un nombre");
        }
        return mapper.obtenerDto(repository.save(sintoma));
    }

    @Override
    public SintomaDto actualizar(Sintoma sintoma) {

        if(sintoma.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }
        return this.guardar(sintoma);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("El síntoma no ha sido encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public SintomaDto buscarPorNombre(String nombre) {
        String nombreSinGuiones = stringMapper.quitarGuionesBajos(nombre);
        return mapper.obtenerDto(repository.findByNombre(nombreSinGuiones).orElseThrow(()-> new EntidadNoEncontradaException("Síntoma no encontrado")));
    }

    @Override
    public SintomaDto modificarNombre(Long id,String nombre) {
        Sintoma sintomaParaActualizar = devolverPorId(id);
        String nombreSinGuiones = stringMapper.quitarGuionesBajos(nombre);

        sintomaParaActualizar.setNombre(nombreSinGuiones);

        return this.actualizar(sintomaParaActualizar);
    }

    public Sintoma devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Síntoma no encontrado"));
    }
}
