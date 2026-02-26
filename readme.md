# Sistema médico

Esta aplicación ha sido desarrollada con Java y Spring boot utilizando IntelliJ IDEA. Consiste en cuatro microservicios: contacto, farmacia, paciente y hospital. El microservicio de contacto tiene las siguentes entidades: Direccion, Localidad, Pais y Provincia. Las entidades que componen al microservicio de farmacia son: AccionTerapeutica, AdministrcionFarmaco, Dosis, FormaFarmaceutica, MarcaMedicamento, Medicamento, PrincipioActivo y UnidadDeMedida. En el microservicio de paciente las entidades son: ObraSocial, Paciente, ResultadoDeEstudios, Sede, TurnoCita y TurnoEstudio. Para el microservicio de hospital las entidades son: CirugiaPaciente, Diagnostico, DiagnosticoPaciente, Empleado, EstudioMedico, EstudioMEdicoClasificacion, FisioterapiaPaciente, MedicamentoPaciente, PsicoterapiaPaciente, RadioTerpiaPaciente, RolEmpleado, Sector, Signo, Sintoma y TratamientoQuirurgico.

---

## Explicaciones sobre entidades  

---

- Direccion: Es la dirección en la que se encuentra un domicilio, edificio, etc. Se compone de la calle, altura, departamento, etc.
- Localidad: Puede ser una ciudad, un pueblo, etc.
- Pais: Es el pais.
- Provincia: Puede ser la provincia o estado de un pais.

- AccionTerapeutica: Es la acción benéfica que tiene un principio activo o medicamento en el cuerpo humano, ejemplos: antiinflamatorio, queratolítico, analgésico, antifebril, etc.
- AdministracionFarmaco: Es la manera en la que se administra un fármaco al paciente, ejemplos: intramuscular, oral, intratecal, nasal, sublingual, oftálmica, etc.
- Dosis: Es una cantidad de fármaco administrada por cantidad de tiempo. Se tiene en cuenta la unidad usada (miligramos, mililitros, etc),  el intervalo de tiempo (por ejemplo, cada 8 horas), y la cantidad que se asocia a la unidad.
- FormaFaremaceutica: Es la forma en la que se presenta un medicamento, por ejemplo: crema, emulsión, jarabe, cápsulas, gel, polvo, etc.
- MarcaMedicamento: Es la marca del medicamento.
- Medicamento: Hace referencia a cada medicamento.
- PrincipioActivo: Es el principio activo que se encuentra en los medicamentos.
- UnidadDeMedida: Es la unidad con la que se miden cantidades, ejemplos: miligramos, mililitros, gotas, etc.

- ObraSocial: Es la obra social de un paciente.
- Paciente: Es un paciente que solicita servicios en el hospital.
- ResultadoDeEstudios: Son los resultados de cada estudio realizado a cada paciente.
- Sede: Es la dirección que le corresponde a cada sede de las obras sociales.
- TurnoCita: Son los datos de un turno para un paciente que solicita una cita con un médico.
- TurnoEstudio: Son los datos de un turno para un paciente que solicita la realización de un estudio médico.

- CirugiaPaciente: Es una cirugía que se ha realizado un paciente.
- Diagnostico: Es el diagnóstico que puede recibir cada paciente, por ejemplo: gripe, diabetes, etc.
- DiagnosticoPaciente: Es el diagnóstico concreto que se ha dado a un paciente concreto.
- Empleado: Son los datos de cada empleado del hospital.
- EstudioMedico: Es cada estudio médico que pueden realizarse los pacientes, ejemplos: perfil renal, hemograma, electrocardiograma, etc.
- EstudioMedicoClasificacion: Tiene que ver con como se clasifican los diferentes estudios médicos, ejemplos: laboratorio, diagnóstico por imágenes, cardiológico, etc.
- FisioterapiaPaciente: Es el tratamiento por fisioterapia que se ha realizado en un paciente.
- MedicamentoPaciente: Es el tratamiento que se ha realizado en un paciente con un medicamento concreto.
- PsicoterapiaPaciente: Es el tratamiento psicológico que se ha realizado en un paciente.
- RadioterapiaPaciente: Es un tratamiento de radioterapia realizado en un paciente concreto.
- RolEmpleado: Es el rol que puede tener cada empleado, por ejemplo: cirujano, cardiólogo, cocinero, secretario, etc.
- Sector: Es el sector al que corresponde cada rol de los empleados, por ejemplo: medicina, limpieza, recursos humanso, gastronomía, etc.
- Signo: Son los signos que pueden presentar los pacientes de acuerdo a su diagnóstico: hiperglucemia, fiebre, etc.
- Sintoma: Son los sintomas que puede tener un paciente de acuerdo a su diagnóstico, por ejemplo: dolor de cabeza, nauseas, fatiga, etc.
- TratamientoQuirurgico: Son las cirugías que pueden realizarse en los pacientes, por ejemplo: cirugía a corazón abierto, cirugía de cadera, etc.

