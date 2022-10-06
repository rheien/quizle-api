FROM eclipse-temurin:17-jdk

RUN mkdir /project

COPY . /project

WORKDIR /project

RUN /project/gradlew clean build

FROM eclipse-temurin:17-jre

EXPOSE 8888

RUN mkdir /app

COPY build/libs/*jar /app/quizleapi-1.0-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/quizleapi-1.0-SNAPSHOT.jar"]
