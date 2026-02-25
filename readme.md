# Sistema médico

Esta aplicación ha sido desarrollada con Java y Spring boot utilizando IntelliJ IDEA. Consiste en cuatro microservicios: contacto, farmacia, paciente y hospital. El microservicio de contacto tiene las siguentes entidades: Direccion, Localidad, Pais y Provincia. Las entidades que componen al microservicio de farmacia son: AccionTerapeutica, AdministrcionFarmaco, Dosis, FormaFarmaceutica, MarcaMedicamento, Medicamento, PrincipioActivo y UnidadDeMedida. En el microservicio de paciente las entidades son: ObraSocial, Paciente, ResultadoDeEstudios, Sede, TurnoCita y TurnoEstudio. Para el microservicio de hospital las entidades son: CirugiaPaciente, Diagnostico, DiagnosticoPaciente, Empleado, EstudioMedico, EstudioMEdicoClasificacion, FisioterapiaPaciente, MedicamentoPaciente, PsicoterapiaPaciente, RadioTerpiaPaciente, RolEmpleado, Sector, Signo, Sintoma y TratamientoQuirurgico.

---

## Explicaciones sobre entidades  

---

Direccion: Es la dirección en la que se encuentra un domicilio, edificio, etc. Se compone de la calle, altura, departamento, etc.
Localidad: Puede ser una ciudad, un pueblo, etc.
Pais: Es el pais.
Provincia: Puede ser la provincia o estado de un pais.

AccionTerapeutica: Es la acción benéfica que tiene un principio activo o medicamento en el cuerpo humano, ejemplos: antiinflamatorio, queratolítico, analgésico, antifebril, etc.
AdministracionFarmaco: Es la manea en la que se administra un fármaco al paceinte, ejemplos: intramuscular, oral, intratecal, nasal, sublingual, oftálmica, etc.
Dosis: Es una cantidad de fármaco administrada por cantidad de tiempo. Se tiene en cuenta la unidad usada (miligrmoas, mililitros, etc),  el intervalo de tiempo (por ejemplo, cada 8 horas), y la cantidad que se asocia a la unidad.
FormaFaremaceutica: Es la forma en la que se presenta un medicamento, por ejemplo: crema, emulsión, jarabe, cápsulas, gel, polvo, etc.
MarcaMedicamento: Es la marca del medicamento.
Medicamento: Hace referencia a cada medicamento.
PrincipioActivo: Es el principio activo que se encuentra en los medicamentos.
UnidadDeMedida: Es la unidad con la que se miden cantidades, ejemplos: miligramos, mililitros, gotas, etc.

ObraSocial: Es la obra social de un paciente.
Paciente: Es un paciente que solicita servicios en el hospital.
ResultadoDeEstudios: Son los resultados de cada estudio realizado a cada paciente.
Sede: Es la dirección que le corresponde a cada sede de las obras sociales.
TurnoCita: Son los datos de un turno para un paciente que solicita un cita con un médico.
TurnoEstudio: Son los datos de un turno para un paciente que solicita la realización de un estudio médico.

CirugiaPaciente: Es una cirugía que se ha realizado un paciente.
Diagnostico: Es el diagnóstico que puede recibir cada paciente, por ejemplo: gripe, diabetes, etc.
DiagnosticoPaciente: Es el diagnóstico concreto que se ha dado a un paciente concreto.
Empleado: Son los datos de cada empleado del hospital.
EstudioMedico: Es cada estudio médico que pueden realizarse los pacientes, ejemplos: perfil renal, hemograma, electrocardiograma, etc.
EstudioMedicoClasificacion: Teien que ver con como se clasifican los diferentes estudios médicos, ejemplos: laboratorio, diagnóstico por imágenes, cardiológico, etc.
FisioterapiaPaciente: Es el tratamiento por fisioterapia que se ha realizado en un paciente.
MedicamentoPaciente: Es el tratamiento que se ha realizado en un paciente con un medicamento concreto.
PsicoterapiaPaciente: Es el tratamiento psicológico que se ha realizado en un paciente.
RadioTerapiaPaciente: Es un tratamiento de radioterapia realizado en un paciente concreto.
RolEmpleado: Es el rol que puede tener cada empleado, por ejemplo: cirujano, cardiólogo, cocinero, secretario, etc.
Sector: Es el sector al que corresponde cada rol de los empleados, por ejemplo: medicina, limpieza, recursos humanso, gastronomía, etc.
Signo: Son los signos que pueden presentar los pacientes de acuerdo a su diagnóstico: hiperglucemia, fiebre, etc.
Sintoma: Son los sintomas que puede tener un paciente de acuerdo a su diagnóstico, por ejemplo: dolor de cabeza, nauseas, fatiga, etc.
TratamientoQuirurgico: Son las cirugías que pueden realizarse en los pacientes, por ejemplo: cirugía a corazón abierto, cirugía de cadera, etc.

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

