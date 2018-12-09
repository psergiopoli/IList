FROM openjdk:8u151-jdk-alpine

WORKDIR /app

RUN apk update && apk add bash

COPY build/libs/*.jar ilist.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/ilist.jar"]