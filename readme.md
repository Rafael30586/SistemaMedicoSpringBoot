English
---
# Medical system

This application has been developed with Java and Spring Boot using IntelliJ IDEA. It consists of four microservices: contacto (contact), farmacia (pharmacy), paciente (patient), and hospital (hospital).
The contacto (contact) microservice has the following entities: Direccion (address), Localidad (city, town or village), Pais (country), and Provincia (province or state).
The entities that compose the farmacia microservice are: AccionTerapeutica (therapeutic effect), AdministrcionFarmaco (drug administration), Dosis (dose), FormaFarmaceutica (pharmaceutical form), MarcaMedicamento (medicine brand), Medicamento (medicine), PrincipioActivo (active ingredient), and UnidadDeMedida (measurement unit).
In the paciente microservice the entities are: ObraSocial (health insurance), Paciente (patient), ResultadoDeEstudios (examinations result), Sede (central office), TurnoCita (appointment turn), and TurnoEstudio (examination turn).
For the hospital microservice the entities are: CirugiaPaciente (surgery-patient), Diagnostico (diagonsis), DiagnosticoPaciente (diagnosis-patient), Empleado (employee), EstudioMedico (medical examination), EstudioMedicoClasificacion (medical examination clasification), FisioterapiaPaciente (phisiotherapy-patient), MedicamentoPaciente (medicine-patient), PsicoterapiaPaciente (psychotherapy-patient), RadioTerpiaPaciente (radiotherapy-patient), RolEmpleado (employee role), Sector (sector), Signo (sign), Sintoma (symptom), and TratamientoQuirurgico (surgery). 

---
---

## Index 

1. Download of the project and exectution of the microservices
2. Entities explanation
3. Notes
4. Request examples

---
---

## Download of the project and exectution of the microservices

### Some requisites for the execution of the project

- Having IntelliJ IDEA installed
- MySQL installed ingt eh computer

### Steps to follow

1. Make a directory in the working device (your computer);
2. Clone the project from the GitHub repository https://github.com/Rafael30586/SistemaMedicoSpringBoot inside the directory from the previous item;
3. Create .env files with the database connection data inside the root directory of each microservice;
4. Open each microservice separatedly, each one on an IntelliJ IDEA window;
5. Execute them one by one;
6. Verify their functioning with Postman or similar tools.

### To keep in mind

- The project can be executed with other IDEs such as Eclipse IDE or Apache Neatbeans, but the procedure could be different.
- You can use a different database manager tool changing some configurations.

---
---

## Entities explanation

---

- Direccion (address): it's the a ddress of people or a building like the street, number, etc.
- Localidad (location): It can be a city, a town or a village.
- Pais (country): It's a country like Argentina, United States, France, etc.
- Provincia (state or province): Can be the state or the province of a country.

- AccionTerapeutica (therepeutic effect): It is the beneficial action that an active ingredient or medication has in the human body. Examples include: anti-inflammatory, keratolytic, analgesic, antipyretic, etc.
- AdministracionFarmaco (drug administration): It is the way a drug is administered to a patient; for example: intramuscular, oral, intrathecal, nasal, sublingual, ophthalmic, etc.
- Dosis (dose): It is an amount of a drug administered over a period of time. The unit used (milligrams, milliliters, etc.), the time interval (for example, every 8 hours), and the quantity associated with the unit are taken into account.
- FormaFaremaceutica (pharmaceutical form): It is the form in which a medication is presented, for example: cream, emulsion, syrup, capsules, gel, powder, etc.
- MarcaMedicamento (medicine brand): It is the brand of a medicine.
- Medicamento (medicine): It refers to each medication.
- PrincipioActivo (active ingredient): It's the active ingredient that you can find in a medicine.
- UnidadDeMedida (measurement unit): It is the unit used to measure quantities; for example: milligrams, milliliters, drops, etc.

- ObraSocial (health insurance): It is the health insurance of a patient.
- Paciente (patient): It is a patient who requests services at the hospital.
- ResultadoDeEstudios (examinations result): These are the results of each study performed on each patient.
- Sede (central office): It is the address that corresponds to each branch of the health insurance providers.
- TurnoCita (appointment turn): These are the details of an appointment for a patient who requests a consultation with a doctor.
- TurnoEstudio (examination turn): These are the details of an appointment for a patient who requests the performance of a medical study.

- CirugiaPaciente (surgery-patient): It is a surgery that has been performed on a patient.
- Diagnostico (diagnosis): It is the diagnosis that each patient may receive, for example: flu, diabetes, etc.
- DiagnosticoPaciente (diagnosis-patient): It is the specific diagnosis that has been given to a specific patient.
- Empleado (employee): These are the details of each hospital employee.
- EstudioMedico (medical examination): It is each medical study that patients can undergo, for example: renal profile, blood count, electrocardiogram, etc.
- EstudioMedicoClasificacion (medical examination clasification): It refers to how the different medical studies are classified, for example: laboratory, diagnostic imaging, cardiological, etc.
- FisioterapiaPaciente (phisioterapy-patient): It is the physiotherapy treatment that has been performed on a patient.
- MedicamentoPaciente (medicine-patient): It is the treatment that has been performed on a patient with a specific medication.
- PsicoterapiaPaciente (psychotherapy-patient): It is the psychological treatment that has been performed on a patient.
- RadioterapiaPaciente (radiotherapy-patient): It is a radiotherapy treatment performed on a specific patient.
- RolEmpleado (employee role): It is the role that each employee may have, for example: surgeon, cardiologist, cook, secretary, etc.
- Sector (sector): It is the sector to which each employee role belongs, for example: medicine, cleaning, human resources, gastronomy, etc.
- Signo (sign): These are the signs that patients may present according to their diagnosis: hyperglycemia, fever, etc.
- Sintoma (symptom): These are the symptoms that a patient may have according to their diagnosis, for example: headache, nausea, fatigue, etc.
- TratamientoQuirurgico (surgery): These are the surgeries that can be performed on patients, for example: open-heart surgery, hip surgery, etc.

---

## Contacto (contact) microservice

---

### Direccion (address) entity

---

#### GET requests (Direccion)

##### {CONTACTO-SERVICIO}/direcciones/{id}

- It shows one addresss searching by id

##### {CONTACTO-SERVICIO}/direcciones

- It shows all the addresses from the database 

##### {CONTACTO-SERVICIO}/direcciones/localidad?localidad={x}

- It shows all the addresses from a specific location 

##### {CONTACTO-SERVICIO}/direcciones/provincia?provincia={x}

- Shows all addresses located in a specific province or state

---

#### POST requests (Direccion)

##### {CONTACTO-SERVICIO}/direcciones

- Saves an address according to the request body

- **body:**

~~~javascript
{
    calle: string,
    altura: integer,
    departamento: string,
    localidad: Localidad
}
~~~

- **Meaning of each attribute:**

- Calle: street
- Altura: number
- Despartamento: department
- Localidad: locality

- **Example:**

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

#### PUT request (Direccion)

##### {CONTACTO-SERVICIO}/direcciones

- Edits an address in the database according to the request body

- **body**

~~~javascript
{
    id: integer,
    calle: string,
    altura: integer,
    departamento: string,
    localidad: Localidad
}
~~~

---

#### DELETE requests (Direccion)

##### {CONTACTO-SERVICIO}/direcciones/{id}

- Deletes an address from the database

---

#### PATCH requests (Direccion)

##### {CONTACTO-SERVICIO}/direcciones/{id}/calle?calle={x}

- Modifies the street of an address

##### {CONTACTO-SERVICIO}/direcciones/{id}/altura?altura={x}

- Modifies the street number of an address

##### {CONTACTO-SERVICIO}/direcciones/{id}/departamento?departamento={x}

- Modifies the apartment/unit of an address

##### {CONTACTO-SERVICIO}/direcciones/{id}/localidad?localidad-id={x}

- Modifies the locality of an address

---

### Localidad (locality) entity

---

#### GET requests (Localidad)

##### {CONTACTO-SERVICIO}/localidades/{id}

- Shows a locality by searching it by id

##### {CONTACTO-SERVICIO}/localidades

- Shows all localities in the database

---

#### POST request (Localidad)

##### {CONTACTO-SERVICIO}/localidades

- Saves a locality in the database using the data from the request body

- **body:**

~~~javascript
{
    nombre: string,
    provincia: Provincia,
}
~~~

- **meaning of each attribute:**
- Nombre: name
- provincia: province or state

- **Ejemplo:**