- **body:**

~~~javascript
{
    calle: string,
    altura: numero_entero,
    departamento: string,
    localidad: Localdidad
}
~~~

- **Ejemplo:**

~~~json
{
    "calle": "san martín",
    "altura": 5612,
    "departemento": "1A",
    "localidad":{
        "id":4
    }
}
~~~

---

#### Solicitued PUT

##### {CONTACTO-SERVICIO}/direcciones

- **body**

~~~javascript
{
    id: numero_entero,
    calle: string,
    altura: numero_entero,
    departamento: string,
    localidad: Localdidad
}
~~~

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

- **body:**

~~~javascript
{
    nombre: string,
    provincia: Provincia,
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "san miguel",
    "provicnia":{
        "id":1
    }
}
~~~

---

#### Solicitudes PUT

##### {CONTACTO-SERVICIO}/localidades

- **body:**

~~~javascript
{
    id: nimero_entero,
    nombre: string,
    provincia: Provincia
}
~~~


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

- **body:**

~~~javascript
{
    nombre: string,
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "argentina",
}
~~~

---

#### Solicitudes PUT

##### {CONTACTO-SERVICIO}/paises

- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

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

- **body:**

~~~javascript
{
    nombre: string,
    pais: Pais
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "buenos aires",
    "pais": {
        "id":10
    }
}
~~~

---

#### Solicitudes PUT

##### {CONTACTO-SERVICIO}/provincias

- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string,
    pais: Pais
}
~~~

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

- **body:**

~~~javascript
{
    nombre: string,
    descripcion: string
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "antifebril",
    "descripcion": "reduce la fiebre"
}
~~~

---

#### Solicitudes PUT

##### {FARMACIA-SERVICIO}/acciones-terapeuticas

- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string,
    descripcion: string
}
~~~

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

- **body:**

~~~javascript
{
    via: string,
}
~~~

- **Ejemplo:**

~~~json
{
    "via": "oftálmica",
}
~~~

---

#### Solicitudes PUT

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco

- **body:**

~~~javascript
{
    id: numero_entero,
    via: string
}
~~~

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

- **body:**

~~~javascript
{
    cantidad: numero_decimal,
    unidad: UnidadDeMedida,
    intervaloHoras: numero_entero
}
~~~

- **Ejemplo:**

~~~json
{
    "cantidad": "2.0",
    "unidad": {
        "id":3
    },
    "intervaloHoras": 8,
}
~~~

---

#### Solicitudes PUT

##### {FARMACIA-SERVICIO}/dosis

- **body:**

~~~javascript
{
    id: numero_entero,
    cantidad: numero_decimal,
    unidad: UnidadDeMedida,
    intervaloHoras: numero_entero
}
~~~

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

- **body:**

~~~javascript
{
    nombre: string,
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "crema",
}
~~~


---

### Solicitudes PUT

##### {FARMACIA-SERVICIO}/formas-farmaceuticas

~~~javascript
{
    id: numero_entero,
    nombre:string
}
~~~

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

- **body:**

~~~javascript
{
    nombre: string
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "cassará"
}
~~~


---

#### Solcitudes PUT

##### {FARMACIA-SERVICIO}/marcas

- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

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

- **body:**

~~~javascript
{
    nombre: string,
    principiosActivos: PrincipioActivo[],
    formaFarmaceutica: FormaFarmaceutica,
    administracion: AdministracionFarmaco,
    marca: MarcaMedicamento
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "peptazol 40",
    "principiosActivos":[
        {
            "id":3
        },
        {
            "id":11
        }
    ],
    "formaFarmaceutica": {
        "id":16
    },
    "administracion":{
        "id":2
    },
    "marca":{
        "id":5
    }
}
~~~

---

#### Solicitudes PUT

##### {FARMACIA-SERVICIO}/medicamentos

- **body:**

~~~javascript
{   
    id: numero_entero,
    nombre: string,
    principiosActivos: PrincipioActivo[],
    formaFarmaceutica: FormaFarmaceutica,
    administracion: AdministracionFarmaco,
    marca: MarcaMedicamento
}
~~~

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

- **body:**

~~~javascript
{
    nombre: string
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "paracetamol"
}
~~~

---

#### Solicitudes PUT

##### {FARMACIA-SERVICIO}/principios-activos

- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

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

- **body:**

