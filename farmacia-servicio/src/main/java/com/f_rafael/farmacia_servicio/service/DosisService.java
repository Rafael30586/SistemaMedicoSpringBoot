package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.DatoIncorrectoException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.mapper.StringMapper;
import com.f_rafael.farmacia_servicio.model.Dosis;
import com.f_rafael.farmacia_servicio.model.UnidadDeMedida;
import com.f_rafael.farmacia_servicio.repository.IDosisRepository;
import com.f_rafael.farmacia_servicio.repository.IUnidadDeMedidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DosisService implements IDosisService{

    private IDosisRepository repository;
    private IUnidadDeMedidaRepository unidadDeMedidaRepository;
    private StringMapper stringMapper;

    @Override
    public Dosis buscarPorId(Long id) {
        return devolverPorId(id);
    }

    @Override
    public List<Dosis> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public Dosis guardar(Dosis dosis) {

        if(dosis.getCantidad() == null || dosis.getUnidad() == null || dosis.getIntervaloHoras() == null){
            throw new CampoNuloException("Hay tres campos en esta entidad que no pueden ser nulos");
        }

        if(!unidadDeMedidaRepository.existsById(dosis.getUnidad().getId())){
            throw new DatoIncorrectoException("El id no corresponde a ninguna unidad de medida de la base de datos");
        }

        return repository.save(dosis);
    }

    @Override
    public Dosis actualizar(Dosis dosis) {
        Long id = dosis.getId();

        if(id == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return this.guardar(dosis);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public Dosis buscarPorCantidadUnidadEIntervalo(float cantidad, String nombreUnidad, int intervaloHoras) {

        String unidadSinGuiones = stringMapper.removerGuionesBajos(nombreUnidad);

        if(repository.buscarPorCantidadUnidadEIntervalo(cantidad,unidadSinGuiones,intervaloHoras).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.buscarPorCantidadUnidadEIntervalo(cantidad,unidadSinGuiones,intervaloHoras).get();
    }

    @Override
    public Dosis modificarCantidad(Long id, Float cantidad) {
        Dosis dosisParaActualizar = devolverPorId(id);
        dosisParaActualizar.setCantidad(cantidad);

        return this.actualizar(dosisParaActualizar);
    }

    @Override
    public Dosis modificarUnidad(Long id, Long unidadId) {
        Dosis dosisParaActualizar = devolverPorId(id);
        UnidadDeMedida unidadParaAsignar = new UnidadDeMedida();
        unidadParaAsignar.setId(unidadId);

        if(!unidadDeMedidaRepository.existsById(unidadId)){
            throw new EntidadNoEncontradaException("La unidad de medida no se ha encontrado");
        }

        dosisParaActualizar.setUnidad(unidadParaAsignar);

        return this.actualizar(dosisParaActualizar);
    }

    @Override
    public Dosis modificarIntervalo(Long id, Integer intervaloHoras) {
        Dosis dosisParaActualizar = devolverPorId(id);
        dosisParaActualizar.setIntervaloHoras(intervaloHoras);

        return this.actualizar(dosisParaActualizar);
    }

    public Dosis devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Dosis no encontrada"));
    }
}
