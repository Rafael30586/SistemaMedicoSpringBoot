package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.SignoDto;
import com.f_rafael.hospital_servicio.model.Signo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ISignoService {

    public SignoDto buscarPorId(Long id);
    public List<SignoDto> buscarTodos();
    public SignoDto guardar(Signo signo);
    public SignoDto actualizar(Signo signo);
    public void borrarPorId(Long id);
    public SignoDto buscarPorNombre(String nombre);
    public List<SignoDto> buscarPorUnidad(String unidad);
    public List<SignoDto> buscarPorDescripcion(String secuencia);
}
