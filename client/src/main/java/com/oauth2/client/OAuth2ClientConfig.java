package com.oauth2.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistrations;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class OAuth2ClientConfig {
    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(){
        return new InMemoryClientRegistrationRepository(keycloakClientRegistration());
    }

    private ClientRegistration keycloakClientRegistration() {
        return ClientRegistrations.fromIssuerLocation("http://localhost:8080/realms/oauth2")//issuer url을 통해 정보를 가져오므로 설정이 필요없다.
                .registrationId("keycloak")
                .clientId("oauth2-client-app")
                .clientSecret("fdacDn3pRW7ImDBOfDQZERbjrBVUiZcW")
                .redirectUri("http://localhost:8081/login/oauth2/code/keycloak")
                .build();
    }
}
