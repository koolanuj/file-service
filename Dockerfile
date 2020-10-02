# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine

#copy application jar
COPY ./build/libs/file-service-1.0-SNAPSHOT.jar /app/file-service-app.jar

#define working dir
WORKDIR /tmp

# run application with this command line
CMD ["/usr/bin/java", "-Dspring.profiles.active=local", "-jar", "/app/file-service-app.jar"]

#ENTRYPOINT ["java","Main"]