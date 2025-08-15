FROM openjdk:17-jdk-slim
EXPOSE 8080
WORKDIR /app
COPY target/demo-app.jar demo-app.jar
CMD [ "java", "-jar", "demo-app.jar" ]