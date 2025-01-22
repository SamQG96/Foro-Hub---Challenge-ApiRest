# ForoHub API

**ForoHub** es una aplicación de API REST diseñada para gestionar tópicos de discusión en un foro. Los usuarios pueden crear, listar, actualizar y eliminar tópicos relacionados con cursos específicos. Esta API está construida utilizando **Spring Boot**, **JPA**, y **MySQL**, proporcionando un entorno flexible y escalable para la gestión de contenido en línea.

---

## Tabla de Contenidos

- [Tecnologías](#tecnologías)
- [Configuración del Entorno](#configuración-del-entorno)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Cómo Usar la API](#cómo-usar-la-api)
  - [Registrar un Tópico](#registrar-un-tópico)
  - [Listar Tópicos](#listar-tópicos)
  - [Actualizar un Tópico](#actualizar-un-tópico)
  - [Eliminar un Tópico](#eliminar-un-tópico)
- [Dependencias](#dependencias)
- [Contribuciones](#contribuciones)

---

## Tecnologías

Este proyecto se basa en las siguientes tecnologías:

- **Spring Boot** (versión 3 en adelante)
- **Java** (JDK 17 en adelante)
- **MySQL** (versión 8 en adelante)
- **JPA** (Java Persistence API)
- **Maven** (para la gestión de dependencias)
- **Spring Security** (para asegurar los endpoints)
- **Flyway** (para la migración de la base de datos)
- **Spring Boot DevTools** (para mejorar el desarrollo)

---

## Configuración del Entorno

### Paso 1: Descargar Dependencias

Asegúrate de tener las siguientes dependencias configuradas en tu proyecto. Estas son necesarias para el funcionamiento adecuado del proyecto.

**Archivo `pom.xml`**:

```xml
<dependencies>
    <!-- Dependencias de Spring Boot -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    
    <!-- Dependencia de MySQL -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>

    <!-- Flyway para migraciones de base de datos -->
    <
