package com.oauth2.client.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
    @GetMapping("/")
    public String index(){

        ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId("keycloak");

        String clientId = clientRegistration.getClientId();
        System.out.println("Client Id :"+ clientId);

        String redirectUrl = clientRegistration.getRedirectUri();
        System.out.println("Redirect Url :"+ redirectUrl);
        return "index";
    }
}