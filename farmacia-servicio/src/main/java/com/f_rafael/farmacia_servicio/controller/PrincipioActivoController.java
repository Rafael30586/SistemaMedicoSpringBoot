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

    @GetMapping("/{id}")
    public ResponseEntity<PrincipioActivoDto> buscarPorId(@PathVariable Long id){
        PrincipioActivoDto dtoARetornar;

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new PrincipioActivoDto(-99999L,"Entidad no encontrada",null),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(Transformacion.dePrincipioActivoADto(service.buscarPorId(id).get()));
    }

    @GetMapping
    public ResponseEntity<List<PrincipioActivoDto>> buscarTodos(){
        return ResponseEntity.ok(Transformacion.obtenerListaDePrincipioActivoDto(service.buscarTodos()));
    }

    @GetMapping
    public ResponseEntity<List<PrincipioActivo>> buscarPorAccionTerapeutica(@RequestParam("nombre-accion-terapeutica") String nombreAccionTerapeutica){
        return ResponseEntity.ok(service.buscarPorAccionTerapeutica(nombreAccionTerapeutica));
    }

    @PostMapping
    public ResponseEntity<PrincipioActivoDto> guardar(@RequestBody PrincipioActivo principioActivo){
        PrincipioActivoDto dtoARetornar;
        PrincipioActivo informacionPrincipioActivo = service.guardar(principioActivo);
        dtoARetornar = Transformacion.dePrincipioActivoADto(informacionPrincipioActivo);
        return ResponseEntity.ok(dtoARetornar);
    }

    @PutMapping
    public ResponseEntity<PrincipioActivoDto> actualizar(@RequestBody PrincipioActivo principioActivo){
        Long id = principioActivo.getId();
        PrincipioActivo informacionPrincipioActivo;
        PrincipioActivoDto dtoARetornar;

        if(id == null){
            return new ResponseEntity<>(new PrincipioActivoDto(-99999L,"El id no puede ser nulo",null),
                    HttpStatusCode.valueOf(204));
        }

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new PrincipioActivoDto(-99999L,"Entidad no encontrada",null),
                    HttpStatusCode.valueOf(204));
        }

        informacionPrincipioActivo = service.actualizar(principioActivo);
        dtoARetornar = Transformacion.dePrincipioActivoADto(informacionPrincipioActivo);

        return ResponseEntity.ok(dtoARetornar);
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
