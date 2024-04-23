FROM eclipse-temurin:17-alpine

RUN mkdir /app

WORKDIR /app

COPY target/clase_41-v1.0.0.jar /app/clase_41-v1.0.0.jar

EXPOSE 8080

CMD ["java", "-jar", "clase_41-v1.0.0.jar"]