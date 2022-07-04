package cn.leolam.www.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: leolam
 */
@EnableEurekaClient // 标识是eureka客户端
@SpringBootApplication
//@ComponentScan(basePackages = {"cn.leolam.www.base", "cn.leolam.www.auth"})
//添加依赖包的扫描
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
}
