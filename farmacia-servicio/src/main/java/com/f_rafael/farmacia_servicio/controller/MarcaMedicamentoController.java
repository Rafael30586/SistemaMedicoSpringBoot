package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.model.MarcaMedicamento;
import com.f_rafael.farmacia_servicio.service.IMarcaMedicamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
@AllArgsConstructor
public class MarcaMedicamentoController {

    private IMarcaMedicamentoService service;

    @GetMapping("/{id}")
    public ResponseEntity<MarcaMedicamento> buscarPorId(@PathVariable Long id){

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new MarcaMedicamento(-99999L, null),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.buscarPorId(id).get());
    }

    @GetMapping
    public ResponseEntity<List<MarcaMedicamento>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping
    public ResponseEntity<MarcaMedicamento> buscarPorNombre(@RequestParam String nombre){

        if(service.buscarPorNombre(nombre).isEmpty()){
            return new ResponseEntity<>(new MarcaMedicamento(-99999L,"Entidad no encontrada"),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.buscarPorNombre(nombre).get());
    }

    @PostMapping
    public ResponseEntity<MarcaMedicamento> guardar(@RequestBody MarcaMedicamento marcaMedicamento){
        return ResponseEntity.ok(service.guardar(marcaMedicamento));
    }

    @PutMapping
    public ResponseEntity<MarcaMedicamento> actualizar(@RequestBody MarcaMedicamento marcaMedicamento){
        Long id = marcaMedicamento.getId();

        if(id == null){
            return new ResponseEntity<>(new MarcaMedicamento(-99999L,"El id no debe ser nulo"),
                    HttpStatusCode.valueOf(204));
        }

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new MarcaMedicamento(-9999999L, "Entidad no encontrada"),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.actualizar(marcaMedicamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity("Entidad nbo encontrada",
                    HttpStatusCode.valueOf(204));
        }

        service.borrarPorId(id);
        return ResponseEntity.ok("Entidad borrada exitosamente");
    }
}
