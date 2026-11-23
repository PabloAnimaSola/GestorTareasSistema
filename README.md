# Gestor de Tareas del Sistema

Esto es un pequeño proyecto personal que se me ocurrió en una tarde porque me interesa el concepto de multiplataforma.

He hecho un Dockerfile/Docker compose para que se pueda probar con una distribución de Linux si usas Windows o Mac OS

### Para Ejecutarlo corre en tu terminal:

```
docker build . -t gestor-tareas-sistema:v1.0
```
### Seguido de

```
docker run -it gestor-tareas-sistema:v1.0
```

### O si usas docker compose:

```
docker compose run --build --rm gestor-tareas
```

### Estructura de ``compose.yaml``
```yaml
services:
  gestor-tareas:
    image: gestor-tareas-sistema
    build:
      context: .
      dockerfile: Dockerfile
    stdin_open: true
    tty: true
```
Por ahora no es necesario especificar ninguna variable de entorno.
