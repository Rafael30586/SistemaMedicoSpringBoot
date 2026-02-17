# Sistema médico

## Esta aplicación ha sido desarrollada con Java y Spring boot utilizando IntelliJ IDEA. Consiste en cuatro microservicios: contacto, farmacia, paciente y hospital. El microservicio de contacto tiene las siguentes entidades: Direccion, Localidad, Pais y Provincia. Las entidades que componen al microservicio de farmacia son: AccionTerapeutica, AdministrcionFarmaco, Dosis, FormaFarmaceutica, MarcaMedicamento, Medicamento, PrincipioActivo y UnidadDeMedida. En el microservicio de paciente las entidades son: ObraSocial, Paciente, ResultadoDeEstudios, Sede, TurnoCita y TurnoEstudio. Para el microservicio de hospital las entidades son: CirugiaPaciente, Diagnostico, DiagnosticoPaciente, Empleado, EstudioMedico, EstudioMEdicoClasificacion, FisioterapiaPaciente, MedicamentoPaciente, PsicoterapiaPaciente, RadioTerpiaPaciente, RolEmpleado, Sector, Signo, Sintoma y TratamientoQuirurgico.

---

## Contacto

---

### Direccion

---

#### Solicitudes GET

##### {CONTACTO-SERVICIO}/direcciones/{id}

##### {CONTACTO-SERVICIO}/direcciones

##### {CONTACTO-SERVICIO}/direcciones/localidad?localidad=

##### {CONTACTO-SERVICIO}/direcciones/provincia?provincia=

---

#### Solicitudes POST

##### {CONTACTO-SERVICIO}/direcciones

---

#### Solicitued PUT

##### {CONTACTO-SERVICIO}/direcciones

---

#### Solicitudes DELETE

##### {CONTACTO-SERVICIO}/direcciones/{id}

---

#### Solicitudes PATCH

##### {CONTACTO-SERVICIO}/direcciones/{id}/calle?calle=

##### {CONTACTO-SERVICIO}/direcciones/{id}/altura?altura=

##### {CONTACTO-SERVICIO}/direcciones/{id}/departamento?departamento=

##### {CONTACTO-SERVICIO}/direcciones/{id}/localidad?localidad-id=

---

### Localidad

---

#### Solicitudes GET

##### {CONTACTO-SERVICIO}/localidades/{id}

##### {CONTACTO-SERVICIO}/localidades

---

#### Solicitudes POST

##### {CONTACTO-SERVICIO}/localidades

---

#### Solicitudes PUT

##### {CONTACTO-SERVICIO}/localidades

---

#### Solicitudes DELETE

##### {CONTACTO-SERVICIO}/localidades/{id}

---

#### Solicitudes PATCH

##### {CONTACTO-SERVICIO}/localidades/{id}/nombre?nombre=

##### {CONTACTO-SERVICIO}/localidades/{id}/provincia?provincia-id=

---

### Pais

---

#### Solicitudes GET

##### {CONTACTO-SERVICIO}/paises/{id}

##### {CONTACTO-SERVICIO}/paises

---

#### Solicitudes POST

##### {CONTACTO-SERVICIO}/paises

---

#### Solicitudes PUT

##### {CONTACTO-SERVICIO}/paises

---

#### Solicitudes DELETE

##### {CONTACTO-SERVICIO}/paises/{id}

---

#### Solicitudes PATCH

##### {CONTACTO-SERVICIO}/paises/{id}/nombre?nombre=

---

### Provincia

---

#### Solicitudes GET

##### {CONTACTO-SERVICIO}/provincias

##### {CONTACTO-SERVICIO}/provincias/{ID}

##### {CONTACTO-SERVICIO}/provincias/nombre?nombre=

---

#### Solicitudes POST

##### {CONTACTO-SERVICIO}/provincias

---

#### Solicitudes PUT

##### {CONTACTO-SERVICIO}/provincias

---

#### Solicitudes DELETE

##### {CONTACTO-SERVICIO}/provincias/{id}

---

#### Solicitudes PATCH

##### {CONTACTO-SERVICIO}/provincias/{id}/nombre?nombre=

##### {CONTACTO-SERVICIO}/provincias/{id}/pais?pais-id=

---

## Farmacia

---

### AccionTerapeutica

---

#### Solcitudes GET

##### {FARMACIA-SERVICIO}/acciones-terapeuticas

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/nombre?nombre=

---

#### Solicitudes POST

##### {FARMACIA-SERVICIO}/acciones-terapeuticas

---

#### Solicitudes PUT

##### {FARMACIA-SERVICIO}/acciones-terapeuticas

---

#### Solicitudes DELETE

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}

---