~~~javascript
{
    nombre: string,
    simbolo: string
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "miligramo",
    "simbolo":"mg"
}
~~~

---

#### Solcitudes PUT

##### {FARMACIA-SERVICIO}/unidades-de-medida

- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string,
    simbolo: string
}
~~~

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

#### Solcitudes GET

##### {PACIENTES-SERVICIO}/obras-sociales/{id}

##### {PACIENTES-SERVICIO}/obras-sociales

##### {PACIENTES-SERVICIO}/obras-sociales/nombre?nombre=

##### {PACIENTES-SERVICIO}/obras-sociales

---

#### Solicitudes POST

##### {PACIENTES-SERVICIO}/obras-sociales

- **body:**

~~~javascript
{
    nombre: string
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "osde"
}
~~~

--- 

#### Solicitudes PUT

##### {PACIENTES-SERVICIO}/obras-sociales

- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

---

#### Soloicitudes DELETE

##### {PACIENTES-SERVICIO}/obras-sociales/{id}

---

#### Solicitudes PATCH

##### {PACIENTES-SERVICIO}/obras-sociales/{id}/nombvre?nombre=

---

### Paciente

---

#### Solicitudes GET

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

#### Solicitudes POST

##### {PACIENTES-SERVICIO}/pacientes

- **body:**

~~~javascript
{
    dni: numero_entero,
    primerNombre: string,
    segundoNombre: string,
    apellidoPaterno: string,
    apellidoMaterno: string,
    email: string,
    telefonos: string[],
    fechaNacimiento: fecha
    lugarNacimientoId: numero_entero,
    direccionId: numero_entero,
    obraSocial: ObraSocial
}
~~~

- **Ejemplo:**

~~~json
{
    "dni": 34910028,
    "primerNombre":"miguel",
    "segundoNombre": "alejandro",
    "apellidoPaterno": "alvarez",
    "apellidoMaterno": "dominguez",
    "email": "miguel28@gmail.com",
    "telefonos":[
        "986-59201",
        "28-9604-234"
    ],
    "fechaNacimiento":"09-04-1988",
    "lugarNacimientoId": 3,
    "direccionId":37,
    "obraSocial": {
        "id":5
    }
}
~~~

---

#### Solicitudes PUT

##### {PACIENTES-SERVICIO}/pacientes/{id}

- **body:**

~~~javascript
{
    id: numero_entero,
    dni: numero_entero,
    primerNombre: string,
    segundoNombre: string,
    apellidoPaterno: string,
    apellidoMaterno: string,
    email: string,
    telefonos: string[],
    fechaNacimiento: fecha
    lugarNacimientoId: numero_entero,
    direccionId: numero_entero,
    obraSocial: ObraSocial
}
~~~

---

#### Solicitudes DELETE

##### {PACIENTES-SERVICIO}/pacientes/{id}

---

#### Solicitudes PATCH

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

---

### ResultadosDeEstudios

---

#### Solicitudes GET

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}

##### {PACIENTES-SERVICIO}/resultados-de-estudios

##### {PACIENTES-SERVICIO}/resultados-de-estudios/paciente?dni=

##### {PACIENTES-SERVICIO}/resultados-de-estudios/estudio?nombre-estudio=

---

#### Solicitudes POST

##### {PACIENTES-SERVICIO}/resultados-de-estudios

- **body:**

~~~javascript
{
    paciente: Paciente,
    estudios: numero_entero[],
    urlInform: string
}
~~~

- **Ejemplo:**

~~~json
{
    "paciente": {
        "id":193
    },
    "estudios":[4,12],
    "urlInforme":"hostipal.com/informes/73291"
}
~~~

---

#### Solicitudes PUT

##### {PACIENTES-SERVICIO}/resultados-de-estudios

- **body:**

~~~javascript
{   
    id: numero_entero,
    paciente: Paciente,
    estudios: numero_entero[],
    urlInform: string
}
~~~

---

#### Solicitudes DELETE

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}

---

#### Solicitudes PATCH

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/paciente?id-o-dni-paciente= &opcion=

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/agregar-estudio?estudio-id=

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/quitar-estudio?estudio-id=

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/url-informe?url-informe=

---

### Sede

---

#### Solicitudes GET

##### {PACIENTES-SERVICIO}/sedes/{id}

##### {PACIENTES-SERVICIO}/sedes

##### {PACIENTES-SERVICIO}/sedes/direccion?calle=

##### {PACIENTES-SERVICIO}/sedes/{id}/telefono?telefono=

---

#### Solicitudes POST

##### {PACIENTES-SERVICIO}/sedes

- **body:**

