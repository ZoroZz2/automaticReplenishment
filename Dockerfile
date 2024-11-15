# 基础镜像
FROM eclipse-temurin:17
# 作者
LABEL maintainer="13266762205@163.com"
# 工作目录
WORKDIR /usr/local/java
# 同步docker内部的时间
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
# 设置时区
ENV TZ=Asia/Shanghai
EXPOSE 8081
# 复制jar包到/user/local/java下
ARG JAR_FILE
ADD ${JAR_FILE} ./automaticReplenishment.jar

ENTRYPOINT ["sleep","infinity"]
# ENTRYPOINT ["java","-Dspring.config.location=/usr/local/java/application.yml,/usr/local/java/application-druid.yml,/usr/local/java/application-mybatis.yml,/usr/local/java/application-redis.yml","-jar","/usr/local/java/automaticReplenishment.jar"]