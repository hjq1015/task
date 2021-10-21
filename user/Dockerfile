FROM java:openjdk-8u111
MAINTAINER huangyong yong.huang1@thoughtworks.com
COPY build/libs/*.jar /app.jar
EXPOSE 6666
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "app.jar"]