~~~javascript
{
    direccionId: numero_entero,
    telefonos: string[],
    obraSocial: ObraSocial
}
~~~

- **Ejemplo:**

~~~json
{
    "direccionId": 90,
    "telefonos":[
        "09-4866-201",
        "94623-0917776",
        "10923-67398"
    ],
    "obraSocial":{
        "id":2
    }
}
~~~

---

#### Solicitudes PUT

##### {PACIENTES-SERVICIO}/sedes

~~~javascript
{
    id: numero_entero,
    direccionId: numero_entero,
    telefonos: string[],
    obraSocial: ObraSocial
}
~~~

---

#### Solicitudes DELETE

##### {PACIENTES-SERVICIO}/sedes/{id}

---

#### Solicitudes PATCH

##### {PACIENTES-SERVICIO}/sedes/{id}/direccion?direccion-id=

##### {PACIENTES-SERVICIO}/sedes/{id}/agregar-telefono?telefono=

##### {PACIENTES-SERVICIO}/sedes/{id}/quitar-telefono?telefono=

##### {PACIENTES-SERVICIO}/sedes/{id}/obra-social?obra-social-id=

---

### TurnoCita

---

#### Solicitudes GET

##### {PACIENTES-SERVICIO}/turnos-cita/{id}

##### {PACIENTES-SERVICIO}/turnos-cita

##### {PACIENTES-SERVICIO}/turnos-cita/paciente?dni=

##### {PACIENTES-SERVICIO}/turnos-cita/fecha-turno?fecha-turno=

##### {PACIENTES-SERVICIO}/turnos-cita/periodo?desde= &hasta=

##### {PACIENTES-SERVICIO}/turnos-cita/profesional?profesional-id=

---

#### Solicitudes POST

##### {PACIENTES-SERVICIO}/turnos-cita


- **body:**

~~~javascript
{
    paciente: Paciente,
    fechaSolicitud: fecha,
    fechaTurno: fecha,
    inicio: hora,
    fin: hora,
    estado: Estado,
    cobertura: Cobertura
}
~~~

- **Ejemplo:**

~~~json
{
    "paciente":{
        "id":78
    },
    "fechaSolicitud": "15-06-2025",
    "fechaTurno": "30-06-2025",
    "inicio": "10:00",
    "fin": "10:45",
    "estado": "EN_PROCESO",
    "cobertura": "TOTAL"
}
~~~

---

#### Solicitudes PUT

##### {PACIENTES-SERVICIO}/turnos-cita


- **body:**

~~~javascript
{
    id: numero_entero,
    paciente: Paciente,
    fechaSolicitud: fecha,
    fechaTurno: fecha,
    inicio: hora,
    fin: hora,
    estado: Estado,
    cobertura: Cobertura
}
~~~

---

#### Solicitudes DELETE

##### {PACIENTES-SERVICIO}/turnos-cita/{id}

---

#### Solicitudes PATCH

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/paciente?id-o-dni-paciente= &opcion=

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/fecha-solicitud?fecha-solicitud=

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/horario?inicio= &fin=

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/estado?estado=

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/cobertura?cobertura=

---

### TurnoEstudio

---

#### Solicitudes GET

##### {PACIENTES-SERVICIO}/turnos-estudio/{id}

##### {PACIENTES-SERVICIO}/turnos-estudio

##### {PACIENTES-SERVICIO}/turnos-cita/paciente?dni=

##### {PACIENTES-SERVICIO}/turnos-cita/fecha-turno?fecha-turno=

##### {PACIENTES-SERVICIO}/turnos-cita/periodo?desde= &hasta=

##### {PACIENTES-SERVICIO}/turnos-estudio/estudio?estudio-id=

---

#### Solicitudes POST

##### {PACIENTES-SERVICIO}/turnos-estudio

- **body:**

~~~javascript
{
    paciente: Paciente,
    fechaSolicitud: fecha,
    fechaTurno: fecha,
    inicio: hora,
    fin: hora,
    estado: Estado,
    cobertura: Cobertura,
    estudioId: numero_entero
}
~~~

- **Ejemplo:**

~~~json
{
    "paciente":{
        "id":13
    },
    "fechaSolicitud": "04-05-2024",
    "fechaTurno": "30-05-2024",
    "inicio": "15:30",
    "fin": "16:00",
    "estado": "CONCLUIDO",
    "cobertura": "COSEGURO",
    "estudioId":62
}
~~~


---

#### Solicitudes PUT

##### {PACIENTES-SERVICIO}/turnos-estudio

- **body:**

~~~javascript
{
    id: numero_entero,
    paciente: Paciente,
    fechaSolicitud: fecha,
    fechaTurno: fecha,
    inicio: hora,
    fin: hora,
    estado: Estado,
    cobertura: Cobertura
}
~~~