---

## Microservicio de Contacto

---

### Direccion

---

#### Solicitudes GET (Direccion)

##### {CONTACTO-SERVICIO}/direcciones/{id}

- Muestra una dirección buscando por id

##### {CONTACTO-SERVICIO}/direcciones

- Muestra todas las direcciones de la base de datos

##### {CONTACTO-SERVICIO}/direcciones/localidad?localidad={x}

- Muestra todas las direcciones que se encuentren en una laocalidad específica

##### {CONTACTO-SERVICIO}/direcciones/provincia?provincia={x}

- Muestra todas las direcciones que se encuentren en una provicnia específica

---

#### Solicitud POST (Direccion)

##### {CONTACTO-SERVICIO}/direcciones

- Guarda una dirección

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

#### Solicitud PUT (Direccion)

##### {CONTACTO-SERVICIO}/direcciones

- Edita una dirección de la base de datos

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

#### Solicitudes DELETE (Direccion)

##### {CONTACTO-SERVICIO}/direcciones/{id}

- Borra una dirección de la base de datos

---

#### Solicitudes PATCH (Direccion)

##### {CONTACTO-SERVICIO}/direcciones/{id}/calle?calle={x}

- Modifica la calle de una dirección

##### {CONTACTO-SERVICIO}/direcciones/{id}/altura?altura={x}

- Modifica la altura de una dirección

##### {CONTACTO-SERVICIO}/direcciones/{id}/departamento?departamento={x}

- Modifica el departamento de una dirección

##### {CONTACTO-SERVICIO}/direcciones/{id}/localidad?localidad-id={x}

- Modifica la localidad de una dirección

---

### Localidad

---

#### Solicitudes GET (Localidad) 

##### {CONTACTO-SERVICIO}/localidades/{id}

- Muestra una localidad buscándola por id

##### {CONTACTO-SERVICIO}/localidades

- Muestra todas las localidades de la base de datos

---

#### Solicitud POST (Localidad)

##### {CONTACTO-SERVICIO}/localidades

- Guarda una localidad en la base de datos con los datos del "body"

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

#### Solicitud PUT (Localidad)

##### {CONTACTO-SERVICIO}/localidades

- Modifica una localidad de acuerdo al "body" de la solicitud

- **body:**

~~~javascript
{
    id: nimero_entero,
    nombre: string,
    provincia: Provincia
}
~~~


---

#### Solicitud DELETE (Localidad)

##### {CONTACTO-SERVICIO}/localidades/{id}

- Borra una localidad de acuerdo al id de la url

---

#### Solicitudes PATCH (Localidad)

##### {CONTACTO-SERVICIO}/localidades/{id}/nombre?nombre={x}

- Modifica el nombre de una localidad de acuerdo al id de la url

##### {CONTACTO-SERVICIO}/localidades/{id}/provincia?provincia-id={x}

- Modifica la provicnia a la que perytenece una localidad de acuerdo al id de la url

---

### Pais

---

#### Solicitudes GET (Pais)

##### {CONTACTO-SERVICIO}/paises/{id}

- Muestra los datos de un pais de la base de datos de acuerdo al id de la URL

##### {CONTACTO-SERVICIO}/paises

- Muestra todos los paises de la base de datos

---

#### Solicitud POST (Pais)

##### {CONTACTO-SERVICIO}/paises

- Guarda un nuevo pais en la base de datos con los datos del "body" de la solicitud

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

#### Solicitud PUT (Pais)

##### {CONTACTO-SERVICIO}/paises

- Modifica un pais de la base de datos de usando los datos del "body" de la solicitud

- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

---

#### Solicitud DELETE (Pais)

##### {CONTACTO-SERVICIO}/paises/{id}

- Borra un pais de la base de datos de acuerdo al id de la URL

---

#### Solicitudes PATCH (Pais)

##### {CONTACTO-SERVICIO}/paises/{id}/nombre?nombre={x}

- Modifica el nombre de un pais de la base de datos de acuerdo al id de la URL

---

### Provincia

---

#### Solicitudes GET (Provincia) 

##### {CONTACTO-SERVICIO}/provincias

- Muestra todas las provicnias de la base de datos

##### {CONTACTO-SERVICIO}/provincias/{id}

- Muestra una provincia de la base de datos de acuerdo al id de la URL

##### {CONTACTO-SERVICIO}/provincias/nombre?nombre={x}

- Muestra una provincia de la base de datos buscándola por nombre

---

#### Solicitud POST (Provincia)

##### {CONTACTO-SERVICIO}/provincias

