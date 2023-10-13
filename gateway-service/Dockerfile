FROM openjdk:17.0.1-jdk-slim

ENV HOST_POSTGRES=127.0.0.1
ENV PORT_POSTGRES=5432
ENV DB_POSTGRES=asset
ENV USERNAME_POSTGRES=postgres
ENV PASSWORD_POSTGRES=postgres

WORKDIR /app

COPY target/gateway-service.jar /app/gateway-service.jar

CMD ["java", "-jar", "gateway-service.jar"]