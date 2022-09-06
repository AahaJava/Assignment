package com.ahb;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import org.modelmapper.ModelMapper;

@Factory
public class Config {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