~~~json
{
    "nombre": "new york",
    "provincia":{
        "id":1
    }
}
~~~

---

#### PUT request (Localidad)

##### {CONTACTO-SERVICIO}/localidades

- Modifies a locality according to the request body

- **body:**

~~~javascript
{
    id: integer,
    nombre: string,
    provincia: Provincia
}
~~~

---

#### DELETE request (Localidad)

##### {CONTACTO-SERVICIO}/localidades/{id}

- Deletes a locality according to the id in the URL

---

#### PATCH requests (Localidad)

##### {CONTACTO-SERVICIO}/localidades/{id}/nombre?nombre={x}

- Modifies the name of a locality according to the id in the URL

##### {CONTACTO-SERVICIO}/localidades/{id}/provincia?provincia-id={x}

- Modifies the province to which a locality belongs according to the id in the URL

---

### Pais (country) entity

---

#### GET requests (Pais)

##### {CONTACTO-SERVICIO}/paises/{id}

- Shows the data of a country in the database according to the id in the URL

##### {CONTACTO-SERVICIO}/paises

- Shows all countries in the database

---

#### POST requests (Pais)

##### {CONTACTO-SERVICIO}/paises

- Saves a new country in the database using the data from the request body

- **body:**

~~~javascript
{
    nombre: string,
}
~~~

- **Meaning of each attribute:**
- Nombre: name

- **Example:**

~~~json
{
    "nombre": "sweden",
}
~~~

---

#### PUT request (Pais)

##### {CONTACTO-SERVICIO}/paises

- Modifies a country in the database using the data from the request body

- **body:**

~~~javascript
{
    id: integer,
    nombre: string
}
~~~

---

#### DELETE request (Pais)

##### {CONTACTO-SERVICIO}/paises/{id}

- Deletes a country from the database according to the id in the URL

---

#### PATCH request (Pais)

##### {CONTACTO-SERVICIO}/paises/{id}/nombre?nombre={x}

- Modifies the name of a country in the database according to the id in the URL

---

### Provincia (province or state) entity 

---

#### GET requests (Provincia)

##### {CONTACTO-SERVICIO}/provincias

- Shows all provinces/states or states in the database

##### {CONTACTO-SERVICIO}/provincias/{id}

- Shows a province/state from the database according to the id in the URL

##### {CONTACTO-SERVICIO}/provincias/nombre?nombre={x}

- Shows a province/state from the database by searching it by name

---

#### POST request (Provincia)

##### {CONTACTO-SERVICIO}/provincias

- Saves a province/state in the database using the data from the request body

- **body:**

~~~javascript
{
    nombre: string,
    pais: Pais
}
~~~

-**Meaning of each attribute:**

- Nombre: name
- Pais: country

- **Ejemplo:**

~~~json
{
    "nombre": "florida",
    "pais": {
        "id":10
    }
}
~~~

---

#### PUT request (Provincia)

##### {CONTACTO-SERVICIO}/provincias

- Modifies a province/state

- **body:**

~~~javascript
{
    id: integer,
    nombre: string,
    pais: Pais
}
~~~

---

#### DELETE requests (Provincia)

##### {CONTACTO-SERVICIO}/provincias/{id}

- Deletes a province/state from the database according to its id

---

#### PATCH requests (Provincia)

##### {CONTACTO-SERVICIO}/provincias/{id}/nombre?nombre={x}

- Modifies the name of a province/state by searching it by id

##### {CONTACTO-SERVICIO}/provincias/{id}/pais?pais-id={x}

- Modifies the country to which a province/state belongs by assigning the corresponding country id

---

## Farmacia (pharmacy) microservice

---

### AccionTerapeutica (therapeutic effect) entity

---

#### Solcitudes GET (AccionTerapeutica)

##### {FARMACIA-SERVICIO}/acciones-terapeuticas

- Shows all therapeutic actions in the database

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}

- Shows a therapeutic action by searching it by its id

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/nombre?nombre={x}

- Shows a therapeutic action by searching it by its name

---

#### Solicitudes POST (AccionTerapeutica)

##### {FARMACIA-SERVICIO}/acciones-terapeuticas

- Saves a therapeutic action in the database using the data from the request body

- **body:**

~~~javascript
{
    nombre: string,
    descripcion: string
}
~~~

- **Meaning of each attribute:**
- Nombre: name
- Descripcion: description

- **Example:**

~~~json
{
    "nombre": "antifebrile",
    "descripcion": "reduces fever"
}
~~~

---

#### PUT requests (AccionTerapeutica)

##### {FARMACIA-SERVICIO}/acciones-terapeuticas

- Modifies a therapeutic action according to the id provided in the request body

- **body:**

~~~javascript
{
    id: integer,
    nombre: string,
    descripcion: string
}
~~~

---

#### DELETE requests (AccionTerapeutica)

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}

- Deletes a therapeutic action according to the id in the URL

---

#### PATCH requests (AccionTerapeutica)

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}/nombre?nombre={x}

- Modifies the name of a therapeutic action according to the id in the URL

##### {FARMACIA-SERVICIO}/acciones-terapeuticas/{id}/descripcion 

- Modifies the description of a therapeutic action according to the id in the URL and the text in the request body

- **body:**

~~~javascript
{
    texto: string
}
~~~

- **Meaning of each atribute:**
- Texto: text

---

### AdministracionFarmaco (drug administration) entity

---

#### GET requests (AdministracionFarmaco)

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/{id}

- Shows a drug administration by searching it by id

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco

- Shows all drug administrations in the database

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/via?via={x}

- Shows a drug administration by searching it by the administration route

---

#### POST requests (AdministracionFarmaco)

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco

- Saves a new drug administration in the database using the data from the request body

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

#### PUT request (AdministracionFarmaco)

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco

- Modifies a drug administration using the data from the request body

- **body:**

~~~javascript
{
    id: numero_entero,
    via: string
}
~~~

---

#### DELETE request (AdministracionFarmaco)

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/{id}

- Deletes a drug administration from the database according to the id in the URL

---

#### PATCH request (AdministracionFarmaco)

##### {FARMACIA-SERVICIO}/administraciones-de-farmaco/{id}/via?via={x}

- Modifies the administration route of a drug administration according to the data in the URL

---

### Dosis (dose) entity

---

#### Solicitudes GET (Dosis)

##### {FARMACIA-SERVICIO}/dosis/{id}

- Shows a dose from the database by searching it by id

##### {FARMACIA-SERVICIO}/dosis

- Shows all doses in the database

##### {FARMACIA-SERVICIO}/dosis/cantidad-unidad-intervalo?cantidad={x}&nombre-unidad={x}&intervalo={x}

- Searches for a dose in the database according to the data provided in the URL

---

#### Solicitudes POST (Dosis)

##### {FARMACIA-SERVICIO}/dosis

- Saves a dose in the database according to the data in the request body

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

- Modifies a dose in the database according to the data in the request body

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

- Deletes a dose from the database according to the id in the URL

---

#### Solicitudes PATCH (Dosis)

##### {FARMACIA-SERVICIO}/dosis/{id}/cantidad?cantidad={x}

- Modifies the quantity of the dose according to what is specified in the URL

##### {FARMACIA-SERVICIO}/dosis/{id}/unidad?unidad-id={x}

- Modifies the unit of the dose according to what is specified in the URL

##### {FARMACIA-SERVICIO}/dosis/{id}/intervalo?intervalo={x}

- Modifies the time interval of the dose according to what is specified in the URL

---

### Entidad FormaFarmaceutica

---

#### Solicitudes GET (FormaFarmaceutica)

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/{id}

- Shows a pharmaceutical form from the database by searching it by id

##### {FARMACIA-SERVICIO}/formas-farmaceuticas

- Shows all pharmaceutical forms in the database

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/nombre?nombre={x}

- Shows a pharmaceutical form from the database by searching it by its name

---

#### Solicitudes POST (FormaFarmaceutica)

##### {FARMACIA-SERVICIO}/formas-farmaceuticas

- Saves a pharmaceutical form in the database using the data from the request body

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

- Modifies a pharmaceutical form in the database according to the data in the request body

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

- Deletes a pharmaceutical form from the database according to the id in the URL

---

#### Solicitudes PATCH (FormaFarmaceutica)

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/{id}/nombre?nombre={x}

- Modifies the name of a pharmaceutical form according to what is specified in the URL

---

### Entidad MarcaMedicamento

---

#### Solicitudes GET (MarcaMedicamento)

##### {FARMACIA-SERVICIO}/marcas/{id}

