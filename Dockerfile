# 使用官方Java 1.8镜像作为基础镜像
FROM openjdk:8-jdk-alpine

# 维护者信息
MAINTAINER niko <1194142140@qq.com>

# 设置环境变量，例如JAVA_OPTS
ENV JAVA_OPTS -Xmx512m -Xms256m

# 将本地文件复制到容器中
COPY ./xiaomotou-official.jar /usr/app/xiaomotou-official.jar

# 设置工作目录为/usr/app
WORKDIR /usr/app

# 暴露端口
EXPOSE 80

# 运行Java应用
CMD ["java", "${JAVA_OPTS}", "-jar", "xiaomotou-official.jar"]