package cn.leolam.www.user;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ResourceUtils;

/**
 * user资源服务器启动类
 *
 * @Auther: leolam
 */

@EnableEurekaClient
@SpringBootApplication
//@ComponentScan(basePackages = {"cn.leolam.www.base"})
////添加依赖包的扫描
@ComponentScan(basePackages = {"cn.leolam.www.base", "cn.leolam.www.user"})
//开启mybatis 事务
@EnableTransactionManagement
public class UserResourceApplication {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(UserResourceApplication.class, args);
    }
}
