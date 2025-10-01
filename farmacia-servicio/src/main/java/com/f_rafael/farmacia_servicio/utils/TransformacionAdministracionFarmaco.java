package com.f_rafael.farmacia_servicio.utils;

import com.f_rafael.farmacia_servicio.dto.AdministracionFarmacoDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.model.AdministracionFarmaco;
import com.f_rafael.farmacia_servicio.model.Medicamento;

import java.util.*;

public class TransformacionAdministracionFarmaco {

    public static AdministracionFarmacoDto obtenerDto(AdministracionFarmaco administracion){
        AdministracionFarmacoDto dtoARetornar = new AdministracionFarmacoDto();
        SubMedicamentoDto medicamentoAAsignar;
        Set<SubMedicamentoDto> medicamentosAAsignar;
        Optional<Set<Medicamento>> medicamentosOptional = Optional.of(administracion.getMedicamentos());
        Set<Medicamento> informacionMedicamentos;

        if(medicamentosOptional.isPresent()){

            informacionMedicamentos = administracion.getMedicamentos();
            medicamentosAAsignar = new HashSet<>();

            for(Medicamento m : informacionMedicamentos){
                medicamentoAAsignar = new SubMedicamentoDto(m.getId(),
                        m.getPrincipioActivo().getNombre(),
                        m.getFormaFarmaceutica().getNombre(),
                        m.getAdministracion().getVia(),
                        m.getMarca().getNombre());

                medicamentosAAsignar.add(medicamentoAAsignar);
            }

            dtoARetornar.setMedicamentos(medicamentosAAsignar);
        }

        dtoARetornar.setId(administracion.getId());
        dtoARetornar.setVia(administracion.getVia());

        return dtoARetornar;
    }

    public static List<AdministracionFarmacoDto> obtenerListaDtos(Collection<AdministracionFarmaco> coleccionAdministracionFarmaco){
        List<AdministracionFarmacoDto> listaARetornar = new LinkedList<>();

        for(AdministracionFarmaco af : coleccionAdministracionFarmaco){
            listaARetornar.add(obtenerDto(af));
        }

        return listaARetornar;
    }
}
