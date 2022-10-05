FROM eclipse-temurin:17-jdk

COPY --chown=gradle=gradle . /project/

WORKDIR /project

RUN /project/gradlew clean build

FROM eclipse-temurin:17-jre

EXPOSE 8888

RUN mkdir /app

COPY --from=build /project/build/libs/*jar /app/quizleapi.jar

ENTRYPOINT ["java", "-jar", "/app/quizleapi.jar"]

