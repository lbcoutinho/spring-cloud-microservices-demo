FROM openjdk:8-jdk-alpine
MAINTAINER Leandro Coutinho <lbcoutinho.blm@gmail.com>

ADD target/product-api.jar product-api.jar
RUN mkdir logs
VOLUME /logs

ENV SPRING_PROFILE=""
ENV JAVA_OPTS=""

ENTRYPOINT java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active="$SPRING_PROFILE" -jar product-api.jar

EXPOSE 8090