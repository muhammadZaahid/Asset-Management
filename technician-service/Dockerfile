FROM openjdk:17.0.1-jdk-slim

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/asset
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=postgres

WORKDIR /app

EXPOSE 8082

COPY target/technician-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "technician-0.0.1-SNAPSHOT.jar"]