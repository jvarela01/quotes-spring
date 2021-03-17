FROM docker.io/library/openjdk:11-jre

RUN mkdir /app

COPY target/quotes-spring-0.0.1-SNAPSHOT.jar /app

WORKDIR /app

CMD ["java","-jar","quotes-spring-0.0.1-SNAPSHOT.jar"]