- Shows a medication brand from the database by searching it by id

##### {FARMACIA-SERVICIO}/marcas

- Shows all medication brands in the database

##### {FARMACIA-SERVICIO}/marcas/nombre?nombre={x}

- Shows a medication brand from the database by searching it by name

---

#### Solcitudes POST (MarcaMedicamento)

##### {FARMACIA-SERVICIO}/marcas

- Saves a medication brand in the database according to the data in the request body

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

- Modifies a medication brand in the database according to the data in the request body

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

- Deletes a medication brand from the database according to the id in the URL

---

#### Solicitudes PATCH (MarcaMedicamento)

##### {FARMACIA-SERVICIO}/marcas/{id}/nombre?nombre={x}

- Modifies the name of a medication brand according to what is specified in the URL

---

### Medicamento (medicine) entity

---

#### Solicitudes GET (Medicamento)

##### {FARMACIA-SERVICIO}/medicamentos/{id}

- Shows a medication from the database by searching it by id

##### {FARMACIA-SERVICIO}/medicamentos

- Shows all medications in the database

##### {FARMACIA-SERVICIO}/medicamentos/nombre?nombre={x}

- Shows a medication from the database by searching it by name

##### {FARMACIA-SERVICIO}/medicamentos/principio-activo?nombre-principio-activo={x}

- Shows all medications that contain the active ingredient specified in the URL

##### {FARMACIA-SERVICIO}/medicamentos/forma-farmaceutica?nombre-forma-farmaceutica={x}

- Shows all medications that have the pharmaceutical form specified in the URL

##### {FARMACIA-SERVICIO}/medicamentos/administracion?via={x}

- Shows all medications that are administered through the route specified in the URL

##### {FARMACIA-SERVICIO}/medicamentos/marca?nombre-marca={x}

- Shows all medications belonging to the brand specified in the URL

---

#### Solicitudes POST (Medicamento)

##### {FARMACIA-SERVICIO}/medicamentos

- Saves a medication in the database according to what is specified in the request body

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

- Modifies a medication in the database according to what is specified in the request body

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

- Deletes a medication from the database according to the id specified in the URL

---

#### Solicitudes PATCH (Medicamento)

##### {FARMACIA-SERVICIO}/medicamentos/{id}/nombre?nombre={x}

- Modifies the name of a medication in the database according to the data in the URL

##### {FARMACIA-SERVICIO}/medicamentos/{id}/agregar-principio-activo?principio-activo-id={x}

- Adds an active ingredient to a medication in the database according to what is specified in the URL

##### {FARMACIA-SERVICIO}/medicamentos/{id}/quitar-principio-activo?principio-activo-id={x}

- Removes an active ingredient from a medication in the database according to what is specified in the URL

##### {FARMACIA-SERVICIO}/medicamentos/{id}/forma-farmaceutica?forma-farmaceutica-id={x}

- Modifies the pharmaceutical form of a medication in the database according to what is specified in the URL

##### {FARMACIA-SERVICIO}/medicamentos/{id}/administracion?administracion-id={x}

- Modifies the administration route of a medication according to what is specified in the URL

##### {FARMACIA-SERVICIO}/medicamentos/{id}/marca?marca-id={x}

- Modifies the brand of a medication in the database according to what is specified in the URL

---

### PrincipioActivo (active ingredient) entity

---

#### Solicitudes GET (PrincipioActivo)

##### {FARMACIA-SERVICIO}/principios-activos/{id}

- Shows an active ingredient from the database by searching it by the id in the URL

##### {FARMACIA-SERVICIO}/principios-activos

- Shows all active ingredients in the database

##### {FARMACIA-SERVICIO}/principios-activos/nombre?nombre={x}

- Shows an active ingredient from the database by searching it by its name

##### {FARMACIA-SERVICIO}/principios-activos/accion-terapeutica?nombre-accion-terapeutica={x}

- Shows all active ingredients in the database that contain the therapeutic action specified in the URL

---

#### Solicitudes POST (PrincipioActivo)

##### {FARMACIA-SERVICIO}/principios-activos

- Saves an active ingredient in the database according to the data specified in the request body

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

- Modifies an active ingredient according to the data specified in the request body

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

- Deletes an active ingredient from the database according to the id specified in the URL

---

#### Solocitudes PATCH (PrincipioActivo)

##### {FARMACIA-SERVICIO}/principios-activos/{id}/agregar-accion-terapeutica?accion-terapeutica-id={x}

- Adds a therapeutic action to an active ingredient according to what is specified in the URL

##### {FARMACIA-SERVICIO}/principios-activos/{id}/quitar-accion-terapeutica?accion-terapeutica-id={x}

- Removes a therapeutic action from an active ingredient according to what is specified in the URL

---

### UnidadDeMedida (measurement unit) entity

---

#### Solicitudes GET (UnidadDeMedida)

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}

- Shows a measurement unit from the database by searching it by id

##### {FARMACIA-SERVICIO}/unidades-de-medida

- Shows all measurement units in the database

##### {FARMACIA-SERVICIO}/unidades-de-medida/nombre?nombre={x}

- Shows a measurement unit from the database by searching it by its name

##### {FARMACIA-SERVICIO}/unidades-de-medida/simbolo?simbolo={x}

- Shows a measurement unit from the database by searching it by its symbol

---

#### Solicitudes POST (UnidadDeMedida)

##### {FARMACIA-SERVICIO}/unidades-de-medida

- Saves a measurement unit in the database according to what is specified in the request body

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

- Modifies a measurement unit according to what is specified in the request body

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

- Deletes a measurement unit from the database according to what is specified in the URL

---

#### Solicitudes PATCH (UnidadDeMedida)

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}/nombre?nombre={x}

- Modifies the name of a measurement unit according to what is specified in the URL

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}/simbolo?simbolo={x}

- Modifies the symbol of a measurement unit according to what is specified in the URL

---

## Patients micrsoservice

---

### ObraSocial (health insurance) entity

---

#### Solcitudes GET (ObraSocial)

##### {PACIENTES-SERVICIO}/obras-sociales/{id}

- Shows a health insurance provider by searching it by id

##### {PACIENTES-SERVICIO}/obras-sociales

- Shows all health insurance providers in the database

##### {PACIENTES-SERVICIO}/obras-sociales/nombre?nombre={x}

- Shows a health insurance provider from the database by searching it by its name

---

#### Solicitudes POST (ObraSocial)

##### {PACIENTES-SERVICIO}/obras-sociales

- Saves a health insurance provider in the database according to what is specified in the request body

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

- Modifies a health insurance provider in the database according to the request body

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

- Deletes a health insurance provider from the database according to the id in the URL

---

#### Solicitudes PATCH (ObraSocial)

##### {PACIENTES-SERVICIO}/obras-sociales/{id}/nombre?nombre={x}

- Modifies the name of a health insurance provider according to what is specified in the request URL

---

### Paciente (patient) entity

---

#### Solicitudes GET (Paciente)

##### {PACIENTES-SERVICIO}/pacientes/{id}

- Shows a patient from the database according to the id in the URL

##### {PACIENTES-SERVICIO}/pacientes

- Shows all patients in the database

##### {PACIENTES-SERVICIO}/pacientes/dni?dni={x}

- Shows a patient from the database according to the DNI specified in the URL

##### {PACIENTES-SERVICIO}/pacientes/nombre?nombre={x}

- Shows the patients in the database who have the name specified in the URL

##### {PACIENTES-SERVICIO}/pacientes/apellido?apellido={x}

- Shows the patients in the database who have the last name specified in the URL

##### {PACIENTES-SERVICIO}/pacientes/email?email={x}

- Shows a patient from the database according to the email specified in the URL

##### {PACIENTES-SERVICIO}/pacientes/telefono?numero-telefonico={x}

- Shows the patients in the database who have the phone number specified in the URL

##### {PACIENTES-SERVICIO}/pacientes/fecha-nacimiento?desde={x}&hasta={x}

- Shows the patients in the database whose birth date is within the interval specified in the URL

##### {PACIENTES-SERVICIO}/pacientes/lugar-nacimiento?localidad={x}

- Shows the patients whose place of birth corresponds to the locality specified in the URL

##### {PACIENTES-SERVICIO}/pacientes/domicilio?calle={x}

- Shows the patients in the database whose address is located on the street specified in the URL

---

#### Solicitudes POST (Paciente)

##### {PACIENTES-SERVICIO}/pacientes

- Saves a patient in the database according to what is specified in the request body

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

- Modifies a patient in the database according to what is specified in the request body

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

