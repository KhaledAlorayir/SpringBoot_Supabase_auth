package com.example.supabaseAuthTest.config;

import com.example.supabaseAuthTest.httpClient.UserClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebConfig {

    @Value("${supabase_admin_key}")
    private String SUPABASE_ADMIN_KEY;

    @Bean
    WebClient webClient(ObjectMapper objectMapper) {
        return WebClient.builder()
                .baseUrl("https://sieazraqxirknqzcszsr.supabase.co/auth/v1")
                .defaultHeader("apikey",SUPABASE_ADMIN_KEY)
                .build();
    }

    @SneakyThrows
    @Bean
    UserClient userClient(WebClient webClient) {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                        .build();
        return httpServiceProxyFactory.createClient(UserClient.class);
    }

}