---

#### Solicitudes DELETE

##### {PACIENTES-SERVICIO}/turnos-estudio/{id}

---

#### Solicitudes PATCH

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/paciente?id-o-dni-paciente= &opcion=

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/fecha-solicitud?fecha-solicitud=

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/horario?inicio= &fin=

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/estado?estado=

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/cobertura?cobertura=

##### {PACIENTES-SERVICIO}/turnos-estudio/{id}/estudio?estudio-id=

---

## Hospital

---

### CirugiaPaciente

---

#### Solicitudes GET

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}

##### {HOSPITAL-SERVICIO}/cirugias-pacientes

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/paciente?paciente-id-o-dni= &opcion=

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/cirugia?cirugia=

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/periodo?desde= &hasta=

---

#### Solicitudes POST

##### {HOSPITAL-SERVICIO}/cirugias-pacientes

- **body:**

~~~javascript
{
    pacienteId: numero_entero,
    cirugia: TratamientoQuirurgico, 
    fecha: fecha,
    inicio: hora,
    fin: hora
}
~~~

- **Ejemplo:**

~~~json
{
    "pacienteId":39,
    "cirugia":{
        "id":5
    },
    "fecha":"10-09-2025",
    "inicio":"12:00",
    "fin":"15:00"
}
~~~


---

#### Solicitudes PUT

##### {HOSPITAL-SERVICIO}/cirugias-pacientes


~~~javascript
{
    pacienteId: numero_entero,
    cirugia: TratamientoQuirurgico, 
    fecha: fecha,
    inicio: hora,
    fin: hora
}
~~~

---

#### Solicitudes DELETE

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}

---

#### Solicitudes PATCH

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/paciente?paciente-id-o-dni= &opcion=

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/cirugia?cirugia-id=

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/fecha?fecha=

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/hora-inicio?inicio=

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/hota-final?fin=

---

### Diagnostico

---

#### Solicitudes GET

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}

##### {HOSPITAL-SERVICIO}/diagnosticos

##### {HOSPITAL-SERVICIO}/diagnosticos/nombre?nombre=

---

#### Solicitudes POST

##### {HOSPITAL-SERVICIO}/diagnosticos


- **body:**

~~~javascript
{
    nombre: string,
    sintomas: Sintoma[], 
    signos: Signo[]
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "gripe",
    "sintomas":[
        {
            "id":12
        },
        {
            "id":14
        },
        {
            "id":25
        }
    ],
    "signos":[
        {
            "id":13
        },
        {
            "id":20
        }
    ]
}
~~~

---

#### Solicitudes PUT

##### {HOSPITAL-SERVICIO}/diagnosticos


- **body:**

~~~javascript
{
    id:numero_entero,
    nombre: string,
    sintomas: Sintoma[], 
    signos: Signo[]
}
~~~

---

#### Solicitudes DELETE

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}

---

#### Solicitudes PATCH

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/agregar-sintoma?sintoma-id=

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/quitar-sintoma?sintoma-id=

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/agregar-signo?signo-id=

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/quitar-signo?signo-id=

---

### DiagnosticoPaciente

---

#### Solicitudes GET

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/paciente?pacinete-id-o-dni= &opcion=

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/diagnostico?diagnostico=

---

#### Solicitudes POST

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes


- **body:**

~~~javascript
{
    pacienteId: numero_entero,
    diagnostico: Diagnostico, 
    inicio: fecha,
    fin: fecha
}
~~~

- **Ejemplo:**

~~~json
{
    "pacienteId": 10,
    "diagnostico": {
        "id":17
    },
    "inicio":"29-10-2020",
    "fin":"12-04-2023"
}
~~~


---

#### Solicitudes PUT

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes

- **body:**

~~~javascript
{
    id: numero_entero,
    pacienteId: numero_entero,
    diagnostico: Diagnostico, 
    inicio: fecha,
    fin: fecha
}
~~~

---

#### Solicitudes DELETE

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}

---

#### Solicitudes PATCH

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/paciente?paciente-id-o-dni= &opcion=

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/diagnostico?diagnostico-id=

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/fecha-inicio?inicio=

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/fecha-final?fin=

---

### Empleado

---

#### Solicitudes GET

##### {HOSPITAL-SERVICIO}/empleados/{id}

##### {HOSPITAL-SERVICIO}/empleados

##### {HOSPITAL-SERVICIO}/empleados/dni?dni=

##### {HOSPITAL-SERVICIO}/empleados/nombre?nombre=