- Guarda una provincia en la base de datos con los datos de "body" de la solicitud

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

#### Solicitudes PUT (Provincia) <!-- Continuar desde acá-->

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

#### Solicitudes DELETE (Provincia)

##### {CONTACTO-SERVICIO}/provincias/{id}

---

#### Solicitudes PATCH (Provincia)

##### {CONTACTO-SERVICIO}/provincias/{id}/nombre?nombre={x}

##### {CONTACTO-SERVICIO}/provincias/{id}/pais?pais-id={x}

---

## Microservicio de Farmacia

---

### AccionTerapeutica

---

#### Solcitudes GET (AccionTerapeutica)

##### {FARMACIA-SERVICIO}/acciones-terapeuticas

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/nombre?nombre={x}

---

#### Solicitudes POST (AccionTerapeutica)

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

#### Solicitudes PUT (AccionTerapeutica)

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

#### Solicitudes DELETE (AccionTerapeutica)

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}

---

#### Solicitudes PATCH (AccionTerapeutica)

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}/nombre?nombre={x}

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}/descripcion <!-- ¿Request Body?-->

---

### AdministracionFarmaco

---

#### Solicitudes GET (AdministracionFarmaco)

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/{id}

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/via?via={x}

---

#### Solicitudes POST (AdministracionFarmaco)

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

#### Solicitudes PUT (AdministracionFarmaco)

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco

- **body:**

~~~javascript
{
    id: numero_entero,
    via: string
}
~~~

---

#### Solicitudes DELETE (AdministracionFarmaco)

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/{id}

---

#### Solicitudes PATCH (AdministracionFarmaco)

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/{id}/via?via={x}

---

### Dosis

---

#### Solicitudes GET (Dosis)

##### {FARMACIA-SERVICIO}/dosis/{id}

##### {FARMACIA-SERVICIO}/dosis

##### {FARMACIA-SERVICIO}/dosis/cantidad-unidad-intervalo?cantidad={x}&nombre-unidad={x}&intervalo={x}

---

#### Solicitudes POST (Dosis)

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

#### Solicitudes PUT (Dosis)

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

#### Solicitudes DELETE (Dosis)

##### {FARMACIA-SERVICIO}/dosis/{id}

---

#### Solicitudes PATCH (Dosis)

##### {FARMACIA-SERVICIO}/dosis/{id}/cantidad?cantidad={x}

##### {FARMACIA-SERVICIO}/dosis/{id}/unidad?unidad-id={x}

##### {FARMACIA-SERVICIO}/dosis/{id}/intervalo?intervalo={x}

---

### FormaFarmaceutica

---

#### Solicitudes GET (FormaFarmaceutica)

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/{id}

##### {FARMACIA-SERVICIO}/formas-farmaceuticas

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/nombre?nombre={x}

---

#### Solicitudes POST (FormaFarmaceutica)

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

### Solicitudes PUT (FormaFarmaceutica)

##### {FARMACIA-SERVICIO}/formas-farmaceuticas

~~~javascript
{
    id: numero_entero,
    nombre:string
}
~~~

---

#### Solicitudes DELETE (FormaFarmaceutica)

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/{id}

---

#### Solicitudes PATCH (FormaFarmaceutica)

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/{id}/nombre?nombre={x}

---

### MarcaMedicamento

---

#### Solicitudes GET (MarcaMedicamento)

##### {FARMACIA-SERVICIO}/marcas/{id}

##### {FARMACIA-SERVICIO}/marcas

##### {FARMACIA-SERVICIO}/marcas/nombre?nombre={x}

---

#### Solcitudes POST (MarcaMedicamento)

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

#### Solcitudes PUT (MarcaMedicamento)

##### {FARMACIA-SERVICIO}/marcas

- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

---

#### Solicitudes DELETE (MarcaMedicamento)

##### {FARMACIA-SERVICIO}/marcas/{id}

---

#### Solicitudes PATCH (MarcaMedicamento)

##### {FARMACIA-SERVICIO}/marcas/{id}/nombre?nombre={x}

---

### Medicamento

---

#### Solicitudes GET (Medicamento)

##### {FARMACIA-SERVICIO}/medicamentos/{id}

##### {FARMACIA-SERVICIO}/medicamentos

##### {FARMACIA-SERVICIO}/medicamentos/nombre?nombre={x}

##### {FARMACIA-SERVICIO}/medicamentos/principio-activo?nombre-principio-activo={x}

##### {FARMACIA-SERVICIO}/medicamentos/forma-farmaceutica?nombre-forma-farmaceutica={x}

##### {FARMACIA-SERVICIO}/medicamentos/administracion?via={x}

##### {FARMACIA-SERVICIO}/medicamentos/marca?nombre-marca={x}

---

