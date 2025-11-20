package com.f_rafael.farmacia_servicio.mapper;

import com.f_rafael.farmacia_servicio.dto.*;
import com.f_rafael.farmacia_servicio.model.*;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class MedicamentoMapper {

    public MedicamentoDto obtenerDto(Medicamento medicamento){
        MedicamentoDto dtoARetornar = new MedicamentoDto();

        Optional<PrincipioActivo> optionalPrincipioActivo = Optional.of(medicamento.getPrincipioActivo());
        Optional<FormaFarmaceutica> optionalFormaFarmaceutica = Optional.of(medicamento.getFormaFarmaceutica());
        Optional<AdministracionFarmaco> optionalAdministracionFarmaco = Optional.of(medicamento.getAdministracion());
        Optional<MarcaMedicamento> optionalMarca = Optional.of(medicamento.getMarca());

        SubPrincipioActivoDto principioActivoParaAsignar;
        SubFormaFarmaceuticaDto formafarmaceuticaParaAsignar;
        SubAdministracionFarmacoDto administracionParaAsignar;
        SubMarcaMedicamentoDto marcaParaAsignar;

        if(optionalPrincipioActivo.isPresent()){
            principioActivoParaAsignar = new SubPrincipioActivoDto(medicamento.getPrincipioActivo().getId(),
                    medicamento.getPrincipioActivo().getNombre());
            dtoARetornar.setPrincipioActivo(principioActivoParaAsignar);
        }

        if(optionalFormaFarmaceutica.isPresent()){
            formafarmaceuticaParaAsignar = new SubFormaFarmaceuticaDto(medicamento.getFormaFarmaceutica().getId(),
                    medicamento.getFormaFarmaceutica().getNombre());
            dtoARetornar.setFormaFarmaceutica(formafarmaceuticaParaAsignar);
        }

        if(optionalAdministracionFarmaco.isPresent()){
            administracionParaAsignar = new SubAdministracionFarmacoDto(medicamento.getAdministracion().getId(),
                    medicamento.getAdministracion().getVia());
            dtoARetornar.setAdministracion(administracionParaAsignar);
        }

        if(optionalMarca.isPresent()){
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
