package com.f_rafael.lugares_servicio.service;

import com.f_rafael.lugares_servicio.exception.CampoNuloException;
import com.f_rafael.lugares_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.lugares_servicio.mapper.StringMapper;
import com.f_rafael.lugares_servicio.model.Direccion;
import com.f_rafael.lugares_servicio.model.Localidad;
import com.f_rafael.lugares_servicio.repository.IDireccionRepository;
import com.f_rafael.lugares_servicio.repository.ILocalidadRepository;
import com.f_rafael.lugares_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DireccionService implements IDireccionService{

    private IDireccionRepository repository;
    private StringMapper stringMapper;
    private Verificador verificador;
    private ILocalidadRepository localidadRepository;

    @Override
    public Direccion buscarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findById(id).get();
    }

    @Override
    public List<Direccion> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public Direccion guardar(Direccion direccion) {
        String calle = direccion.getCalle();

        if(calle == null){
            throw new CampoNuloException("La calle no puede ser nula");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(calle);

        return repository.save(direccion);
    }

    @Override
    public Direccion actualizar(Direccion direccion) {

        if(direccion.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }

        return this.guardar(direccion);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public List<Direccion> buscarPorLocalidad(String localidad) {
        List<Direccion> todasLasDirecciones = repository.findAll();
        List<Direccion> direccionesARetornar = new LinkedList<>();
        String localidadSinGuiones = stringMapper.quitarGuionesBajos(localidad);

        todasLasDirecciones.stream().parallel().forEach(direccion -> {
            if(direccion.getLocalidad().getNombre().equals(localidadSinGuiones)){
                direccionesARetornar.add(direccion);
            }
        });

        return direccionesARetornar;
    }

    @Override
    public List<Direccion> buscarPorProvincia(String provincia) {
        List<Direccion> todasLasDirecciones = repository.findAll();
        List<Direccion> direccionesARetornar = new LinkedList<>();
        String provinciaSinGuiones = stringMapper.quitarGuionesBajos(provincia);

        todasLasDirecciones.stream().parallel().forEach(direccion -> {
            if(direccion.getLocalidad().getProvincia().getNombre().equals(provinciaSinGuiones)){
                direccionesARetornar.add(direccion);
            }
        });

        return direccionesARetornar;
    }

    @Override
    public void editarCalle(Long id, String calle) {
        Direccion direccionAEditar;
        String calleSinGuiones = stringMapper.quitarGuionesBajos(calle);

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(calleSinGuiones);

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        direccionAEditar = repository.findById(id).get();
        direccionAEditar.setCalle(calleSinGuiones);

        this.guardar(direccionAEditar);
    }

    @Override
    public void editarAltura(Long id, Integer altura) {
        Direccion direccionAEditar;

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        direccionAEditar = repository.findById(id).get();
        direccionAEditar.setAltura(altura);

        this.guardar(direccionAEditar);
    }

    @Override
    public void editarDepartamento(Long id, String departamento) {
        Direccion direccionAEditar;
        String departamentoSinGuiones = stringMapper.quitarGuionesBajos(departamento);

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        direccionAEditar = repository.findById(id).get();
        direccionAEditar.setDepartamento(departamentoSinGuiones);

        this.guardar(direccionAEditar);
    }

    @Override
    public void editarLocalidad(Long id, Long localidadId) {
        Direccion direccionAEditar = devolverPorId(id);
        Localidad localidadParaAsignar = new Localidad();

        localidadParaAsignar.setId(localidadId);

        // Comprobar si la localidad existe
        if(!localidadRepository.existsById(localidadId)){
            throw new EntidadNoEncontradaException("Localidad no encontrada");
        }

        direccionAEditar.setLocalidad(localidadParaAsignar);
        this.actualizar(direccionAEditar);
    }

    private Direccion devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Direccion no encontrada"));
    }
}
