package cn.leolam.www.video;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEurekaClient
@SpringBootApplication
//开启mybatis 事务
@EnableTransactionManagement
@ComponentScan(basePackages = {"cn.leolam.www.base", "cn.leolam.www.video"})
public class VideoResourceApplication {
    static {
        try {
//            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        } catch (UnsatisfiedLinkError ignore) {

            //使用spring-dev-tools之后，上下文会被加载多次，所以这里会抛出链接库已被加载的异常。
            //有这个异常则说明链接库已被加载，直接吞掉异常即可
        }
    }

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(VideoResourceApplication.class, args);
    }
}
