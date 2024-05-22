
#
# Build stage
#
FROM gradle:jdk21 AS build
RUN gradle build --no-daemon
LABEL org.name="Profwider"
#
# Package stage
#
FROM eclipse-temurin:21-jdk
COPY --from-build /home/gradle/src/build/libs/HTWSportPlanner-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]