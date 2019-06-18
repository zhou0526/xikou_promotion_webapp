package com.xikou.promotion.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ImportResource(locations = {"classpath:configurations/motan_ref.xml"})
@ComponentScan(basePackages = "com.xikou.promotion", excludeFilters = @ComponentScan.Filter(classes = Controller.class))
public class WebAppConfiguration {

}