package com.xh.dubbo.learn.lesson1.provider.conf;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfiguration {
    @Bean
    public ApplicationConfig getApplicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("sesson1-config-provider");
        return applicationConfig;
    }

/*    @Bean
    public ProviderConfig getProviderConfig() {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(5000);
        return providerConfig;
    }*/

    @Bean
    public RegistryConfig getRegistryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        registryConfig.setClient("curator");
        return registryConfig;

    }
}