- Deletes a patient from the database according to the id in the URL

---

#### Solicitudes PATCH (Paciente)

##### {PACIENTES-SERVICIO}/pacientes/dni?id={x}&dni={x}

- Modifies the DNI of a patient according to what is specified in the URL

##### {PACIENTES-SERVICIO}/pacientes/primer-nombre?id-o-dni={x}&opcion={x}&nombre={x}

- Modifies the first name of a patient by searching it by id or DNI

##### {PACIENTES-SERVICIO}/pacientes/segundo-nombre?id-o-dni={x}&opcion={x}&nombre={x}

- Modifies the second name of a patient by searching it by id or DNI

##### {PACIENTES-SERVICIO}/pacientes/apellido-paterno?id-o-dni={x}&opcion={x}&apellido={x}

- Modifies the paternal last name of a patient by searching it by id or DNI

##### {PACIENTES-SERVICIO}/pacientes/apellido-materno?id-o-dni={x}&opcion={x}&apellido={x}

- Modifies the maternal last name of a patient by searching it by id or DNI

##### {PACIENTES-SERVICIO}/pacientes/email?id-o-dni={x}&opcion={x}&email={x}

- Modifies the email of a patient by searching it by id or DNI

##### {PACIENTES-SERVICIO}/pacientes/agregar-telefono?id-o-dni={x}&opcion={x}&telefono-para-agregar={x}

- Adds a phone number to a patient by searching it by id or DNI

##### {PACIENTES-SERVICIO}/pacientes/quitar-telefono?id-o-dni={x}&opcion={x}&telefono-para-quitar={x}

- Removes a phone number from a patient by searching it by id or DNI

##### {PACIENTES-SERVICIO}/pacientes/fecha-nacimiento?id-o-dni={x}&opcion={x}&fecha={x}

- Modifies the birth date of a patient by searching it by id or DNI

##### {PACIENTES-SERVICIO}/pacientes/lugar-nacimiento?id-o-dni={x}&opcion={x}&localidad-id={x}

- Modifies the place of birth of a patient by searching it by id or DNI

##### {PACIENTES-SERVICIO}/pacientes/domicilio?id-o-dni={x}&opcion={x}&direccion-id={x}

- Modifies the address of a patient by searching it by id or DNI

##### {PACIENTES-SERVICIO}/pacientes/obra-social?id-o-dni={x}&opcion={x}&obra-social-id={x}

- Modifies the health insurance of a patient by searching it by id or DNI

---

### ResultadosDeEstudios (examinations results) entity

---

#### Solicitudes GET (ResultadosDeEstudios)

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}

- Shows the examination results of a patient according to the id in the URL

##### {PACIENTES-SERVICIO}/resultados-de-estudios

- Shows all examination results in the database

##### {PACIENTES-SERVICIO}/resultados-de-estudios/paciente?dni={x}

- Shows all examination results of a patient by searching with their DNI

##### {PACIENTES-SERVICIO}/resultados-de-estudios/estudio?nombre-estudio={x}

- Shows examination results in the database by searching by examination name

---

#### Solicitudes POST (ResultadosDeEstudios)

##### {PACIENTES-SERVICIO}/resultados-de-estudios

- Saves a set of examination results of a patient in the database

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

- Modifies a set of examination results of a patient according to the request body

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

- Deletes a set of examination results from the database according to the id in the request

---

#### Solicitudes PATCH (ResultadosDeEstudios)

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/paciente?id-o-dni-paciente={x}&opcion={x}

- Modifies the patient of a set of examination results according to the data in the URL

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/agregar-estudio?estudio-id={x}

- Adds an examination to a set of examination results according to the data in the request URL

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/quitar-estudio?estudio-id={x}

- Removes an examination from a set of examination results according to the data in the request URL

##### {PACIENTES-SERVICIO}/resultados-de-estudios/{id}/url-informe?url-informe={x}

- Modifies the report URL of a set of examination results according to the data in the request URL

---

### Sede (central office) entity

---

#### Solicitudes GET (Sede)

##### {PACIENTES-SERVICIO}/sedes/{id}

- Shows a central office from the database according to the id in the request URL

##### {PACIENTES-SERVICIO}/sedes

- Shows all central offices in the database

##### {PACIENTES-SERVICIO}/sedes/direccion?calle={x}

- Shows the central offices in the database by searching them by street

##### {PACIENTES-SERVICIO}/sedes/{id}/telefono?telefono={x}

- Shows the central offices in the database by searching them by phone number

---

#### Solicitudes POST (Sede)

##### {PACIENTES-SERVICIO}/sedes

- Saves a central office in the database according to the request body

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

- Modifies a central office in the database according to the request body

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

- Deletes a central office from the database according to the id in the request URL

---

#### Solicitudes PATCH (Sede)

##### {PACIENTES-SERVICIO}/sedes/{id}/direccion?direccion-id={x}

- Modifies the address of a central office in the database according to the data in the URL

##### {PACIENTES-SERVICIO}/sedes/{id}/agregar-telefono?telefono={x}

- Adds a phone number to a central office in the database according to the data in the URL

##### {PACIENTES-SERVICIO}/sedes/{id}/quitar-telefono?telefono={x}

- Removes a phone number from a central office in the database according to the data in the URL

##### {PACIENTES-SERVICIO}/sedes/{id}/obra-social?obra-social-id={x}

- Modifies the health insurance provider of a central office according to the data in the request URL

---

### Entidad TurnoCita 

---

#### Solicitudes GET (TurnoCita)

##### {PACIENTES-SERVICIO}/turnos-cita/{id}

- Shows the data of an appointment with a professional according to the id in the URL

##### {PACIENTES-SERVICIO}/turnos-cita

- Shows all appointments with professionals in the database

##### {PACIENTES-SERVICIO}/turnos-cita/paciente?dni={x}

- Shows appointments with professionals by searching with the patient's DNI

##### {PACIENTES-SERVICIO}/turnos-cita/fecha-turno?fecha-turno={x}

- Shows appointments with professionals by searching by appointment date

##### {PACIENTES-SERVICIO}/turnos-cita/periodo?desde={x}&hasta={x}

- Shows appointments with professionals by searching by the appointment period

##### {PACIENTES-SERVICIO}/turnos-cita/profesional?profesional-id={x}

- Shows appointments with professionals by searching by the professional id

---

#### Solicitudes POST (TurnoCita)

##### {PACIENTES-SERVICIO}/turnos-cita

- Saves an appointment in the database according to the data in the request body

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

- Modifies an appointment with a professional according to the data in the request body

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

- Deletes an appointment with a professional from the database according to the id in the URL

---

#### Solicitudes PATCH (TurnoCita)

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/paciente?id-o-dni-paciente={x}&opcion={x}

- Modifies the patient of an appointment according to the data in the URL

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/fecha-solicitud?fecha-solicitud={x}

- Modifies the request date of an appointment with a professional according to the data in the URL

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/horario?inicio={x}&fin={x}

- Modifies the schedule of an appointment with a professional according to the data in the request URL

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/estado?estado={x}

- Modifies the status of an appointment with a professional according to the data in the URL

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/cobertura?cobertura={x}

- Modifies the coverage that a patient has in their appointment with a professional according to the data in the URL

---

### Entidad TurnoEstudio

---

#### Solicitudes GET (TurnoEstudio)

##### {PACIENTES-SERVICIO}/turnos-estudio/{id}

- Shows the data of an appointment for an examination according to the id in the URL

##### {PACIENTES-SERVICIO}/turnos-estudio

- Shows the data of all examination appointments in the database

##### {PACIENTES-SERVICIO}/turnos-cita/paciente?dni={x}

- Shows the data of examination appointments by searching with the patient's DNI

##### {PACIENTES-SERVICIO}/turnos-cita/fecha-turno?fecha-turno={x}

- Shows the data of examination appointments by searching by appointment date

##### {PACIENTES-SERVICIO}/turnos-cita/periodo?desde={x}&hasta={x}

- Shows the data of examination appointments by searching by the examination period

##### {PACIENTES-SERVICIO}/turnos-estudio/estudio?estudio-id={x}

- Shows the data of examination appointments by searching by a specific examination

---

#### Solicitudes POST (TurnoEstudio)

##### {PACIENTES-SERVICIO}/turnos-estudio

- Saves an examination appointment in the database according to the data in the request body

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

- Modifies the data of an examination appointment according to the data in the request body

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

- Deletes an examination appointment from the database according to the data in the URL

---

