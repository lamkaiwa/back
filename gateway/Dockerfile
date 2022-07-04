FROM leolamkaiwa/tv
COPY *.jar /gateway.jar
CMD ["--server.port=7001"]
EXPOSE 7001
ENTRYPOINT ["java","-jar","/gateway.jar","--spring.config.location=classpath:/gateway.yml"]