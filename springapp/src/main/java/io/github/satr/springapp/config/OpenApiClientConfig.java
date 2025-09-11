package io.github.satr.springapp.config;

import io.github.satr.springapp.api.ProductControllerApi;
import io.github.satr.springapp.api.OrderControllerApi;
import io.github.satr.springapp.invoker.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiClientConfig {

    @Bean
    public ApiClient apiClient() {
        return new ApiClient(); // configure basePath if needed
    }

    @Bean
    public ProductControllerApi productControllerApi(ApiClient apiClient) {
        return new ProductControllerApi(apiClient);
    }

    @Bean
    public OrderControllerApi orderControllerApi(ApiClient apiClient) {
        return new OrderControllerApi(apiClient);
    }
}