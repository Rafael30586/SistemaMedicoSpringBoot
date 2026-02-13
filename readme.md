# Esta aplicación ha sido desarrollada con Java y Spring boot utilizando IntelliJ IDEA. Consiste en cuatro microservicios: contacto, farmacia, paciente y hospital. El microservicio de contacto tiene las siguentes entidades: Direccion, Localidad, Pais y Provincia. Las entidades que componen al microservicio de farmacia son: AccionTerapeutica, AdministrcionFarmaco, Dosis, FormaFarmaceutica, MarcaMedicamento, Medicamento, PrincipioActivo y UnidadDeMedida. En el microservicio de paciente las entidades son: ObraSocial, Paciente, ResultadoDeEstudios, Sede, TurnoCita y TurnoEstudio. Para el microservicio de hospital las entidades son: CirugiaPaciente, Diagnostico, DiagnosticoPaciente, Empleado, EstudioMedico, EstudioMEdicoClasificacion, FisioterapiaPaciente, MedicamentoPaciente, PsicoterapiaPaciente, RadioTerpiaPaciente, RolEmpleado, Sector, Signo, Sintoma y TratamientoQuirurgico.

## Contacto

### Direccion

#### Solicitudes GET

##### {CONTACTO-SERVICIO}/direcciones/{id}

##### {CONTACTO-SERVICIO}/direcciones

##### {CONTACTO-SERVICIO}/direcciones/localidad?localidad=

##### {CONTACTO-SERVICIO}/direcciones/provincia?provincia=

#### Solicitudes POST

##### {CONTACTO-SERVICIO}/direcciones

#### Solicitued PUT

##### {CONTACTO-SERVICIO}/direcciones

#### Solicitudes DELETE

##### {CONTACTO-SERVICIO}/direcciones/{id}

#### Solicitudes PATCH

##### {CONTACTO-SERVICIO}/direcciones/{id}/calle?calle=

##### {CONTACTO-SERVICIO}/direcciones/{id}/altura?altura=

##### {CONTACTO-SERVICIO}/direcciones/{id}/departamento?departamento=

##### {CONTACTO-SERVICIO}/direcciones/{id}/localidad?localidad-id=

### Localidad

#### Solicitudes GET

##### {CONTACTO-SERVICIO}/localidades/{id}

##### {CONTACTO-SERVICIO}/localidades

#### Solicitudes POST

##### {CONTACTO-SERVICIO}/localidades

#### Solicitudes PUT

##### {CONTACTO-SERVICIO}/localidades

#### Solicitudes DELETE

##### {CONTACTO-SERVICIO}/localidades/{id}

#### Solicitudes PATCH

##### {CONTACTO-SERVICIO}/localidades/{id}/nombre?nombre=

##### {CONTACTO-SERVICIO}/localidades/{id}/provincia?provincia-id=

### Pais

#### Solicitudes GET

##### {CONTACTO-SERVICIO}/paises/{id}

##### {CONTACTO-SERVICIO}/paises

#### Solicitudes POST

##### {CONTACTO-SERVICIO}/paises

#### Solicitudes PUT

##### {CONTACTO-SERVICIO}/paises

#### Solicitudes DELETE

##### {CONTACTO-SERVICIO}/paises/{id}

#### Solicitudes PATCH

##### {CONTACTO-SERVICIO}/paises/{id}/nombre?nombre=

### Provincia

#### Solicitudes GET

##### {CONTACTO-SERVICIO}/provincias

##### {CONTACTO-SERVICIO}/provincias/{ID}

#### Solicitudes POST

##### {CONTACTO-SERVICIO}/provincias

#### Solicitudes PUT

##### {CONTACTO-SERVICIO}/provincias

#### Solicitudes DELETE

##### {CONTACTO-SERVICIO}/provincias/{id}

#### Solicitudes PATCH

##### {CONTACTO-SERVICIO}/provincias/{id}/nombre?nombre=

##### {CONTACTO-SERVICIO}/provincias/{id}/pais?pais-id=

## Farmacia

### AccionTerapeutica

#### Solcitudes GET

##### {FARMACIA-SERVICIO}/acciones-terapeuticas

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}

#### Solicitudes POST

##### {FARMACIA-SERVICIO}/acciones-terapeuticas

#### Solicitudes PUT

##### {FARMACIA-SERVICIO}/acciones-terapeuticas

#### Solicitudes DELETE

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}

#### Solicitudes PATCH

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}/nombre?nombre=

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}/descripcion 

### AdministracionFarmaco

#### Solicitudes GET

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/{id}

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco

#### Solicitudes POST

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco

#### Solicitudes PUT

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco

#### Solicitudes DELETE

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/{id}

#### Solicitudes PATCH

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/{id}/via?via=