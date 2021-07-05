
FROM maven:3.6.3-jdk-11-slim AS builder

COPY src /home/app/src

ADD pom.xml /home/app

RUN mvn -ntp -f /home/app/pom.xml clean package -DskipTests

FROM adoptopenjdk/openjdk11

RUN mkdir /app

COPY --from=builder /home/app/target/*.jar /app/app.jar

EXPOSE 8080

EXPOSE 8089

ENV JAVA_OPTS=""

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=prod -jar /app/app.jar


#FROM openjdk:11.0.6-slim
#ARG JAR_FILE=target/test-project-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/app.jar"]



#FROM openjdk:16-jdk-alpine
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




#FROM store/oracle/jdk:11
#RUN apk update && apk add --no-cache libc6-compat
#RUN apk update && \
#  apk add --no-cache libc6-compat && \
#  ln -s /lib/libc.musl-x86_64.so.1 /lib/ld-linux-x86-64.so.2
#VOLUME /tmp
#ADD target/test-project-0.0.1-SNAPSHOT.jar app.jar
#ENV JAVA_OPTS=""
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=prod -jar /app.jar
#
#HEALTHCHECK --interval=5s \
#            --timeout=5s \
#            CMD curl -f http://127.0.0.1:8082 || exit 1
#EXPOSE 8080