package io.github.satr.springapp.config;

import io.github.satr.springapp.api.OrderControllerApi;
import io.github.satr.springapp.api.ProductControllerApi;
import io.github.satr.springapp.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiClientConfig {
    private ApiClient apiClient;
    @Value("${API_URL:http://localhost:8081}")
    private String apiUrl;

    @Bean
    public ApiClient apiClient() {
        var apiClient = new ApiClient();
        apiClient.setBasePath(apiUrl);
        return apiClient;
    }

    @Bean
    public ProductControllerApi productControllerApi() {
        return new ProductControllerApi(this.apiClient);
    }

    @Bean
    public OrderControllerApi orderControllerApi() {
        return new OrderControllerApi(this.apiClient);
    }
}

