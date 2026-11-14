# Sistema de Inventario - Backend Spring Boot con Nube Local (Floci)

Backend desarrollado en Java 21 y Spring Boot conectado a un entorno de nube local mediante **Floci** y **Docker**, utilizando variables de entorno para la gestión segura de credenciales.

## Análisis de Servicios de Floci Aplicables al Proyecto

Tras revisar la documentación de Floci (`https://floci.io/`), los servicios emulados en el puerto `:4566` que mejor se acoplan a la arquitectura del sistema de inventario son:

1. **RDS (Relational Database Service):** Emulación de instancias relacionales para alojar las tablas de productos y clientes gestionadas por Spring Data JPA.
2. **S3 (Simple Storage Service):** Almacenamiento de objetos en buckets locales para guardar imágenes de productos, facturas de compra y reportes exportados del inventario.
3. **Secrets Manager / Parameter Store:** Gestión centralizada de credenciales (`DB_PASSWORD`, llaves de acceso) para evitar exponer datos sensibles en el código fuente.
4. **SQS (Simple Queue Service):** Cola de mensajes para procesar de forma asíncrona alertas cuando el stock de un producto llegue al mínimo permitido.

## Requisitos Previos

* Java JDK 21
* Maven
* Docker Desktop (en ejecución)
* Floci CLI (`https://floci.io/`)
* IntelliJ IDEA y Thunder Client

## Instrucciones de Ejecución

### 1. Clonar el repositorio
```bash
git clone [https://github.com/Yerson0306/inventario-floci-springboot.git](https://github.com/Yerson0306/inventario-floci-springboot.git)
cd inventario-floci-springboot