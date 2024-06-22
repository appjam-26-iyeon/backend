package com.geunoo.backend.global.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import java.util.List;

@OpenAPIDefinition
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Server server = new Server();
        server.setUrl("https://redfish-driving-exactly.ngrok-free.app");
        return new OpenAPI()
            .servers(List.of(server))
            .info(
                new Info()
                    .title("너와나 API")
                    .description("너와나 API 명세입니다.")
                    .version("v1")
            )
            .components(
                new Components()
                    .addSecuritySchemes("Access Token (Bearer)", createAPIKeyScheme())
            )
            .addSecurityItem(
                new SecurityRequirement()
                    .addList("Access Token (Bearer)")
                    .addList("Refresh Token")
            );
    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT")
            .in(SecurityScheme.In.HEADER)
            .name(HttpHeaders.AUTHORIZATION);
    }
}
