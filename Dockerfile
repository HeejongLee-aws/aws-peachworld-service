FROM        065517460842.dkr.ecr.ap-northeast-2.amazonaws.com/amazoncorretto:11.0.12-alpine
LABEL       maintainer="AWS Peachworld Workshop"

ARG         APP_NAME
ARG         JVM_OPS
ENV         JVM_OPS=${JVM_OPS}
ENV         APP_PROFILE=local

ADD         build/libs/$APP_NAME.jar /app.jar
ADD         src/main/resources/application-$APP_PROFILE.properties application.properties

RUN         echo "Asia/Seoul" > /etc/timezone
CMD         ["sh", "-c", "java $JVM_OPS -jar app.jar"]
ENTRYPOINT  ["ls","-al","/app.jar"]