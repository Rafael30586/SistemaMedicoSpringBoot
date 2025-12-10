package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.MarcaMedicamentoDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.DatoIncorrectoException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.mapper.MarcaMedicamentoMapper;
import com.f_rafael.farmacia_servicio.mapper.StringMapper;
import com.f_rafael.farmacia_servicio.model.MarcaMedicamento;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.repository.IMarcaMedicamentoRepository;
import com.f_rafael.farmacia_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class MarcaMedicamentoService implements IMarcaMedicamentoService{

    private IMarcaMedicamentoRepository repository;
    private MarcaMedicamentoMapper mapper;
    private Verificador verificador;
    private StringMapper stringMapper;

    @Override
    public MarcaMedicamentoDto buscarPorId(Long id) {
        return mapper.obtenerDto(devolverPorId(id));
    }

    @Override
    public List<MarcaMedicamentoDto> buscarTodas() {
        return mapper.obtenerListaDtos(repository.findAll());
    }


    @Override
    public MarcaMedicamentoDto guardar(MarcaMedicamento marca) {
        String nombre = marca.getNombre();

        if(nombre == null){
            throw new CampoNuloException("El nombre no puede ser nulo");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombre);

        return mapper.obtenerDto(repository.save(marca));
    }

    @Override
    public MarcaMedicamentoDto actualizar(MarcaMedicamento marca) {
        Long id = marca.getId();
        String nuevoNombre = marca.getNombre();

        if(id == null){
            throw new CampoNuloException("El id y no puede ser nulo");
        }

        if(nuevoNombre != repository.findById(id).get().getNombre()){
            throw new DatoIncorrectoException("El nombre ya existe para otra entidad");
        }

        return this.guardar(marca);
    }

    @Override
    public void borrarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public MarcaMedicamentoDto buscarPorNombre(String nombre) {

        if(!existePorNombre(nombre)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return mapper.obtenerDto(repository.findByNombre(nombre).get());
    }

    @Override
    public MarcaMedicamentoDto modificarNombre(Long id, String nuevoNombre) {
        MarcaMedicamento marcaParaActualizar = devolverPorId(id);
        String nombreSinGuiones = stringMapper.removerGuionesBajos(nuevoNombre);

        if(existePorNombre(nombreSinGuiones)){
            throw new DatoIncorrectoException("El nombre ya existe para alguna entidad");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombreSinGuiones);

        marcaParaActualizar.setNombre(nombreSinGuiones);

        return this.actualizar(marcaParaActualizar);
    }


    private MarcaMedicamento devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Marca de medicamento no encontrada"));
    }

    private boolean existePorNombre(String nombre){
        return repository.findByNombre(nombre).isPresent();
    }
}
