package com.f_rafael.lugares_servicio.controller;

import com.f_rafael.lugares_servicio.model.Direccion;
import com.f_rafael.lugares_servicio.service.IDireccionService;
import com.f_rafael.lugares_servicio.utils.Transform;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/direcciones")
public class DireccionController {

    private IDireccionService service;

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> buscarPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.buscarPorId(id),HttpStatusCode.valueOf(200));

    }

    @GetMapping
    public ResponseEntity<List<Direccion>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/localidad")
    public ResponseEntity<List<Direccion>> buscarPorLocalidad(@RequestParam String localidad){
        return ResponseEntity.ok(service.buscarPorLocalidad(localidad));
    }

    @GetMapping("/provincia")
    public ResponseEntity<List<Direccion>> buscarPorProvincia(@RequestParam String provincia){
        return ResponseEntity.ok(service.buscarPorProvincia(provincia));
    }

    @PostMapping
    public ResponseEntity<Direccion> guardar(@RequestBody Direccion direccion){
        return new ResponseEntity<>(service.guardar(direccion),HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<Direccion> actualizar(@RequestBody Direccion direccion){
        return ResponseEntity.ok(service.actualizar(direccion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/calle")
    public ResponseEntity<String> editarCalle(@PathVariable Long id,
                                                 @RequestParam("calle") String calle){
        // String calleSinGuiones = Transform.removerGuiones(calle);
        service.editarCalle(id,calle);
        return new ResponseEntity<>("Direccion editada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/altura")
    public ResponseEntity<String> editarAltura(@PathVariable Long id,
                                                 @RequestParam("altura") Integer altura){
        service.editarAltura(id,altura);
        return new ResponseEntity<>("Entidad editada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/departamento") // El departamento va con guiones bajos en lugar de espacios vacíos
    public ResponseEntity<String> editarDepartamento(@PathVariable Long id,
                                                 @RequestParam("departamento") String departamento){
        // String departamentoSinGuiones = Transform.removerGuiones(departamento);

        service.editarDepartamento(id,departamento);
        return new ResponseEntity<>("Entidad editada correctamente",HttpStatusCode.valueOf(204));
    }
}
