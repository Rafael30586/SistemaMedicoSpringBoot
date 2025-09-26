package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.service.IAccionTerapeuticaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acciones-terapeuteicas")
@AllArgsConstructor
public class AccionTerapeuticaController {

    private IAccionTerapeuticaService service;

    @GetMapping("/{id}")
    public ResponseEntity<AccionTerapeutica> buscarPorId(@PathVariable Long id){
        if(service.buscarPorId(id).isPresent()){
            return new ResponseEntity<>(service.buscarPorId(id).get(), HttpStatusCode.valueOf(201));
        }else{
            return ResponseEntity.ok(new AccionTerapeutica(-99999L,
                    "El id no corresponde a ninguna acción terapéutica",
                    null));
        }
    }

    @GetMapping
    public ResponseEntity<List<AccionTerapeutica>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @PostMapping
    public ResponseEntity<AccionTerapeutica> guardar(@RequestBody AccionTerapeutica accionTerapeutica){
        return ResponseEntity.ok(service.guardar(accionTerapeutica));
    }

    @PutMapping
    public ResponseEntity<AccionTerapeutica> actualizar(@RequestBody AccionTerapeutica accionTerapeutica){
        Long id = accionTerapeutica.getId();

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new AccionTerapeutica(-99999999L,"Accion terapéutica no encontrada",null),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.actualizar(accionTerapeutica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>("El id no corresponde a ninguna entidad de la base de datos",
                    HttpStatusCode.valueOf(204));
        }else{
            service.borrarPorId(id);
            return new ResponseEntity<>("Entidad borrada correctamente",
                    HttpStatusCode.valueOf(200));
        }

    }
}
