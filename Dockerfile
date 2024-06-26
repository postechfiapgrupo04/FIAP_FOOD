FROM openjdk:17-slim

WORKDIR /app

COPY build/libs/*.jar /app/fiapfood.jar
COPY wait-for-it.sh /wait-for-it.sh

#RUN chmod +x /wait-for-it.sh

EXPOSE 8080

CMD ["java", "-jar", "fiapfood.jar"]