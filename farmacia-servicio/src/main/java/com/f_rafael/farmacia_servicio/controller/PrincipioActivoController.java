package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;
import com.f_rafael.farmacia_servicio.service.IPrincipioActivoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/principios-activos")
@AllArgsConstructor
public class PrincipioActivoController {

    private IPrincipioActivoService service;

    @GetMapping("/{id}")
    public ResponseEntity<PrincipioActivo> buscarPorId(@PathVariable Long id){

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new PrincipioActivo(-99999L,"Entidad no encontrada",null),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.buscarPorId(id).get());
    }

    @GetMapping
    public ResponseEntity<List<PrincipioActivo>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<PrincipioActivo> guardar(@RequestBody PrincipioActivo principioActivo){
        return ResponseEntity.ok(service.guardar(principioActivo));
    }

    @PutMapping
    public ResponseEntity<PrincipioActivo> actualizar(@RequestBody PrincipioActivo principioActivo){
        Long id = principioActivo.getId();

        if(id == null){
            return new ResponseEntity<>(new PrincipioActivo(-99999L,"El id no puede ser nulo",null),
                    HttpStatusCode.valueOf(204));
        }

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new PrincipioActivo(-99999L,"Entidad no encontrada",null),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.actualizar(principioActivo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>("Entidad no encontrada",
                    HttpStatusCode.valueOf(204));
        }

        service.borrarPorId(id);
        return ResponseEntity.ok("Entidad borrada exitosamente");
    }
}
