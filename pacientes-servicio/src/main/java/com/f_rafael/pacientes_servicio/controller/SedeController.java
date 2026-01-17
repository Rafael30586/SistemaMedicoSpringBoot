package com.f_rafael.pacientes_servicio.controller;

import com.f_rafael.pacientes_servicio.dto.SedeDto;
import com.f_rafael.pacientes_servicio.model.Sede;
import com.f_rafael.pacientes_servicio.service.ISedeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sedes")
@AllArgsConstructor
public class SedeController {

    private ISedeService service;

    @GetMapping("/{id}") // funciona
    public ResponseEntity<SedeDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<SedeDto>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/direccion") // funciona
    public ResponseEntity<List<SedeDto>> buscarPorDireccion(@RequestParam String calle){
        return ResponseEntity.ok(service.buscarPorDireccion(calle));
    }

    @GetMapping("/telefono") // funciona
    public ResponseEntity<SedeDto> buscarPorTelefono(@RequestParam String telefono){
        return ResponseEntity.ok(service.buscarPortelefono(telefono));
    }

    @PostMapping // funciona
    public ResponseEntity<SedeDto> guardar(@RequestBody Sede sede){
        return new ResponseEntity<>(service.guardar(sede), HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<SedeDto> actualizar(@RequestBody Sede sede){
        return ResponseEntity.ok(service.actualizar(sede));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarporId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/direccion") // funciona
    public ResponseEntity<SedeDto> actualizarDireccion(@PathVariable Long id,
                                                       @RequestParam("direccion-id") Long direccionId){
        return ResponseEntity.ok(service.actualizarDireccion(id,direccionId));
    }

    @PatchMapping("/{id}/agregar-telefono") // funciona
    public ResponseEntity<SedeDto> agregarTelefono(@PathVariable Long id,
                                                   @RequestParam String telefono){
        return ResponseEntity.ok(service.agregarTelefono(id,telefono));
    }

    @PatchMapping("/{id}/quitar-telefono") // funciona
    public ResponseEntity<SedeDto> quitarTelefono(@PathVariable Long id,
                                                  @RequestParam String telefono){
        return ResponseEntity.ok(service.quitarTelefono(id,telefono));
    }

    @PatchMapping("/{id}/obra-social") // funciona
    public ResponseEntity<SedeDto> actualizarObraSocial(@PathVariable Long id,
                                                        @RequestParam("obra-social-id") Long obraSocialId){
        return ResponseEntity.ok(service.actualizarObraSocial(id,obraSocialId));
    }
}
