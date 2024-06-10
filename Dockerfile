FROM openjdk:17-jdk

WORKDIR /app

#copy from the host to the docker images
COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

EXPOSE 8080

CMD ["java","-jar","demo.jar"]