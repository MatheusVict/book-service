FROM openjdk:17-jdk-slim
ARG JAR_FILE=book-service/target/*.jar
COPY ${JAR_FILE} app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]