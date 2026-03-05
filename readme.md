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

### Entidad Direccion

---

#### Solicitudes GET (Direccion)

##### {CONTACTO-SERVICIO}/direcciones/{id}

- Muestra una dirección buscando por id

##### {CONTACTO-SERVICIO}/direcciones

- Muestra todas las direcciones de la base de datos

##### {CONTACTO-SERVICIO}/direcciones/localidad?localidad={x}

- Muestra todas las direcciones que se encuentren en una localidad específica

##### {CONTACTO-SERVICIO}/direcciones/provincia?provincia={x}

- Muestra todas las direcciones que se encuentren en una provicnia específica

---

#### Solicitud POST (Direccion)

##### {CONTACTO-SERVICIO}/direcciones

- Guarda una dirección de acuerdo al "body" de la solicitud

- **body:**

~~~javascript
{
    calle: string,
    altura: numero_entero,
    departamento: string,
    localidad: Localidad
}
~~~

- **Ejemplo:**

~~~json
{
    "calle": "san martín",
    "altura": 5612,
    "departamento": "1A",
    "localidad":{
        "id":4
    }
}
~~~

---

#### Solicitud PUT (Direccion)

##### {CONTACTO-SERVICIO}/direcciones

- Edita una dirección de la base de datos de acuerdo al "body" de la solicitud

- **body**

~~~javascript
{
    id: numero_entero,
    calle: string,
    altura: numero_entero,
    departamento: string,
    localidad: Localidad
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

### Entidad Localidad

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
    "provincia":{
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
    id: numero_entero,
    nombre: string,
    provincia: Provincia
}
~~~


---

#### Solicitud DELETE (Localidad)

##### {CONTACTO-SERVICIO}/localidades/{id}

- Borra una localidad de acuerdo al id de la URL

---

#### Solicitudes PATCH (Localidad)

##### {CONTACTO-SERVICIO}/localidades/{id}/nombre?nombre={x}

- Modifica el nombre de una localidad de acuerdo al id de la URL

##### {CONTACTO-SERVICIO}/localidades/{id}/provincia?provincia-id={x}

- Modifica la provincia a la que perytenece una localidad de acuerdo al id de la URL

---

### Entidad Pais

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

### Entidad Provincia

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

#### Solicitudes PUT (Provincia)

##### {CONTACTO-SERVICIO}/provincias

- Modifica una provincia

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

- Borra una provincia de la base de datos de acuerdo a su id

---

#### Solicitudes PATCH (Provincia)

##### {CONTACTO-SERVICIO}/provincias/{id}/nombre?nombre={x}

- Modifica el nombre de una provincia buscándola por id

##### {CONTACTO-SERVICIO}/provincias/{id}/pais?pais-id={x}

- Modifica el pais al que pertyenece una provincia asignándole el id del pais que corresponda

---

## Microservicio de Farmacia

---

### Entidad AccionTerapeutica

---

#### Solcitudes GET (AccionTerapeutica)

##### {FARMACIA-SERVICIO}/acciones-terapeuticas

- Muestra todas las acciones terapéuticas de la base de datos

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}

- Muestra una acción terapéutica buscándola por su id

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/nombre?nombre={x}

- Muestra un acción terapéutica buscándola por su nombre

---

#### Solicitudes POST (AccionTerapeutica)

##### {FARMACIA-SERVICIO}/acciones-terapeuticas

- Guarda una acción terpéutica en la base de datos con los datos del "body" de la solicitud

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

- Modifica una acción terapéutica de acuerdo al id que colocamos en el "body" de la solicitud

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

- Borra una acción terapéutica de acuerdo al id de la URL

---

#### Solicitudes PATCH (AccionTerapeutica)

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}/nombre?nombre={x}

- Modifica el nombre de una acción terapéutica de acuerdo al id de la URL

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}/descripcion 

- Modifica la descripción de una acción terapéutica de acuerdo al id de la URL y al texto del "body"

- **body:**

~~~javascript
{
    texto: string
}
~~~

---

### Entidad AdministracionFarmaco

---

#### Solicitudes GET (AdministracionFarmaco)

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/{id}

- Muestra un administración de fármaco buscándola por el id

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco

- Muestra todas las administraciones de fármaco de la base de datos

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/via?via={x}

- Muestra una administración de fármaco buscándola por la vía

---

#### Solicitudes POST (AdministracionFarmaco)

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco

- Guarda una administración de fármaco nueva en la base de datos con la información del "body" de la solicitud

- **body:**

~~~javascript
{
    via: string
}
~~~

- **Ejemplo:**

~~~json
{
    "via": "oftálmica"
}
~~~

---

#### Solicitudes PUT (AdministracionFarmaco)

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco

- Modifica una administración de fármaco con la información del "body" de la solicitud

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

- Borra una administración de fármaco de la base de datos de acuerdo al id de la URL

---

#### Solicitudes PATCH (AdministracionFarmaco)

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/{id}/via?via={x}

- Modifica la vía de una administración de fármaco de acuerdo a los datos en la URL

---

### Entidad Dosis

---

#### Solicitudes GET (Dosis)

##### {FARMACIA-SERVICIO}/dosis/{id}

- Muestra una dosis de la base de datos buscándola por el id

##### {FARMACIA-SERVICIO}/dosis

- Muestra todas las dosis de la base de datos

##### {FARMACIA-SERVICIO}/dosis/cantidad-unidad-intervalo?cantidad={x}&nombre-unidad={x}&intervalo={x}

- Busca una dosis de la base de datos de acuerdo a los datos de la URL.

---

#### Solicitudes POST (Dosis)

##### {FARMACIA-SERVICIO}/dosis

- Guarda una dosis en la base de datos de acuerdo a los datos del "body"

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

- Modifica una dosis de la base de datos de acuerdo a los datos del "body"

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

- Borra una dosis de la base de datos de acuerdo al id de la URL

---

#### Solicitudes PATCH (Dosis)

##### {FARMACIA-SERVICIO}/dosis/{id}/cantidad?cantidad={x}

- Modifica la cantidad de la dosis de acuerdo a lo establecido en la URL

##### {FARMACIA-SERVICIO}/dosis/{id}/unidad?unidad-id={x}

- Modifica la unidad de la dosis de acuerdo a lo establecido en la URL

##### {FARMACIA-SERVICIO}/dosis/{id}/intervalo?intervalo={x}

- Modifica el intervalo de tiempo de la dosis de acuerdo a lo establecido en la URL

---

### Entidad FormaFarmaceutica

---

#### Solicitudes GET (FormaFarmaceutica)

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/{id}

- Muestra una forma farmacéutica de la base de datos buscándola por id

##### {FARMACIA-SERVICIO}/formas-farmaceuticas

- Muestra todas las formas farmacéuticas de la base de datos

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/nombre?nombre={x}

