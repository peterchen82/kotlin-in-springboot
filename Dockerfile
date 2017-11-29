FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD build/docker/docker-ready.jar /app.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","preview"]