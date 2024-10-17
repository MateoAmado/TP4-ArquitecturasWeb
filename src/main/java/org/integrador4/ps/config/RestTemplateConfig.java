package org.integrador4.ps.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableTransactionManagement
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {
        //Los bean ya son singleton ..
        return new RestTemplate();
    }
}