- Muestra una forma farmacéutica de la base de datos buscándola por su nombre

---

#### Solicitudes POST (FormaFarmaceutica)

##### {FARMACIA-SERVICIO}/formas-farmaceuticas

- Guarda una forma farmacéutica en la base de datos con los datos del "body"

- **body:**

~~~javascript
{
    nombre: string
}
~~~

- **Ejemplo:**

~~~json
{
    "nombre": "crema"
}
~~~


---

### Solicitudes PUT (FormaFarmaceutica)

##### {FARMACIA-SERVICIO}/formas-farmaceuticas

- Modifica una forma farmacértica de la base de datos de acuerdo a los datos del "body" 

- **body:**

~~~javascript
{
    id: numero_entero,
    nombre:string
}
~~~

---

#### Solicitudes DELETE (FormaFarmaceutica)

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/{id}

- Borra una forma farmacéutica de la base de datos de acuerodo al id de la URL

---

#### Solicitudes PATCH (FormaFarmaceutica)

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/{id}/nombre?nombre={x}

- Modifica el nombre de una forma farmacéutica de acuerdo a lo establecido en la URL

---

### Entidad MarcaMedicamento

---

#### Solicitudes GET (MarcaMedicamento)

##### {FARMACIA-SERVICIO}/marcas/{id}

- Mesutra una marca de medicamento de la base de datos buscándola por id

##### {FARMACIA-SERVICIO}/marcas

- Muestra todas las marcas de medicamento de la base de datos

##### {FARMACIA-SERVICIO}/marcas/nombre?nombre={x}

- Muestra una marca de medicamento de la base de datos buscándola por nombre

---

#### Solcitudes POST (MarcaMedicamento)

##### {FARMACIA-SERVICIO}/marcas

- Guarda una marca de medicamento en la base de datos de acuerdo a los datos del "body"

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

- Modifica una marca de medicamento de la base de datos de acuerdo a los datos del "body"

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

- Borra una marca de medicamento de la base de datos de acuerdo al id de la URL

---

#### Solicitudes PATCH (MarcaMedicamento)

##### {FARMACIA-SERVICIO}/marcas/{id}/nombre?nombre={x}

- Modifica el nombre de una marca de medicamento de acuerdo a lo establecido en la URL

---

### Entidad Medicamento

---

#### Solicitudes GET (Medicamento)

##### {FARMACIA-SERVICIO}/medicamentos/{id}

- Muestra un medicamento de la base de datos buscándolo por id

##### {FARMACIA-SERVICIO}/medicamentos

- Muestra todos los medicamentos de la base de datos

##### {FARMACIA-SERVICIO}/medicamentos/nombre?nombre={x}

- Muestra un medicamento de la base de datos buscándolo por nombre

##### {FARMACIA-SERVICIO}/medicamentos/principio-activo?nombre-principio-activo={x}

- Muestra todos los medicamentos que posean el principio activo establecido en la URL

##### {FARMACIA-SERVICIO}/medicamentos/forma-farmaceutica?nombre-forma-farmaceutica={x}

- Muestra todos los medicamentos que posean la forma farmacéutica establecida en la URL

##### {FARMACIA-SERVICIO}/medicamentos/administracion?via={x}

- Muestra todos los medicamentos que se admnistren por la vía establecida en la URL

##### {FARMACIA-SERVICIO}/medicamentos/marca?nombre-marca={x}

- Muestra todos los medicamentos de la marca establecida en la URL

---

#### Solicitudes POST (Medicamento)

##### {FARMACIA-SERVICIO}/medicamentos

- Guarda en la base de datos un medicamento de acuerdo a lo establecido en el body de la solicitud

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

- Modifica un medicamento de la base de datos de acuerdo a lo establecido en el "body" de la solicitud

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

- Borra un medicamento de la base de datos de acuerdo al id establecido en la URL

---

#### Solicitudes PATCH (Medicamento)

##### {FARMACIA-SERVICIO}/medicamentos/{id}/nombre?nombre={x}

- Modifica el nombre de un medicamento de la base de datos de acuerdo a los datos de la URL

##### {FARMACIA-SERVICIO}/medicamentos/{id}/agregar-principio-activo?principio-activo-id={x}

- Agrega un principio activo a un medicamento de la base de datos de acuerdo a lo establecido en la URL

##### {FARMACIA-SERVICIO}/medicamentos/{id}/quitar-principio-activo?principio-activo-id={x}

- Quita un principio activo de un medicamento de la base de datos de acuerdo a lo establecido en la URL

##### {FARMACIA-SERVICIO}/medicamentos/{id}/forma-farmaceutica?forma-farmaceutica-id={x}

- Modifica la forma farmacéutica de un medicamento de la base de datos de acuerdo a lo establecido en la URL  

##### {FARMACIA-SERVICIO}/medicamentos/{id}/administracion?administracion-id={x}

- Modifica la vía de administración de un medicamento de acuerdo a lo establecido en la URL

##### {FARMACIA-SERVICIO}/medicamentos/{id}/marca?marca-id={x}

- Modifica la marca de un medicamento de la base de datos de acuerdo a lo establecido en la URL

---

### Entidad PrincipioActivo

---

#### Solicitudes GET (PrincipioActivo)

##### {FARMACIA-SERVICIO}/principios-activos/{id}

- Muestra un principio activo de la base de datos buscándolo por la URL

##### {FARMACIA-SERVICIO}/principios-activos

- Muestra todos los principios activos de la base de datos

##### {FARMACIA-SERVICIO}/principios-activos/nombre?nombre={x}

- Muestra un principio activo de la base de datos buscándolo por su nombre

##### {FARMACIA-SERVICIO}/principios-activos/accion-terapeutica?nombre-accion-terapeutica={x}

- Muestra todos los principios activos de la base de datos que contengan la acción terpaéutica estalbecida en la URL

---

#### Solicitudes POST (PrincipioActivo)

##### {FARMACIA-SERVICIO}/principios-activos

- Guarda un principio activo en la base de datos de acuerdo a los datos establecidos en el "body"

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

- Modifica un principio activo de acuerdo  a los datos estblecidos en el "body"

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

- Borra un principio activo de la base de datos de acuerdo al id establecido en la URL

---

#### Solocitudes PATCH (PrincipioActivo)

##### {FARMACIA-SERVICIO}/principios-activos/{id}/agregar-accion-terapeutica?accion-terapeutica-id={x}

- Agrega una acción terapéutica a un principio activo de acuerdo a lo establecido en la URL

##### {FARMACIA-SERVICIO}/principios-activos/{id}/quitar-accion-terapeutica?accion-terapeutica-id={x}

- Quita una acción terapéutica a un principio activo de acuerdo a lo establecido en la URL

---

### Entidad UnidadDeMedida

---

