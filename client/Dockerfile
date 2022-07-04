FROM leolamkaiwa/tv
COPY *.jar /client.jar
CMD ["--server.port=80"]
EXPOSE 80
ENTRYPOINT ["java","-jar","/client.jar","--spring.config.location=classpath:/client.yml"]