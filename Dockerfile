
#
# Build stage
#
FROM gradle:jdk21 AS build
COPY . ./
WORKDIR /
RUN gradle build
#
# Package stage
#
FROM eclipse-temurin:21-jdk
COPY --from-builder build/libs .
ENTRYPOINT ["java","-jar","HTWSportPlanner-0.0.1-SNAPSHOT.jar"]