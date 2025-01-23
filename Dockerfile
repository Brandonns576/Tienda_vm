#Version con jdk17

FROM maven:3.8.5-openjdk-17 as build

COPY . .

RUN mvn clean package -DskipTests
 
FROM openjdk:17.0.1-jdk-slim

COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar to C:\Users\brand\.m2\repository\com\tienda\demo\0.0.1-SNAPSHOT\demo-0.0.1-SNAPSHOT.jar tienda.jar

EXPOSE 80

ENTRYPOINT ["java","-jar","tienda.jar"]
 
