package com.xikou.promotion.configuration;

import com.google.common.collect.Lists;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
@EnableWebMvc
@ImportResource(locations = {"classpath:configurations/web_mvc.xml"})
@ComponentScan(basePackages = "com.xikou.promotion.controller")
public class WebAppMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        SerializerFeature[] features = new SerializerFeature[]{SerializerFeature.QuoteFieldNames, //
                SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteNullStringAsEmpty, //
                SerializerFeature.WriteNullBooleanAsFalse};
        converter.setFeatures(features);
        // 设置json数据字符集编码
        List<MediaType> fastMediaTypes = Lists.newArrayList();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(fastMediaTypes);
        converters.add(converter);
    }

    // favorPathExtension表示支持后缀匹配
    // 属性ignoreAcceptHeader默认为fasle,表示accept-header匹配,defaultContentType开启默认匹配
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        configurer.favorPathExtension(false);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        // 添加swagger2支持
        registry.addResourceHandler("doc.html")//
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("swagger-ui.html")//
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**") //
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
