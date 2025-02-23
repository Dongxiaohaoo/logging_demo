package top.dongxiaohao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ElkLogDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElkLogDemoApplication.class, args);
    }

}
