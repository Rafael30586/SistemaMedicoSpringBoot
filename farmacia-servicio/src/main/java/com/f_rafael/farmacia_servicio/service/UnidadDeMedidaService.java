package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.mapper.StringMapper;
import com.f_rafael.farmacia_servicio.model.UnidadDeMedida;
import com.f_rafael.farmacia_servicio.repository.IUnidadDeMedidaRepository;
import com.f_rafael.farmacia_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UnidadDeMedidaService implements IUnidadDeMedidaService{

    private IUnidadDeMedidaRepository repository;
    private StringMapper stringMapper;
    private Verificador verificador;

    @Override
    public UnidadDeMedida buscarPorId(Long id) {

        if(repository.findById(id).isEmpty()){ // refactorizar
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findById(id).get();
    }

    @Override
    public List<UnidadDeMedida> buscarTodas() {
        return repository.findAll();
    }


    @Override
    public UnidadDeMedida guardar(UnidadDeMedida unidad) {
        String nombre = unidad.getNombre();

        if(nombre == null){
            throw new CampoNuloException("El nombre no puede ser nulo");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombre);

        return repository.save(unidad);
    }

    @Override
    public UnidadDeMedida actualizar(UnidadDeMedida unidad) {
        Long id = unidad.getId();

        if(id == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return guardar(unidad);
    }

    @Override
    public void borrarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public UnidadDeMedida buscarPorNombre(String nombre) {

        if(repository.findByNombre(nombre).isEmpty()){
            throw  new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findByNombre(nombre).get();
    }

    @Override
    public UnidadDeMedida buscarPorSimbolo(String simbolo) {

        if(repository.findBySimbolo(simbolo).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findBySimbolo(simbolo).get();
    }

    @Override
    public UnidadDeMedida modificarNombre(Long id, String nombre) {
        UnidadDeMedida unidadParaModificar = devolverPorId(id);

        unidadParaModificar.setNombre(stringMapper.removerGuionesBajos(nombre));

        return this.actualizar(unidadParaModificar);
    }

    @Override
    public UnidadDeMedida modificarSimbolo(Long id, String simbolo) {
        UnidadDeMedida unidadParaModificar = devolverPorId(id);

        unidadParaModificar.setSimbolo(simbolo);

        return this.actualizar(unidadParaModificar);
    }

    public UnidadDeMedida devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Unidad de medida no encontrada"));
    }
}
