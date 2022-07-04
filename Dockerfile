FROM leolamkaiwa/tv
COPY auth-1.0-SNAPSHOT.jar /auth.jar
COPY client-1.0-SNAPSHOT.jar /client.jar
COPY eureka-1.0-SNAPSHOT.jar /eureka.jar
COPY gateway-1.0-SNAPSHOT.jar /gateway.jar
COPY user-1.0-SNAPSHOT.jar /user.jar
COPY video-1.0-SNAPSHOT.jar /video.jar
EXPOSE 8090
EXPOSE 6001
EXPOSE 7001
EXPOSE 8080
EXPOSE 9004
EXPOSE 80

##汇总
#ENTRYPOINT ["java","-jar","/eureka.jar","--spring.config.location=classpath:/application_production.yml"]
#ENTRYPOINT ["java","-jar","/gateway.jar","--spring.config.location=classpath:/application_production.yml"]
#ENTRYPOINT ["java","-jar","/auth.jar","--spring.config.location=classpath:/application_production.yml"]
#ENTRYPOINT ["java","-jar","/user.jar","--spring.config.location=classpath:/application_production.yml"]
#ENTRYPOINT ["java","-jar","/eureka.jar","--spring.config.location=classpath:/application_production.yml"]