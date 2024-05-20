package com.ssm.backend;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 공식문서 : https://springdoc.org/#Introduction
// Swagger UI 페이지 : http://localhost:8080/swagger-ui/index.html
// OpenAPI 설명 페이지 (json 형식) : http://localhost:8080/api-docs
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()))
                .info(new Info().title("SSM REST API")
                        .description("API for Saeroun Study Manager")
                        .version("1.0").contact(new Contact().name("Daniel Choi").email("test@gmail.com").url("test.com"))
                        .license(new License().name("License of API")
                                .url("www.sampleurl.com")));
    }

    private Info apiInfo() {
        return new Info()
                .title("Springdoc 테스트")
                .description("Springdoc을 사용한 Swagger UI 테스트")
                .version("1.0.0");
    }
    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }


}