#### Solicitudes POST (Medicamento)

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

#### Solicitudes PUT (Medicamento)

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

#### Solicitudes DELETE (Medicamento)

##### {FARMACIA-SERVICIO}/medicamentos/{id}

---

#### Solicitudes PATCH (Medicamento)

##### {FARMACIA-SERVICIO}/medicamentos/{id}/nombre?nombre={x}

##### {FARMACIA-SERVICIO}/medicamentos/{id}/agregar-principio-activo?principio-activo-id={x}

##### {FARMACIA-SERVICIO}/medicamentos/{id}/quitar-principio-activo?principio-activo-id={x}

##### {FARMACIA-SERVICIO}/medicamentos/{id}/forma-farmaceutica?forma-farmaceutica-id={x}

##### {FARMACIA-SERVICIO}/medicamentos/{id}/administracion?administracion-id={x}

##### {FARMACIA-SERVICIO}/medicamentos/{id}/marca?marca-id={x}

---

### PrincipioActivo

---

#### Solicitudes GET (PrincipioActivo)

##### {FARMACIA-SERVICIO}/principios-activos/{id}

##### {FARMACIA-SERVICIO}/principios-activos

##### {FARMACIA-SERVICIO}/principios-activos/nombre?nombre={x}

##### {FARMACIA-SERVICIO}/principios-activos/accion-terapeutica?nombre-accion-terapeutica={x}

---

#### Solicitudes POST (PrincipioActivo)

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

#### Solicitudes PUT (PrincipioActivo)

##### {FARMACIA-SERVICIO}/principios-activos

- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

---

#### Solicitudes DELETE (PrincipioActivo)

##### {FARMACIA-SERVICIO}/principios-activos/{id}

---

#### Solocitudes PATCH (PrincipioActivo)

##### {FARMACIA-SERVICIO}/principios-activos/{id}/agregar-accion-terapeutica?accion-terapeutica-id={x}

##### {FARMACIA-SERVICIO}/principios-activos/{id}/quitar-accion-terapeutica?accion-terapeutica-id={x}

---

### UnidadDeMedida

---

#### Solicitudes GET (UnidadDeMedida)

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}

##### {FARMACIA-SERVICIO}/unidades-de-medida

##### {FARMACIA-SERVICIO}/unidades-de-medida/nombre?nombre={x}

##### {FARMACIA-SERVICIO}/unidades-de-medida/simbolo?simbolo={x}

---

#### Solicitudes POST (UnidadDeMedida)

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

#### Solcitudes PUT (UnidadDeMedida)

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

#### Solicitudes DELETE (UnidadDeMedida)

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}

---

#### Solicitudes PATCH (UnidadDeMedida)

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}/nombre?nombre={x}

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}/simbolo?simbolo={x}

---

## Microservicio de Pacientes

---

### ObraSocial

---

#### Solcitudes GET (ObraSocial)

##### {PACIENTES-SERVICIO}/obras-sociales/{id}

##### {PACIENTES-SERVICIO}/obras-sociales

##### {PACIENTES-SERVICIO}/obras-sociales/nombre?nombre={x}

##### {PACIENTES-SERVICIO}/obras-sociales

---

#### Solicitudes POST (ObraSocial)

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

#### Solicitudes PUT (ObraSocial)

##### {PACIENTES-SERVICIO}/obras-sociales

- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

---

#### Soloicitudes DELETE (ObraSocial)

##### {PACIENTES-SERVICIO}/obras-sociales/{id}

---

#### Solicitudes PATCH (ObraSocial)

##### {PACIENTES-SERVICIO}/obras-sociales/{id}/nombvre?nombre={x}

---

### Paciente

---

#### Solicitudes GET (Paciente)

##### {PACIENTES-SERVICIO}/pacientes/{id}

##### {PACIENTES-SERVICIO}/pacientes

##### {PACIENTES-SERVICIO}/pacientes/dni?dni={x}

##### {PACIENTES-SERVICIO}/pacientes/nombre?nombre={x}

##### {PACIENTES-SERVICIO}/pacientes/apellido?apellido={x}

##### {PACIENTES-SERVICIO}/pacientes/email?email={x}

##### {PACIENTES-SERVICIO}/pacientes/telefono?numero-telefonico={x}

##### {PACIENTES-SERVICIO}/pacientes/fecha-nacimiento?desde={x}&hasta={x}

##### {PACIENTES-SERVICIO}/pacientes/lugar-nacimiento?localidad={x}

##### {PACIENTES-SERVICIO}/pacientes/domicilio?calle={x}

---

#### Solicitudes POST (Paciente)

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

#### Solicitudes PUT (Paciente)

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

#### Solicitudes DELETE (Paciente)

##### {PACIENTES-SERVICIO}/pacientes/{id}

