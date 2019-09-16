package com.tdt.postgresjsonb.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JacksonConfig {

    @Autowired
    ObjectMapper objectMapper;

    @PostConstruct
    public void postConstruct() {
        ObjectMapperHolder.objectMapper = objectMapper;
    }
}
