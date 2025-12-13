package com.f_rafael.lugares_servicio.service;

import com.f_rafael.lugares_servicio.exception.CampoNuloException;
import com.f_rafael.lugares_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.lugares_servicio.mapper.StringMapper;
import com.f_rafael.lugares_servicio.model.Pais;
import com.f_rafael.lugares_servicio.model.Provincia;
import com.f_rafael.lugares_servicio.repository.IPaisRepository;
import com.f_rafael.lugares_servicio.repository.IProvinciaRepository;
import com.f_rafael.lugares_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProvinciaService implements IProvinciaService{

    private IProvinciaRepository repository;
    private StringMapper stringMapper;
    private IPaisRepository paisRepository;
    private Verificador verificador;

    @Override
    public Provincia buscarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findById(id).get();
    }

    @Override
    public List<Provincia> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public Provincia guardar(Provincia provincia) {
        String nombre = provincia.getNombre();

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombre);

        if(nombre == null || provincia.getPais() == null){
            throw new CampoNuloException("El nombre no puede ser nulo");
        }

        return repository.save(provincia);
    }

    @Override
    public Provincia actualizar(Provincia provincia) {
        Long id = provincia.getId();

        if(id == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return this.guardar(provincia);
    }

    @Override
    public void borrarPorId(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }
        repository.deleteById(id);
    }

    @Override
    public Provincia buscarPorNombre(String nombre) {

        if(repository.findByNombre(nombre).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findByNombre(nombre).get();
    }

    @Override
    public Provincia modificarNombre(Long id, String nombre) {
        Provincia provinciaParaModificar = devolverPorId(id);
        String nombreSinGuiones = stringMapper.quitarGuionesBajos(nombre);

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombreSinGuiones);

        provinciaParaModificar.setNombre(nombreSinGuiones);

        return this.actualizar(provinciaParaModificar);
    }

    @Override
    public Provincia modificarProvincia(Long id, Long paisId) {
        Provincia provinciaParaModificiar = devolverPorId(id);
        Pais paisParaAsignar = new Pais();

        if(paisRepository.existsById(paisId)) {
            paisParaAsignar.setId(paisId);
        }else{
            throw new EntidadNoEncontradaException("Pais no encontrado");
        }

        provinciaParaModificiar.setPais(paisParaAsignar);

        return this.actualizar(provinciaParaModificiar);
    }

    private Provincia devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Provincia no encontrada"));
    }
}