#### Solicitudes PATCH (TurnoEstudio)

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/paciente?id-o-dni-paciente={x}&opcion={x}

- Modifies the patient of an examination appointment according to the data in the request URL

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/fecha-solicitud?fecha-solicitud={x}

- Modifies the request date of an examination appointment according to the data in the request URL

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/horario?inicio={x}&fin={x}

- Modifies the schedule of an examination appointment according to the data in the request URL

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/estado?estado={x}

- Modifies the status of an examination appointment according to the data in the request URL

##### {PACIENTES-SERVICIO}/turnos-cita/{id}/cobertura?cobertura={x}

- Modifies the coverage for the patient of an examination appointment according to the data in the request URL

##### {PACIENTES-SERVICIO}/turnos-estudio/{id}/estudio?estudio-id={x}

- Modifies the examination of an examination appointment according to the data in the request URL

---

## Microservicio de Hospital

---

### Entidad CirugiaPaciente

---

#### Solicitudes GET (CirugiaPaciente)

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}

- Searches for a surgery performed on a patient according to the id in the request

##### {HOSPITAL-SERVICIO}/cirugias-pacientes

- Shows all surgeries performed on patients in the database

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/paciente?paciente-id-o-dni={x}&opcion={x}

- Shows the surgeries performed on patients by searching with the patient id or DNI

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/cirugia?cirugia={x}

- Shows the surgeries performed on patients by searching by surgical treatment

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/periodo?desde={x}&hasta={x}

- Shows the surgeries performed on patients by searching by period

---

#### Solicitudes POST (CirugiaPaciente)

##### {HOSPITAL-SERVICIO}/cirugias-pacientes

- Saves a surgery performed on a patient in the database according to the data in the request body

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

- Modifies a surgery performed on a patient in the database according to the request body

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

- Deletes a surgery performed on a patient from the database according to the id in the URL

---

#### Solicitudes PATCH (CirugiaPaciente)

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/paciente?paciente-id-o-dni={x}&opcion={x}

- Modifies the patient of a surgery performed on a patient according to the request URL

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/cirugia?cirugia-id={x}

- Modifies the surgical treatment of a surgery performed on a patient according to the request URL

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/fecha?fecha={x}

- Modifies the date of a surgery performed on a patient according to the request URL

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/hora-inicio?inicio={x}

- Modifies the start time of a surgery performed on a patient according to the request URL

##### {HOSPITAL-SERVICIO}/cirugias-pacientes/{id}/hota-final?fin={x}

- Modifies the end time of a surgery performed on a patient according to the request URL

---

### Entidad Diagnostico

---

#### Solicitudes GET (Diagnostico)

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}

- Shows a diagnosis from the database by searching with its id

##### {HOSPITAL-SERVICIO}/diagnosticos

- Shows all diagnoses from the database

##### {HOSPITAL-SERVICIO}/diagnosticos/nombre?nombre={x}

- Shows a diagnosis from the database by searching by its name

---

#### Solicitudes POST (Diagnostico)

##### {HOSPITAL-SERVICIO}/diagnosticos

- Saves a diagnosis in the database according to the data in the request body

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

- Modifies a diagnosis in the database according to the data in the request body

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

- Deletes a diagnosis from the database according to the id in the URL

---

#### Solicitudes PATCH (Diagnostico)

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/agregar-sintoma?sintoma-id={x}

- Adds a symptom to a diagnosis in the database according to the data in the request URL

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/quitar-sintoma?sintoma-id={x}

- Removes a symptom from a diagnosis in the database according to the data in the request URL

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/agregar-signo?signo-id={x}

- Adds a sign to a diagnosis in the database according to the data in the request URL

##### {HOSPITAL-SERVICIO}/diagnosticos/{id}/quitar-signo?signo-id={x}

- Removes a sign from a diagnosis in the database according to the data in the request URL

---

### Entidad DiagnosticoPaciente

---

#### Solicitudes GET (DiagnosticoPaciente)

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}

- Shows a diagnosis made for a patient by searching with its id

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes

- Shows all diagnoses made for patients in the database

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/paciente?pacinete-id-o-dni={x}&opcion={x}

- Shows the diagnoses made for a patient

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/diagnostico?diagnostico={x}

- Shows the diagnoses made for patients by searching by diagnosis

---

#### Solicitudes POST (DiagnosticoPaciente)

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes

- Saves a diagnosis made for a patient in the database according to the data in the request body

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

- Modifies the data of a diagnosis made for a patient according to the request body

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

- Deletes a diagnosis made for a patient from the database according to the id in the request URL

---

#### Solicitudes PATCH (DiagnosticoPaciente)

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/paciente?paciente-id-o-dni={x}&opcion={x}

- Modifies the patient of a diagnosis made for a patient according to the data in the request URL

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/diagnostico?diagnostico-id={x}

- Modifies the diagnosis of a diagnosis made for a patient according to the data in the request URL

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/fecha-inicio?inicio={x}

- Modifies the start date of a diagnosis made for a patient according to the data in the request URL

##### {HOSPITAL-SERVICIO}/diagnosticos-pacientes/{id}/fecha-final?fin={x}

- Modifies the end date of a diagnosis made for a patient according to the data in the request URL

---

### Entidad Empleado

---

#### Solicitudes GET (Empleado)

##### {HOSPITAL-SERVICIO}/empleados/{id}

- Shows an employee from the database by searching with its id

##### {HOSPITAL-SERVICIO}/empleados

- Shows all employees in the database

##### {HOSPITAL-SERVICIO}/empleados/dni?dni={x}

- Shows an employee from the database by searching by DNI

##### {HOSPITAL-SERVICIO}/empleados/nombre?nombre={x}

- Shows employees from the database by searching by name

##### {HOSPITAL-SERVICIO}/empleados/apellido?apellido={x}

- Shows employees from the database by searching by last name

##### {HOSPITAL-SERVICIO}/empleados/email?email={x}

- Shows an employee from the database by searching by email

##### {HOSPITAL-SERVICIO}/empleados/matricula?matricula={x}

- Shows an employee from the database by searching by professional license number

##### {HOSPITAL-SERVICIO}/empleados/rol?rol={x}

- Shows employees from the database by searching by role

##### {HOSPITAL-SERVICIO}/empleados/rango-salarial?minimo={x}&maximo={x}

- Shows employees from the database by searching by salary range

---

#### Solicitudes POST (Empleado)

##### {HOSPITAL-SERVICIO}/empleados

- Saves an employee in the database according to the data in the request body

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

- Modifies an employee in the database according to the data in the request body

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

- Deletes an employee from the database according to the id in the request URL

---

#### Solicitudes PATCH (Empleado)

##### {HOSPITAL-SERVICIO}/empleados/{id}/dni?dni={x}

- Modifies the DNI of an employee according to the data in the request URL

##### {HOSPITAL-SERVICIO}/empleados/{id}/primer-nombre?primer-nombre={x}

- Modifies the first name of an employee according to the data in the request URL

##### {HOSPITAL-SERVICIO}/empleados/{id}/segundo-nombre?segundo-nombre={x}

- Modifies the second name of an employee according to the data in the request URL

##### {HOSPITAL-SERVICIO}/empleados/{id}/apellido-paterno?apellido-paterno={x}

- Modifies the paternal last name of an employee according to the data in the request URL

##### {HOSPITAL-SERVICIO}/empleados/{id}/apellido-materno?apellido-materno={x}

- Modifies the maternal last name of an employee according to the data in the request URL

##### {HOSPITAL-SERVICIO}/empleados/{id}/email?email={x}

- Modifies the email of an employee according to the data in the request URL

##### {HOSPITAL-SERVICIO}/empleados/{id}/domicilio?domicilio-id={x}

- Modifies the address of an employee according to the data in the request URL

##### {HOSPITAL-SERVICIO}/empleados/{id}/agregar-telefono?telefono={x}

- Adds a phone number to an employee according to the data in the request URL

##### {HOSPITAL-SERVICIO}/empleados/{id}/quitar-telefono?telefono={x}

- Removes a phone number from an employee according to the data in the request URL

##### {HOSPITAL-SERVICIO}/empleados/{id}/matricula?matricula={x}

- Modifies the professional license number of an employee according to the data in the request URL

##### {HOSPITAL-SERVICIO}/empleados/{id}/rol?rol-id={x}

- Modifies the role of an employee according to the data in the request URL

##### {HOSPITAL-SERVICIO}/empleados/{id}/salario?salario={x}

- Modifies the salary of an employee according to the data in the request URL