##### {HOSPITAL-SERVICIO}/empleados/apellido?apellido=

##### {HOSPITAL-SERVICIO}/empleados/email?email=

##### {HOSPITAL-SERVICIO}/empleados/matricula?matricula=

##### {HOSPITAL-SERVICIO}/empleados/rol?rol=

##### {HOSPITAL-SERVICIO}/empleados/rango-salarial?minimo= &maximo=

---

#### Solicitudes POST

##### {HOSPITAL-SERVICIO}/empleados


- **body:**

~~~javascript
{
    dni: numero_entero,
    primerNombre: string, 
    segundoNombre: string,
    apellidoPaterno: string,
    apellidoMaterno: string,
    email: string,
    domicilioId: numero_entero,
    telefonos: string[],
    matriculaProfesional: string,
    rol: RolEmpleado,
    salario: numero_decimal
}
~~~

- **Ejemplo:**

~~~json
{
    "dni": 29010772,
    "primerNombre": "mariano",
    "segundoNombre": "gabriel",
    "apellidoPaterno":"vazquez",
    "apellidoMaterno": "gimenez",
    "email": "gaby102@gmail.com",
    "domicilioId": 92,
    "telefonos":[
        "08372-183",
        "6939-08273-211"
    ],
    "matriculaProfesional": "A-720",
    "rol":{
        "id":13
    },
    "salario":500.50
}
~~~


---

#### Solicitudes PUT

##### {HOSPITAL-SERVICIO}/empleados



- **body:**

~~~javascript
{
    id: numero_entero,
    dni: numero_entero,
    primerNombre: string, 
    segundoNombre: string,
    apellidoPaterno: string,
    apellidoMaterno: string,
    email: string,
    domicilioId: numero_entero,
    telefonos: string[],
    matriculaProfesional: string,
    rol: RolEmpleado,
    salario: numero_decimal
}
~~~

---

#### Solicitudes DELETE

##### {HOSPITAL-SERVICIO}/empleados/{id}

---

#### Solicitudes PATCH

##### {HOSPITAL-SERVICIO}/empleados/{id}/dni?dni=

##### {HOSPITAL-SERVICIO}/empleados/{id}/primer-nombre?primer-nombre=

##### {HOSPITAL-SERVICIO}/empleados/{id}/segundo-nombre?segundo-nombre=

##### {HOSPITAL-SERVICIO}/empleados/{id}/apellido-paterno?apellido-paterno=

##### {HOSPITAL-SERVICIO}/empleados/{id}/apellido-materno?apellido-materno=

##### {HOSPITAL-SERVICIO}/empleados/{id}/email?email=

##### {HOSPITAL-SERVICIO}/empleados/{id}/domicilio?domicilio-id=

##### {HOSPITAL-SERVICIO}/empleados/{id}/agregar-telefono?telefono=

##### {HOSPITAL-SERVICIO}/empleados/{id}/quitar-telefono?telefono=

##### {HOSPITAL-SERVICIO}/empleados/{id}/matricula?matricula=

##### {HOSPITAL-SERVICIO}/empleados/{id}/rol?rol-id=

##### {HOSPITAL-SERVICIO}/empleados/{id}/salario?salario=

---

### EstudioMedicoClasificacion

---

#### Solictudes GET

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos/{id}

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos


##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos/nombre?nombre=

---

#### Solicitudes POST

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos



- **body:**

~~~javascript
{
    nombre: string
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "laboratorio"
}
~~~

---

#### Solicitudes PUT

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos

- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

---

#### Solicitudes DELETE

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos/{id}

---

#### Solicitudes PATCH

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos/{id}/nombre?nombre=

---

### EstudioMedico

---

#### Solicitudes GET

##### {HOSPITAL-SERVICIO}/estudios-medicos/{id}

##### {HOSPITAL-SERVICIO}/estudios-medicos

##### {HOSPITAL-SERVICIO}/estudios-medicos/nombre?nombre=

##### {HOSPITAL-SERVICIO}/estudios-medicos/clasificacion?clasificacion=

---

#### Soplicitudes POST

##### {HOSPITAL-SERVICIO}/estudios-medicos


- **body:**

~~~javascript
{
    nombre: string,
    clasificacion: EstudioMedicoClasificacion
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "electrocardiograma",
    "clasificacion":{
        "id":6
    }
}
~~~


---

#### Solicitudes PUT

##### {HOSPITAL-SERVICIO}/estudios-medicos


- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string,
    clasificacion: EstudioMedicoClasificacion
}
~~~

---

#### Solictudes DELETE

##### {HOSPITAL-SERVICIO}/estudios-medicos/{id}

---

