package com.f_rafael.farmacia_servicio.mapper;

import com.f_rafael.farmacia_servicio.dto.AdministracionFarmacoDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.model.AdministracionFarmaco;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AdministracionFarmacoMapper {

    public AdministracionFarmacoDto obtenerDto(AdministracionFarmaco administracion){

        AdministracionFarmacoDto dtoARetornar = new AdministracionFarmacoDto();
        SubMedicamentoDto medicamentoAAsignar;
        Set<SubMedicamentoDto> medicamentosAAsignar;
        //Optional<Set<Medicamento>> medicamentosOptional = Optional.of(administracion.getMedicamentos()); // parece que acá da un null pointer exception

        Set<Medicamento> informacionMedicamentos = administracion.getMedicamentos();

        if(informacionMedicamentos != null){

            // informacionMedicamentos = administracion.getMedicamentos();
            medicamentosAAsignar = new HashSet<>();

            for(Medicamento m : informacionMedicamentos){
                medicamentoAAsignar = new SubMedicamentoDto(m.getId(),
                        m.getNombre(),
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


    public List<AdministracionFarmacoDto> obtenerListaDtos(Collection<AdministracionFarmaco> coleccionAdministracionFarmaco){
        List<AdministracionFarmacoDto> listaARetornar = new LinkedList<>();

        for(AdministracionFarmaco af : coleccionAdministracionFarmaco){
            listaARetornar.add(obtenerDto(af));
        }

        return listaARetornar;
    }
}
