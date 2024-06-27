# technical-test-NTT-DATA

## Medidas para prevenir ataques de inyección SQL

4. Utilizar cifrado SSL/TLS para proteger contra ataques SQL.

## Diferencia entre autenticación y autorización en el contexto de una aplicación web

2. La autenticación se refiere al proceso de verificar la identidad del usuario, mientras que la autorización determina qué acciones tiene permitido realizar un usuario autenticado.

## Preguntas abiertas

1. **Describe cómo diseñarías una arquitectura escalable para una aplicación web que espera un aumento significativo en el tráfico.**
   - Respuesta Abierta:
   Tenderia a usar una arquitectura de microservicios que posea un bufer o cola de eventos para interconectar el trafico de data en caso de que importe el orden y sean datos de volumen considerable, por otro lado para datos mas sencillos aplicaria una comunicacion entre servicios via gRPC o REST dependiendo claro de los TPS objetivo que se quiera alcanzar

2. **Háblame sobre un desafío técnico que hayas enfrentado en un proyecto anterior y cómo lo resolviste.**
   - Respuesta Abierta:
   Al desarrollar un servicio que funciona como middleware entre dos microservicios bastante robusto de principio fue todo ok, hasta que empezaron a saltar problemas con el performance y se evidenciaban altas latencias en la entrega de datos para ello, me pues en la busqueda de una comunicacion mucho mas rapida que la que se tenia como lineamiento hasta toparme con gRPC, la cual solvento varios de los problemas presentados.

3. **¿Puedes mencionar y explicar brevemente tres patrones de diseño que hayas utilizado en proyectos anteriores?**
   - Respuesta Abierta:
   Comunmente y los que mas frecuento usar:

   Strategy: Se basa en dividir un comportamiento que define un procesamiento dependiendo de alguna condicion y se comparte entre servicios.
   Factory: Se trata de dividir la creacion de objetos o entidades que comparten atributos similares
   Comando: Se enfoca en separar por aciones un comportamiento definido sobre un objeto o entidad

## Caso de uso

La aplicación de validación de horas trabajadas en la compañía NTTDATA presenta una falla recurrente:

La aplicación presenta caídas constantes, el equipo de soporte realiza la revisión de los tiempos de respuesta de los servicios BFF y observa un tiempo de respuesta de 16 a 20 segundos. Al revisar los logs evidencian un timeout presentado por los servicios login y consultar horas, igualmente los servicios llevan corriendo más de 60 días constantes. Dato adicional: los servidores contienen un administrador de servicios Kubernetes y cada servicio maneja tres imágenes desplegadas.

1. ¿Qué práctica implementaría para solucionar el problema?
   - Respuesta Abierta:
   Tengo muy poca experiencia con relacion a k8s y mejoras de rendimiento, pero de igual manera suponiendo que se esta en un ambiente produccion, mientras se revisa un bugFix hacia dev, aumentaria los recursos fisicos del cluster y aumentria el numero de copias maximas de los servicios por POD.

2. ¿Qué Script de Kubernetes utilizaría, basado en el nombre de los servicios?
   - Respuesta Abierta:
   N/A
