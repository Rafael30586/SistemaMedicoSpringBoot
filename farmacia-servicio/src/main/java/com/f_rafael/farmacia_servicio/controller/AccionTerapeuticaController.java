package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.AccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.service.IAccionTerapeuticaService;
import com.f_rafael.farmacia_servicio.utils.Transformacion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acciones-terapeuteicas")
@AllArgsConstructor
public class AccionTerapeuticaController {

    private IAccionTerapeuticaService service;

    @GetMapping("/{id}")
    public ResponseEntity<AccionTerapeuticaDto> buscarPorId(@PathVariable Long id){
        AccionTerapeuticaDto dtoARetornar;
        Optional<AccionTerapeutica> accionTerapeuticaOptional = service.buscarPorId(id);

        if(accionTerapeuticaOptional.isEmpty()){
            return new ResponseEntity<>(new AccionTerapeuticaDto(-999999L,"Entidad no encontrada",null),
                    HttpStatusCode.valueOf(204));
        }

        dtoARetornar = Transformacion.deAccionTerapeuticaADto(accionTerapeuticaOptional.get());

        return ResponseEntity.ok(dtoARetornar);
    }

    @GetMapping
    public ResponseEntity<List<AccionTerapeuticaDto>> buscarTodas(){
        List<AccionTerapeuticaDto> dtosARetornar = Transformacion.obtenerListaDeAccionesTerapeuticasDto(service.buscarTodas());
        return ResponseEntity.ok(dtosARetornar);
    }

    @GetMapping
    public ResponseEntity<AccionTerapeuticaDto> buscarPorNombre(@RequestParam String nombre){
        AccionTerapeuticaDto dtoARetornar;
        AccionTerapeutica informacionAccionTerapeutica;

        if(service.buscarPorNombre(nombre).isEmpty()){
            return new ResponseEntity<>(new AccionTerapeuticaDto(-9999L,"Entidad no encontrada",null),
                    HttpStatusCode.valueOf(204));
        }

        informacionAccionTerapeutica = service.buscarPorNombre(nombre).get();
        dtoARetornar = Transformacion.deAccionTerapeuticaADto(informacionAccionTerapeutica);
        return ResponseEntity.ok(dtoARetornar);
    }

    @GetMapping
    public ResponseEntity<List<AccionTerapeuticaDto>> buscarPorSecuenciaEnDescripcion(@RequestParam String secuencia){
        List<AccionTerapeutica> informacionAccionesTerapeuticas = service.buscarPorSecuenciaEnDescripcion(secuencia);

        return ResponseEntity.ok(Transformacion.obtenerListaDeAccionesTerapeuticasDto(informacionAccionesTerapeuticas));
    }

    @PostMapping
    public ResponseEntity<AccionTerapeuticaDto> guardar(@RequestBody AccionTerapeutica accionTerapeutica){
        AccionTerapeutica informacionAccionTerapeutica = service.guardar(accionTerapeutica);
        AccionTerapeuticaDto dtoARetornar = Transformacion.deAccionTerapeuticaADto(informacionAccionTerapeutica);
        return ResponseEntity.ok(dtoARetornar);
    }

    @PutMapping
    public ResponseEntity<AccionTerapeuticaDto> actualizar(@RequestBody AccionTerapeutica accionTerapeutica){
        Long id = accionTerapeutica.getId();
        AccionTerapeuticaDto dtoARetornar;
        Optional<AccionTerapeutica> accionTerapeuticaOptional = service.buscarPorId(id);

        if(id == null){
            return new ResponseEntity<>(new AccionTerapeuticaDto(-9999L,"El id no debe ser nulo",null),
                    HttpStatusCode.valueOf(204));
        }

        if(accionTerapeuticaOptional.isEmpty()){
            return new ResponseEntity<>(new AccionTerapeuticaDto(-99999999L,"Accion terapéutica no encontrada",null),
                    HttpStatusCode.valueOf(204));
        }

        dtoARetornar = Transformacion.deAccionTerapeuticaADto(accionTerapeuticaOptional.get());

        return ResponseEntity.ok(dtoARetornar);
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

    @PatchMapping("/cambiar-nombre/{id}")
    public ResponseEntity<AccionTerapeuticaDto> modificarNombre(@PathVariable Long id, @RequestParam String nombre){
        String nombreSinGuiones = Transformacion.removerGuionesBajos(nombre);
        AccionTerapeutica accionTerapeuticaAEditar;
        AccionTerapeuticaDto dtoARetornar;
        AccionTerapeutica informacionAccinTerapeutica;


        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new AccionTerapeuticaDto(-99999L,"Entidad no encontrada",null),
                    HttpStatusCode.valueOf(204));
        }

        accionTerapeuticaAEditar = service.buscarPorId(id).get();
        accionTerapeuticaAEditar.setNombre(nombreSinGuiones);
        informacionAccinTerapeutica = service.actualizar(accionTerapeuticaAEditar);

        return ResponseEntity.ok(Transformacion.deAccionTerapeuticaADto(informacionAccinTerapeutica));
    }
}
