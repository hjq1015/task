FROM java:openjdk-8u111
MAINTAINER huangyong yong.huang1@thoughtworks.com
COPY build/libs/eureka-1.0.jar /eureka.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka.jar"]