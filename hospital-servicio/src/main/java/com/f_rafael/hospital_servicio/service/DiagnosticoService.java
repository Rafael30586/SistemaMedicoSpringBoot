package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.DiagnosticoDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.DiagnosticoMapper;
import com.f_rafael.hospital_servicio.mapper.StringMapper;
import com.f_rafael.hospital_servicio.model.Diagnostico;
import com.f_rafael.hospital_servicio.model.Signo;
import com.f_rafael.hospital_servicio.model.Sintoma;
import com.f_rafael.hospital_servicio.repository.IDiagnosticoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class DiagnosticoService implements IDiagnosticoService{

    private DiagnosticoMapper mapper;
    private IDiagnosticoRepository repository;
    private StringMapper stringMapper;
    @Override
    public DiagnosticoDto buscarPorId(Long id) {
        return mapper.obtenerDto(devolverPorId(id));
    }

    @Override
    public List<DiagnosticoDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public DiagnosticoDto guardar(Diagnostico diagnostico) {

        if(diagnostico.getNombre() == null){
            throw new CampoNuloException("El nombre del diagnóstico no puede ser nulo");
        }

        return mapper.obtenerDto(repository.save(diagnostico));
    }

    @Override
    public DiagnosticoDto actualizar(Diagnostico diagnostico) {

        if(diagnostico.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }

        return this.guardar(diagnostico);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("El diagnóstico para borrar no se ha encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public DiagnosticoDto buscarPorNombre(String nombre) {
        String nombreSinGuiones = stringMapper.quitarGuionesBajos(nombre);
        return mapper.obtenerDto(repository.findByNombre(nombreSinGuiones).orElseThrow(()-> new EntidadNoEncontradaException("Diagnóstico no encontrado")));
    }

    @Override
    public DiagnosticoDto modificarNombre(Long id, String nuevoNombre) {
        String nombreSinGuiones = stringMapper.quitarGuionesBajos(nuevoNombre);
        Diagnostico diagnosticoParaActualizar = devolverPorId(id);

        diagnosticoParaActualizar.setNombre(nombreSinGuiones);

        return this.actualizar(diagnosticoParaActualizar);
    }

    @Override
    public DiagnosticoDto agregarSintoma(Long id, Long sintomaId) {
        Diagnostico diagnosticoParaActualizar = devolverPorId(id);
        Set<Sintoma> sintomasParaAsignar = diagnosticoParaActualizar.getSintomas();
        Sintoma sintomaParaAgregar = new Sintoma();

        sintomaParaAgregar.setId(sintomaId);
        sintomasParaAsignar.add(sintomaParaAgregar);

        diagnosticoParaActualizar.setSintomas(sintomasParaAsignar);

        return this.actualizar(diagnosticoParaActualizar);
    }

    @Override
    public DiagnosticoDto quitarSintoma(Long id, Long sintomaId) {
        Diagnostico diagnosticoParaActualizar = devolverPorId(id);
        Set<Sintoma> sintomasParaAsignar = diagnosticoParaActualizar.getSintomas();
        Iterator<Sintoma> iteradorSintomas = sintomasParaAsignar.iterator();
        boolean sintomaPresente = false;

        while(iteradorSintomas.hasNext()){
            if(iteradorSintomas.next().getId().equals(sintomaId)){
                iteradorSintomas.remove();
                sintomaPresente = true;
            }
        }

        if(!sintomaPresente){
            throw new EntidadNoEncontradaException("El síntoma no está dentro de la lista");
        }

        return this.actualizar(diagnosticoParaActualizar);
    }

    @Override
    public DiagnosticoDto agregarSigno(Long id, Long signoId) {
        Diagnostico diagnosticoParaActualizar = devolverPorId(id);
        Set<Signo> signosParaAsignar = diagnosticoParaActualizar.getSignos();
        Signo signoParaAgregar= new Signo();

        signoParaAgregar.setId(signoId);
        signosParaAsignar.add(signoParaAgregar);
        diagnosticoParaActualizar.setSignos(signosParaAsignar);

        return this.actualizar(diagnosticoParaActualizar);
    }

    @Override
    public DiagnosticoDto quitarSigno(Long id, Long signoId) {
        Diagnostico diagnosticoParaActualizar = devolverPorId(id);
        Set<Signo> signosParaAsignar = diagnosticoParaActualizar.getSignos();
        Iterator<Signo> iteradorSignos = signosParaAsignar.iterator();
        boolean signoPresente = false;

        while(iteradorSignos.hasNext()){
            if(iteradorSignos.next().getId().equals(signoId)){
                iteradorSignos.remove();
                signoPresente = true;
            }
        }

        if(!signoPresente){
            throw new EntidadNoEncontradaException("El signo no está presente en la lista");
        }

        return this.actualizar(diagnosticoParaActualizar);
    }

    public Diagnostico devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Diagnóstico no encontrado"));
    }
}
