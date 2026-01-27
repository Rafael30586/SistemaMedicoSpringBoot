package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.SignoDto;
import com.f_rafael.hospital_servicio.dto.TextoDto;
import com.f_rafael.hospital_servicio.dto.UnidadDeMedidaDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.SignoMapper;
import com.f_rafael.hospital_servicio.mapper.StringMapper;
import com.f_rafael.hospital_servicio.model.Signo;
import com.f_rafael.hospital_servicio.repository.IFarmaciaClient;
import com.f_rafael.hospital_servicio.repository.ISignoRepository;
import com.f_rafael.hospital_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class SignoService implements ISignoService{

    private ISignoRepository repository;
    private SignoMapper mapper;
    // private IUnidadDeMedidaClient unidadDeMedidaClient;
    private IFarmaciaClient farmaciaClient;
    private Verificador verificador;
    private StringMapper stringMapper;

    @Override
    public SignoDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Signo no encontrado")));
    }

    @Override
    public List<SignoDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public SignoDto guardar(Signo signo) {
        String nombreSigno = signo.getNombre();
        Long unidadId = signo.getUnidadId();

        if(nombreSigno == null || (signo.getValorMinimo() == null && signo.getValorMaximo() == null)){
            throw new CampoNuloException("Algunos campos de signo no pueden ser nulos");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombreSigno);

        if(unidadId != null){
            farmaciaClient.buscarUnidadPorId(unidadId);
        }

        return mapper.obtenerDto(repository.save(signo));
    }

    @Override
    public SignoDto actualizar(Signo signo) {

        if(signo.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }

        return this.guardar(signo);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Signo no encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public SignoDto buscarPorNombre(String nombre) {
        String nombreSinGuiones = stringMapper.quitarGuionesBajos(nombre);
        return mapper.obtenerDto(repository.findByNombre(nombreSinGuiones).orElseThrow(()-> new EntidadNoEncontradaException("Signo no encontrado")));
    }

    @Override
    public List<SignoDto> buscarPorUnidad(String unidad) {
        List<SignoDto> listaParaRetornar = new LinkedList<>();
        List<Signo> informacionSignos = repository.findAll();
        //String unidadSinGuiones = stringMapper.quitarGuionesBajos(unidad);
        UnidadDeMedidaDto unidadParaBuscar = farmaciaClient.buscarUnidadPorNombre(unidad);

        for(Signo s : informacionSignos){
            if(unidadParaBuscar.getId().equals(s.getUnidadId())){
                listaParaRetornar.add(mapper.obtenerDto(s));
            }
        }

        return listaParaRetornar;
    }

    @Override
    public List<SignoDto> buscarPorDescripcion(String secuencia) {
        return mapper.obtenerListaDto(repository.findByDescripcionContaining(secuencia));
    }

    @Override
    public SignoDto modificarNombre(Long id, String nombre) {
        Signo signoParaActualizar = devolverPorId(id);
        String nombreSinGuiones = stringMapper.quitarGuionesBajos(nombre);

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombreSinGuiones);
        signoParaActualizar.setNombre(nombreSinGuiones);

        return this.actualizar(signoParaActualizar);
    }

    @Override
    public SignoDto modificarValorMinimo(Long id, Double valorMinimo) {
        Signo signoParaActualizar = devolverPorId(id);

        verificador.esMenor(valorMinimo, signoParaActualizar.getValorMaximo());
        signoParaActualizar.setValorMinimo(valorMinimo);

        return this.actualizar(signoParaActualizar);
    }

    @Override
    public SignoDto modificarValorMaximo(Long id, Double valorMaximo) {
        Signo signoParaActualizar = devolverPorId(id);

        verificador.esMenor(signoParaActualizar.getValorMinimo(), valorMaximo);
        signoParaActualizar.setValorMaximo(valorMaximo);

        return this.actualizar(signoParaActualizar);
    }

    @Override
    public SignoDto modificarUnidad(Long id, Long unidadId) {
        Signo signoParaActualizar = devolverPorId(id);
        farmaciaClient.buscarUnidadPorId(unidadId);
        signoParaActualizar.setUnidadId(unidadId);

        return this.actualizar(signoParaActualizar);
    }

    @Override
    public SignoDto modificarDescripcion(Long id, TextoDto descripcion) {
        Signo signoParaActualizar = devolverPorId(id);
        signoParaActualizar.setDescripcion(descripcion.getTexto());

        return this.actualizar(signoParaActualizar);
    }

    public Signo devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Signo no encontrado"));
    }
}
