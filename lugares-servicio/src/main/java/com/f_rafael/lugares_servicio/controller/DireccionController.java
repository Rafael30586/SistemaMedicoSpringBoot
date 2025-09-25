package com.f_rafael.lugares_servicio.controller;

import com.f_rafael.lugares_servicio.model.Direccion;
import com.f_rafael.lugares_servicio.service.IDireccionService;
import com.f_rafael.lugares_servicio.utils.Transform;
import lombok.AllArgsConstructor;
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

        if(service.buscarPorId(id).isPresent()){
            return ResponseEntity.ok(service.buscarPorId(id).get());
        }else{
            return ResponseEntity.ok(new Direccion(-99999L,null,null,null,null));
        }

    }

    @GetMapping
    public ResponseEntity<List<Direccion>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @PostMapping
    public ResponseEntity<Direccion> guardar(@RequestBody Direccion direccion){
        return ResponseEntity.ok(service.guardar(direccion));
    }

    @PutMapping
    public ResponseEntity<Direccion> actualizar(@RequestBody Direccion direccion){
        if(direccion.getId() == null){
            return ResponseEntity.ok(new Direccion(-999999L,"El id no puede ser nulo",null,null,null));
        }

        if(service.buscarPorId(direccion.getId()).isPresent()){
            return ResponseEntity.ok(service.actualizar(direccion));
        }else{
            return ResponseEntity.ok(new Direccion(-99999L,"Direccion no encontrada",null,null,null));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){

        if(service.buscarPorId(id).isPresent()){
            service.borrarPorId(id);
            return ResponseEntity.ok("Direccion borrada correctamente");
        }else{
            return ResponseEntity.ok("Direccion no encontrada");
        }
    }

    @PatchMapping("/editar-calle/{id}") // La calle va con guiones bajos en lugar de espacios vacíos
    public ResponseEntity<Direccion> editarCalle(@PathVariable Long id,
                                                 @RequestParam("calle") String calle){
        Direccion direccionAEditar;

        if(service.buscarPorId(id).isEmpty()){
            return ResponseEntity.ok(new Direccion(-999999L,"Direccion no encontrada",null,null,null));
        }

        direccionAEditar = service.buscarPorId(id).get();
        direccionAEditar.setCalle(Transform.removerGuiones(calle));
        return ResponseEntity.ok(service.actualizar(direccionAEditar));
    }

    @PatchMapping("/editar-altura/{id}")
    public ResponseEntity<Direccion> editarAltura(@PathVariable Long id,
                                                 @RequestParam("altura") Integer altura){
        Direccion direccionAEditar;

        if(service.buscarPorId(id).isEmpty()){
            return ResponseEntity.ok(new Direccion(-999999L,"Direccion no encontrada",null,null,null));
        }

        direccionAEditar = service.buscarPorId(id).get();
        direccionAEditar.setAltura(altura);
        return ResponseEntity.ok(service.actualizar(direccionAEditar));
    }

    @PatchMapping("/editar-departamento/{id}") // El departamento va con guiones bajos en lugar de espacios vacíos
    public ResponseEntity<Direccion> editarDepartamento(@PathVariable Long id,
                                                 @RequestParam("departamento") String departamento){
        Direccion direccionAEditar;

        if(service.buscarPorId(id).isEmpty()){
            return ResponseEntity.ok(new Direccion(-999999L,"Direccion no encontrada",null,null,null));
        }

        direccionAEditar = service.buscarPorId(id).get();
        direccionAEditar.setDepartamento(Transform.removerGuiones(departamento));
        return ResponseEntity.ok(service.actualizar(direccionAEditar));
    }
}
