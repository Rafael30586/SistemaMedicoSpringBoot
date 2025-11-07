package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.model.RolEmpleado;

import java.util.List;

public interface IRolEmpleadoService {
    public RolEmpleado buscarPorId(Long id);
    public List<RolEmpleado> buscarTodos();
    public RolEmpleado guardar(RolEmpleado rolEmpleado);
    public RolEmpleado actualizar(RolEmpleado rolEmpleado);
    public void borrarPorId(Long id);
    public RolEmpleado buscarPorNombre(String nombre);
    public List<RolEmpleado> buscarPorSector(String sector);
    public RolEmpleado modificarNombre(Long id, String nombre);
    public RolEmpleado modificarSector(Long id, Long sectorId);
}
