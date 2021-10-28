FROM openjdk:8
EXPOSE 8092
ADD target/CentreMicroService.jar CentreMicroService.jar
ENTRYPOINT ["java", "-jar", "CentreMicroService.jar"]