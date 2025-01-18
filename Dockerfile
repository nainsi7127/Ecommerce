# Use default java-newrelic image
FROM sitaonair.azurecr.io/java-newrelic:eclipse-temurin-jre-21.0.3_9-alpine-3.19.1-newrelic-8.12.0

COPY build/libs/*.jar /opt/application.jar