#### Solictudes PATCH

##### {HOSPITAL-SERVICIO}/estudios-medicos/{id}/nombre?nombre=

##### {HOSPITAL-SERVICIO}/estudios-medicos/{id}/cladificacion?clasificacion=

---

### FisioterapiaPaciente

---

#### Solicitudes GET

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/paciente?paciente-id-o-dni= &opcion=

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/fecha-inicio?desde= &hasta=

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/fecha-final?desde= &hasta=

---

#### Solicitudes POST

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes


- **body:**

~~~javascript
{
    pacienteId: numero_entero,
    inicio: fecha,
    fin:fecha
}
~~~

- **Ejemplo:**

~~~json
{
    "pacienteId": 71,
    "inicio": "12-07-2021",
    "fin":"20-10-2023"
}
~~~

---

#### Solicitudes PUT

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes


- **body:**

~~~javascript
{
    id: neumero_entero,
    pacienteId: numero_entero,
    inicio: fecha,
    fin:fecha
}
~~~


---

#### Solicitudes DELETE

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}

---

#### Solicitudes PATCH

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}/paciente-id-o-dni= &opcion=

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}/fecha-inicio?inicio=

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}/fecha-final?final=

---

### MedicamentoPaciente

---

#### Solicitudes GET

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/paciente?paciente-id-o-dni= &opcion=

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/principio-activo?principio-activo=

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/fecha-inicio?desde= &hasta=

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/fecha-final?desde= &hasta=

---

#### Solicitudes POST

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes

- **body:**

~~~javascript
{
    pacienteId: numero_entero,
    medicamentoId: numero_entero,
    dosisId:numero_entero,
    inicio: fecha,
    fin:fecha
}
~~~

- **Ejemplo:**

~~~json
{
    "pacienteId": 410,
    "medicamentoId":32,
    "dosisId":129,
    "inicio": "01-02-2019",
    "fin":"09-03-2024"
}
~~~

---

#### Solicitudes PUT

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes


- **body:**

~~~javascript
{
    id: nuemro_entero,
    pacienteId: numero_entero,
    medicamentoId: numero_entero,
    dosisId:numero_entero,
    inicio: fecha,
    fin:fecha
}
~~~

---

#### Solicitudes DELETE

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}

---

#### Solicitudes PATCH

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/paciente?paciente-id-o-dni= &opcion=

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/medicamento?medicamento-id=

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/dosis?dosis-id=

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/fecha-inicio?inicio=

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/fecha-final?fin=

---

### PsicoterpiaPaciente

---

#### Solicitudes GET

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/paciente?paciente-id-o-dni= &opcion=

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/fecha-inicio?desde= &hasta=

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/fecha-final?desde &hasta=

---

#### Solicitudes POST

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes


- **body:**

~~~javascript
{
    pacienteId: numero_entero,
    inicio: fecha,
    fin:fecha
}
~~~

- **Ejemplo:**

~~~json
{
    "pacienteId": 410,
    "inicio": "25-06-2022",
    "fin":"10-11-2024"
}
~~~


---

#### Solicitudes PUT

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes


- **body:**

~~~javascript
{
    id: numero_entero,
    pacienteId: numero_entero,
    inicio: fecha,
    fin:fecha
}
~~~

--- 

#### Solicitudes DELETE

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}

---

#### Solicitudes PATCH

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}/paciente?paciente-id-o-dni= &opcion=

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}/fecha-inicio?inicio=

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}/fecha-final?fin=

---

### RadioTerapiaPaciente

---

#### Solicitudes GET

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/paciente?paciente-id-o-dni= &opcion=

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/fecha-inicio?desde= &hasta=

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/fecha-final?desde= &hasta=

#### Solicitudes POST

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes


- **body:**

~~~javascript
{
    pacienteId: numero_entero,
    inicio: fecha,
    fin:fecha
}
~~~

- **Ejemplo:**

~~~json
{
    "pacienteId": 158,
    "inicio": "10-08-2023",
    "fin":"11-02-2025"
}
~~~
---

#### Solicitudes PUT

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes


- **body:**

~~~javascript
{
    pacienteId: numero_entero,
    inicio: fecha,
    fin:fecha
}
~~~

---
#### Solcitudes DELETE

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}

---

#### Solicitudes PATCH

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}/paciente?paciente-id-o-dni= &opcion=

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}/fecha-inicio?inicio=

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}/fecha-final?fin=

---

### RolEmpleado

---

#### Solicitudes GET

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}

##### {HOSPITAL-SERVICIO}/roles-empleado

##### {HOSPITAL-SERVICIO}/roles-empleado/nombre?nombre=

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}/sector?sector=

