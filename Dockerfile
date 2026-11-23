# Me acabo de dar cuenta que esto es bastante innecesario para lo que sirve, pero bueno. Practicar es practicar, ¿no?
# Por referencia: Esto siempre va a correr sobre Linux como Sistema Operativo

FROM maven:4.0.0-rc-4-amazoncorretto-25 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

# Ahora para ejecutarlo

FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar GestorTareasSistema.jar

ENTRYPOINT ["java", "-jar", "GestorTareasSistema.jar"]