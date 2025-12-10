package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.AdministracionFarmacoDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.DatoIncorrectoException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.mapper.AdministracionFarmacoMapper;
import com.f_rafael.farmacia_servicio.mapper.StringMapper;
import com.f_rafael.farmacia_servicio.model.AdministracionFarmaco;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.repository.IAdministracionFarmacoRepository;
import com.f_rafael.farmacia_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class AdministarcionFarmacoService implements IAdministracionFarmacoService{

    private IAdministracionFarmacoRepository repository;
    private AdministracionFarmacoMapper mapper;
    private Verificador verificador;
    private StringMapper stringMapper;

    @Override
    public AdministracionFarmacoDto buscarPorId(Long id) {
        AdministracionFarmaco informacionAdministracionFarmaco = devolverPorId(id);

        return mapper.obtenerDto(informacionAdministracionFarmaco);
    }

    @Override
    public List<AdministracionFarmacoDto> buscarTodas() {
        return mapper.obtenerListaDtos(repository.findAll());
    }

    @Override
    public AdministracionFarmacoDto guardar(AdministracionFarmaco administracion) {
        String via = administracion.getVia();

        if(via == null){
            throw new CampoNuloException("La via no puede ser nula");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(via);

        return mapper.obtenerDto(repository.save(administracion));
    }


    @Override
    public AdministracionFarmacoDto actualizar(AdministracionFarmaco administracion) {
        Long id = administracion.getId();
        String nuevaVia = administracion.getVia();

        if(id == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }

        if(nuevaVia != repository.findById(id).get().getVia()){
            if(existePorVia(nuevaVia)) throw new DatoIncorrectoException("La via existe para otra entidad");
        }

        return this.guardar(administracion);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public AdministracionFarmacoDto buscarPorVia(String via) {

        if(!existePorVia(via)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return mapper.obtenerDto(repository.findByVia(via).get());
    }

    @Override
    public AdministracionFarmacoDto modificarVia(Long id, String via) {
        AdministracionFarmaco administracionParaEditar = devolverPorId(id);
        String viaSinGuiones = stringMapper.removerGuionesBajos(via);

        if(existePorVia(viaSinGuiones)) throw new DatoIncorrectoException("La via ya existe para una entidad");

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(viaSinGuiones);

        administracionParaEditar.setVia(viaSinGuiones);

        return this.actualizar(administracionParaEditar);
    }

    private AdministracionFarmaco devolverPorId(Long id){
        AdministracionFarmaco admninitracionParaRetornar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Admninistración de fármaco no encontrada"));
        return admninitracionParaRetornar;
    }

    private boolean existePorVia(String via){
        return repository.findByVia(via).isPresent();
    }


}
