nohup java -jar /eureka.jar  --spring.config.location=classpath:/eureka.yml &
nohup java -jar /gateway.jar  --spring.config.location=classpath:/gateway.yml &
nohup java -jar /auth.jar  --spring.config.location=classpath:/auth.yml &
nohup java -jar /user.jar  --spring.config.location=classpath:/user.yml &
nohup java -jar /video.jar  --spring.config.location=classpath:/video.yml &
nohup java -jar /client.jar  --spring.config.location=classpath:/client.yml
docker exec -it 541e602a0aa1 /bin/bash