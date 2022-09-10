package com.pilgrims.travelagency.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration for CORS
 *
 * @author Ott Pikk
 */

@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {

    public void addCorsMapping(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT");
    }
}
