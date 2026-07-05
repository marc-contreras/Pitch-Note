# PITCH NOTE -- Documentación Técnica

## Proyecto Final de DAM

**PITCH NOTE** es una aplicación Android desarrollada en **Kotlin** cuyo
objetivo es entrenar el reconocimiento auditivo de notas musicales
(*Pitch Note*), ayudando al usuario a mejorar el oído relativo y
sentando las bases para el desarrollo del oído absoluto.

------------------------------------------------------------------------

# Estructura del proyecto

``` text
app/
├── src/main/java/com/example/PITCH NOTE/
│   ├── AuthActivity.kt
│   ├── HomeActivity.kt
│   ├── PitchNoteActivity.kt
│   ├── RegistrarUsuario.kt
│   └── Usuario.kt
│
├── src/main/res/
│   ├── layout/
│   ├── raw/
│   ├── drawable/
│   └── values/
│
└── AndroidManifest.xml
```

------------------------------------------------------------------------

# Arquitectura

``` text
                +------------------+
                | AuthActivity     |
                +------------------+
                         |
          Login correcto |
                         ▼
                +------------------+
                | HomeActivity     |
                +------------------+
                    |          |
      Cerrar sesión |          | Ejercicio
                    ▼          ▼
            AuthActivity   PitchNoteActivity
                               |
                      Reproduce nota
                               |
                      Usuario responde
                               |
                     Comprueba resultado
```

------------------------------------------------------------------------

# AuthActivity

## Responsabilidad

Es la pantalla inicial de la aplicación y gestiona:

-   Inicio de sesión.
-   Autenticación mediante Firebase Authentication.
-   Acceso al registro de usuarios.
-   Navegación al menú principal.

### Métodos principales

  Método                         Descripción
  ------------------------------ -----------------------------------
  `onCreate()`                   Inicializa la actividad.
  `setup()`                      Configura botones y eventos.
  `showAlert()`                  Muestra errores de autenticación.
  `showHome()`                   Abre `HomeActivity`.
  `showUserRegisterActivity()`   Abre la pantalla de registro.

------------------------------------------------------------------------

# RegistrarUsuario

Permite crear nuevas cuentas utilizando:

-   Firebase Authentication.
-   Firebase Realtime Database.

## Flujo

``` text
Usuario
   │
Introduce datos
   │
   ▼
Firebase Authentication
   │
Usuario creado
   │
   ▼
Realtime Database
   │
Guarda:
- Nombre
- Teléfono
- UID
```

### Modelo de datos

``` kotlin
data class Usuario(
    var nombre: String?,
    var movil: Int?,
    val userId: String?
)
```

------------------------------------------------------------------------

# HomeActivity

Actúa como menú principal de la aplicación.

Permite:

-   Mostrar el usuario autenticado.
-   Acceder al entrenamiento Pitch Note.
-   Cerrar sesión.

------------------------------------------------------------------------

# PitchNoteActivity

Es la actividad principal del proyecto.

## Objetivo

Entrenar el reconocimiento auditivo de las doce notas de la escala
cromática.

### Recursos

Los audios se almacenan en:

``` text
res/raw/
```

Contienen las siguientes notas:

``` text
A  A#  B
C  C#  D
D# E  F
F# G  G#
```

### Funcionamiento

1.  Se genera una nota aleatoria.
2.  El usuario pulsa **Escuchar**.
3.  La aplicación reproduce el sonido mediante `SoundPool`.
4.  El usuario selecciona una nota.
5.  La aplicación compara ambas respuestas y muestra si es correcta.

### SoundPool

Se utiliza por su baja latencia y rapidez para reproducir sonidos
cortos.

Ejemplo:

``` kotlin
soundPool.load(baseContext, R.raw.a, 1)
```

------------------------------------------------------------------------

# Firebase

## Authentication

-   Registro.
-   Inicio de sesión.
-   Cierre de sesión.

## Realtime Database

Información almacenada:

``` text
Usuarios
├── nombre
├── teléfono
└── uid
```

------------------------------------------------------------------------

# Recursos

  Carpeta      Contenido
  ------------ ------------------------------------
  `layout`     Interfaces XML.
  `raw`        Audios de las notas musicales.
  `drawable`   Imágenes e iconos.
  `values`     Colores, temas y cadenas de texto.

------------------------------------------------------------------------

# Objetivo pedagógico

La aplicación busca mejorar la percepción auditiva mediante ejercicios
repetitivos de identificación de notas musicales. El usuario escucha una
nota generada aleatoriamente y debe reconocerla correctamente entre las
doce notas de la escala cromática. La práctica continuada favorece el
desarrollo del oído relativo y constituye una base sólida para entrenar
el oído absoluto.

------------------------------------------------------------------------

# Mejoras futuras

-   Migrar la arquitectura al patrón **MVVM**.
-   Separar la lógica de negocio de las Activities.
-   Añadir estadísticas y seguimiento del progreso.
-   Incorporar niveles de dificultad.
-   Internacionalizar completamente la aplicación.
-   Añadir nuevos modos de entrenamiento musical.

------------------------------------------------------------------------

# Tecnologías utilizadas

-   Kotlin
-   Android Studio
-   Firebase Authentication
-   Firebase Realtime Database
-   SoundPool
-   XML
-   Gradle

------------------------------------------------------------------------

## Autor

Proyecto desarrollado como **Trabajo Final del Ciclo Formativo de
Desarrollo de Aplicaciones Multiplataforma (DAM)**.
