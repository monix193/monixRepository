FROM openjdk:8-alpine

RUN apk update && add /bin/bash
RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app
COPY jobber-0.0.1-SNAPSHOT.jar ${PROJECT_HOME}
WORKDIR ${PROJECT_HOME}
EXPOSE 8090
CMD [ "java", "-jar", "jobber-0.0.1-SNAPSHOT.jar"  ]