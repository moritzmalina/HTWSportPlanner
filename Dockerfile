#
# Build stage
#
FROM gradle:jdk21 AS build
WORKDIR /app
COPY . ./
RUN gradle build

#
# Package stage
#
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/build/libs/HTWSportPlanner-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "HTWSportPlanner-0.0.1-SNAPSHOT.jar"]