---

#### Solicitudes PATCH (Paciente)

##### {PACIENTES-SERVICIO}/pacientes/{id}/dni?dni={x}

##### {PACIENTES-SERVICIO}/pacientes/{id}/primer-nombre?id-o-dni={x}&opcion={x}&nombre={x}

##### {PACIENTES-SERVICIO}/pacientes/{id}/segundo-nombre?id-o-dni={x}&opcion={x}&nombre={x}

##### {PACIENTES-SERVICIO}/pacientes/{id}/apellido-paterno?id-o-dni={x}&opcion={x}&apellido={x}

##### {PACIENTES-SERVICIO}/pacientes/{id}/apellido-materno?id-o-dni={x}&opcion={x}&apellido={x}

##### {PACIENTES-SERVICIO}/pacientes/{id}/email?id-o-dni={x}&opcion={x}&email={x}

##### {PACIENTES-SERVICIO}/pacientes/{id}/agregar-telefono?id-o-dni={x}&opcion={x}&telefono-para-agregar={x}

##### {PACIENTES-SERVICIO}/pacientes/{id}/quitar-telefono?id-o-dni={x}&opcion={x}&telefono-para-quitar={x}

##### {PACIENTES-SERVICIO}/pacientes/{id}/fecha-nacimiento?id-o-dni={x}&opcion={x}&fecha={x}

##### {PACIENTES-SERVICIO}/pacientes/{id}/lugar-nacimiento?id-o-dni={x}&opcion={x}&localidad-id={x}

##### {PACIENTES-SERVICIO}/pacientes/{id}/domicilio?id-o-dni={x}&opcion={x}&direccion-id={x}

##### {PACIENTES-SERVICIO}/pacientes/{id}/obra-social?id-o-dni={x}&opcion={x}&obra-social-id={x}

---

### ResultadosDeEstudios

---

#### Solicitudes GET (ResultadosDeEstudios)

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}

##### {PACIENTES-SERVICIO}/resultados-de-estudios

##### {PACIENTES-SERVICIO}/resultados-de-estudios/paciente?dni={x}

##### {PACIENTES-SERVICIO}/resultados-de-estudios/estudio?nombre-estudio={x}

---

#### Solicitudes POST (ResultadosDeEstudios)

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

#### Solicitudes PUT (ResultadosDeEstudios)

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

#### Solicitudes DELETE (ResultadosDeEstudios)

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}

---

#### Solicitudes PATCH (ResultadosDeEstudios)

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/paciente?id-o-dni-paciente={x}&opcion={x}

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/agregar-estudio?estudio-id={x}

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/quitar-estudio?estudio-id={x}

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/url-informe?url-informe={x}

---

### Sede

---

#### Solicitudes GET (Sede)

##### {PACIENTES-SERVICIO}/sedes/{id}

##### {PACIENTES-SERVICIO}/sedes

##### {PACIENTES-SERVICIO}/sedes/direccion?calle={x}

##### {PACIENTES-SERVICIO}/sedes/{id}/telefono?telefono={x}

---

#### Solicitudes POST (Sede)

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

#### Solicitudes PUT (Sede)

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

#### Solicitudes DELETE (Sede)

##### {PACIENTES-SERVICIO}/sedes/{id}

---

#### Solicitudes PATCH (Sede)

##### {PACIENTES-SERVICIO}/sedes/{id}/direccion?direccion-id={x}

##### {PACIENTES-SERVICIO}/sedes/{id}/agregar-telefono?telefono={x}

##### {PACIENTES-SERVICIO}/sedes/{id}/quitar-telefono?telefono={x}

##### {PACIENTES-SERVICIO}/sedes/{id}/obra-social?obra-social-id={x}

---

### TurnoCita

---

#### Solicitudes GET (TurnoCita)

##### {PACIENTES-SERVICIO}/turnos-cita/{id}

##### {PACIENTES-SERVICIO}/turnos-cita

##### {PACIENTES-SERVICIO}/turnos-cita/paciente?dni={x}

##### {PACIENTES-SERVICIO}/turnos-cita/fecha-turno?fecha-turno={x}

##### {PACIENTES-SERVICIO}/turnos-cita/periodo?desde={x}&hasta={x}

##### {PACIENTES-SERVICIO}/turnos-cita/profesional?profesional-id={x}

---

#### Solicitudes POST (TurnoCita)

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

#### Solicitudes PUT (TurnoCita)

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

#### Solicitudes DELETE (TurnoCita)

##### {PACIENTES-SERVICIO}/turnos-cita/{id}

---

#### Solicitudes PATCH (TurnoCita)

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/paciente?id-o-dni-paciente={x}&opcion={x}

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/fecha-solicitud?fecha-solicitud={x}

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/horario?inicio={x}&fin={x}

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/estado?estado={x}

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/cobertura?cobertura={x}