---

### Entidad EstudioMedicoClasificacion

---

#### Solictudes GET (EstudioMedicoClasificacion)

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos/{id}

- Shows a medical study classification by searching with its id

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos

- Shows all medical study classifications in the database

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos/nombre?nombre={x}

- Shows a medical study classification by searching by its name

---

#### Solicitudes POST (EstudioMedicoClasificacion)

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos

- Saves a medical study classification in the database according to the data in the request body

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

- Modifies a medical study classification in the database according to the data in the request body

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

- Deletes a medical study classification from the database according to the id in the request URL

---

#### Solicitudes PATCH (EstudioMedicoClasificacion)

##### {HOSPITAL-SERVICIO}/clasificacion-estudios-medicos/{id}/nombre?nombre={x}

- Modifies the name of a medical study classification according to the data in the request URL

---

### Entidad EstudioMedico

---

#### Solicitudes GET (EstudioMedico)

##### {HOSPITAL-SERVICIO}/estudios-medicos/{id}

- Shows a medical study by searching with its id

##### {HOSPITAL-SERVICIO}/estudios-medicos

- Shows all medical studies in the database

##### {HOSPITAL-SERVICIO}/estudios-medicos/nombre?nombre={x}

- Shows a medical study by searching by its name

##### {HOSPITAL-SERVICIO}/estudios-medicos/clasificacion?clasificacion={x}

- Shows medical studies from the database by searching by their classification

---

#### Soplicitudes POST (EstudioMedico)

##### {HOSPITAL-SERVICIO}/estudios-medicos

- Saves a medical study in the database according to the data in the request body

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

- Modifies a medical study in the database according to the data in the request body

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

- Deletes a medical study from the database according to the id in the URL

---

#### Solictudes PATCH (EstudioMedico)

##### {HOSPITAL-SERVICIO}/estudios-medicos/{id}/nombre?nombre={x}

- Modifies the name of a medical study according to the data in the request URL

##### {HOSPITAL-SERVICIO}/estudios-medicos/{id}/cladificacion?clasificacion={x}

- Modifies the classification of a medical study according to the data in the request URL

---

### Entidad FisioterapiaPaciente

---

#### Solicitudes GET (FisioterapiaPaciente)

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}

- Shows a physiotherapy treatment performed on a patient by searching with its id

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes

- Shows all physiotherapy treatments performed on patients in the database

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/paciente?paciente-id-o-dni={x}&opcion={x}

- Shows physiotherapy treatments performed on patients by searching by the patient's id or DNI

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/fecha-inicio?desde={x}&hasta={x}

- Shows physiotherapy treatments performed on patients by searching by start date

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/fecha-final?desde={x}&hasta={x}

- Shows physiotherapy treatments performed on patients by searching by end date

---

#### Solicitudes POST (FisioterapiaPaciente)

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes

- Saves a physiotherapy treatment performed on a patient according to the data in the request body

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

- Modifies a physiotherapy treatment performed on a patient according to the data in the request body

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

- Deletes a physiotherapy treatment performed on a patient according to the id in the URL

---

#### Solicitudes PATCH (FisioterapiaPaciente)

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}/paciente-id-o-dni={x}&opcion={x}

- Modifies the patient of a physiotherapy treatment performed on a patient according to the data in the request URL

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}/fecha-inicio?inicio={x}

- Modifies the start date of a physiotherapy treatment performed on a patient according to the data in the request URL

##### {HOSPITAL-SERVICIO}/fisioterapias-pacientes/{id}/fecha-final?final={x}

- Modifies the end date of a physiotherapy treatment performed on a patient according to the data in the request URL

---

### Entidad MedicamentoPaciente

---

#### Solicitudes GET (MedicamentoPaciente)

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}

- Shows a medication treatment performed on a patient by searching with its id

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes

- Shows all medication treatments performed on patients in the database

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/paciente?paciente-id-o-dni={x}&opcion={x}

- Shows medication treatments performed on patients by searching by the patient's id or DNI

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/principio-activo?principio-activo={x}

- Shows medication treatments performed on patients by searching by the active ingredient of the medication

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/fecha-inicio?desde={x}&hasta={x}

- Shows medication treatments performed on patients by searching by start date

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/fecha-final?desde={x}&hasta={x}

- Shows medication treatments performed on patients by searching by end date

---

#### Solicitudes POST (MedicamentoPaciente)

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes

- Saves a medication treatment performed on a patient in the database according to the data in the request body

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

- Modifies a medication treatment performed on a patient in the database according to the data in the request body

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

- Deletes a medication treatment performed on a patient from the database according to the request URL

---

#### Solicitudes PATCH (MedicamentoPaciente)

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/paciente?paciente-id-o-dni={x}&opcion={x}

- Modifies the patient of a medication treatment performed on a patient according to the data in the request URL

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/medicamento?medicamento-id={x}

- Modifies the medication of a medication treatment performed on a patient according to the data in the request URL

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/dosis?dosis-id={x}

- Modifies the dosage of a medication treatment performed on a patient according to the data in the request URL

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/fecha-inicio?inicio={x}

- Modifies the start date of a medication treatment performed on a patient according to the data in the request URL

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/{id}/fecha-final?fin={x}

- Modifies the end date of a medication treatment performed on a patient according to the data in the request URL

---

### Entidad PsicoterpiaPaciente

---

#### Solicitudes GET (PsicoterpiaPaciente)

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}

- Shows a psychotherapy treatment performed on a patient according to the id in the URL

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes

- Shows all psychotherapy treatments performed on patients in the database

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/paciente?paciente-id-o-dni={x}&opcion={x}

- Shows psychotherapy treatments performed on patients by searching by the patient's id or DNI

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/fecha-inicio?desde={x}&hasta={x}

- Shows psychotherapy treatments performed on patients by searching by start date

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/fecha-final?desde={x}&hasta={x}

- Shows psychotherapy treatments performed on patients by searching by end date

---

#### Solicitudes POST (PsicoterpiaPaciente)

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes

- Saves a psychotherapy treatment performed on a patient in the database according to the data in the request body

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

- Modifies a psychotherapy treatment performed on a patient in the database according to the data in the request body

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

- Deletes a psychotherapy treatment performed on a patient from the database according to the id in the URL

---

#### Solicitudes PATCH (PsicoterpiaPaciente)

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}/paciente?paciente-id-o-dni={x}&opcion={x}

- Modifies the patient of a psychotherapy treatment performed on a patient according to the data in the request URL

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}/fecha-inicio?inicio={x}

- Modifies the start date of a psychotherapy treatment performed on a patient according to the data in the request URL

##### {HOSPITAL-SERVICIO}/psicoterapias-pacientes/{id}/fecha-final?fin={x}

- Modifies the end date of a psychotherapy treatment performed on a patient according to the data in the request URL

---

### Entidad RadioTerapiaPaciente

---

#### Solicitudes GET (RadioTerapiaPaciente)

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}

- Shows a radiotherapy treatment performed on a patient by searching with its id

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes

- Shows all radiotherapy treatments performed on patients in the database

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/paciente?paciente-id-o-dni={x}&opcion={x}

- Shows radiotherapy treatments performed on patients by searching by the patient's id or DNI

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/fecha-inicio?desde={x}&hasta={x}

- Shows radiotherapy treatments performed on patients by searching by start date

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/fecha-final?desde={x}&hasta={x}

- Shows radiotherapy treatments performed on patients by searching by end date

---

#### Solicitudes POST (RadioTerapiaPaciente)

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes

- Saves a radiotherapy treatment performed on a patient in the database according to the data in the request body

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

- Modifies a radiotherapy treatment performed on a patient according to the data in the request body

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

- Deletes a radiotherapy treatment performed on a patient according to the id in the URL

---

#### Solicitudes PATCH (RadioTerapiaPaciente)

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}/paciente?paciente-id-o-dni={x}&opcion={x}

- Modifies the patient of a radiotherapy treatment performed on a patient according to the data in the request URL

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}/fecha-inicio?inicio={x}

- Modifies the start date of a radiotherapy treatment performed on a patient according to the data in the request URL

##### {HOSPITAL-SERVICIO}/radioterapias-pacientes/{id}/fecha-final?fin={x}

- Modifies the end date of a radiotherapy treatment performed on a patient according to the data in the request URL

---

### Entidad RolEmpleado

---

#### Solicitudes GET (RolEmpleado)

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}

- Shows an employee role by searching with its id

##### {HOSPITAL-SERVICIO}/roles-empleado

- Shows all employee roles in the database