#### Solicitudes GET (UnidadDeMedida)

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}

- Muestra una unidad de medida de la base de datos buscándola por id

##### {FARMACIA-SERVICIO}/unidades-de-medida

- Muestra todas las unidades de medida de la base de datos

##### {FARMACIA-SERVICIO}/unidades-de-medida/nombre?nombre={x}

- Muestra una udnidad de medida de la base de datos buscándola por su nombre

##### {FARMACIA-SERVICIO}/unidades-de-medida/simbolo?simbolo={x}

- Muestra una unidad de la base de datos buscándola por su símbolo

---

#### Solicitudes POST (UnidadDeMedida)

##### {FARMACIA-SERVICIO}/unidades-de-medida

- Guarda una undidad de medida en la base de datos de acuerdo a lo establecido en el body

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

- Modifica un unidad de medida de acuerdo a lo establecido en el "body"

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

- Elimina una unidad de medida de la bsse de datos de acuerdo a lo establecido en la URL

---

#### Solicitudes PATCH (UnidadDeMedida)

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}/nombre?nombre={x}

- Modifica el nombre de una unidad de medida de acuerod a lo estsblecido en la URL

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}/simbolo?simbolo={x}

- Modifica el símbolo de una unidad de medida de acuerdo a lo establecido en la URL

---

## Microservicio de Pacientes

---

### Entidad ObraSocial

---

#### Solcitudes GET (ObraSocial)

##### {PACIENTES-SERVICIO}/obras-sociales/{id}

- Muestra un obra social buscándola por id

##### {PACIENTES-SERVICIO}/obras-sociales

- Muestra todas las obras sociales de la base de datos

##### {PACIENTES-SERVICIO}/obras-sociales/nombre?nombre={x}

- Muestra una obra social de la base de datos buscándola por su nombre

---

#### Solicitudes POST (ObraSocial)

##### {PACIENTES-SERVICIO}/obras-sociales

- Guarda una obra social en una base de datos de acuerdo a lo establecido en el "body" de la solicitud

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

- Modifica una obra social de la base de datos de acuerdo al "body" de la solicitud

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

- Borra una obra social de la base de datos de acuerdo al id de la URL

---

#### Solicitudes PATCH (ObraSocial)

##### {PACIENTES-SERVICIO}/obras-sociales/{id}/nombre?nombre={x}

- Modifica el nombre de una obra social de acuerdo a lo establecido en la URL de la solicitud

---

### Entidad Paciente

---

#### Solicitudes GET (Paciente)

##### {PACIENTES-SERVICIO}/pacientes/{id}

- Muestra un apciente de la base de datos de acuerdo al id de la URL

##### {PACIENTES-SERVICIO}/pacientes

- Muestra todos los pacientes de la base de datos

##### {PACIENTES-SERVICIO}/pacientes/dni?dni={x}

- Muestra a un paciente de la base de datos de acuerdo al DNI de la URL

##### {PACIENTES-SERVICIO}/pacientes/nombre?nombre={x}

- Muestra a los pacientes de la base de datos que posean el nombre establecido en la URL

##### {PACIENTES-SERVICIO}/pacientes/apellido?apellido={x}

- Muestra a los pacientes de la base de datos que posean el apellido establecido en la URL

##### {PACIENTES-SERVICIO}/pacientes/email?email={x}

- Muestra a un paciente de la base de datos de acuerdo al email de la URL

##### {PACIENTES-SERVICIO}/pacientes/telefono?numero-telefonico={x}

- Muestra a los pacientes de la base de datos que posean el número telefónico de la URL

##### {PACIENTES-SERVICIO}/pacientes/fecha-nacimiento?desde={x}&hasta={x}

- Muestra a los pacientes de la base de datos cuya fecha de nacimiento esté comprendida en el intervalo establecido en la URL

##### {PACIENTES-SERVICIO}/pacientes/lugar-nacimiento?localidad={x}

- Muestra a los pacientes cuya localidad de nacimiento sea la establecida en la URL

##### {PACIENTES-SERVICIO}/pacientes/domicilio?calle={x}

- Muestra a los pacientes de la base de datos cuyo domicilio se encuentre en la calle de la URL

---

#### Solicitudes POST (Paciente)

##### {PACIENTES-SERVICIO}/pacientes

- Guarda un paciente en la base de datos de acuerdo a lo establecido en el "body" de la solicitud

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
    fechaNacimiento: fecha,
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

- Modifica un paciente de la base de datos de acuerdo a lo establecido en el "body" de la solicitud

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
    fechaNacimiento: fecha,
    lugarNacimientoId: numero_entero,
    direccionId: numero_entero,
    obraSocial: ObraSocial
}
~~~

---

#### Solicitudes DELETE (Paciente)

##### {PACIENTES-SERVICIO}/pacientes/{id}

- Borra un paciente de la base de datos de acuerdo al id de la URL

---

#### Solicitudes PATCH (Paciente)

##### {PACIENTES-SERVICIO}/pacientes/{id}/dni?dni={x}

- Modifica el DNI de un paciente de acuerdo a lo establecido en la URL

##### {PACIENTES-SERVICIO}/pacientes/{id}/primer-nombre?id-o-dni={x}&opcion={x}&nombre={x}

- Modifica el primer nombre de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/{id}/segundo-nombre?id-o-dni={x}&opcion={x}&nombre={x}

- Modifica el segundo nombre de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/{id}/apellido-paterno?id-o-dni={x}&opcion={x}&apellido={x}

- Modifica el apellido paterno de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/{id}/apellido-materno?id-o-dni={x}&opcion={x}&apellido={x}

- Modifica el apellido materno de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/{id}/email?id-o-dni={x}&opcion={x}&email={x}

- Modifica el email de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/{id}/agregar-telefono?id-o-dni={x}&opcion={x}&telefono-para-agregar={x}

- Agrega un número telefónico a un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/{id}/quitar-telefono?id-o-dni={x}&opcion={x}&telefono-para-quitar={x}

- Quita un número telefónico a un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/{id}/fecha-nacimiento?id-o-dni={x}&opcion={x}&fecha={x}

- Modifica la fecha de nacimiento de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/{id}/lugar-nacimiento?id-o-dni={x}&opcion={x}&localidad-id={x}

- Modifica el lugar de nacimiento de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/{id}/domicilio?id-o-dni={x}&opcion={x}&direccion-id={x}

- Modifica el domicilio de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/{id}/obra-social?id-o-dni={x}&opcion={x}&obra-social-id={x}

- Modifica la obra social de un paciente buscándolo por id o DNI

---

### Entidad ResultadosDeEstudios

---

#### Solicitudes GET (ResultadosDeEstudios)

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}

- Muestra los resultados de estudios de un paciente de acuerdo al id de la URL

##### {PACIENTES-SERVICIO}/resultados-de-estudios

