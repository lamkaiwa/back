FROM leolamkaiwa/tv
COPY *.jar /video.jar
CMD ["--server.port=8080"]
EXPOSE 8080
ENTRYPOINT ["java","-jar","/video.jar","--spring.config.location=classpath:/video.yml"]