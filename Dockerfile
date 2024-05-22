FROM gradle:8-jdk21 as builder
WORKDIR /
COPY . ./
RUN gradle build

FROM openjdk:21-slim
LABEL authors="moritz.malina"
COPY --from=builder build/libs .
ENTRYPOINT ["java","-jar","/HTWSportPlanner-0.0.1-SNAPSHOT.jar"]