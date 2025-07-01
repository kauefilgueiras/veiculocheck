FROM eclipse-temurin:21
LABEL maintainer="kauefilgueiras.dev@gmail.com"
WORKDIR /app
COPY target/veiculocheck-0.0.1-SNAPSHOT.jar /app/veiculocheck.jar
ENTRYPOINT ["java", "-jar", "veiculocheck.jar"]
EXPOSE 8080