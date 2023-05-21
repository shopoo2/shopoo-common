FROM openjdk:8-jre-alpine
MAINTAINER Joe <android_li@sina.cn>
ENV JAR_FILE start.jar
#Set Beijing time zone
RUN echo 'Asia/Shanghai'>/etc/timezone
ADD ./start/target/$JAR_FILE /app/
CMD java -Xmx400m -jar /app/$JAR_FILE
EXPOSE 8710
