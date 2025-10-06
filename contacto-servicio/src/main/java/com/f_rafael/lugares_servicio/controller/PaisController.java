package com.f_rafael.lugares_servicio.controller;

import com.f_rafael.lugares_servicio.model.Pais;
import com.f_rafael.lugares_servicio.service.IPaisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/paises")
public class PaisController {

    private IPaisService service;

    @GetMapping("/{id}")
    public ResponseEntity<Pais> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Pais>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Pais> guardar(@RequestBody Pais pais){
        return new ResponseEntity<>(service.guardar(pais), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<Pais> actualizar(@RequestBody Pais pais){
        return new ResponseEntity<>(service.actualizar(pais),HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }
}
