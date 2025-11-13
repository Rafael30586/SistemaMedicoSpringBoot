package com.f_rafael.hospital_servicio.controller;

import com.f_rafael.hospital_servicio.model.RolEmpleado;
import com.f_rafael.hospital_servicio.service.IRolEmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/roles-empleado")
@RestController
public class RolEmpleadoController {

    private IRolEmpleadoService service;

    @GetMapping("/{id}")
    public ResponseEntity<RolEmpleado> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<RolEmpleado>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping
    public ResponseEntity<RolEmpleado> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @GetMapping
    public ResponseEntity<List<RolEmpleado>> buscarPorSector(@RequestParam String sector){
        return ResponseEntity.ok(service.buscarPorSector(sector));
    }

    @PostMapping
    public ResponseEntity<RolEmpleado> guardar(@RequestBody RolEmpleado rolEmpleado){
        return ResponseEntity.ok(service.guardar(rolEmpleado));
    }

    @PutMapping
    public ResponseEntity<RolEmpleado> actualizar(@RequestBody RolEmpleado rolEmpleado){
        return ResponseEntity.ok(service.actualizar(rolEmpleado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("El rol ha sido borrado", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RolEmpleado> modificarNombre(@PathVariable Long id,
                                                       @RequestParam String nombre){
        return ResponseEntity.ok(service.modificarNombre(id, nombre));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RolEmpleado> modificarSector(@PathVariable Long id,
                                                       @RequestParam("sector-id") Long sectorId){
        return ResponseEntity.ok(service.modificarSector(id,sectorId));
    }
}
