package com.codingshuttle.sathwik.prod_ready_features.configs;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Configuration
public class RestConfig {

    @Value("${employeeService.base.url}")
    private String BASE_URL;

    @Bean
    @Qualifier("employeeRestClient")
    public RestClient getEmployeeRestClient() {
        return RestClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