---

### TurnoEstudio

---

#### Solicitudes GET (TurnoEstudio)

##### {PACIENTES-SERVICIO}/turnos-estudio/{id}

##### {PACIENTES-SERVICIO}/turnos-estudio

##### {PACIENTES-SERVICIO}/turnos-cita/paciente?dni={x}

##### {PACIENTES-SERVICIO}/turnos-cita/fecha-turno?fecha-turno={x}

##### {PACIENTES-SERVICIO}/turnos-cita/periodo?desde={x}&hasta={x}

##### {PACIENTES-SERVICIO}/turnos-estudio/estudio?estudio-id={x}

---

#### Solicitudes POST (TurnoEstudio)

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

#### Solicitudes PUT (TurnoEstudio)

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

#### Solicitudes DELETE (TurnoEstudio)

##### {PACIENTES-SERVICIO}/turnos-estudio/{id}

---

#### Solicitudes PATCH (TurnoEstudio)

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/paciente?id-o-dni-paciente={x}&opcion={x}

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/fecha-solicitud?fecha-solicitud={x}

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/horario?inicio={x}&fin={x}

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/estado?estado={x}

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/cobertura?cobertura={x}

##### {PACIENTES-SERVICIO}/turnos-estudio/{id}/estudio?estudio-id={x}

---

## Microservicio de Hospital

---

### CirugiaPaciente

---

#### Solicitudes GET (CirugiaPaciente)

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}

##### {HOSPITAL-SERVICIO}/cirugias-pacientes

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/paciente?paciente-id-o-dni={x}&opcion={x}

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/cirugia?cirugia={x}

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/periodo?desde={x}&hasta={x}

---

#### Solicitudes POST (CirugiaPaciente)

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

#### Solicitudes PUT (CirugiaPaciente)

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

#### Solicitudes DELETE (CirugiaPaciente)

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}

---

#### Solicitudes PATCH (CirugiaPaciente)

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/paciente?paciente-id-o-dni={x}&opcion={x}

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/cirugia?cirugia-id={x}

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/fecha?fecha={x}

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/hora-inicio?inicio={x}

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/hota-final?fin={x}

---

### Diagnostico

---

#### Solicitudes GET (Diagnostico)

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}

##### {HOSPITAL-SERVICIO}/diagnosticos

##### {HOSPITAL-SERVICIO}/diagnosticos/nombre?nombre={x}

---

#### Solicitudes POST (Diagnostico)

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

#### Solicitudes PUT (Diagnostico)

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

#### Solicitudes DELETE (Diagnostico)

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}

---

#### Solicitudes PATCH (Diagnostico)

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/agregar-sintoma?sintoma-id={x}

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/quitar-sintoma?sintoma-id={x}

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/agregar-signo?signo-id={x}

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/quitar-signo?signo-id={x}

---

### DiagnosticoPaciente

---

#### Solicitudes GET (DiagnosticoPaciente)

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/paciente?pacinete-id-o-dni={x}&opcion={x}

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/diagnostico?diagnostico={x}

---

#### Solicitudes POST (DiagnosticoPaciente)

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

#### Solicitudes PUT (DiagnosticoPaciente)

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

#### Solicitudes DELETE (DiagnosticoPaciente)

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}

---

#### Solicitudes PATCH (DiagnosticoPaciente)

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/paciente?paciente-id-o-dni={x}&opcion={x}

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/diagnostico?diagnostico-id={x}

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/fecha-inicio?inicio={x}

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/fecha-final?fin={x}

---

### Empleado

---

#### Solicitudes GET (Empleado)

##### {HOSPITAL-SERVICIO}/empleados/{id}

##### {HOSPITAL-SERVICIO}/empleados

##### {HOSPITAL-SERVICIO}/empleados/dni?dni={x}

##### {HOSPITAL-SERVICIO}/empleados/nombre?nombre={x}

##### {HOSPITAL-SERVICIO}/empleados/apellido?apellido={x}

##### {HOSPITAL-SERVICIO}/empleados/email?email={x}

##### {HOSPITAL-SERVICIO}/empleados/matricula?matricula={x}

##### {HOSPITAL-SERVICIO}/empleados/rol?rol={x}

##### {HOSPITAL-SERVICIO}/empleados/rango-salarial?minimo={x}&maximo={x}

---

#### Solicitudes POST (Empleado)

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

#### Solicitudes PUT (Empleado)

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

#### Solicitudes DELETE (Empleado)

##### {HOSPITAL-SERVICIO}/empleados/{id}

---

#### Solicitudes PATCH (Empleado)

##### {HOSPITAL-SERVICIO}/empleados/{id}/dni?dni={x}