##### {HOSPITAL-SERVICIO}/roles-empleado/nombre?nombre={x}

- Shows an employee role by searching by its name

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}/sector?sector={x}

- Shows employee roles in the database by searching by sector

---

#### Solicitudes POST (RolEmpleado)

##### {HOSPITAL-SERVICIO}/roles-empleado

- Saves an employee role in the database according to the data in the request body

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

- Modifies an employee role in the database according to the data in the request body

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

- Deletes an employee role from the database according to the id in the request

---

#### Solicitudes PATCH (RolEmpleado)

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}/nombre?nombre

- Modifies the name of an employee role according to the data in the request URL

##### {HOSPITAL-SERVICIO}/roles-empleado/{id}/sector?sector-id={x}

- Modifies the sector of an employee role according to the data in the request URL

---

### Entidad Sector

---

#### Solicitudes GET (Sector)

##### {HOSPITAL-SERVICIO}/sectores/{id}

- Shows a sector according to the id in the URL

##### {HOSPITAL-SERVICIO}/sectores

- Shows all sectors in the database

##### {HOSPITAL-SERVICIO}/sectores/nombre?nombre={x}

- Shows a sector from the database by searching by its name

---

#### Solicitudes POST (Sector)

##### {HOSPITAL-SERVICIO}/sectores

- Saves a sector in the database according to the data in the request body

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

- Modifies a sector in the database according to the data in the request body

~~~javascript
{
    id: numero_entero,
    nombre: string
}
~~~

---

#### Solicitudes DELETE (Sector)

##### {HOSPITAL-SERVICIO}/sectores/{id}

- Deletes a sector from the database according to the id in the URL

---

#### Solicitudes PATCH (Sector)

##### {HOSPITAL-SERVICIO}/sectores/{id}/nombre?nombre={x}

- Modifies the name of a sector according to the data in the request URL

---

### Entidad Signo

---

#### Solicitudes GET (Signo)

##### {HOSPITAL-SERVICIO}/signos/{id}

- Shows a sign from the database by searching with its id

##### {HOSPITAL-SERVICIO}/signos

- Shows all signs in the database

##### {HOSPITAL-SERVICIO}/signos/nombre?nombre={x}

- Shows a sign from the database by searching by its name

##### {HOSPITAL-SERVICIO}/signos/unidad?unidad={x}

- Shows signs from the database by searching by the name of the measurement unit

##### {HOSPITAL-SERVICIO}/signos/descripcion?secuencia={x}

- Shows signs from the database by searching by a sequence of characters in the description

---

#### Solicitudes POST (Signo)

##### {HOSPITAL-SERVICIO}/signos

- Saves a sign in the database according to the data in the request body

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

- Modifies a sign in the database according to the data in the request body

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

- Deletes a sign from the database according to the id in the URL

---

#### Solictudes PATCH (Signo)

##### {HOSPITAL-SERVICIO}/signos/{id}/nombre?nombre={x}

- Modifies the name of a sign according to the data in the request URL

##### {HOSPITAL-SERVICIO}/signos/{id}/valor-minimo?valor-minimo={x}

- Modifies the minimum value of a sign measurement according to the data in the request URL

##### {HOSPITAL-SERVICIO}/signos/{id}/valor-maximo?valor-maximo={x}

- Modifies the maximum value of a sign measurement according to the data in the request URL

##### {HOSPITAL-SERVICIO}/signos/{id}/unidad?unidad-id={x}

- Modifies the measurement unit of a sign according to the data in the request URL

##### {HOSPITAL-SERVICIO}/signos/{id}/descripcion

- Modifies the description of a sign according to the data in the request body

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

- Shows a symptom from the database by searching with its id

##### {HOSPITAL-SERVICIO}/sintomas

- Shows all symptoms in the database

##### {HOSPITAL-SERVICIO}/sintomas/nombre?nombre={x}

- Shows a symptom from the database by searching by its name

---

#### Solicitudes POST (Sintoma)

##### {HOSPITAL-SERVICIO}/sintomas

- Saves a symptom in the database according to the data in the request body

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

- Modifies a symptom in the database according to the data in the request body

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

- Deletes a symptom from the database according to the id in the URL

---

#### Solicitudes PATCH (Sintoma)

##### {HOSPITAL-SERVICIO}/sintomas/{id}/nombre?nombre={x}

- Modifies the name of a symptom according to the data in the request URL

---

### Entidad TratamientoQuirurgico

---

#### Solicitudes GET (TratamientoQuirurgico)

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/{id}

- Shows a surgical treatment from the database by searching with its id

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos

- Shows all surgical treatments in the database

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/nombre?nombre={x}

- Shows a surgical treatment by searching by its name

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/descripcion?descripcion={x}

- Shows surgical treatments from the database by searching by a sequence of characters in their description

---

#### Solicitudes POST (TratamientoQuirurgico)

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos

- Saves a surgical treatment in the database according to the data in the request body

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

- Modifies a surgical treatment in the database according to the data in the request body

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

- Deletes a surgical treatment from the database according to the id in the URL

---

#### Solcitudes PATCH (TratamientoQuirurgico)

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/{id}/nombre?nombre={x}

- Modifies the name of a surgical treatment according to the data in the request URL

##### {HOSPITAL-SERVICIO}/tratamientos-quirurgicos/{id}/descripcion 

- Modifies the description of a surgical treatment according to the data in the request body

- **body:**

~~~javascript
{
    texto: string
}
~~~

---
---



---
---
---
Español
---

# Sistema médico

Esta aplicación ha sido desarrollada con Java y Spring boot utilizando IntelliJ IDEA. Consiste en cuatro microservicios: contacto, farmacia, paciente y hospital. El microservicio de contacto tiene las siguentes entidades: Direccion, Localidad, Pais y Provincia. Las entidades que componen al microservicio de farmacia son: AccionTerapeutica, AdministrcionFarmaco, Dosis, FormaFarmaceutica, MarcaMedicamento, Medicamento, PrincipioActivo y UnidadDeMedida. En el microservicio de paciente las entidades son: ObraSocial, Paciente, ResultadoDeEstudios, Sede, TurnoCita y TurnoEstudio. Para el microservicio de hospital las entidades son: CirugiaPaciente, Diagnostico, DiagnosticoPaciente, Empleado, EstudioMedico, EstudioMedicoClasificacion, FisioterapiaPaciente, MedicamentoPaciente, PsicoterapiaPaciente, RadioTerpiaPaciente, RolEmpleado, Sector, Signo, Sintoma y TratamientoQuirurgico.

---
---

## Índice

1. Descarga del proyecto y ejecución de los microservicios
2. Explicación sobre entidades
3. Notas
4. Ejemplos de solicitudes

---
---

## Descarga del proyecto y ejecución de sus microservicios

### Algunos requisitos para la ejecución del proyecto

- Tener instalado IntelliJ IDEA
- MySQL instalado en la computadora

### Pasos a seguir

1. Crear un directorio en el dispositivo de trabajo (tu computadora);
2. Clonar el proyecto del repositorio de GitHub https://github.com/Rafael30586/SistemaMedicoSpringBoot en el directorio creado en el punto anterior;
3. Crear los archivos .env con los datos de conexión a base de datos en el directorio raíz de cada microservicio;
4. Abrir cada microservicio por separado, cada uno en una ventana de IntelliJ IDEA;
5. Ejecutarlos uno por uno;
6. Comprobar su funcionamiento con Postman o herramientas similares.

### A tener en cuenta

- El proyecto puede ser ejecutado con otros IDEs como Eclipse IDE o Apache NetBeans, pero el procedimiento puede variar.
- Se puede utilizar algún otro gestor de base de datos diferente de MySQL cambiando algunas configuraciones.

---
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

- Muestra todas las direcciones que se encuentren en una provincia específica

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

- Modifica la provincia a la que pertenece una localidad de acuerdo al id de la URL

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

- Modifica un pais de la base de datos usando los datos del "body" de la solicitud

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

- Muestra todas las provincias de la base de datos

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

- Modifica el pais al que pertenece una provincia asignándole el id del pais que corresponda

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

- Guarda una acción terapéutica en la base de datos con los datos del "body" de la solicitud

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

- Muestra una administración de fármaco buscándola por el id

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

- Modifica una forma farmacéutica de la base de datos de acuerdo a los datos del "body" 

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

- Borra una forma farmacéutica de la base de datos de acuerdo al id de la URL

---

#### Solicitudes PATCH (FormaFarmaceutica)

