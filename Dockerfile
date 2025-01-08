FROM eclipse-temurin:23-jre

COPY build/libs/*.jar /app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app.jar"]