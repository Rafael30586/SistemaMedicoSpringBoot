package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.StringMapper;
import com.f_rafael.hospital_servicio.model.Sector;
import com.f_rafael.hospital_servicio.repository.ISectorRepository;
import com.f_rafael.hospital_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SectorService implements ISectorService{

    private ISectorRepository repository;
    private StringMapper stringMapper;
    private Verificador verificador;

    @Override
    public Sector buscarPorId(Long id) {
        return devolverPorId(id);
    }

    @Override
    public List<Sector> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Sector guardar(Sector sector) {
        String nombreSector = sector.getNombre();

        if(nombreSector == null){
            throw new CampoNuloException("El nombre del sector no puede ser nulo");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombreSector);

        return repository.save(sector);
    }

    @Override
    public Sector actualizar(Sector sector) {

        if(sector.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo en una actualización");
        }
        return this.guardar(sector);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Sector no encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public Sector buscarPorNombre(String nombre) {
        String nombreSinGuiones = stringMapper.quitarGuionesBajos(nombre);
        return repository.findByNombre(nombreSinGuiones).orElseThrow(()-> new EntidadNoEncontradaException("Sector no encontrado"));
    }

    @Override
    public Sector modificarNombre(Long id, String nombre) {
        Sector sectorParaActualizar = devolverPorId(id);
        String nombreSinGuiones = stringMapper.quitarGuionesBajos(nombre);

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombreSinGuiones);
        sectorParaActualizar.setNombre(nombreSinGuiones);

        return this.actualizar(sectorParaActualizar);
    }

    public Sector devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Sector no encontrado"));
    }
}
