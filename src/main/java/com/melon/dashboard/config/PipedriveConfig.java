package com.melon.dashboard.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Getter
@Setter
@Configuration
@PropertySource("classpath:application.properties")
public class PipedriveConfig {

    @Value("${pipedrive.api.token}")
    private String apiPipeToken;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public String pipedriveApiToken() {
        return apiPipeToken;
    }
}
