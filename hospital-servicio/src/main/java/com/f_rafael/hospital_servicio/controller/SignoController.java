package com.f_rafael.hospital_servicio.controller;

import com.f_rafael.hospital_servicio.dto.SignoDto;
import com.f_rafael.hospital_servicio.dto.TextoDto;
import com.f_rafael.hospital_servicio.model.Signo;
import com.f_rafael.hospital_servicio.service.ISignoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/signos")
public class SignoController {

    private ISignoService service;

    @GetMapping("/{id}")
    public ResponseEntity<SignoDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<SignoDto>> buscarTodos(){
        return ResponseEntity.ok(service. buscarTodos());
    }

    @GetMapping("/nombre")
    public ResponseEntity<SignoDto> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @GetMapping("/unidad")
    public ResponseEntity<List<SignoDto>> buscarPorUnidad(@RequestParam String unidad){
        return ResponseEntity.ok(service.buscarPorUnidad(unidad));
    }

    @GetMapping("/descripcion")
    public ResponseEntity<List<SignoDto>> buscarPorDescripcion(@RequestParam String secuencia){
        return ResponseEntity.ok(service.buscarPorDescripcion(secuencia));
    }

    @PostMapping
    public ResponseEntity<SignoDto> guardar(@RequestBody Signo signo){
        return new ResponseEntity<>(service.guardar(signo), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<SignoDto> actualizar(@RequestBody Signo signo){
        return ResponseEntity.ok(service.actualizar(signo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("El signo ha sido borrado", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/nombre")
    public ResponseEntity<SignoDto> modificarNombre(@PathVariable Long id,
                                                    @RequestParam String nombre){
        return ResponseEntity.ok(service.modificarNombre(id, nombre));
    }

    @PatchMapping("/{id}/valor-minimo")
    public ResponseEntity<SignoDto> modificarValorMinimo(@PathVariable Long id,
                                                         @RequestParam("valor-minimo") Double valorMinimo){
        return ResponseEntity.ok(service.modificarValorMinimo(id, valorMinimo));
    }

    @PatchMapping("/{id}/valor-maximo")
    public ResponseEntity<SignoDto> modificarValorMaximo(@PathVariable Long id,
                                                         @RequestParam("valor-maximo") Double valorMaximo){
        return ResponseEntity.ok(service.modificarValorMaximo(id, valorMaximo));
    }

    @PatchMapping("/id/unidad")
    public ResponseEntity<SignoDto> modificarUnidad(@PathVariable Long id,
                                                    @RequestParam("unidad-id") Long unidadId){
        return ResponseEntity.ok(service.modificarUnidad(id, unidadId));
    }

    @PatchMapping("/{id}/descripcion")
    public ResponseEntity<SignoDto> modificarDescripcion(@PathVariable Long id,
                                                         @RequestBody TextoDto descripcion){
        return ResponseEntity.ok(service.modificarDescripcion(id, descripcion));
    }
}
