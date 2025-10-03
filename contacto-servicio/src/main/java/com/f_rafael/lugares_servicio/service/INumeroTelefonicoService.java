package com.f_rafael.lugares_servicio.service;

import com.f_rafael.lugares_servicio.model.NumeroTelefonico;

import java.util.List;
import java.util.Optional;

public interface INumeroTelefonicoService {
    public NumeroTelefonico buscarPorId(Long id);
    public List<NumeroTelefonico> buscarTodos();
    public NumeroTelefonico guardar(NumeroTelefonico telefono);
    public NumeroTelefonico actualizar(NumeroTelefonico telefono);
    public void borrarPorId(Long id);
    public NumeroTelefonico buscarPorNumero(String numero);
    public List<NumeroTelefonico> buscarPorTipo(String tipo);
}