- Muestra todos los resultados de estudios de la base de datos

##### {PACIENTES-SERVICIO}/resultados-de-estudios/paciente?dni={x}

- Muestra todos los resultados de estudios de un paciente buscando por su DNI

##### {PACIENTES-SERVICIO}/resultados-de-estudios/estudio?nombre-estudio={x}

- Muestra resultados de estudios de la base de datos buscando por nombre de estudio

---

#### Solicitudes POST (ResultadosDeEstudios)

##### {PACIENTES-SERVICIO}/resultados-de-estudios

- Guarda un conjunto de resultados de estudios de un paciente en la base de datos

- **body:**

~~~javascript
{
    paciente: Paciente,
    estudios: numero_entero[],
    urlInforme: string
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

- Modifica un conjunto de resultados de estudios de un paciente de acuerdo al "body" de la solicitud

- **body:**

~~~javascript
{   
    id: numero_entero,
    paciente: Paciente,
    estudios: numero_entero[],
    urlInforme: string
}
~~~

---

#### Solicitudes DELETE (ResultadosDeEstudios)

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}

- Borra un conjunto de resultados de estudios de la base de datos de acuerdo al id de la solicitud

---

#### Solicitudes PATCH (ResultadosDeEstudios)

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/paciente?id-o-dni-paciente={x}&opcion={x}

- Modifica el paciente de un conjunto de resultados de estudios de acuerdo a los datos de la URL

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/agregar-estudio?estudio-id={x}

- Agrega un estudio a un conjunto de resultados de estudios de acuerdo a los datos de la URL de la solicitud

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/quitar-estudio?estudio-id={x}

- Quita un estudio de un conjunto de resultados de estudios de acuerdo a los datos de la URL de la solicitud

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/url-informe?url-informe={x}

- Modifica la URL del informe de un conjunto de resultados de estudios de acuerdo los datos de la URL de la solicitud

---

### Entidad Sede

---

#### Solicitudes GET (Sede)

##### {PACIENTES-SERVICIO}/sedes/{id}

- Muestra una sede de la base de datos de acuerdo al id de la URL de la solicitud

##### {PACIENTES-SERVICIO}/sedes

- Muestra todas las sedes de la base de datos

##### {PACIENTES-SERVICIO}/sedes/direccion?calle={x}

- Muestra las sedes de la base de datos buscándolas por la calle
0
##### {PACIENTES-SERVICIO}/sedes/{id}/telefono?telefono={x}

- Muestra las sedes de la base de datos buscándolas por el teléfono

---

#### Solicitudes POST (Sede)

##### {PACIENTES-SERVICIO}/sedes

- Guarda una sede en la base de datos de acuerdo al "body" de la solicitud

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

- Modifica una sede de la base de datos de acuerdo al "body" de la solicitud

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

- Borra una sede de la base de datos de acuerdo al id de la URL de la solicitud

---

#### Solicitudes PATCH (Sede)

##### {PACIENTES-SERVICIO}/sedes/{id}/direccion?direccion-id={x}

- Modifica la dirección de una sede de la base de datos de acuerdo a los datos de la URL

##### {PACIENTES-SERVICIO}/sedes/{id}/agregar-telefono?telefono={x}

- Agrega un número telefónico a una sede de la base de datos de acuerdo a los datos de la URL

##### {PACIENTES-SERVICIO}/sedes/{id}/quitar-telefono?telefono={x}

- Quita un número telefónico a una sede de la base de datos de acuerdo a los datos de la URL

##### {PACIENTES-SERVICIO}/sedes/{id}/obra-social?obra-social-id={x}

- Modifica la obra social de una sede de acuerdo a los datos de la URL de la solicitud

---

### Entidad TurnoCita

---

#### Solicitudes GET (TurnoCita)

##### {PACIENTES-SERVICIO}/turnos-cita/{id}

- Muestra los datos de un turno para una cita con un profesional según la id de la URL

##### {PACIENTES-SERVICIO}/turnos-cita

- Muestra todos los turnos de citas con profesionales de la base de datos

##### {PACIENTES-SERVICIO}/turnos-cita/paciente?dni={x}

- Muestra los turnos de citas con profesionales buscando por DNI de paciente

##### {PACIENTES-SERVICIO}/turnos-cita/fecha-turno?fecha-turno={x}

- Muestra los turnos de citas con profesionales buscando por fecha de turno

##### {PACIENTES-SERVICIO}/turnos-cita/periodo?desde={x}&hasta={x}

- Muestra los turnos de citas con profesionales buscando por periodo de realización de cita

##### {PACIENTES-SERVICIO}/turnos-cita/profesional?profesional-id={x}

- Muestra los turnos de citas con profesionales buscando por id de profesional

---

#### Solicitudes POST (TurnoCita)

##### {PACIENTES-SERVICIO}/turnos-cita

- Guarda un turno en la base de datos de acuerdo a los datos del body de la solicitud

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

- Modifica un turno de cita con un profesional de acuerdo a los datos del body de la solicitud

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

- Borra un turno de cita con un profesional de la base de datos de acuerdo al id de la URL

---

#### Solicitudes PATCH (TurnoCita)

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/paciente?id-o-dni-paciente={x}&opcion={x}

- Modifica el paciente de un turno de acuerdo a los datos de la URL

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/fecha-solicitud?fecha-solicitud={x}

- Modifica la fecha de solicitud de un turno con un profesional de acuerdo a los datos de la URL

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/horario?inicio={x}&fin={x}

- Modifica el horario de un turno con un profesional de aucerdo a los datos de la URL de la solicitud

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/estado?estado={x}

- Modifica el estado en el que se encuentra un turno de una cita con un profesional de acuerdo a los datos de la URL

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/cobertura?cobertura={x}

- Modifica la cobertura que tiene un paciente en su cita con un profesional de acuerdo a los datos de la URL

---

### Entidad TurnoEstudio

---

#### Solicitudes GET (TurnoEstudio)

##### {PACIENTES-SERVICIO}/turnos-estudio/{id}

- Muestra los datos de un turno para realización de estudios de acuerdo al id de la URL

##### {PACIENTES-SERVICIO}/turnos-estudio

- Muestra los datos de todos los turnos para realización de estudios de la base de datos

##### {PACIENTES-SERVICIO}/turnos-cita/paciente?dni={x}

- Muestra los datos de los turnos para realización de estudios buscando por DNI de paciente

##### {PACIENTES-SERVICIO}/turnos-cita/fecha-turno?fecha-turno={x}

- Muestra los datos de los turnos para realización de estudios buscando fecha de turno

##### {PACIENTES-SERVICIO}/turnos-cita/periodo?desde={x}&hasta={x}

- Muestra los datos de los turnos para realización de estudios buscando por periodo de realización de estudios

