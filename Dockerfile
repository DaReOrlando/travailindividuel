FROM openjdk:21
LABEL maintainer="orlando"
ADD rest/target/rest-0.0.1-SNAPSHOT.jar springboot-docker-orlando.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-orlando.jar"]