FROM adoptopenjdk/openjdk11:alpine-jre

COPY target/project1-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]