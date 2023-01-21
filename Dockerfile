FROM openjdk:11
EXPOSE 8080
ADD target/pointage.jar pointage.jar
ENTRYPOINT ["java","-jar","/pointage.jar"]
