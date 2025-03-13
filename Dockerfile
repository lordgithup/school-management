

FROM openjdk:17
EXPOSE 8080
COPY target/schoolmanagement.jar schoolmanagement.jar
ENTRYPOINT ["java","-jar","/schoolmanagement.jar"]


