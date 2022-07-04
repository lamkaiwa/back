FROM leolamkaiwa/tv
COPY *.jar /user.jar
CMD ["--server.port=9004"]
EXPOSE 9004
ENTRYPOINT ["java","-jar","/user.jar","--spring.config.location=classpath:/user.yml"]