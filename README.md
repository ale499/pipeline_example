# 🧩 Validación de Pedidos con Pipeline Pattern – Spring Boot + MySQL

Este proyecto implementa el patrón de diseño **Pipeline** para validar entidades `Order` en una API REST construida con **Spring Boot**. Utiliza MySQL como base de datos persistente y sigue buenas prácticas de organización de código.

---

## 📦 Estructura del Proyecto
```
com.example.pipelineexample
│
├── controller
│   └── OrderController.java
│
├── model
│   └── Order.java
│
├── pipeline
│   ├── Pipeline.java
│   ├── PipelineStage.java
│   ├── ValidateClienteStage.java
│   ├── ValidateTotalStage.java
│   └── ValidateProductosStage.java
│
└── PipelineExampleApplication.java
```
---

## 🛠️ Tecnologías Utilizadas

- Java 17+
- Spring Boot 3.5.x
- Spring Web
- Spring Data JPA
- MySQL
- Lombok
- Maven

---

## 🔍 Descripción del Pipeline

El paquete `pipeline` contiene una implementación del patrón Pipeline donde cada etapa valida un aspecto específico del pedido:

### Etapas de Validación:
- `ValidateClienteStage`: Verifica que el nombre del cliente no sea nulo o vacío
- `ValidateTotalStage`: Asegura que el total del pedido sea mayor a cero
- `ValidateProductosStage`: Valida que se haya incluido al menos un producto

Todas las etapas implementan la interfaz `PipelineStage` y se ejecutan secuencialmente en el `Pipeline`.

---

## 🧪 Endpoints API REST

### ✅ Validar un Pedido (Sin persistencia)
**POST** `/orders/validate`
```json
{
  "cliente": "Alejandro",
  "total": 1200.0,
  "productos": ["Pizza", "Empanadas"]
}
```

Si todas las validaciones son correctas, responde con:
"Pedido válido"

Si alguna validación falla, responde con:
"Error: <mensaje de validación>"

⚙️ Configuración de Base de Datos
```json
application.properties (configurado para MySQL):
spring.datasource.url=jdbc:mysql://localhost:3306/pipeline_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
▶️ Cómo Ejecutar el Proyecto

1. Cloná el repositorio:
git clone <url-del-repo>
cd pipeline-example

2. Configurá las credenciales de tu base de datos en application.properties.

3.Ejecutá la aplicación desde tu IDE o con Maven:
./mvnw spring-boot:run

4. Enviá peticiones a:
http://localhost:8080/orders/validate


🧪 Cómo Probar
Podés usar herramientas como:

.Postman / Insomnia

.curl en terminal:

curl -X POST http://localhost:8080/orders/validate \
  -H "Content-Type: application/json" \
  -d '{"cliente":"Ana","total":0,"productos":["Pizza"]}'



✅ Posibles mejoras

.Agregar persistencia de pedidos válidos en la base de datos.

.Desacoplar las etapas con anotaciones y beans configurables.

.Agregar Swagger para documentar la API.

.Agregar pruebas unitarias con JUnit y Mockito.
















