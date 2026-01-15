package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.MedicamentoDto;
import com.f_rafael.farmacia_servicio.mapper.StringMapper;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.service.IMedicamentoService;
import com.f_rafael.farmacia_servicio.utils.Transformacion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
@AllArgsConstructor
public class MedicamentoController {

    private IMedicamentoService service;
    private StringMapper stringMapper;

    @GetMapping("/{id}") // funciona
    public ResponseEntity<MedicamentoDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<MedicamentoDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/nombre") // funciona
    public ResponseEntity<MedicamentoDto> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @GetMapping("/principio-activo") // funciona
    public ResponseEntity<List<MedicamentoDto>> buscarPorPrincipioActivo(@RequestParam("nombre-principio-activo") String nombrePrincipioActivo){
        //String principioActivoSinGuiones = stringMapper.removerGuionesBajos(nombrePrincipioActivo);
        return ResponseEntity.ok(service.buscarPorPrincipioActivo(nombrePrincipioActivo));
    }

    @GetMapping("/forma-farmaceutica") // funciona
    public ResponseEntity<List<MedicamentoDto>> buscarPorFormaFarmaceutica(@RequestParam("nombre-forma-farmaceutica") String nombreFormaFarmaceutica){
        //String formaFarmaceuticaSinGuiones = Transformacion.removerGuionesBajos(nombreFormaFarmaceutica);
        return ResponseEntity.ok(service.buscarPorFormaFarmaceutica(nombreFormaFarmaceutica));
    }

    @GetMapping("/administracion") // funciona
    public ResponseEntity<List<MedicamentoDto>> buscarPorAdminiastracion(@RequestParam("via") String via){
        //String viaSinGuiones = Transformacion.removerGuionesBajos(via);
        return ResponseEntity.ok(service.buscarPorAdministracion(via));
    }

    @GetMapping("/marca") // funciona
    public ResponseEntity<List<MedicamentoDto>> buscarPorMarca(@RequestParam("nombre-marca") String nombreMarca){
        //String marcaSinGuiones = Transformacion.removerGuionesBajos(nombreMarca);
        return ResponseEntity.ok(service.buscarPorMarca(nombreMarca));
    }

    @PostMapping // funciona
    public ResponseEntity<MedicamentoDto> guardar(@RequestBody Medicamento medicamento){
        return new ResponseEntity<>(service.guardar(medicamento),HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<MedicamentoDto> actualizar(@RequestBody Medicamento medicamento){
        return ResponseEntity.ok(service.actualizar(medicamento));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/nombre") // funciona
    public ResponseEntity<String> modificarNombre(@PathVariable Long id,@RequestParam String nombre){
        service.modificarNombre(id, nombre);
        return new ResponseEntity<>("Entidad modificada exitosamente", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/agregar-principio-activo") // funciona
    public ResponseEntity<String> agregarPrincipioActivo(@PathVariable Long id,
                                                         @RequestParam("principio-activo-id") Long principioActivoId){
        service.agregarPrincpioActivo(id, principioActivoId);
        return new ResponseEntity<>("Entidad modificada correctamente", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/quitar-principio-activo") // funciona
    public ResponseEntity<String> quitarPrincipioActivo(@PathVariable Long id,
                                                        @RequestParam("principio-activo-id") Long principioActivoId){
        service.quitarPrincipioActivo(id, principioActivoId);
        return new ResponseEntity<>("Entidad modificada correctamente", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/forma-farmaceutica") // funciona
    public ResponseEntity<String> asignarFormaFarmaceutica(@PathVariable Long id,
                                                           @RequestParam("forma-farmaceutica-id") Long formaFarmaceuticaId){
        service.asignarFormaFarmaceutica(id,formaFarmaceuticaId);
        return new ResponseEntity<>("Entidad modificada correctamente", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/administracion") // funciona
    public ResponseEntity<String> asignarAdministracion(@PathVariable Long id,
                                                        @RequestParam("administracion-id") Long administracionId){
        service.asignarAdministracion(id,administracionId);
        return new ResponseEntity<>("Entidad modificada correctamente", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/marca") // funciona
    public ResponseEntity<String> asignarMarca(@PathVariable Long id,
                                               @RequestParam("marca-id") Long marcaId){
        service.asignarMarca(id,marcaId);
        return new ResponseEntity<>("Entidad modificada correctamente",HttpStatusCode.valueOf(204));
    }
}
