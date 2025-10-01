package com.f_rafael.lugares_servicio.controller;

import com.f_rafael.lugares_servicio.model.NumeroTelefonico;
import com.f_rafael.lugares_servicio.service.INumeroTelefonicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/numeros-telefonicos")
@AllArgsConstructor
public class NumeroTelefonicoController {

    private INumeroTelefonicoService service;

    @GetMapping("/{id}")
    public ResponseEntity<NumeroTelefonico> buscarPorId(@PathVariable Long id){

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new NumeroTelefonico(-99999L,"Entidad no encontrada",null),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.buscarPorId(id).get());
    }

    @GetMapping
    public ResponseEntity<List<NumeroTelefonico>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping
    public ResponseEntity<NumeroTelefonico> buscarPorNumero(@RequestParam String numero){

        if(service.buscarPorNumero(numero).isEmpty()){
            return new ResponseEntity<>(new NumeroTelefonico(-9999L,"Entidad no encontrada",null),
            HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.buscarPorNumero(numero).get());
    }

    @GetMapping
    public ResponseEntity<List<NumeroTelefonico>> buscarPorTipo(@RequestParam String tipo){
        return ResponseEntity.ok(service.buscarPorTipo(tipo));
    }

    @PostMapping
    public ResponseEntity<NumeroTelefonico> guardar(@RequestBody NumeroTelefonico telefono){
        return ResponseEntity.ok(service.guardar(telefono));
    }

    @PutMapping
    public ResponseEntity<NumeroTelefonico> actualizar(@RequestBody NumeroTelefonico telefono){
        Long id = telefono.getId();

        if(id == null){
            return new ResponseEntity<>(new NumeroTelefonico(-99999L,"El id no puede ser nulo",null),
                    HttpStatusCode.valueOf(204));
        }

        if(service.buscarPorNumero(telefono.getNumero()).isPresent()){
            return new ResponseEntity<>(new NumeroTelefonico(-99999L,"El numero de telefono ya existe",null),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.actualizar(telefono));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>("Entidad no encontrada",HttpStatusCode.valueOf(204));
        }

        service.borrarPorId(id);
        return ResponseEntity.ok("Entidad borrada correctamente");
    }
}