##### {PACIENTES-SERVICIO}/turnos-estudio/estudio?estudio-id={x}

- Muestra los datos de los turnos para realización de estudios buscando por estudio individual

---

#### Solicitudes POST (TurnoEstudio)

##### {PACIENTES-SERVICIO}/turnos-estudio

- Guarda un turno para realización de estudios en la base de datos de acuerdo a los datos del "body" de la solcitud

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

- Modifica los datos de un turno para la realización de estudios según los datos del "body" de la solicitud

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

- Borra un turno para realización de estudios de la base de datos según los datos de la URL

---

#### Solicitudes PATCH (TurnoEstudio)

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/paciente?id-o-dni-paciente={x}&opcion={x}

- Modifica el paciente de un turno para realización de estudios según los datos de la URL de la solicitud

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/fecha-solicitud?fecha-solicitud={x}

- Modifica la fecha de solicitud de un turno para realización de estudios según los datos de la URL de la solicitud

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/horario?inicio={x}&fin={x}

- Modifica el horario de un turno para realización de estudios según los datos de la URL de la solicitud

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/estado?estado={x}

- Modifica el estado de un turno para realización de estudios según los datos de la URL de la solicitud

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/cobertura?cobertura={x}

- Modifica la cobertura para el paciente de un turno para realización de estudios según los datos de la URL de la solicitud

##### {PACIENTES-SERVICIO}/turnos-estudio/{id}/estudio?estudio-id={x}

- Modifica el estudio de un turno para realización de estudios según los datos de la URL de la solicitud

---

## Microservicio de Hospital

---

### Entidad CirugiaPaciente

---

#### Solicitudes GET (CirugiaPaciente)

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}

- Busca una cirugía realizada en un pacidente de acuerdo al id de la solicitud

##### {HOSPITAL-SERVICIO}/cirugias-pacientes

- Muestra todas las cirugías realizadas en pacientes de la base de datos

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/paciente?paciente-id-o-dni={x}&opcion={x}

- Muestra las cirugías realizadas en pacientes buscando por id o DNI de paciente

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/cirugia?cirugia={x}

- Muestra las cirugías realizadas en pacientes buscando por tratamiento quirúrgico

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/periodo?desde={x}&hasta={x}

- Muestra las cirugías realizadas en pacientes buscando por período

---

#### Solicitudes POST (CirugiaPaciente)

##### {HOSPITAL-SERVICIO}/cirugias-pacientes

- Guarda en la base de datos una cirugía realizada en un paciente de acuerdo a los datos del "body" de la solcitud

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

- Modifica una cirugía realizada en un paciente de la base de datos de acuerdo al "body" de la solicitud

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

- Borra una cirugía realizada en un paciente de la base de datos de acuerdo al id de la URL

---

#### Solicitudes PATCH (CirugiaPaciente)

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/paciente?paciente-id-o-dni={x}&opcion={x}

- Modifica el paciente de una cirugía realizada en un paciente de acuerdo a la URL de la solicitud

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/cirugia?cirugia-id={x}

- Modifica el tratamiento quirúrgico de una cirugía realizada en un paciente de acuerdo a la URL de la solicitud

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/fecha?fecha={x}

- Modifica la fecha de una cirugía realizada en un paciente de acuerdo a la URL de la solicitud

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/hora-inicio?inicio={x}

- Modifica el horario de inicio de una cirugía realizada en un paciente de acuerdo a la URL de la solicitud

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/hota-final?fin={x}

- Modifica el horario de final de una cirugía realizada en un paciente de acuerdo a la URL de la solicitud

---

### Entidad Diagnostico

---

#### Solicitudes GET (Diagnostico)

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}

- Muestra un diagnóstico de la base de datos buscándolo por id

##### {HOSPITAL-SERVICIO}/diagnosticos

- Muestra todos los diagnósticos de la base de datos

##### {HOSPITAL-SERVICIO}/diagnosticos/nombre?nombre={x}

- Muestra un diagnóstico de la base de datos buscándolo por nombre

---

#### Solicitudes POST (Diagnostico)

##### {HOSPITAL-SERVICIO}/diagnosticos

- Guarda un diagnóstico en la base de datos de acuerdo a los datos del "body" de la solicitud

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

- Modifica un diagnóstico de la base de datos de acuerdo a los datos del "body" de la solicitud

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

- Borra de la base de datos a un diagnóstico de acuerdo al id de la URL

---

#### Solicitudes PATCH (Diagnostico)

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/agregar-sintoma?sintoma-id={x}

- Agrega un síntoma a un diagnóstico de la base de datos de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/quitar-sintoma?sintoma-id={x}

- Quita un síntoma a un diagnóstico de la base de datos de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/agregar-signo?signo-id={x}

- Agrega un signo a un diagnóstico de la base de datos de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/quitar-signo?signo-id={x}

- Quita un síntoma a un diagnóstico de la base de datos de acuerdo a los datos de la URL de la solicitud

---

### Entidad DiagnosticoPaciente

---

#### Solicitudes GET (DiagnosticoPaciente)

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}

- Muestra un diagnóstico realizado en un paciente buscándolo por id

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes

- Muestra todos los diagnósticos realizados en pacientes de la base de datos

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/paciente?pacinete-id-o-dni={x}&opcion={x}

- Muestra los diagnósticos realizados en un paciente

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/diagnostico?diagnostico={x}

- Muestra los diagnósticos realizados en pacientes buscando por diagnóstico

---

#### Solicitudes POST (DiagnosticoPaciente)

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes

- Guarda en la base de datos un diagnóstico realizado en un paciente de acuerdo a los datos del "body" de la solicitud

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

- Modifica los datos de un diagnóstico realizado en un paciente de acuerdo al "body" de la solicitud

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

- Borra un diagnóstico realizado en un paciente de la base de datos de acuerdo al id de la URL de la solicitud

---

#### Solicitudes PATCH (DiagnosticoPaciente)

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/paciente?paciente-id-o-dni={x}&opcion={x}

- Modifica el paciente de un diagnóstico realizado en un paciente de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/diagnostico?diagnostico-id={x}

- Modifica el diagnóstico de un diagnóstico realizado en un paciente de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/fecha-inicio?inicio={x}

- Modifica la fecha de inicio de un diagnóstico realizado en un paciente de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/fecha-final?fin={x}

- Modifica la fecha de final de un diagnóstico realizado en un paciente de acuerdo a los datos de la URL de la solicitud

---

### Entidad Empleado

---

#### Solicitudes GET (Empleado)

##### {HOSPITAL-SERVICIO}/empleados/{id}

- Muestra a un empleado de la base de datos buscándolo por id

##### {HOSPITAL-SERVICIO}/empleados

- Muestra a todos los empleados de la base de datos

##### {HOSPITAL-SERVICIO}/empleados/dni?dni={x}

