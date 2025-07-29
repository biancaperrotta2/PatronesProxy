# 🧪 Proyecto Spring Boot - Patrón Proxy

Este proyecto es una demostración práctica del uso de **programación asíncrona** en **Spring Boot** utilizando las anotaciones `@Async` y `@EnableAsync`, junto con conceptos de **Proxy**. El objetivo es entender cómo funcionan los proxies en Spring para poder interceptar y ejecutar métodos de forma asíncrona sin bloquear el hilo principal.

## 🧠 ¿Qué es un Proxy en Spring?

En Spring, un **proxy** es una clase que actúa como intermediario entre el cliente y el objeto real. Sirve para añadir comportamiento adicional (como logging, transacciones, seguridad o asincronía) sin modificar el código original. 

Cuando usás `@Async`, Spring crea un **proxy del bean** para interceptar las llamadas a métodos anotados y ejecutarlas en un **hilo separado**, delegando la tarea a un **Executor**.

> ⚠️ Importante: el método `@Async` debe ser llamado desde **otro bean** para que el proxy funcione correctamente. Si lo llamás desde la misma clase, no pasará por el proxy y no se ejecutará de forma asíncrona.

## Descripción del Proyecto

Este proyecto es una demostración simple del uso de **métodos asincrónicos con Spring Boot** usando la anotación `@Async`. Su objetivo es mostrar cómo ejecutar tareas en segundo plano sin bloquear el hilo principal de la aplicación.

El comportamiento se basa en el uso de proxies dinámicos de Spring, por lo cual es necesario que el método asincrónico sea invocado desde otro bean (es decir, desde otra clase gestionada por el contenedor de Spring).

---

## ¿Qué hace este proyecto?

- Inicia una aplicación Spring Boot.
- Invoca un método marcado con `@Async` desde otro bean.
- El método se ejecuta en un **hilo diferente** (por ejemplo, `task-1`), permitiendo que el flujo principal (`main`) continúe sin esperar a que termine la tarea.
- Imprime en consola los nombres de los hilos para evidenciar que son distintos.

---

## Explicación de las clases

### `PruebaProxyApplication.java`

- **Rol:** Clase principal del proyecto. Contiene la anotación `@SpringBootApplication`, que habilita la configuración automática.
- También activa `@EnableAsync` (para permitir el uso de métodos asincrónicos) y `@EnableScheduling` (opcional en este ejemplo).

---

### `RunAsyncService.java`

- **Rol:** Servicio con un método marcado con `@Async`.
- Este método simula una tarea lenta (por ejemplo, con un `Thread.sleep`) y se ejecuta en un hilo diferente.

---

### `PruebaAsync.java`

- **Rol:** Cliente que llama al método `@Async` desde otro bean.
- Es clave para que funcione el proxy de Spring, ya que **si llamás a un método asincrónico desde la misma clase, no se ejecutará de forma asincrónica**.
- Este bean se inyecta y se ejecuta desde el `CommandLineRunner` de Spring o similar.

---

## ¿Por qué es importante el proxy?

Spring implementa `@Async` usando **proxies dinámicos**. Esto significa que:
- El método asincrónico no se ejecutará de forma paralela si es llamado desde la misma clase que lo define.
- Por eso es fundamental separarlo en otra clase y llamarlo desde otro bean para que Spring pueda interceptar la llamada y delegarla a otro hilo.

## 🚀 Tecnologías Utilizadas

- ✅ **Java 17**
- ✅ **Spring Boot 3.5.4**
- ✅ **Maven/Gradle** (según cómo lo hayas configurado)
- ✅ **Apache Tomcat embebido**
- ✅ **Librerías de Spring Web, Context y Core**
- ✅ **IntelliJ IDEA** (entorno de desarrollo)

## 📂 Estructura del Proyecto
```bash
AsyncTest/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── asynctest/
│ │ │ ├── PruebaAsync.java # Cliente que llama al servicio @Async
│ │ │ ├── PruebaProxyApplication.java # Clase principal con @SpringBootApplication y @EnableAsync
│ │ │ └── RunAsyncService.java # Servicio con método @Async
│ │ └── resources/
│ └── test/
├── build/
├── .idea/
└── .gradle/
```

## ⚙️ Cómo Ejecutarlo

### Usando IntelliJ IDEA o cualquier IDE:

1. Cloná este repositorio:
   ```bash
   git clone https://github.com/biancaperrotta2/PatronesProxy.git
   cd PatronesProxy
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
---
## Desarrollado por
**Bianca Perrotta**  
Universidad Tecnológica Nacional (UTN)  
Facultad Regional Mendoza  
Carrera: Tecnicatura Universitaria en Programación