---

#### Solicitudes POST

##### {HOSPITAL-SERVICIO}/roles-empleado


- **body:**

~~~javascript
{
    nombre: string,
    sector: Sector
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "cirujano",
    "sector":{
        "id":12
    }
}
~~~
---
#### Solicitudes PUT

##### {HOSPITAL-SERVICIO}/roles-empleado


- **body:**

~~~javascript
{
    id:numero_entero,
    nombre: string,
    sector: Sector
}
~~~
---

#### Solicitudes DELETE

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}

---

#### Solicitudes PATCH

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}/nombre?nombre

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}/sector?sector-id=

---

### Sector

---

#### Solicitudes GET

##### {HOSPITAL-SERVICIO}/sectores/{id}

##### {HOSPITAL-SERVICIO}/sectores

##### {HOSPITAL-SERVICIO}/sectores/nombre?nombre=
---

#### Solicitudes POST

##### {HOSPITAL-SERVICIO}/sectores


- **body:**

~~~javascript
{
    nombre: string
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "recursos humanos"
}
~~~

---

#### Solicitudes PUT

##### {HOSPITAL-SERVICIO}/sectores


~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

---

#### Solicitudes DELETE

##### {HOSPITAL-SERVICIO}/sectores/{id}

---

#### Solicitudes PATCH

##### {HOSPITAL-SERVICIO}/sectores/{id}/nombre?nombre=

---

### Signo

---

#### Solicitudes GET

##### {HOSPITAL-SERVICIO}/signos/{id}

##### {HOSPITAL-SERVICIO}/signos

##### {HOSPITAL-SERVICIO}/signos/nombre?nombre=

##### {HOSPITAL-SERVICIO}/signos/unidad?unidad=

##### {HOSPITAL-SERVICIO}/signos/descripcion?secuencia=

---

#### Solicitudes POST

##### {HOSPITAL-SERVICIO}/signos


- **body:**

~~~javascript
{
    nombre: string,
    valorMinimo: numero_decimal,
    valorMaximo: numero_decimal,
    unidadId: numero_entero,
    descripcion: string
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "hiperglucemia",
    "valorMinimo":130,
    "valorMaximo": null,
    "unidadId":9,
    "descripcion": "elevado nuvel de azúcar en sangre"
}
~~~

---
#### Solictudes PUT

##### {HOSPITAL-SERVICIO}/signos


- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string,
    valorMinimo: numero_decimal,
    valorMaximo: numero_decimal,
    unidadId: numero_entero,
    descripcion: string
}
~~~

---

#### Solictudes DELETE

##### {HOSPITAL-SERVICIO}/signos/{id}

---

#### Solictudes PATCH

##### {HOSPITAL-SERVICIO}/signos/{id}/nombre?nombre=

##### {HOSPITAL-SERVICIO}/signos/{id}/valor-minimo?valor-minimo=

##### {HOSPITAL-SERVICIO}/signos/{id}/valor-maximo?valor-maximo=

##### {HOSPITAL-SERVICIO}/signos/{id}/unidad?unidad-id=

##### {HOSPITAL-SERVICIO}/signos/{id}/descripcion <!-- Request body -->

---

### Sintoma

---

#### Solicitudes GET

##### {HOSPITAL-SERVICIO}/sintomas/{id}

##### {HOSPITAL-SERVICIO}/sintomas

##### {HOSPITAL-SERVICIO}/sintomas/nombre?nombre=

---

#### Solicitudes POST

##### {HOSPITAL-SERVICIO}/sintomas


- **body:**

~~~javascript
{
    nombre: string
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "náuseas"
}
~~~

---

#### Solicitudes PUT

##### {HOSPITAL-SERVICIO}/sintomas


- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

---

#### Solicitudes DELETE

##### {HOSPITAL-SERVICIO}/sintomas/{id}

---

#### Solicitudes PATCH

##### {HOSPITAL-SERVICIO}/sintomas/{id}/nombre?nombre=

---

### TratamientoQuirurgico

---

#### Solicitudes GET

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/{id}

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/nombre?nombre=

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/descripcion?descripcion=

---

#### Solicitudes POST

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos


- **body:**

~~~javascript
{
    nombre: string,
    descripcion: string
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "cirugía de cadera"
}
~~~

---

#### Solicitudes PUT

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos


- **body:**

~~~javascript
{
    id: neumero_entero,
    nombre: string,
    descripcion: string
}
~~~

---

#### Solicitudes DELETE 

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/{id}

---

#### Solcitudes PATCH

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/{id}/nombre?nombre=

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/{id}/descripcion <!-- Request Body-->