##### {HOSPITAL-SERVICIO}/empleados/{id}/primer-nombre?primer-nombre={x}

##### {HOSPITAL-SERVICIO}/empleados/{id}/segundo-nombre?segundo-nombre={x}

##### {HOSPITAL-SERVICIO}/empleados/{id}/apellido-paterno?apellido-paterno={x}

##### {HOSPITAL-SERVICIO}/empleados/{id}/apellido-materno?apellido-materno={x}

##### {HOSPITAL-SERVICIO}/empleados/{id}/email?email={x}

##### {HOSPITAL-SERVICIO}/empleados/{id}/domicilio?domicilio-id={x}

##### {HOSPITAL-SERVICIO}/empleados/{id}/agregar-telefono?telefono={x}

##### {HOSPITAL-SERVICIO}/empleados/{id}/quitar-telefono?telefono={x}

##### {HOSPITAL-SERVICIO}/empleados/{id}/matricula?matricula={x}

##### {HOSPITAL-SERVICIO}/empleados/{id}/rol?rol-id={x}

##### {HOSPITAL-SERVICIO}/empleados/{id}/salario?salario={x}

---

### EstudioMedicoClasificacion

---

#### Solictudes GET (EstudioMedicoClasificacion)

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos/{id}

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos


##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos/nombre?nombre={x}

---

#### Solicitudes POST (EstudioMedicoClasificacion)

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

#### Solicitudes PUT (EstudioMedicoClasificacion)

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos

- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

---

#### Solicitudes DELETE (EstudioMedicoClasificacion)

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos/{id}

---

#### Solicitudes PATCH (EstudioMedicoClasificacion)

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos/{id}/nombre?nombre={x}

---

### EstudioMedico

---

#### Solicitudes GET (EstudioMedico)

##### {HOSPITAL-SERVICIO}/estudios-medicos/{id}

##### {HOSPITAL-SERVICIO}/estudios-medicos

##### {HOSPITAL-SERVICIO}/estudios-medicos/nombre?nombre={x}

##### {HOSPITAL-SERVICIO}/estudios-medicos/clasificacion?clasificacion={x}

---

#### Soplicitudes POST (EstudioMedico)

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

#### Solicitudes PUT (EstudioMedico)

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

#### Solictudes DELETE (EstudioMedico)

##### {HOSPITAL-SERVICIO}/estudios-medicos/{id}

---

#### Solictudes PATCH (EstudioMedico)

##### {HOSPITAL-SERVICIO}/estudios-medicos/{id}/nombre?nombre={x}

##### {HOSPITAL-SERVICIO}/estudios-medicos/{id}/cladificacion?clasificacion={x}

---

### FisioterapiaPaciente

---

#### Solicitudes GET (FisioterapiaPaciente)

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/paciente?paciente-id-o-dni={x}&opcion={x}

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/fecha-inicio?desde={x}&hasta={x}

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/fecha-final?desde={x}&hasta={x}

---

#### Solicitudes POST (FisioterapiaPaciente)

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

#### Solicitudes PUT (FisioterapiaPaciente)

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

#### Solicitudes DELETE (FisioterapiaPaciente)

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}

---

#### Solicitudes PATCH (FisioterapiaPaciente)

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}/paciente-id-o-dni={x}&opcion={x}

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}/fecha-inicio?inicio={x}

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}/fecha-final?final={x}

---

### MedicamentoPaciente

---

#### Solicitudes GET (MedicamentoPaciente)

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/paciente?paciente-id-o-dni={x}&opcion={x}

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/principio-activo?principio-activo={x}

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/fecha-inicio?desde={x}&hasta={x}

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/fecha-final?desde={x}&hasta={x}

---

#### Solicitudes POST (MedicamentoPaciente)

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

#### Solicitudes PUT (MedicamentoPaciente)

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

#### Solicitudes DELETE (MedicamentoPaciente)

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}

---

#### Solicitudes PATCH (MedicamentoPaciente)

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/paciente?paciente-id-o-dni={x}&opcion={x}

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/medicamento?medicamento-id={x}

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/dosis?dosis-id={x}

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/fecha-inicio?inicio={x}

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/fecha-final?fin={x}

---

### PsicoterpiaPaciente

---

#### Solicitudes GET (PsicoterpiaPaciente)

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/paciente?paciente-id-o-dni={x}&opcion={x}

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/fecha-inicio?desde={x}&hasta={x}

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/fecha-final?desde={x}&hasta={x}

---

#### Solicitudes POST (PsicoterpiaPaciente)

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

#### Solicitudes PUT (PsicoterpiaPaciente)

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

#### Solicitudes DELETE (PsicoterpiaPaciente)

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}

---

