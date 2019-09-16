package com.tdt.postgresjsonb.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

public class ObjectMapperHolder {

    @Getter
    @Setter
    static volatile ObjectMapper objectMapper;
}
