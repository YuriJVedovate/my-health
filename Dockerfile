FROM maven:3.6.0-jdk-11
MAINTAINER Yuri

WORKDIR /vvv/www
COPY target/*.jar /vvv/www/app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]