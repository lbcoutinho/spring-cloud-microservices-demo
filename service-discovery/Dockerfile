FROM openjdk:8-jdk-alpine
MAINTAINER Leandro Coutinho <lbcoutinho.blm@gmail.com>

ADD target/service-discovery.jar service-discovery.jar
RUN mkdir logs
VOLUME /logs

ENV SPRING_PROFILE=""
ENV JAVA_OPTS=""

ENTRYPOINT java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active="$SPRING_PROFILE" -jar service-discovery.jar

EXPOSE 8761