# recargas
Examen recargas para Bimbo 

# Base de Datos
Se genero una base de datos con las siguientes tablas

bitacora
historico_pagos
plan
tipo_plan

La cual se tiene esta estructura en el archivo recargas.sql se debe ejecutar el archivo .sql dentro de un manejador de base de datos y tiene que ser previamente ejecutado el script y de preferencia debe estar corriendo la base de datos 3306.

# Desarrollo

Para poder obtener el codigo es descargar por medio de gitbash colocarse en la ruta donde se quieres descargar el codigo y se es por comando seria colocar la siguiente url en la terminal del mismo.


Y ejecuar el siguiente comando 

 - git pull

Posteriormente hacer un importe desde algun ide de desarrollo.

Una vez importado puedes ejecutar la clase RecargasApplication.java con un run

O si quieres por medio de linea de comando o CMD

Es entrar a la ruta del proyecto desde el CMD y ejecutar el comenado 

- mvn clean install o mvn clean package

Posteriormente puedes ejecutar el siguiente comando 

- mvnw spring-boot:run

De igual forma puedes entrar desde el cmd hasta la carpete targer y colocar el siguiente comando

- java -jar recargas-0.0.1-SNAPSHOT.jar

# Collection

Se agrega la colleccion de postman con los metodos de los servicios.

Este se debe importar en la aplicación de Postman

# NOTA
Los archivos se encuentran dentro del desarrollo en la carpeta template
- recargas\src\main\resources\templates\recargas.sql
- recargas\src\main\resources\templates\Examen.postman_collection.json

