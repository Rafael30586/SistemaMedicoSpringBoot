package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.MarcaMedicamentoDto;
import com.f_rafael.farmacia_servicio.model.MarcaMedicamento;
import com.f_rafael.farmacia_servicio.service.IMarcaMedicamentoService;
import com.f_rafael.farmacia_servicio.utils.Transformacion;
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

    @GetMapping("/{id}") // funciona
    public ResponseEntity<MarcaMedicamentoDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<MarcaMedicamentoDto>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/nombre") // funciona
    public ResponseEntity<MarcaMedicamentoDto> buscarPorNombre(@RequestParam String nombre){
        String nombreSinGuiones = Transformacion.removerGuionesBajos(nombre);
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @PostMapping // funciona
    public ResponseEntity<MarcaMedicamentoDto> guardar(@RequestBody MarcaMedicamento marcaMedicamento){
        return new ResponseEntity<>(service.guardar(marcaMedicamento),HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<MarcaMedicamentoDto> actualizar(@RequestBody MarcaMedicamento marcaMedicamento){
        return ResponseEntity.ok(service.actualizar(marcaMedicamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada exitosamente", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/nombre")
    public ResponseEntity<String> modificarNombre(@PathVariable Long id, @RequestParam String nombre){
        service.modificarNombre(id,nombre);
        return new ResponseEntity<>("Entidad modificada correctamente",HttpStatusCode.valueOf(204));
    }
}
