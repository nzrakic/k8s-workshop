FROM openjdk:13.0.2-jdk-slim

MAINTAINER Nikola Rakić <rakic.nikola@nsoft.com>

EXPOSE 8080

ARG BUILD_VERSION=dev-master
ARG BUILD_PATH=build/libs/rest
ADD ${BUILD_PATH}-${BUILD_VERSION}.jar service.jar

ENV SERVICE_JAR service.jar

ADD "run.sh" "/run.sh"

ENTRYPOINT ["/run.sh"]