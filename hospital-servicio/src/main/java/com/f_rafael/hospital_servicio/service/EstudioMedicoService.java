package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.StringMapper;
import com.f_rafael.hospital_servicio.model.EstudioMedico;
import com.f_rafael.hospital_servicio.model.EstudioMedicoClasificacion;
import com.f_rafael.hospital_servicio.repository.IEstudioMedicoRepository;
import com.f_rafael.hospital_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstudioMedicoService implements IEstudioMedicoService{

    private IEstudioMedicoRepository repository;
    private StringMapper stringMapper;
    private Verificador verificador;

    @Override
    public EstudioMedico buscarPorId(Long id) {
        return devolverPorId(id);
    }

    @Override
    public List<EstudioMedico> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public EstudioMedico guardar(EstudioMedico estudioMedico) {
        String nombreEstudioMedico = estudioMedico.getNombre();

        if(nombreEstudioMedico == null){
            throw new CampoNuloException("El estudio médico debe tener un nombre");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombreEstudioMedico);

        return repository.save(estudioMedico);
    }

    @Override
    public EstudioMedico actualizar(EstudioMedico estudioMedico) {

        if(estudioMedico.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }
        return null;
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("El estudio médico no se ha encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public EstudioMedico buscarPorNombre(String nombre) {
        String nombreSinGuiones = stringMapper.quitarGuionesBajos(nombre);
        return repository.findByNombre(nombreSinGuiones).orElseThrow(()-> new EntidadNoEncontradaException("El estudio médico no ha sido encontrado"));
    }

    @Override
    public List<EstudioMedico> buscarPorClasificacion(String clasificacion) {
        String clasificacionSinGuiones = stringMapper.quitarGuionesBajos(clasificacion);
        return repository.buscarPorClasificacion(clasificacionSinGuiones);
    }

    @Override
    public EstudioMedico modificarNombre(Long id, String nombre) {
        EstudioMedico estudioParaActualizar = devolverPorId(id);
        String nombreSinGuiones = stringMapper.quitarGuionesBajos(nombre);

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombreSinGuiones);
        estudioParaActualizar.setNombre(nombreSinGuiones);

        return this.actualizar(estudioParaActualizar);
    }

    @Override
    public EstudioMedico modificarClasificacion(Long id, Long clasificacionId) {
        EstudioMedico estudioParaActualizar = devolverPorId(id);
        EstudioMedicoClasificacion clasificacionParaAsignar = new EstudioMedicoClasificacion();

        clasificacionParaAsignar.setId(clasificacionId);
        estudioParaActualizar.setClasificacion(clasificacionParaAsignar);

        return this.actualizar(estudioParaActualizar);
    }

    public EstudioMedico devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Estudio médico no encontrado"));
    }
}
