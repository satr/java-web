package io.github.satr.springapp.security;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    String googleClientId;

    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    String googleClientSecret;

    @Bean
    ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration google =
                org.springframework.security.oauth2.client.registration.ClientRegistrations
                        .fromIssuerLocation("https://accounts.google.com")   // OIDC discovery
                        .registrationId("google")
                        .clientId(googleClientId)
                        .clientSecret(googleClientSecret)
                        .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}") // default is fine
                        .scope("openid", "profile", "email")
                        .build();

        return new InMemoryClientRegistrationRepository(google);
    }

    @Bean
    SecurityFilterChain security(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(a -> a.anyRequest().authenticated())
                .oauth2Login(Customizer.withDefaults());
        return http.build();
    }

    @PostConstruct
    void logCid() {
        System.out.println("Google googleClientId: " + googleClientId.substring(0, 20) + "..." + googleClientId.substring(Math.max(0, googleClientId.length()-20)));
//Just for troubleshooting
// System.out.println("Google googleClientSecret: " + googleClientSecret.substring(0, 5) + "..." + googleClientSecret.substring(Math.max(0, googleClientSecret.length()-5)));
    }
}