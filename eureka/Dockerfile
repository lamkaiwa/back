FROM leolamkaiwa/tv
COPY *.jar /eureka.jar
CMD ["--server.port=6001"]
EXPOSE 6001
ENTRYPOINT ["java","-jar","/eureka.jar","--spring.config.location=classpath:/eureka.yml"]