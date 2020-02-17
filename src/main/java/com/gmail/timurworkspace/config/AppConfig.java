package com.gmail.timurworkspace.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("com.gmail.timurworkspace")
@PropertySource("classpath:/jdbc.properties")
public class AppConfig {

    @Autowired
    private Environment environment;

}
