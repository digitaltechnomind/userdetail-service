FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="saurabh.banerjee@nagarro.com"

# Add a volume pointing to /tmp
VOLUME /tmp


# Make port 8080 available to the world outside this container
ENV SERVER_PORT 8092
EXPOSE $SERVER_PORT


# The application's jar file
ARG JAR_FILE=target/orderdetail-service-0.0.1-SNAPSHOT.jar 

# Add the application's jar to the container
ADD ${JAR_FILE} /app/orderdetail-service-0.0.1-SNAPSHOT.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "/app/orderdetail-service-0.0.1-SNAPSHOT.jar"]
