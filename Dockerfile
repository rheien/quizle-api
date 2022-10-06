FROM eclipse-temurin:17-jdk

RUN mkdir /project

COPY . /project

WORKDIR /project

RUN /project/gradlew clean build

FROM eclipse-temurin:17-jre

EXPOSE 8888

RUN mkdir /app

COPY /project/build/libs/*jar /app/

ENTRYPOINT ["java", "-jar", "/app/quizleapi.jar"]