#### Solicitudes PATCH

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}/nombre?nombre=

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}/descripcion

---

### AdministracionFarmaco

---

#### Solicitudes GET

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/{id}

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/via?via=

---

#### Solicitudes POST

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco

---

#### Solicitudes PUT

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco

---

#### Solicitudes DELETE

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/{id}

---

#### Solicitudes PATCH

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/{id}/via?via=

---

### Dosis

---

#### Solicitudes GET

##### {FARMACIA-SERVICIO}/dosis/{id}

##### {FARMACIA-SERVICIO}/dosis

##### {FARMACIA-SERVICIO}/dosis/cantidad-unidad-intervalo?cantidad= &nombre-unidad= &intervalo=

---

#### Solicitudes POST

##### {FARMACIA-SERVICIO}/dosis

---

#### Solicitudes PUT

##### {FARMACIA-SERVICIO}/dosis

---

#### Solicitudes DELETE

##### {FARMACIA-SERVICIO}/dosis/{id}

---

#### Solicitudes PATCH

##### {FARMACIA-SERVICIO}/dosis/{id}/cantidad?cantidad=

##### {FARMACIA-SERVICIO}/dosis/{id}/unidad?unidad-id

##### {FARMACIA-SERVICIO}/dosis/{id}/intervalo?intervalo=

---

### FormaFarmaceutica

---

#### Solicitudes GET

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/{id}

##### {FARMACIA-SERVICIO}/formas-farmaceuticas

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/nombre?nombre=

---

#### Solicitudes POST

##### {FARMACIA-SERVICIO}/formas-farmaceuticas

---

### Solicitudes PUT

##### {FARMACIA-SERVICIO}/formas-farmaceuticas

---

#### Solicitudes DELETE

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/{id}

---

#### Solicitudes PATCH

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/{id}/nombre?nombre=

---

### MarcaMedicamento

---

#### Solicitudes GET

##### {FARMACIA-SERVICIO}/marcas/{id}

##### {FARMACIA-SERVICIO}/marcas

##### {FARMACIA-SERVICIO}/marcas/nombre?nombre=

---

#### Solcitudes POST 

##### {FARMACIA-SERVICIO}/marcas

---

#### Solcitudes PUT 

##### {FARMACIA-SERVICIO}/marcas

---

#### Solicitudes DELETE

##### {FARMACIA-SERVICIO}/marcas/{id}

---

#### Solicitudes PATCH

##### {FARMACIA-SERVICIO}/marcas/{id}/nombre?nombre=

---

### Medicamento

---

#### Solicitudes GET

##### {FARMACIA-SERVICIO}/medicamentos/{id}

##### {FARMACIA-SERVICIO}/medicamentos

##### {FARMACIA-SERVICIO}/medicamentos/nombre?nombre=

##### {FARMACIA-SERVICIO}/medicamentos/principio-activo?nombre-principio-activo=

##### {FARMACIA-SERVICIO}/medicamentos/forma-farmaceutica?nombre-forma-farmaceutica=

##### {FARMACIA-SERVICIO}/medicamentos/administracion?via=

##### {FARMACIA-SERVICIO}/medicamentos/marca?nombre-marca=

---

#### Solicitudes POST

##### {FARMACIA-SERVICIO}/medicamentos

---

#### Solicitudes PUT

##### {FARMACIA-SERVICIO}/medicamentos

---

#### Solicitudes DELETE

##### {FARMACIA-SERVICIO}/medicamentos/{id}

---

#### Solicitudes PATCH

##### {FARMACIA-SERVICIO}/medicamentos/{id}/nombre?nombre=

##### {FARMACIA-SERVICIO}/medicamentos/{id}/agregar-principio-activo?principio-activo-id=

##### {FARMACIA-SERVICIO}/medicamentos/{id}/quitar-principio-activo?principio-activo-id=

##### {FARMACIA-SERVICIO}/medicamentos/{id}/forma-farmaceutica?forma-farmaceutica-id=

##### {FARMACIA-SERVICIO}/medicamentos/{id}/administracion?administracion-id=

##### {FARMACIA-SERVICIO}/medicamentos/{id}/marca?marca-id=

---

### PrincipioActivo

---

#### Solicitudes GET

##### {FARMACIA-SERVICIO}/principios-activos/{id}

##### {FARMACIA-SERVICIO}/principios-activos

##### {FARMACIA-SERVICIO}/principios-activos/nombre?nombre=

##### {FARMACIA-SERVICIO}/principios-activos/accion-terapeutica?nombre-accion-terapeutica=

---

#### Solicitudes POST

##### {FARMACIA-SERVICIO}/principios-activos

---

#### Solicitudes PUT

