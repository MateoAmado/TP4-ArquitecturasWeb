# Trabajo Practico Nro 3

## Consultas


### Estudiantes
- Para hacer un insert en Estudiantes en la BD H2, debemos hacelo via la siguiente url: http://localhost:8090/estudiantes en Postman
- Para conectar con la BD de MySQL se debe usar la siguiente url: http://localhost:8080/estudiantes en Postman, dejo un template de ejemplo


{
  "numeroDocumento": 123456789,
  "nombre": "Juan",
  "apellido": "Pérez",
  "edad": 22,
  "genero": "Masculino",
  "ciudadResidencia": "Buenos Aires",
  "numeroLibretaUniversitaria": 987654
  }


### Carreras
- Para hacer un insert en Carreras en la BD H2, debemos hacelo via la siguiente url: http://localhost:8090/carreras en Postman
- Para conectar con la BD de MySQL se debe usar la siguiente url:  http://localhost:8080/carreras en Postman, dejo un template de ejemplo


{
  "nombre" : "TUDAI"
  }

### Estudiante_Carrera
- Para hacer un insert en Estudiante_Carrera en la BD H2, debemos hacelo via la siguiente url: http://localhost:8090/estudiante_carrera en Postman
- Para conectar con la BD de MySQL se debe usar la siguiente url:  http://localhost:8080/estudiante_carrera en Postman, dejo un template de ejemplo

{
    "id": {
        "estudianteNumeroDocumento": 365222336,
        "idCarrera": 5
    },
    "estudiante": 
        {
 "numeroDocumento": 365222336
    },
    "carrera": 
        {
   "idCarrera": 5
        }
    ,
    "fechaInscripcion": "2024-10-11",
    "graduado": true
}
