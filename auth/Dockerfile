FROM leolamkaiwa/tv
COPY *.jar /auth.jar
CMD ["--server.port=8090"]
EXPOSE 8090
ENTRYPOINT ["java","-jar","/auth.jar","--spring.config.location=classpath:/auth.yml"]