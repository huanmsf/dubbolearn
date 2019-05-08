package provider.boot;

import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@SpringBootApplication
@EnableDubbo(scanBasePackages = "provider.service.impl")
@PropertySource("classpath:/spring/dubbo-provider.properties")
public class ProviderApp {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    public static void main(String[] args) throws IOException {
        /**
         * 这种方式启动不能注册服务到zookeeper
         */
        //SpringApplication.run(ProviderApp.class, args);

        /**
         * 官方的demon采用这种方式
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();
        System.in.read();

    }


    @Configuration
    @EnableDubbo(scanBasePackages = "provider.service.impl")
    @PropertySource("classpath:/spring/dubbo-provider.properties")
    static class ProviderConfiguration {
        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            //registryConfig.setAddress("multicast://224.5.6.7:1234");
            registryConfig.setAddress("zookeeper://127.0.0.1:2181");
            return registryConfig;
        }

   /*     @Bean // #4
        public ProtocolConfig protocolConfig() {
            ProtocolConfig protocolConfig = new ProtocolConfig();
            protocolConfig.setName("dubbo");
            protocolConfig.setPort(20880);
            return protocolConfig;
        }*/
    }

}
