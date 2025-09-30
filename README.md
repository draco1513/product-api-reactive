# 📦 Product API Reactive

[![Java](https://img.shields.io/badge/Language-Java-007396?style=for-the-badge&logo=java)](https://www.java.com/)
[![Spring](https://img.shields.io/badge/Framework-Spring%20WebFlux-6DB33F?style=for-the-badge&logo=spring)](https://spring.io/projects/spring-framework)
[![Maven](https://img.shields.io/badge/Build-Maven-C71A36?style=for-the-badge&logo=apache-maven)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)](LICENSE)

---

## 📝 Descripción del Proyecto

Esta es una **API RESTful de gestión de productos** desarrollada con un enfoque **reactivo**.

El objetivo principal es proporcionar un *backend* de alta concurrencia y baja latencia para operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre la entidad `Producto`. Al estar construido sobre principios reactivos, es ideal para entornos que manejan un gran número de conexiones simultáneas.

## ✨ Características Principales

* **Programación Reactiva:** Utiliza el paradigma reactivo para manejar peticiones de forma no bloqueante.
* **API RESTful:** Endpoints bien definidos para la manipulación de productos.
* **Desarrollo en Java:** Construido con la robustez y escalabilidad del ecosistema Java.
* **Fácil de escalar:** Diseñado para aprovechar al máximo los recursos del sistema.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 17+
* **Framework:** Spring Boot 3
* **API Reactiva:** Spring WebFlux
* **Base de Datos:** (Ej: MongoDB Reactive / PostgreSQL con R2DBC)
* **Herramienta de Construcción:** Apache Maven

---

## 🚀 Primeros Pasos

Estas instrucciones te ayudarán a obtener una copia del proyecto funcionando en tu máquina local para propósitos de desarrollo y prueba.

### Prerrequisitos

Necesitas tener instalado lo siguiente:

* **Java Development Kit (JDK):** Versión 17 o superior.
* **Apache Maven:** Versión 3.6 o superior.
* **Base de Datos:** Una instancia de la base de datos configurada (Ej: un servidor de MongoDB).

### Instalación y Ejecución

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/draco1513/product-api-reactive.git](https://github.com/draco1513/product-api-reactive.git)
    cd product-api-reactive
    ```

2.  **Configuración de la Base de Datos:**
    Asegúrate de configurar los parámetros de conexión a la base de datos en el archivo `src/main/resources/application.properties` (o `application.yml`).

3.  **Compilar el proyecto:**
    ```bash
    ./mvnw clean package
    ```

4.  **Ejecutar la aplicación:**
    ```bash
    java -jar target/product-api-reactive-0.0.1-SNAPSHOT.jar
    # O usar el comando de Spring Boot si estás en desarrollo:
    # ./mvnw spring-boot:run
    ```

La API estará corriendo en `http://localhost:8080` (a menos que se especifique lo contrario en la configuración).

---

## 💡 Endpoints de la API (Ejemplo)

La API expone los siguientes endpoints para la gestión de productos:

| Método | URL | Descripción |
| :--- | :--- | :--- |
| `GET` | `/api/v1/products` | Obtiene la lista de todos los productos (stream reactivo). |
| `GET` | `/api/v1/products/{id}` | Obtiene los detalles de un producto específico. |
| `POST` | `/api/v1/products` | Crea un nuevo producto. |
| `PUT` | `/api/v1/products/{id}` | Actualiza un producto existente. |
| `DELETE` | `/api/v1/products/{id}` | Elimina un producto. |

---

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar el proyecto, sigue estos pasos:

1.  Haz un *fork* del repositorio.
2.  Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3.  Realiza tus cambios y haz *commit* (`git commit -am 'feat: Añadir nueva funcionalidad X'`).
4.  Sube tus cambios a tu *fork* (`git push origin feature/nueva-funcionalidad`).
5.  Abre un *Pull Request*.

---

## 🔑 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

---

## 👤 Contacto

* **Autor:** [draco1513](https://github.com/draco1513)
* **Enlace al Proyecto:** [https://github.com/draco1513/product-api-reactive](https://github.com/draco1513/product-api-reactive)****
