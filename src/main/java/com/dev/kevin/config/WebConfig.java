package com.dev.kevin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Configuração de CORS
                registry.addMapping("/**") // Aplica CORS para todos os endpoints
                        .allowedOrigins("http://127.0.0.1:5500") // Permite requisições do Live Server
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite métodos HTTP
                        .allowedHeaders("*") // Permite todos os cabeçalhos
                        .allowCredentials(true); // Permite credenciais (cookies, etc.)
            }
        };
    }
	
}
