package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.FormaFarmaceuticaDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.DatoIncorrectoException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.mapper.FormaFarmaceuticaMapper;
import com.f_rafael.farmacia_servicio.mapper.StringMapper;
import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.repository.IFormaFarmaceuticaRepository;
import com.f_rafael.farmacia_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class FormaFarmaceuticaService implements IFormaFarmaceuticaService{

    private IFormaFarmaceuticaRepository repository;
    private Verificador verificador;
    private FormaFarmaceuticaMapper mapper;
    private StringMapper stringMapper;

    @Override
    public FormaFarmaceuticaDto buscarPorId(Long id) {
        return mapper.obtenerDto(devolverPorId(id));
    }

    @Override
    public List<FormaFarmaceuticaDto> buscarTodas() {
        return mapper.obtenerListaDtos(repository.findAll());
    }

    @Override
    public FormaFarmaceuticaDto guardar(FormaFarmaceutica formaFarmaceutica) {
        String nombre = formaFarmaceutica.getNombre();

        if(nombre == null){
            throw new CampoNuloException("El nombre no puede ser nulo");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombre);

        return mapper.obtenerDto(repository.save(formaFarmaceutica));
    }

    @Override
    public FormaFarmaceuticaDto actualizar(FormaFarmaceutica formaFarmaceutica) {
        Long id = formaFarmaceutica.getId();
        String nuevoNombre = formaFarmaceutica.getNombre();

        if(id == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        if(nuevoNombre != repository.findById(id).get().getNombre()){
            if(exietePorNombre(nuevoNombre)) throw new DatoIncorrectoException("El nombrwe ya existe para otra entidad");
        }

        return this.guardar(formaFarmaceutica);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public FormaFarmaceuticaDto buscarPorNombre(String nombre) {

        if(!exietePorNombre(nombre)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return mapper.obtenerDto(repository.findByNombre(nombre).get());
    }

    @Override
    public FormaFarmaceuticaDto modificarNombre(Long id, String nombre) {
        FormaFarmaceutica formaFarmaceuticaParaEditar = devolverPorId(id);
        String nombreSinGuiones = stringMapper.removerGuionesBajos(nombre);

        if(exietePorNombre(nombreSinGuiones)){
            throw new DatoIncorrectoException("El nokbre ya existe para otra entidad");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombreSinGuiones);

        formaFarmaceuticaParaEditar.setNombre(nombreSinGuiones);

        return this.actualizar(formaFarmaceuticaParaEditar);
    }

    private FormaFarmaceutica devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Forma farmacéutica no encontrada"));
    }

    private boolean exietePorNombre(String nombre){
        return repository.findByNombre(nombre).isPresent();
    }

}
