FROM openjdk:13.0.2-jdk-slim

MAINTAINER Nikola Rakić <rakic.nikola@nsoft.com>

EXPOSE 8080

ADD build/libs/rest-dev-master.jar service.jar

ENTRYPOINT ["java", "-jar", "service.jar"]