package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.model.UnidadDeMedida;
import com.f_rafael.farmacia_servicio.service.IUnidadDeMedidaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/unidades-de-medida")
public class UnidadDeMedidaController {

    private IUnidadDeMedidaService service;

    @GetMapping("/{id}")
    public ResponseEntity<UnidadDeMedida> buscarPorId(@PathVariable Long id){

        if(service.buscarPorId(id).isEmpty()) {
            return new ResponseEntity<>(new UnidadDeMedida(-9999L,"Entidad no encontrada", null),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.buscarPorId(id).get());
    }

    @GetMapping
    public ResponseEntity<List<UnidadDeMedida>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping
    public ResponseEntity<UnidadDeMedida> buscarPorNombre(@RequestParam String nombre){

        if(service.buscarPorNombre(nombre).isEmpty()){
            return new ResponseEntity<>(new UnidadDeMedida(-99999L,null,null),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.buscarPorNombre(nombre).get());
    }

    @GetMapping
    public ResponseEntity<UnidadDeMedida> buscarPorSimbolo(@RequestParam String simbolo){

        if(service.buscarPorSimbolo(simbolo).isEmpty()){
            return new ResponseEntity<>(new UnidadDeMedida(-99999L,"Entidad no encontrada", null),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.buscarPorSimbolo(simbolo).get());
    }

    @PostMapping
    public ResponseEntity<UnidadDeMedida> guardar(@RequestBody UnidadDeMedida unidad){
        return ResponseEntity.ok(service.guardar(unidad));
    }

    @PutMapping
    public ResponseEntity<UnidadDeMedida> actualizar(@RequestBody UnidadDeMedida unidad){
        Long id = unidad.getId();

        if(id == null){
            return new ResponseEntity<>(new UnidadDeMedida(-9999L,"El id no debe ser nulo",null),
                    HttpStatusCode.valueOf(204));
        }

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new UnidadDeMedida(-9999L,"Entidad no encontrada",null),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.actualizar(unidad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>("Entidad no encontrada", HttpStatusCode.valueOf(204));
        }

        service.borrarPorId(id);
        return ResponseEntity.ok("Entidad borrada");
    }
}
