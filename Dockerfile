FROM openjdk:8-jdk-alpine
MAINTAINER nithinprasad.com
COPY target/wedding.javed-0.0.1-SNAPSHOT.jar wedding.javed-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/wedding.javed-0.0.1-SNAPSHOT.jar"]
