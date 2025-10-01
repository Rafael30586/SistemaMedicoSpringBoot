package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.MarcaMedicamentoDto;
import com.f_rafael.farmacia_servicio.model.MarcaMedicamento;
import com.f_rafael.farmacia_servicio.service.IMarcaMedicamentoService;
import com.f_rafael.farmacia_servicio.utils.TransformacionMarcaMedicamento;
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
    public ResponseEntity<MarcaMedicamentoDto> buscarPorId(@PathVariable Long id){

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(TransformacionMarcaMedicamento.obtenerDto(new MarcaMedicamento(-99999L, null,null)),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(TransformacionMarcaMedicamento.obtenerDto(service.buscarPorId(id).get()));
    }

    @GetMapping
    public ResponseEntity<List<MarcaMedicamentoDto>> buscarTodas(){
        return ResponseEntity.ok(TransformacionMarcaMedicamento.obtenerListaDtos(service.buscarTodas()));
    }

    @GetMapping
    public ResponseEntity<MarcaMedicamentoDto> buscarPorNombre(@RequestParam String nombre){

        if(service.buscarPorNombre(nombre).isEmpty()){
            return new ResponseEntity<>(TransformacionMarcaMedicamento.obtenerDto(new MarcaMedicamento(-99999L,"Entidad no encontrada",null)),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(TransformacionMarcaMedicamento.obtenerDto(service.buscarPorNombre(nombre).get()));
    }

    @PostMapping
    public ResponseEntity<MarcaMedicamentoDto> guardar(@RequestBody MarcaMedicamento marcaMedicamento){
        return ResponseEntity.ok(TransformacionMarcaMedicamento.obtenerDto(service.guardar(marcaMedicamento)));
    }

    @PutMapping
    public ResponseEntity<MarcaMedicamentoDto> actualizar(@RequestBody MarcaMedicamento marcaMedicamento){
        Long id = marcaMedicamento.getId();

        if(id == null){
            return new ResponseEntity<>(TransformacionMarcaMedicamento.obtenerDto(new MarcaMedicamento(-99999L,"El id no debe ser nulo",null)),
                    HttpStatusCode.valueOf(204));
        }

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(TransformacionMarcaMedicamento.obtenerDto(new MarcaMedicamento(-9999999L, "Entidad no encontrada",null)),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(TransformacionMarcaMedicamento.obtenerDto(service.actualizar(marcaMedicamento)));
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