##### {FARMACIA-SERVICIO}/principios-activos

---

#### Solicitudes DELETE

##### {FARMACIA-SERVICIO}/principios-activos/{id}

---

#### Solocitudes PATCH

##### {FARMACIA-SERVICIO}/principios-activos/{id}/agregar-accion-terapeutica?accion-terapeutica-id=

##### {FARMACIA-SERVICIO}/principios-activos/{id}/quitar-accion-terapeutica?accion-terapeutica-id=

---

### UnidadDeMedida

---

#### Solicitudes GET

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}

##### {FARMACIA-SERVICIO}/unidades-de-medida

##### {FARMACIA-SERVICIO}/unidades-de-medida/nombre?nombre=

##### {FARMACIA-SERVICIO}/unidades-de-medida/simbolo?simbolo=

---

#### Solicitudes POST

##### {FARMACIA-SERVICIO}/unidades-de-medida

---

#### Solcitudes PUT

##### {FARMACIA-SERVICIO}/unidades-de-medida

---

#### Solicitudes DELETE

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}

---

#### Solicitudes PATCH

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}/nombre?nombre=

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}/simbolo?simbolo=

---

## PACIENTES

---

### ObraSocial

---

### Solcitudes GET

##### {PACIENTES-SERVICIO}/obras-sociales/{id}

##### {PACIENTES-SERVICIO}/obras-sociales

##### {PACIENTES-SERVICIO}/obras-sociales/nombre?nombre=

##### {PACIENTES-SERVICIO}/obras-sociales

---

### Solicitudes POST

##### {PACIENTES-SERVICIO}/obras-sociales

--- 

### Solicitudes PUT

##### {PACIENTES-SERVICIO}/obras-sociales

---

### Soloicitudes DELETE

##### {PACIENTES-SERVICIO}/obras-sociales/{id}

---

### Solicitudes PATCH

##### {PACIENTES-SERVICIO}/obras-sociales/{id}/nombvre?nombre=

---

## Paciente

---

### Solicitudes GET

##### {PACIENTES-SERVICIO}/pacientes/{id}

##### {PACIENTES-SERVICIO}/pacientes

##### {PACIENTES-SERVICIO}/pacientes/dni?dni=

##### {PACIENTES-SERVICIO}/pacientes/nombre?nombre=

##### {PACIENTES-SERVICIO}/pacientes/apellido?apellido=

##### {PACIENTES-SERVICIO}/pacientes/email?email=

##### {PACIENTES-SERVICIO}/pacientes/telefono?numero-telefonico=

##### {PACIENTES-SERVICIO}/pacientes/fecha-nacimiento?desde= &hasta=

##### {PACIENTES-SERVICIO}/pacientes/lugar-nacimiento?localidad=

##### {PACIENTES-SERVICIO}/pacientes/domicilio?calle=

---

### Solicitudes POST

##### {PACIENTES-SERVICIO}/pacientes

---

### Solicitudes PUT

##### {PACIENTES-SERVICIO}/pacientes/{id}

---

### Solicitudes DELETE

##### {PACIENTES-SERVICIO}/pacientes/{id}

---

### Solicitudes PATCH

##### {PACIENTES-SERVICIO}/pacientes/{id}/dni?dni=

##### {PACIENTES-SERVICIO}/pacientes/{id}/primer-nombre?id-o-dni= &opcion= &nombre=

##### {PACIENTES-SERVICIO}/pacientes/{id}/segundo-nombre?id-o-dni= &opcion= &nombre=

##### {PACIENTES-SERVICIO}/pacientes/{id}/apellido-paterno?id-o-dni= &opcion= &apellido=

##### {PACIENTES-SERVICIO}/pacientes/{id}/apellido-materno?id-o-dni= &opcion= &apellido=

##### {PACIENTES-SERVICIO}/pacientes/{id}/email?id-o-dni= &opcion= &email=

##### {PACIENTES-SERVICIO}/pacientes/{id}/agregar-telefono?id-o-dni= &opcion= &telefono-para-agregar=

##### {PACIENTES-SERVICIO}/pacientes/{id}/quitar-telefono?id-o-dni= &opcion= &telefono-para-quitar=

##### {PACIENTES-SERVICIO}/pacientes/{id}/fecha-nacimiento?id-o-dni= &opcion= &fecha=

##### {PACIENTES-SERVICIO}/pacientes/{id}/lugar-nacimiento?id-o-dni= &opcion &localidad-id=

##### {PACIENTES-SERVICIO}/pacientes/{id}/domicilio?id-o-dni= &opcion= &direccion-id=

##### {PACIENTES-SERVICIO}/pacientes/{id}/obra-social?id-o-dni= &opcion= &obra-social-id=