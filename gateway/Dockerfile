FROM java:openjdk-8u111
MAINTAINER huangyong yong.huang1@thoughtworks.com
COPY build/libs/*.jar /app.jar
EXPOSE 8769
ENTRYPOINT ["java", "-jar", "app.jar"]