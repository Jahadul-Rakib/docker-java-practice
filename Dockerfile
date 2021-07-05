FROM openjdk:16-jdk-alpine
ARG JAR_FILE=target/test-project-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

#WORKDIR application
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} application.jar
#RUN java -Djarmode=layertools -jar application.jar extract
#
#FROM openjdk:16-jdk-alpine
#WORKDIR application
#COPY --from=builder application/dependencies/ ./
#COPY --from=builder application/snapshot-dependencies/ ./
#COPY --from=builder application/resources/ ./
#COPY --from=builder application/application/ ./
#ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]