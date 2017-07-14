FROM openjdk:jdk-alpine

ENV SCALA_VERSION 2.12.1

WORKDIR /root
EXPOSE 8080
ADD target/scala-2.12/script-engine-assembly-*.jar /root/script-engine-assembly.jar
ADD scripts /root/scripts
ENTRYPOINT  ["java", "-jar", "/root/script-engine-assembly.jar"]
