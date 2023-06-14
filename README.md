# Api_Rest_Arquitect
I use Java for this proyect with the IDE "Intellig IDEA"


# Reglas para mi API REST
## Interfaz uniforme
 1) La interfaz de basa en recursos (por ejemplo el recurso Empleado (Id, Nombre, Apellido, Puesto, Sueldo)
 2) El servidor mandará los datos (vía html, json, xml...) pero lo que tenga en su interior (BBDD por ejemplo) para el cliente es transparente
 3) La representación del recurso que le llega al cliente, será suficiente para poder cambiar/borrar el recurso:
    * Suponiendo que tenga permisos
    * Por eso en el recurso solicitado se suele enviar un parámetro Id

Mensajes descriptivos:
1) Usar las características del protocolo http para mejorar la semántica:
    * HTTP Verbs
    * HTTP Status Codes
    * HTTP Authentication
2) Procurar una API sencilla y jerárquica y con ciertas reglas: uso de nombres en plural

## Peticiones sin estado

* http es un protocolo sin estado ---> mayor rendimiento

        GET mi_url/empleados/1234

        DELETE mi_url/empleados/1234

En la segunda petición hemos tenido que incidar el identificador del recurso que queremos borrar

El servidor no guardaba los datos de la consulta previa que tenía el cliente en partícular.

Una petición del tipo DELETE mi_url/empleado debe dar error, ¡falta el id y el servidor no lo conoce!


## Cacheable

* En la web los clientes pueden cachear las respuestas del servidor
* Las respuestas se deben marcar de forma implícita o explícita como cacheables o no.
* En futuras peticiones, el cliente sabrá si puede reutilizar o no los datos que ya ha obtenido.
* Si ahorramos peticiones, mejoraremos la escabilidad de la aplicación y el rendimiento en cliente (evitamos principalmente la latencia).

## Separación de cliente y servidor
* El cliente y servidor están separados, su unión es mediante la interfaz uniforme
* Los desarrollos en frontend y backend se hacen por separado, teniendo en cuenta la API.
* Mientras la interfaz no cambie, podremos cambiar el cliente o el servidor sin problemas.
## Sistema de Capas
* El cliente puede estar conectado mediante la interfaz al servidor o a un intermediario, para el es irrelevante y desconocido.
* Al cliente solo le preocupa que la API REST funcione como debe: no importa el COMO sino el QUE
* El uso de capas o servidores intermedios puede servir para aumentar la escalabilidad (sistemas de balanceo de carga, cachés) o para implementar políticas de seguridad
* Código bajo demanda (opcional)