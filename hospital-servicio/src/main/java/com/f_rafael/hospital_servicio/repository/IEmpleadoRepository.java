package com.f_rafael.hospital_servicio.repository;

import com.f_rafael.hospital_servicio.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {

    public Optional<Empleado> findByDni(long dni);

    @Query("SELECT e FROM Empleado e WHERE e.primerNombre = :nombre OR e.segundoNombre = :nombre")
    public List<Empleado> buscarPorNombre(@Param("nombre") String nombre);
    @Query("SELECT e FROM Empleado e WHERE e.apellidoPaterno = :apellido OR e.apellidoMaterno = :apellido")
    public List<Empleado> buscarPorApellido(@Param("apellido") String apellido);
    public Optional<Empleado> findByEmail(String email);
    public Optional<Empleado> findByMatriculaProfesional(String matricula);
    @Query("SELECT e FROM  Empleado e LEFT JOIN FETCH e.rol WHERE e.rol.nombre = :rol")
    public List<Empleado> buscarPorRol(@Param("rol") String rol);
}
