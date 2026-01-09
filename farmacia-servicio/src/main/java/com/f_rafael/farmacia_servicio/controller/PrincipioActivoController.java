package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.PrincipioActivoDto;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;
import com.f_rafael.farmacia_servicio.service.IPrincipioActivoService;
import com.f_rafael.farmacia_servicio.utils.Transformacion;
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

    @GetMapping("/{id}") // funciona
    public ResponseEntity<PrincipioActivoDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<PrincipioActivoDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/nombre") // funciona
    public ResponseEntity<PrincipioActivoDto> buscarPorNombre(@RequestParam String nombre){
        //String nombreSinGuiones = Transformacion.removerGuionesBajos(nombre);
        return new ResponseEntity<>(service.buscarPorNombre(nombre),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/accion-terapeutica") // funciona
    public ResponseEntity<List<PrincipioActivoDto>> buscarPorAccionTerapeutica(@RequestParam("nombre-accion-terapeutica") String nombreAccionTerapeutica){
        // String accionTerapeuticaSinGuiones = Transformacion.removerGuionesBajos(nombreAccionTerapeutica);
        return ResponseEntity.ok(service.buscarPorAccionTerapeutica(nombreAccionTerapeutica));
    }

    @PostMapping // funciona
    public ResponseEntity<PrincipioActivoDto> guardar(@RequestBody PrincipioActivo principioActivo){
        return new ResponseEntity<>(service.guardar(principioActivo),HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<PrincipioActivoDto> actualizar(@RequestBody PrincipioActivo principioActivo){
        return ResponseEntity.ok(service.actualizar(principioActivo));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada corrctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/agregar-accion-terapeutica") // funciona
    public ResponseEntity<String> agregarAccionTerapeutica(@PathVariable Long id,
                                                           @RequestParam("accion-terapeutica-id") Long accionTerapeuticaId){
        service.agregarAccionTerapeutica(id,accionTerapeuticaId);
        return new ResponseEntity<>("Entidad modificada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/quitar-accion-terapeutica") // funciona
    public ResponseEntity<String> quitarAccionTerapeutica(@PathVariable Long id,
                                                           @RequestParam("accion-terapeutica-id") Long accionTerapeuticaId){
        service.quitarAccionTerapeutica(id,accionTerapeuticaId);
        return new ResponseEntity<>("Entidad modificada correctamente",HttpStatusCode.valueOf(204));
    }
}
