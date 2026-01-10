package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.model.UnidadDeMedida;
import com.f_rafael.farmacia_servicio.service.IUnidadDeMedidaService;
import com.f_rafael.farmacia_servicio.utils.Transformacion;
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

    @GetMapping("/{id}") // funciona
    public ResponseEntity<UnidadDeMedida> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<UnidadDeMedida>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/nombre") // funciona
    public ResponseEntity<UnidadDeMedida> buscarPorNombre(@RequestParam String nombre){
        String nombreSinGuiones = Transformacion.removerGuionesBajos(nombre);
        return ResponseEntity.ok(service.buscarPorNombre(nombreSinGuiones));
    }

    @GetMapping("/simbolo") // funciona
    public ResponseEntity<UnidadDeMedida> buscarPorSimbolo(@RequestParam String simbolo){
        return ResponseEntity.ok(service.buscarPorSimbolo(simbolo));
    }

    @PostMapping // funciona
    public ResponseEntity<UnidadDeMedida> guardar(@RequestBody UnidadDeMedida unidad){
        return new ResponseEntity<>(service.guardar(unidad),HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<UnidadDeMedida> actualizar(@RequestBody UnidadDeMedida unidad){
        return ResponseEntity.ok(service.actualizar(unidad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada exitosamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/nombre")
    public ResponseEntity<String> modificarNombre(@PathVariable Long id, @RequestParam String nombre){
        service.modificarNombre(id,nombre);
        return new ResponseEntity<>("Entidad modificada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/simbolo")
    public ResponseEntity<String> modificarSimbolo(@PathVariable Long id, @RequestParam String simbolo){
        service.modificarSimbolo(id, simbolo);
        return new ResponseEntity<>("Entidad modificada correctamente",HttpStatusCode.valueOf(204));
    }
}
