FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/EnviarMail-0.0.1.jar
COPY ${JAR_FILE} EnviarMailDocker.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","EnviarMailDocker.jar"]
