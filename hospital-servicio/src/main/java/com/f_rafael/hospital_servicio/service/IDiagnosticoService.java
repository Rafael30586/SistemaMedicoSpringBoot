package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.DiagnosticoDto;
import com.f_rafael.hospital_servicio.model.Diagnostico;

import java.util.List;

public interface IDiagnosticoService {

    public DiagnosticoDto buscarPorId(Long id);
    public List<DiagnosticoDto> buscarTodos();
    public DiagnosticoDto guardar(Diagnostico diagnostico);
    public DiagnosticoDto actualizar(Diagnostico diagnostico);
    public void borrarPorId(Long id);
    public DiagnosticoDto buscarPorNombre(String nombre);
    public DiagnosticoDto modificarNombre(Long id, String nombre);
    public DiagnosticoDto agregarSintoma(Long id, Long sintomaId);
    public DiagnosticoDto quitarSintoma(Long id, Long sintomaId);
    public DiagnosticoDto agregarSigno(Long id, Long signoId);
    public DiagnosticoDto quitarSigno(Long id, Long signoId);
}
