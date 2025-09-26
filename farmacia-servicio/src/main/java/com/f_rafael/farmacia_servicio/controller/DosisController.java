package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.model.Dosis;
import com.f_rafael.farmacia_servicio.service.IDosisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dosis")
@AllArgsConstructor
public class DosisController {

    private IDosisService service;

    @GetMapping("/{id}")
    public ResponseEntity<Dosis> buscarPorId(@PathVariable Long id){
        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new Dosis(-99999L,null,null,null),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.buscarPorId(id).get());
    }

    @GetMapping
    public ResponseEntity<List<Dosis>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @PostMapping
    public ResponseEntity<Dosis> guardar(@RequestBody Dosis dosis){
        return new ResponseEntity<>(service.guardar(dosis),
                HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<Dosis> actualizar(@RequestBody Dosis dosis){
        long id = dosis.getId();

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new Dosis(-99999L,null,null,null),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.actualizar(dosis));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){

        if(service.buscarPorId(id).isEmpty()) {
            return new ResponseEntity<>("Entidad no encontrada",
                    HttpStatusCode.valueOf(204));
        }

        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",
                HttpStatusCode.valueOf(200));

    }
}
