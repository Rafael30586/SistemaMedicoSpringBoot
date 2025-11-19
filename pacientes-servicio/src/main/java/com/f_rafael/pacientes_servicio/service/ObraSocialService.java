package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.ObraSocialDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.mapper.StringMapper;
import com.f_rafael.pacientes_servicio.model.ObraSocial;
import com.f_rafael.pacientes_servicio.repository.IObraSocialRepository;
import com.f_rafael.pacientes_servicio.mapper.ObraSocialMapper;
import com.f_rafael.pacientes_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class ObraSocialService implements IObraSocialService{

    private ObraSocialMapper mapper;
    private IObraSocialRepository repository;
    private StringMapper stringMapper;
    private Verificador verificador;

    @Override
    public ObraSocialDto buscarPorId(Long id) {
        ObraSocialDto dtoARetornar;

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        dtoARetornar = mapper.obtenerDto(repository.findById(id).get());
        return dtoARetornar;
    }

    @Override
    public List<ObraSocialDto> buscarTodas() {
        List<ObraSocialDto> listaARetornar = mapper.obtenerListaDto(repository.findAll());

        return listaARetornar;
    }

    @Override
    public ObraSocialDto buscarPorNombre(String nombre) {
        ObraSocialDto dtoaRetornar;

        if(repository.findByNombre(nombre).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        dtoaRetornar = mapper.obtenerDto(repository.findByNombre(nombre).get());

        return dtoaRetornar;
    }

    @Override
    public ObraSocialDto guardar(ObraSocial obraSocial) {
        ObraSocialDto dtoARetornar;
        String nombreObraSocial = obraSocial.getNombre();

        if(nombreObraSocial == null){
            throw new CampoNuloException("El nombre no puede se nulo");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombreObraSocial);

        dtoARetornar = mapper.obtenerDto(repository.save(obraSocial));

        return dtoARetornar;
    }

    @Override
    public ObraSocialDto actualizar(ObraSocial obraSocial) {
        if(obraSocial.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }
        return this.guardar(obraSocial);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public ObraSocialDto actualizarNombre(Long id,String nombre) {
        ObraSocial obraSocialAEditar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Obra social no encontrada"));
        obraSocialAEditar.setNombre(stringMapper.quitarGuionesBajos(nombre));

        return this.actualizar(obraSocialAEditar);
    }

}