- Muestra a un empleado de la base de datos buscándolo por DNI

##### {HOSPITAL-SERVICIO}/empleados/nombre?nombre={x}

- Muestra a los empleados de la base de datos buscándolos por nombre

##### {HOSPITAL-SERVICIO}/empleados/apellido?apellido={x}

- Muestra a los empleados de la base de datos buscándolos por apellido

##### {HOSPITAL-SERVICIO}/empleados/email?email={x}

- Muestra a un empleado de la base de datos buscándolo por email

##### {HOSPITAL-SERVICIO}/empleados/matricula?matricula={x}

- Muestra a un empleado de la base de datos buscándolo por matrícula profesional

##### {HOSPITAL-SERVICIO}/empleados/rol?rol={x}

- Muestra a empleados de la base de datos buscándolos por rol

##### {HOSPITAL-SERVICIO}/empleados/rango-salarial?minimo={x}&maximo={x}

- Muestra a empleados de la base de datos buscándolos por su salario

---

#### Solicitudes POST (Empleado)

##### {HOSPITAL-SERVICIO}/empleados

- Guarda a un empleado en la base de datos de acuerod a los datos del "body" de la solcitud

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

- Modifica a un empleado de la base de datos de acuerdo a los datos del "body" de la solicitud

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

- Borra a un empleado de la base de datos de acuerdo al id de la URL de la solicitud

---

#### Solicitudes PATCH (Empleado)

##### {HOSPITAL-SERVICIO}/empleados/{id}/dni?dni={x}

- Modifica el DNI de un paciente de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/primer-nombre?primer-nombre={x}

- Modifica el primer de un paciente de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/segundo-nombre?segundo-nombre={x}

- Modifica el segundo nombre de un paciente de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/apellido-paterno?apellido-paterno={x}

- Modifica el apellido de un paciente de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/apellido-materno?apellido-materno={x}

- Modifica el apellido materno de un paciente de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/email?email={x}

- Modifica el email de un paciente de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/domicilio?domicilio-id={x}

- Modifica el domicilio de un paciente de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/agregar-telefono?telefono={x}

- Agrega un teléfono a un paciente de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/quitar-telefono?telefono={x}

- Quita un número telefónico a un paciente de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/matricula?matricula={x}

- Modifica la matrícula profesional de un paciente de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/rol?rol-id={x}

- Modifica el rol de un paciente de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/salario?salario={x}

- Modifica salario de un paciente de acuerdo a los datos de la URL de la solicitud

---

### Entidad EstudioMedicoClasificacion

---

#### Solictudes GET (EstudioMedicoClasificacion)

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos/{id}

- Muestra una clasificación de estudio médico buscándola por id

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos

- Muestra todas las clasificaciones de estudios médicos de la base de datos

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos/nombre?nombre={x}

- Muestra una clasificación de estudio médico buscándola por nombre

---

#### Solicitudes POST (EstudioMedicoClasificacion)

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos

- Guarda una clasificación de estudio médico en la nase de datos de acuerdo al "body" de la solicitud

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

- Modifica una clasificación de estudio médico de la base de datos de acuerdo al "body" de la solicitud

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

- Borra una clasificación de estudio médico de la base de edatos de acuerdo

---

#### Solicitudes PATCH (EstudioMedicoClasificacion)

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos/{id}/nombre?nombre={x}

- Modifica el nombre de una clasificación de estudio médico de acuerdo a los datos de la URL de la solicitud

---

### Entidad EstudioMedico

---

#### Solicitudes GET (EstudioMedico)

##### {HOSPITAL-SERVICIO}/estudios-medicos/{id}

- Muestra un estudio médico buscándolo por id

##### {HOSPITAL-SERVICIO}/estudios-medicos

- Muestra todos los estudios médicos de la base de datos

##### {HOSPITAL-SERVICIO}/estudios-medicos/nombre?nombre={x}

- Muestra un estudio médico buscándolo por nombre

##### {HOSPITAL-SERVICIO}/estudios-medicos/clasificacion?clasificacion={x}

- Muestra estudios médicos de la bse de datos buscándolos por su clasificación

---

#### Soplicitudes POST (EstudioMedico)

##### {HOSPITAL-SERVICIO}/estudios-medicos

- Guarda un estudio médico en la base de datos de acuerdo al "body" de la solicitud

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

- Modifica un estudio médico de la base de datos de acuerdo al "body" de la solicitud

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

- Borra un estudio médico de la base de datos de acuerdo al id de la URL

---

#### Solictudes PATCH (EstudioMedico)

##### {HOSPITAL-SERVICIO}/estudios-medicos/{id}/nombre?nombre={x}

- Modifica el nombre de un estudio médico de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/estudios-medicos/{id}/cladificacion?clasificacion={x}

- Modifica la clsificación de un estudio médico de acuerdo a los datos de la URL de la solicitud

---

### Entidad FisioterapiaPaciente

---

#### Solicitudes GET (FisioterapiaPaciente)

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}

- Muestra un tratamiento de fisioterapia realizado en un paciente buscándolo por id

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes

- Muestra todos los tratamientos de fisioterpaia realizados en pacientes de la base de datos

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/paciente?paciente-id-o-dni={x}&opcion={x}

- Muestra los tratamientos de fisioterapia realizados en pacientes de la base de datos buscándolos por id o DNI del paciente

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/fecha-inicio?desde={x}&hasta={x}

- Muestra los tratamientos de fisioterpaia realizados en pacientes buscando por fecha de inicio

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/fecha-final?desde={x}&hasta={x}

- Muestra los tratamientos de fisioterpaia realizados en pacientes buscando por fecha de final

---

#### Solicitudes POST (FisioterapiaPaciente)

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes

- Guarda un tratamiento de fisioterapia realizado en un paciente de acuerdo a los datos del "body" de la solicitud

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

- Modifica un tratamiento de fisioterapia realizado en un paciente de acuerdo a los datos del "body" de la solicitud

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

#### Solicitudes DELETE (FisioterapiaPaciente)

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}

- Borra un tratamiento de fisioterapia realizado en un paciente de acuerdo al id de la URL

---

#### Solicitudes PATCH (FisioterapiaPaciente)

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}/paciente-id-o-dni={x}&opcion={x}

- Modifica el paciente de un tratamiento de fisioterapia realizado en un paciente de acuerdo a los datos de la URL

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}/fecha-inicio?inicio={x}

- Modifica la fecha de inicio de un tratamiento de fisioterapia realizado en un paciente de acuerdo a los datos de la URL

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}/fecha-final?final={x}

- Modifica la fecha de final de un tratamiento de fisioterapia realizado en un paciente de acuerdo a los datos de la URL

---

### Entidad MedicamentoPaciente

---

#### Solicitudes GET (MedicamentoPaciente)

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}

