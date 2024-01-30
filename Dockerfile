# Stage 1: Build the application
FROM maven:3.9.6-amazoncorretto-21 as builder

# Copia os arquivos do projeto para a imagem
COPY src /usr/src/myapp/src
COPY pom.xml /usr/src/myapp

# Compila e constrói o pacote
WORKDIR /usr/src/myapp
RUN mvn clean package -DskipTests

# Stage 2: Create the Docker image for runtime
FROM amazoncorretto:21

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo JAR gerado na etapa de build
COPY --from=builder /usr/src/myapp/target/*.jar app.jar

# Expõe a porta utilizada pela aplicação
EXPOSE 8080

# Define o comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]