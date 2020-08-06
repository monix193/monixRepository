FROM openjdk:8

RUN apt-get update 
RUN mkdir  /opt/app
ENV PROJECT_HOME /opt/app
COPY target/jobber-0.0.1-SNAPSHOT.jar ${PROJECT_HOME}
WORKDIR ${PROJECT_HOME}
EXPOSE 8090
CMD [ "java", "-jar", "jobber-0.0.1-SNAPSHOT.jar"  ]