##### {FARMACIA-SERVICIO}/formas-farmaceuticas/{id}/nombre?nombre={x}

- Modifica el nombre de una forma farmacéutica de acuerdo a lo establecido en la URL

---

### Entidad MarcaMedicamento

---

#### Solicitudes GET (MarcaMedicamento)

##### {FARMACIA-SERVICIO}/marcas/{id}

- Muestra una marca de medicamento de la base de datos buscándola por id

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

- Muestra todos los principios activos de la base de datos que contengan la acción terapéutica establecida en la URL

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

- Modifica un principio activo de acuerdo  a los datos establecidos en el "body"

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

- Muestra una unidad de medida de la base de datos buscándola por su nombre

##### {FARMACIA-SERVICIO}/unidades-de-medida/simbolo?simbolo={x}

- Muestra una unidad de la base de datos buscándola por su símbolo

---

#### Solicitudes POST (UnidadDeMedida)

##### {FARMACIA-SERVICIO}/unidades-de-medida

- Guarda una unidad de medida en la base de datos de acuerdo a lo establecido en el body

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

- Elimina una unidad de medida de la base de datos de acuerdo a lo establecido en la URL

---

#### Solicitudes PATCH (UnidadDeMedida)

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}/nombre?nombre={x}

- Modifica el nombre de una unidad de medida de acuerdo a lo estsblecido en la URL

##### {FARMACIA-SERVICIO}/unidades-de-medida/{id}/simbolo?simbolo={x}

- Modifica el símbolo de una unidad de medida de acuerdo a lo establecido en la URL

---

## Microservicio de Pacientes

---

### Entidad ObraSocial

---

#### Solcitudes GET (ObraSocial)

##### {PACIENTES-SERVICIO}/obras-sociales/{id}

- Muestra una obra social buscándola por id

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

- Muestra un paciente de la base de datos de acuerdo al id de la URL

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

##### {PACIENTES-SERVICIO}/pacientes/dni?id={x}&dni={x}

- Modifica el DNI de un paciente de acuerdo a lo establecido en la URL

##### {PACIENTES-SERVICIO}/pacientes/primer-nombre?id-o-dni={x}&opcion={x}&nombre={x}

- Modifica el primer nombre de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/segundo-nombre?id-o-dni={x}&opcion={x}&nombre={x}

- Modifica el segundo nombre de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/apellido-paterno?id-o-dni={x}&opcion={x}&apellido={x}

- Modifica el apellido paterno de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/apellido-materno?id-o-dni={x}&opcion={x}&apellido={x}

- Modifica el apellido materno de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/email?id-o-dni={x}&opcion={x}&email={x}

- Modifica el email de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/agregar-telefono?id-o-dni={x}&opcion={x}&telefono-para-agregar={x}

- Agrega un número telefónico a un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/quitar-telefono?id-o-dni={x}&opcion={x}&telefono-para-quitar={x}

- Quita un número telefónico a un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/fecha-nacimiento?id-o-dni={x}&opcion={x}&fecha={x}

- Modifica la fecha de nacimiento de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/lugar-nacimiento?id-o-dni={x}&opcion={x}&localidad-id={x}

- Modifica el lugar de nacimiento de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/domicilio?id-o-dni={x}&opcion={x}&direccion-id={x}

- Modifica el domicilio de un paciente buscándolo por id o DNI

##### {PACIENTES-SERVICIO}/pacientes/obra-social?id-o-dni={x}&opcion={x}&obra-social-id={x}

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

- Guarda un turno en la base de datos de acuerdo a los datos del "body" de la solicitud

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

- Modifica el horario de un turno con un profesional de acuerdo a los datos de la URL de la solicitud

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

- Guarda a un empleado en la base de datos de acuerdo los datos del "body" de la solicitud

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

- Modifica el DNI de un empleado de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/primer-nombre?primer-nombre={x}

- Modifica el primer nombre de un empleado de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/segundo-nombre?segundo-nombre={x}

- Modifica el segundo nombre de un empleado de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/apellido-paterno?apellido-paterno={x}

- Modifica el apellido de un empleado de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/apellido-materno?apellido-materno={x}

- Modifica el apellido materno de un empleado de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/email?email={x}

- Modifica el email de un empleado de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/domicilio?domicilio-id={x}

- Modifica el domicilio de un empleado de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/agregar-telefono?telefono={x}

- Agrega un teléfono a un empleado de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/quitar-telefono?telefono={x}

- Quita un número telefónico a un empleado de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/matricula?matricula={x}

- Modifica la matrícula profesional de un empleado de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/rol?rol-id={x}

- Modifica el rol de un empleado de acuerdo a los datos de la URL de la solicitud

##### {HOSPITAL-SERVICIO}/empleados/{id}/salario?salario={x}

- Modifica el salario de un empleado de acuerdo a los datos de la URL de la solicitud

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

- Guarda una clasificación de estudio médico en la base de datos de acuerdo al "body" de la solicitud

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

- Borra una clasificación de estudio médico de la base de datos de acuerdo

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

- Muestra estudios médicos de la base de datos buscándolos por su clasificación

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

- Modifica la clasificación de un estudio médico de acuerdo a los datos de la URL de la solicitud

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

- Muestra los tratamientos por medicamento realizados en pacientes buscando por principio activo del medicamento

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/fecha-inicio?desde={x}&hasta={x}

- Muestra los tratamientos por medicamento realizados en pacientes buscando por fecha de inicio

##### {HOSPITAL-SERVICIO}/medicamentos-pacientes/fecha-final?desde={x}&hasta={x}

- Muestra los tratamientos por medicamento realizados en pacientes buscando por fecha de final

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

- Muestra un tratamiento quirúrgico buscándolo por nombre

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

- Modifica un tratamiento quirúrgico en la base de datos de acuerdo a los datos del "body" de la solicitud

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
- Los nombres en los "bodys" y URLs de las solicitudes, como por ejemplo, nombres propios de pacientes o empleados, nombres de lugares (provincias o paises), nombres de medicamentos, etc, deben estar en letra minúscula. El desarrollador frontend será el encargado de que los nombres se muestren con letras mayúsculas cuando corresponda.
- Cuando se quiera buscar un registro de la base de datos en base a un campo que sea una cadena de caracteres con espacios vacíos, estos espacios en el argumento de la URL deberán ser reemplazados por un guión bajo cada uno (hay un caso así en el primer ejemplo de solicitud en la siguiente sección). Lo mismo ocurrirá cuando se quiera modificar un campo de un registro utilizando una solicitud de tipo patch: cuando el campo a modificar sea una cadena de caracteres, los espacios vacíos del argumento de la URL de la solicitud deberán ser reemplazados por guiones bajos.
- Las fechas en los argumentos de las URLs deberán tener un formato yyyy-MM-dd, mientras que cuando las fechas estén en el "body" de una solicitud deberán tener un formato dd-MM-yyyy

---
---

## Ejemplos de solicitudes

1. Mostrar todas las direcciones de la base de datos de la provincia de Santa fe:

    - endpoint: .../direcciones/provincia?provincia=santa_fe

2. Modificar la descripción de la acción terapéutica de id igual a 12

    - endpoint: .../acciones-terapeuticas/12/descripcion

    - body:

    ~~~json
    {
       "texto": "inhibe el crecimiento de hongos"
    }
    ~~~

3. Modificar el nombre de la forma farmacéutica con id igual a 3

    - endpoint: .../formas-farmaceuticas/3/nombre?nombre=gel

4. Modificar el primer nombre del paciente de DNI igual a 10928417

    - endpoint: .../pacientes/primer-nombre?id-o-dni=10928417&opcion=dni&nombre=emiliano

5. Agregar un teléfono al paciente de id igual a 401

    - endpoint: .../pacientes/agregar-telefono?id-o-dni=401&opcion=id&telefono-para-aggregar=011-847-3820

6. Modificar todos los campos del estudio médico de id igual a 29

    - endpoint: .../estudios-medicos

    - body: 

    ~~~json
    {
        "id":29,
        "nombre":"perfil lipídico",
        "clasificacion":{
            "id":2
        }
    }
    ~~~

7. Borrar el rol de emplaedo de id 5 de la base de datos

    - endpoint: .../roles-empleado/5

8. Modificar la fecha de final de el diagnóstico realizado en un paciente de id igual a 44 (el id no es del paciente, sinom de un diagnóstico realizado en un paciente como se vió en las entidades en una sección anterior)

    - endpoint: .../diagnosticos-pacientes/44/fecha-final?fin=2024-05-23