- Muestra un tratamiento por medicamento realizado en un paciente buscándolo por id

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes

- Muestra todos los tratamientos por medicamento realizados en pacientes de la base de datos.

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/paciente?paciente-id-o-dni={x}&opcion={x}

- Muestra los tratamientos por medicamento realizados en pacientes buscando por id o DNI del paciente

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/principio-activo?principio-activo={x}

- Muestra los tratamientos por medicamento realizadoas en pacientes buscando por principio activo del medicamento

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/fecha-inicio?desde={x}&hasta={x}

- Muestra los tratamientos por medicamento realizadoas en pacientes buscando por fecha de inicio

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/fecha-final?desde={x}&hasta={x}

- Muestra los tratamientos por medicamento realizadoas en pacientes buscando por fecha de final

---

#### Solicitudes POST (MedicamentoPaciente)

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes

- Guarda un tratamiento por medicamento realizado en un paciente en la base de datos de acuerdo a los datos del "body" de la solicitud

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

- Modifica un tratamiento por medicamento realizado en un paciente en la base de datos de acuerdo a los datos del "body" de la solicitud

- **body:**

~~~javascript
{
    id: numero_entero,
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

- Borra un tratamiento por medicamento realizado en un paciente de la base de datos de acuerdo a la URL de la solcitud

---

#### Solicitudes PATCH (MedicamentoPaciente)

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/paciente?paciente-id-o-dni={x}&opcion={x}

- Modifica el paciente de un tratamiento por medicamento realizado en un paciente de acuerdo a los datos de la URL

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/medicamento?medicamento-id={x}

- Modifica el medicamento de un tratamiento por medicamento realizado en un paciente de acuerdo a los datos de la URL

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/dosis?dosis-id={x}

- Modifica la dosis de un tratamiento por medicamento realizado en un paciente de acuerdo a los datos de la URL

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/fecha-inicio?inicio={x}

- Modifica la fecha de inicio de un tratamiento por medicamento realizado en un paciente de acuerdo a los datos de la URL

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/fecha-final?fin={x}

- Modifica la fecha de final de un tratamiento por medicamento realizado en un paciente de acuerdo a los datos de la URL

---

### Entidad PsicoterpiaPaciente

---

#### Solicitudes GET (PsicoterpiaPaciente)

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}

- Muestra un tratamiento de psicoterpaia realizado en un paciente de acuerdo al id de la URL

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes

- Muestra todos los tratamientos de psicoterapia realizados en pacientes de la base de datos

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/paciente?paciente-id-o-dni={x}&opcion={x}

- Muestra los tratamientos de psicoterapia realizados en pacientes buscando por id o DNI del paciente

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/fecha-inicio?desde={x}&hasta={x}

- Muestra los tratamientos de psicoterapia realizados en pacientes buscando por fecha de inicio

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/fecha-final?desde={x}&hasta={x}

- Muestra los tratamientos de psicoterapia realizados en pacientes buscando por fecha de final

---

#### Solicitudes POST (PsicoterpiaPaciente)

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes

- Guarda un tratamiento de psicoterapia realizado en un paciente en la base de datos de acuerdo a los datos del "body" de la solicitud

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

- Modifica un tratamiento de psicoterapia realizado en un paciente en la base de datos de acuerdo a los datos del "body" de la solicitud

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

- Borra un tratamiento de psicoterpaia realizado en un paciente de la base de datos de acuerdo al id de la URL

---

#### Solicitudes PATCH (PsicoterpiaPaciente)

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}/paciente?paciente-id-o-dni={x}&opcion={x}

- Modifica el paciente de un tratamiento de psicoterpia realizado en un paciente de acuerdo a los datos de la URL

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}/fecha-inicio?inicio={x}

- Modifica la fecha de inicio de un tratamiento de psicoterpia realizado en un paciente de acuerdo a los datos de la URL

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}/fecha-final?fin={x}

- Modifica la fecha de final de un tratamiento de psicoterpia realizado en un paciente de acuerdo a los datos de la URL

---

### Entidad RadioTerapiaPaciente

---

#### Solicitudes GET (RadioTerapiaPaciente)

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}

- Muestra un tratamiento de radioterapia realizado en un paciente buscando por id

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes

- Muestra todos los tratamientos de radioterapia realizados en pacientes

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/paciente?paciente-id-o-dni={x}&opcion={x}

- Muestra los tratamientos de radioterapia realizados en pacientes buscando por id o DNI de paciente

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/fecha-inicio?desde={x}&hasta={x}

- Muestra los tratamientos de radioterapia realizados en pacientes buscando fecha de inicio

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/fecha-final?desde={x}&hasta={x}

- Muestra los tratamientos de radioterapia realizados en pacientes buscando fecha de final

---

#### Solicitudes POST (RadioTerapiaPaciente)

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes

- Guarda un tratamiento de fisioterapia realizado en un paciente de acuerdo a los datos del "body" de la solicitud

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

- Modifica un tratamiento de fisioterapia realizado en un paciente de acuerdo a los datos del "body" de la solicitud

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

- Borra un tratamiento de fisioterpaia realizado en un paciente de acuerdo al id de la URL

---

#### Solicitudes PATCH (RadioTerapiaPaciente)

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}/paciente?paciente-id-o-dni={x}&opcion={x}

- Modifica el paciente de un tratamiento de radioterapia realizado en un paciente de acuerdo a los datos de la URL

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}/fecha-inicio?inicio={x}

- Modifica la fecha de inicio de un tratamiento de radioterapia realizado en un paciente de acuerdo a los datos de la URL

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}/fecha-final?fin={x}

- Modifica la fecha de final de un tratamiento de radioterapia realizado en un paciente de acuerdo a los datos de la URL

---

### Entidad RolEmpleado

---

#### Solicitudes GET (RolEmpleado)

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}

- Mesutra un rol de empleado buscando por id

##### {HOSPITAL-SERVICIO}/roles-empleado

- Muestra todos los roles de empleados de la base de datos

##### {HOSPITAL-SERVICIO}/roles-empleado/nombre?nombre={x}

- Muestra un rol de empleado buscando por nombre

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}/sector?sector={x}

- Muestra roles de empleado de la base de datos buscando por sector

---

#### Solicitudes POST (RolEmpleado)

##### {HOSPITAL-SERVICIO}/roles-empleado

- Guarda un rol de empleado en la base de datos de acuerdo a los datos del "body" de la solicitud

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

- Modifica un rol de empleado en la base de datos de acuerdo a los datos del "body" de la solicitud

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

- Borra un rol de empleado de la base de datos de acuerdo al id de la solicitud

---

#### Solicitudes PATCH (RolEmpleado)

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}/nombre?nombre

- Modifica el nombre de un rol de empleado de acuerdo a los datos de la URL

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}/sector?sector-id={x}

