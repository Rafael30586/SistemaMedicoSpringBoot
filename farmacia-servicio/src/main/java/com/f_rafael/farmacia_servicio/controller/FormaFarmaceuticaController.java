package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;
import com.f_rafael.farmacia_servicio.service.IFormaFarmaceuticaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formas-farmaceuticas")
@AllArgsConstructor
public class FormaFarmaceuticaController {

    private IFormaFarmaceuticaService service;

    @GetMapping("/{id}")
    public ResponseEntity<FormaFarmaceutica> buscarPorId(@PathVariable Long id){

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new FormaFarmaceutica(-99999L,"Entidad no encontrada"),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.buscarPorId(id).get());
    }

    @GetMapping
    public ResponseEntity<List<FormaFarmaceutica>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @PostMapping
    public ResponseEntity<FormaFarmaceutica> guardar(@RequestBody FormaFarmaceutica formaFarmaceutica){
        return ResponseEntity.ok(service.guardar(formaFarmaceutica));
    }

    @PutMapping
    public ResponseEntity<FormaFarmaceutica> actualizar(@RequestBody FormaFarmaceutica formaFarmaceutica){
        long id = formaFarmaceutica.getId();

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new FormaFarmaceutica(-99999L,"Entidad no encontrada"),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.actualizar(formaFarmaceutica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>("Entidad no encontrada",
                    HttpStatusCode.valueOf(204));
        }

        service.borrarPorId(id);
        return ResponseEntity.ok("Entidad borrada correctamente");
    }
}
