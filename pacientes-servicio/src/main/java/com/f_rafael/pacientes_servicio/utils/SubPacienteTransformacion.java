package com.f_rafael.pacientes_servicio.utils;

import com.f_rafael.pacientes_servicio.dto.NumeroTelefonicoDto;
import com.f_rafael.pacientes_servicio.dto.SubPacienteDto;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.repository.INumeroTelefonicoClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
public class SubPacienteTransformacion {

    private INumeroTelefonicoClient numeroTelefonicoClient;

    public SubPacienteDto obtenerDto(Paciente paciente){
        SubPacienteDto dtoARetornar = new SubPacienteDto();
        Set<Long> telefonosIds;
        Set<NumeroTelefonicoDto> telefonosParaAsignar;

        dtoARetornar.setId(paciente.getId());
        dtoARetornar.setDni(paciente.getDni());
        dtoARetornar.setPrimerNombre(paciente.getPrimerNombre());
        dtoARetornar.setSegundoNombre(paciente.getSegundoNombre());
        dtoARetornar.setApellidoPaterno(paciente.getApellidoPaterno());
        dtoARetornar.setApellidoMaterno(paciente.getApellidoMaterno());
        dtoARetornar.setFechaNacimiento(paciente.getFechaNacimiento());
        dtoARetornar.setEmail(paciente.getEmail());

        if(paciente.getTelefonosId() != null){
            telefonosIds = paciente.getTelefonosId();
            telefonosParaAsignar = new HashSet<>();

            for(Long id : telefonosIds){
                telefonosParaAsignar.add(numeroTelefonicoClient.obtenerInformacionDeNumerosTelefonicos(id));
            }

            dtoARetornar.setTelefonos(telefonosParaAsignar);
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
