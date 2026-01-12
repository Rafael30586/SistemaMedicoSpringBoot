package com.f_rafael.farmacia_servicio.mapper;

import com.f_rafael.farmacia_servicio.dto.*;
import com.f_rafael.farmacia_servicio.model.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MedicamentoMapper {

    public MedicamentoDto obtenerDto(Medicamento medicamento){
        MedicamentoDto dtoARetornar = new MedicamentoDto();

        // Optional<PrincipioActivo> optionalPrincipioActivo = Optional.of(medicamento.getPrincipioActivo());
        // Optional<FormaFarmaceutica> optionalFormaFarmaceutica = Optional.of(medicamento.getFormaFarmaceutica());
        // Optional<AdministracionFarmaco> optionalAdministracionFarmaco = Optional.of(medicamento.getAdministracion());
        // Optional<MarcaMedicamento> optionalMarca = Optional.of(medicamento.getMarca());

        Set<SubPrincipioActivoDto> principiosActivosParaAsignar;
        SubPrincipioActivoDto princpioActivoParaAgregar;
        SubFormaFarmaceuticaDto formafarmaceuticaParaAsignar;
        SubAdministracionFarmacoDto administracionParaAsignar;
        SubMarcaMedicamentoDto marcaParaAsignar;
        Set<PrincipioActivo> informacionPrincipiosActivos = medicamento.getPrincipiosActivos();

        if(informacionPrincipiosActivos != null){/*
            principiosActivosParaAsignar = new SubPrincipioActivoDto(medicamento.getPrincipiosActivos().getId(),
                    medicamento.getPrincipiosActivos().getNombre());
            dtoARetornar.setPrincipioActivo(principiosActivosParaAsignar);*/

            principiosActivosParaAsignar = new HashSet<>();

            for(PrincipioActivo pa : informacionPrincipiosActivos){
                princpioActivoParaAgregar = new SubPrincipioActivoDto(pa.getId(), pa.getNombre());
                principiosActivosParaAsignar.add(princpioActivoParaAgregar);
            }

            dtoARetornar.setPrincipiosActivos(principiosActivosParaAsignar);
        }

        if(medicamento.getFormaFarmaceutica() != null){
            formafarmaceuticaParaAsignar = new SubFormaFarmaceuticaDto(medicamento.getFormaFarmaceutica().getId(),
                    medicamento.getFormaFarmaceutica().getNombre());
            dtoARetornar.setFormaFarmaceutica(formafarmaceuticaParaAsignar);
        }

        if(medicamento.getAdministracion() != null){
            administracionParaAsignar = new SubAdministracionFarmacoDto(medicamento.getAdministracion().getId(),
                    medicamento.getAdministracion().getVia());
            dtoARetornar.setAdministracion(administracionParaAsignar);
        }

        if(medicamento.getMarca() !=  null){
            marcaParaAsignar = new SubMarcaMedicamentoDto(medicamento.getMarca().getId(),
                    medicamento.getMarca().getNombre());
            dtoARetornar.setMarca(marcaParaAsignar);
        }

        return dtoARetornar;
    }

    public List<MedicamentoDto> obtenerListaDto(Collection<Medicamento> coleccionMedicamento){
        List<MedicamentoDto> listaARetornar = new LinkedList<>();

        for(Medicamento m : coleccionMedicamento){
            listaARetornar.add(obtenerDto(m));
        }

        return listaARetornar;
    }
}
