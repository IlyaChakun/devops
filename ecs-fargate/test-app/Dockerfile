FROM openjdk:11-jre-slim

ADD target/application.jar /
CMD ["java", "-Xmx200m", "-jar", "/application.jar"]

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8080/service/test-get || exit 1

EXPOSE 8080