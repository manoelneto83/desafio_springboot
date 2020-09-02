FROM openjdk:11
MAINTAINER manoelneto83
WORKDIR opt/app

ARG JAR_FILE=target/desafio-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod","-jar", "app.jar"]