#### Solicitudes PATCH (PsicoterpiaPaciente)

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}/paciente?paciente-id-o-dni={x}&opcion={x}

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}/fecha-inicio?inicio={x}

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}/fecha-final?fin={x}

---

### RadioTerapiaPaciente

---

#### Solicitudes GET (RadioTerapiaPaciente)

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/paciente?paciente-id-o-dni={x}&opcion={x}

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/fecha-inicio?desde={x}&hasta={x}

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/fecha-final?desde={x}&hasta={x}

---

#### Solicitudes POST (RadioTerapiaPaciente)

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

#### Solicitudes PUT (RadioTerapiaPaciente)

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
#### Solcitudes DELETE (RadioTerapiaPaciente)

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}

---

#### Solicitudes PATCH (RadioTerapiaPaciente)

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}/paciente?paciente-id-o-dni={x}&opcion={x}

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}/fecha-inicio?inicio={x}

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}/fecha-final?fin={x}

---

### RolEmpleado

---

#### Solicitudes GET (RolEmpleado)

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}

##### {HOSPITAL-SERVICIO}/roles-empleado

##### {HOSPITAL-SERVICIO}/roles-empleado/nombre?nombre={x}

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}/sector?sector={x}

---

#### Solicitudes POST (RolEmpleado)

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
#### Solicitudes PUT (RolEmpleado)

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

#### Solicitudes DELETE (RolEmpleado)

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}

---

#### Solicitudes PATCH (RolEmpleado)

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}/nombre?nombre

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}/sector?sector-id={x}

---

### Sector

---

#### Solicitudes GET (Sector)

##### {HOSPITAL-SERVICIO}/sectores/{id}

##### {HOSPITAL-SERVICIO}/sectores

##### {HOSPITAL-SERVICIO}/sectores/nombre?nombre={x}
---

#### Solicitudes POST (Sector)

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

#### Solicitudes PUT (Sector)

##### {HOSPITAL-SERVICIO}/sectores


~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

---

#### Solicitudes DELETE (Sector)

##### {HOSPITAL-SERVICIO}/sectores/{id}

---

#### Solicitudes PATCH (Sector)

##### {HOSPITAL-SERVICIO}/sectores/{id}/nombre?nombre={x}

---

### Signo

---

#### Solicitudes GET (Signo)

##### {HOSPITAL-SERVICIO}/signos/{id}

##### {HOSPITAL-SERVICIO}/signos

##### {HOSPITAL-SERVICIO}/signos/nombre?nombre={x}

##### {HOSPITAL-SERVICIO}/signos/unidad?unidad={x}

##### {HOSPITAL-SERVICIO}/signos/descripcion?secuencia={x}

---

#### Solicitudes POST (Signo)

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
#### Solictudes PUT (Signo)

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

#### Solictudes DELETE (Signo)

##### {HOSPITAL-SERVICIO}/signos/{id}

---

#### Solictudes PATCH (Signo)

##### {HOSPITAL-SERVICIO}/signos/{id}/nombre?nombre={x}

##### {HOSPITAL-SERVICIO}/signos/{id}/valor-minimo?valor-minimo={x}

##### {HOSPITAL-SERVICIO}/signos/{id}/valor-maximo?valor-maximo={x}

##### {HOSPITAL-SERVICIO}/signos/{id}/unidad?unidad-id={x}

##### {HOSPITAL-SERVICIO}/signos/{id}/descripcion

- **body:**

~~~javascript
{
    texto: string
}
~~~

---

### Sintoma

---

#### Solicitudes GET (Sintoma)

##### {HOSPITAL-SERVICIO}/sintomas/{id}

##### {HOSPITAL-SERVICIO}/sintomas

##### {HOSPITAL-SERVICIO}/sintomas/nombre?nombre={x}

---

#### Solicitudes POST (Sintoma)

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

#### Solicitudes PUT (Sintoma)

##### {HOSPITAL-SERVICIO}/sintomas


- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

---

#### Solicitudes DELETE (Sintoma)

##### {HOSPITAL-SERVICIO}/sintomas/{id}

---

#### Solicitudes PATCH (Sintoma)

##### {HOSPITAL-SERVICIO}/sintomas/{id}/nombre?nombre={x}

---

### TratamientoQuirurgico

---

#### Solicitudes GET (TratamientoQuirurgico)

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/{id}

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/nombre?nombre={x}

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/descripcion?descripcion={x}

---

#### Solicitudes POST (TratamientoQuirurgico)

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

#### Solicitudes PUT (TratamientoQuirurgico)

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

#### Solicitudes DELETE (TratamientoQuirurgico)

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/{id}

---

#### Solcitudes PATCH (TratamientoQuirurgico)

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/{id}/nombre?nombre={x}

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/{id}/descripcion 


- **body:**

~~~javascript
{
    texto: string
}
~~~
