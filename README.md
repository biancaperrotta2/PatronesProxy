# 🧪 Proyecto Spring Boot - Patrón Proxy

Este proyecto es una demostración práctica del uso de **programación asíncrona** en **Spring Boot** utilizando las anotaciones `@Async` y `@EnableAsync`, junto con conceptos de **Proxy**. El objetivo es entender cómo funcionan los proxies en Spring para poder interceptar y ejecutar métodos de forma asíncrona sin bloquear el hilo principal.

## 🧠 ¿Qué es un Proxy en Spring?

En Spring, un **proxy** es una clase que actúa como intermediario entre el cliente y el objeto real. Sirve para añadir comportamiento adicional (como logging, transacciones, seguridad o asincronía) sin modificar el código original. 

Cuando usás `@Async`, Spring crea un **proxy del bean** para interceptar las llamadas a métodos anotados y ejecutarlas en un **hilo separado**, delegando la tarea a un **Executor**.

> ⚠️ Importante: el método `@Async` debe ser llamado desde **otro bean** para que el proxy funcione correctamente. Si lo llamás desde la misma clase, no pasará por el proxy y no se ejecutará de forma asíncrona.

## 🚀 Tecnologías Utilizadas

- ✅ **Java 17**
- ✅ **Spring Boot 3.5.4**
- ✅ **Maven/Gradle** (según cómo lo hayas configurado)
- ✅ **Apache Tomcat embebido**
- ✅ **Librerías de Spring Web, Context y Core**
- ✅ **IntelliJ IDEA** (entorno de desarrollo)

## 📂 Estructura del Proyecto
```bash
src/
└── main/
    ├── java/com/aluracursos/asynctest/
    │   ├── PruebaProxyApplication.java       # Clase principal con @SpringBootApplication y @EnableAsync
    │   ├── servicio/                         
    │   │   └── MiServicio.java               # Contiene el método @Async
    │   └── principal/                        
    │       └── MiCliente.java                # Llama al método async desde otro bean
    └── resources/
        └── application.properties            # Configuración (puerto, logging, etc.)
```

## ⚙️ Cómo Ejecutarlo

### Usando IntelliJ IDEA o cualquier IDE:

1. Cloná este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/async-proxy-springboot.git
   cd async-proxy-springboot
### 🧪 Cómo ejecutar el proyecto

1. Abrí el proyecto en **IntelliJ IDEA**.
2. Asegurate de tener **Java 17** instalado y configurado en el IDE.
3. Ejecutá la clase `PruebaProxyApplication`.
4. Verificá la consola: deberías ver logs que indican que el método `@Async` se ejecuta en un hilo separado (por ejemplo `task-1`), distinto del hilo principal `main`.

---

### ▶️ También podés ejecutarlo desde la terminal

#### Con Gradle:
```bash
./gradlew bootRun
```
#### Con Maven:
```bash
./mvnw spring-boot:run
```
