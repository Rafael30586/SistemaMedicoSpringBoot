package com.f_rafael.pacientes_servicio.mapper;


import com.f_rafael.pacientes_servicio.dto.LocalidadDto;
import com.f_rafael.pacientes_servicio.dto.SubPacienteDto;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.repository.IContactoClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
public class SubPacienteMapper {

    // private INumeroTelefonicoClient numeroTelefonicoClient;
    private IContactoClient contactoClient;

    public SubPacienteDto obtenerDto(Paciente paciente){
        SubPacienteDto dtoARetornar = new SubPacienteDto();
        LocalidadDto localidadParaAsignar;
        Long lugarNacimentoId = paciente.getLugarNacimientoId();

        dtoARetornar.setId(paciente.getId());
        dtoARetornar.setDni(paciente.getDni());
        dtoARetornar.setPrimerNombre(paciente.getPrimerNombre());
        dtoARetornar.setSegundoNombre(paciente.getSegundoNombre());
        dtoARetornar.setApellidoPaterno(paciente.getApellidoPaterno());
        dtoARetornar.setApellidoMaterno(paciente.getApellidoMaterno());
        dtoARetornar.setFechaNacimiento(paciente.getFechaNacimiento());
        dtoARetornar.setEmail(paciente.getEmail());
        dtoARetornar.setTelefonos(paciente.getTelefonos());

        if(lugarNacimentoId != null){
            localidadParaAsignar = contactoClient.obtenerLocalidadPorId(lugarNacimentoId);
            dtoARetornar.setLugarNacimiento(localidadParaAsignar);
        }

        return dtoARetornar;
    }

    public List<SubPacienteDto> obtenerListaDto(Collection<Paciente> informacionPacientes){

        List<SubPacienteDto> listaARetornar = new LinkedList<>();

        for(Paciente p : informacionPacientes){
            listaARetornar.add(obtenerDto(p));
        }

        return listaARetornar;
    }
}
