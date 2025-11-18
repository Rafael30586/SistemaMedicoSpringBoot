package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.TextoDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.StringMapper;
import com.f_rafael.hospital_servicio.model.TratamientoQuirurgico;
import com.f_rafael.hospital_servicio.repository.ITratamientoQuirurgicoRepository;
import com.f_rafael.hospital_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TratamientoQuirurgicoService implements ITratamientoQuirurgicoService{

    private ITratamientoQuirurgicoRepository repository;
    private StringMapper stringMapper;
    private Verificador verificador;

    @Override
    public TratamientoQuirurgico buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento quirúrgico no encontrado"));
    }

    @Override
    public List<TratamientoQuirurgico> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public TratamientoQuirurgico guardar(TratamientoQuirurgico tratamientoQuirurgico) {
        String nombreCirugia = tratamientoQuirurgico.getNombre();

        if(nombreCirugia == null){
            throw new CampoNuloException("El tratamiento quirúrgico debe tener un nombre");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombreCirugia);

        return repository.save(tratamientoQuirurgico);
    }

    @Override
    public TratamientoQuirurgico actualizar(TratamientoQuirurgico tratamientoQuirurgico) {

        if(tratamientoQuirurgico.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }

        return this.guardar(tratamientoQuirurgico);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("El tratamiento quirúrgico no ha sido encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public TratamientoQuirurgico buscarPorNombre(String nombre) {
        String nombreSinGuiones = stringMapper.quitarGuionesBajos(nombre);
        return repository.findByNombre(nombreSinGuiones).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento quirúrgico no encontrado"));
    }

    @Override
    public List<TratamientoQuirurgico> buscarPorDescripcion(String secuencia) {
        return repository.findAllByDescripcionContaining(secuencia);
    }

    @Override
    public TratamientoQuirurgico modificarNombre(Long id, String nombre) {
        TratamientoQuirurgico tratamientoParaActualizar = devolverPorId(id);
        String nombreSinGuiones = stringMapper.quitarGuionesBajos(nombre);

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombreSinGuiones);
        tratamientoParaActualizar.setNombre(nombreSinGuiones);

        return this.actualizar(tratamientoParaActualizar);
    }

    @Override
    public TratamientoQuirurgico modificarDescripcion(Long id, TextoDto descripcion) {
        TratamientoQuirurgico tratamientoParaActualizar = devolverPorId(id);
        tratamientoParaActualizar.setDescripcion(descripcion.getTexto());

        return this.actualizar(tratamientoParaActualizar);
    }

    public TratamientoQuirurgico devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento quirúrgico no encontrado"));
    }
}
