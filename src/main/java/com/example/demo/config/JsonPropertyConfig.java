package com.example.demo.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JsonPropertyConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilder(){
        return jacksonObjectMapperBuilder -> {
            jacksonObjectMapperBuilder.featuresToEnable(
                    DeserializationFeature.USE_LONG_FOR_INTS)
                    .build();
        };
    }

}
