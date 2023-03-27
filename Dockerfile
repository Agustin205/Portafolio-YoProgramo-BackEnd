FROM amazoncorretto:11-alpine-jdk
MAINTAINER Agustin
COPY target/Agustin-0.0.1-SNAPSHOT.jar Agus-app.jar
ENTRYPOINT ["java","-jar","/Agus-app.jar"]