- Modifica el sctor de un rol de empleado de acuerdo a los datos de la URL

---

### Entidad Sector

---

#### Solicitudes GET (Sector)

##### {HOSPITAL-SERVICIO}/sectores/{id}

- Muestra un sector de acuerdo al id de la URL

##### {HOSPITAL-SERVICIO}/sectores

- Muestra todos los sectores de la base de datos

##### {HOSPITAL-SERVICIO}/sectores/nombre?nombre={x}

- Muestra un sector de la base de datos buscando por nombre

---

#### Solicitudes POST (Sector)

##### {HOSPITAL-SERVICIO}/sectores

- Guarda un sector en la base de datos de acuerdo al "body" de la solicitud

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

- Modifica un sector en la base de datos de acuerdo al "body" de la solicitud

~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

---

#### Solicitudes DELETE (Sector)

##### {HOSPITAL-SERVICIO}/sectores/{id}

- Borra un sector de la base de datos de acuerdo al id de la URL

---

#### Solicitudes PATCH (Sector)

##### {HOSPITAL-SERVICIO}/sectores/{id}/nombre?nombre={x}

- Modifica el nombre de un sector de acuerdo a los datos de la URL

---

### Entidad Signo

---

#### Solicitudes GET (Signo)

##### {HOSPITAL-SERVICIO}/signos/{id}

- Muestra un signo de la base de datos buscando por id

##### {HOSPITAL-SERVICIO}/signos

- Muestra todos los signos de la base de datos

##### {HOSPITAL-SERVICIO}/signos/nombre?nombre={x}

- Muestra un signo de la base de datos buscando por nombre

##### {HOSPITAL-SERVICIO}/signos/unidad?unidad={x}

- Muestra los signos de la base de datos buscando por el nombre de la unidad de medición

##### {HOSPITAL-SERVICIO}/signos/descripcion?secuencia={x}

- Muestra signos de la base de datos buscando por secuencia de caracteres en la descripción

---

#### Solicitudes POST (Signo)

##### {HOSPITAL-SERVICIO}/signos

- Guarda un signo en la base de datos de acuerdo al "body" de la solicitud

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

- Modifica un signo en la base de datos de acuerdo al "body" de la solicitud

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

- Borra un signo en la base de datos de acuerdo al id de la URL

---

#### Solictudes PATCH (Signo)

##### {HOSPITAL-SERVICIO}/signos/{id}/nombre?nombre={x}

- Modifica el nombre de un signo de acuerdo a los datos de la URL

##### {HOSPITAL-SERVICIO}/signos/{id}/valor-minimo?valor-minimo={x}

- Modifica el valor mínimo de una medición de un signo de acuerdo a los datos de la URL

##### {HOSPITAL-SERVICIO}/signos/{id}/valor-maximo?valor-maximo={x}

- Modifica el valor máximo de una medición de un signo de acuerdo a los datos de la URL

##### {HOSPITAL-SERVICIO}/signos/{id}/unidad?unidad-id={x}

- Modifica la unidad de medición de un signo de acuerdo a los datos de la URL

##### {HOSPITAL-SERVICIO}/signos/{id}/descripcion

- Modifica el valor mínimo de una medición de un signo de acuerdo al "body" de la solicitud

- **body:**

~~~javascript
{
    texto: string
}
~~~

---

### Entidad Sintoma

---

#### Solicitudes GET (Sintoma)

##### {HOSPITAL-SERVICIO}/sintomas/{id}

- Muestra un síntoma de la base de datos buscando por id

##### {HOSPITAL-SERVICIO}/sintomas

- Muestra todos los síntomas de la base de datos

##### {HOSPITAL-SERVICIO}/sintomas/nombre?nombre={x}

- Muestra un síntoma de la base de datos buscando por nombre

---

#### Solicitudes POST (Sintoma)

##### {HOSPITAL-SERVICIO}/sintomas

- Guarda un síntoma en la base de datos de acuerdo al "body" de la solicitud

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

- Modifica un síntoma en la base de datos de acuerdo al "body" de la solicitud

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

- Borra un síntoma de la base de datos de acuerdo al id de la URL

---

#### Solicitudes PATCH (Sintoma)

##### {HOSPITAL-SERVICIO}/sintomas/{id}/nombre?nombre={x}

- Modifica el nombre de un síntoma de acuerdo a los datos de la URL

---

### Entidad TratamientoQuirurgico

---

#### Solicitudes GET (TratamientoQuirurgico)

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/{id}

- Muestra un tratamiento quirúrgico de la base de datos buscándolo por id

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos

- Muestra todos los tratamientos quirúrgicos de la base de datos

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/nombre?nombre={x}

- Muestra un tratamiento mquirúrgico buscándolo por nombre

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/descripcion?descripcion={x}

- Muestra tratamientos quirúrgicos de la base de datos buscándolos por secuencia de caracteres en su descripción

---

#### Solicitudes POST (TratamientoQuirurgico)

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos

- Guarda un tratamiento quirúrgico en la base de datos de acuerdo a los datos del "body" de la solicitud

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

- modifica un tratamiento quirúrgico en la base de datos de acuerdo a los datos del "body" de la solicitud

- **body:**

~~~javascript
{
    id: numero_entero,
    nombre: string,
    descripcion: string
}
~~~

---

#### Solicitudes DELETE (TratamientoQuirurgico)

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/{id}

- Borra una tratamiento quirúrgico de la base de datos de acuerdo al id de la URL

---

#### Solcitudes PATCH (TratamientoQuirurgico)

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/{id}/nombre?nombre={x}

- Modifica el nombre de un tratamiento quirúrgico según los datos de la URL

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/{id}/descripcion 

- Modifica la descripción de un tratamiento quirúrgico según los datos del "body" de la solicitud

- **body:**

~~~javascript
{
    texto: string
}
~~~

---
---

## Notas

- En las solicitudes de tipo PUT se debe tener en cuenta que el id del "body" de la solicitud es el id del registro que se quiere modificar. En las solicitudes PATCH  ocurre algo similar, solo que el id del registro a modificar se encuentra en la URL de la solicitud.
- En las entidades de TurnoCita y TurnoEstudio hay campos llamados Estado y Cobertura. Estos dos campos son tipos enumerados: el tipo enumerado EstadoTurno puede tener valores de EN_PROCESO, CONCLUIDO O CANCELADO; el tipo enumerado COBERTURA puede tener los valores NINGUNA, TOTAL o COSEGURO.
- Los nombres en los "bodys" y URLs de las solicitudes, como por ejemplo, nombres propios de pacientes o empleados, nombres de lugares (provincias o paises), nombres de medicamentos, etc, deben estar en letra minúscula. El desarrollador frontend será el encargado de que los nombres se escriban con letras mayúsculas cuando corresponda.