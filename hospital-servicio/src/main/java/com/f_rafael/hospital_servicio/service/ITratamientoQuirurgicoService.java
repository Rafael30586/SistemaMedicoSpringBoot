package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.model.TratamientoQuirurgico;

import java.util.List;

public interface ITratamientoQuirurgicoService {
    public TratamientoQuirurgico buscarPorId(Long id);
    public List<TratamientoQuirurgico> buscarTodos();
    public TratamientoQuirurgico guardar(TratamientoQuirurgico tratamientoQuirurgico);
    public TratamientoQuirurgico actualizar(TratamientoQuirurgico tratamientoQuirurgico);
    public void borrarPorId(Long id);
    public TratamientoQuirurgico buscarPorNombre(String nombre);
    public List<TratamientoQuirurgico> buscarPorDescripcion(String secuencia);
}
