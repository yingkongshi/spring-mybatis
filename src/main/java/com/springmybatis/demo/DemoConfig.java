package com.springmybatis.demo;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan
@ImportResource(locations = {"classpath:spring.xml"})
public class DemoConfig extends WebMvcConfigurationSupport {
  @Override
  protected Map<String, MediaType> getDefaultMediaTypes() {
    return Collections.singletonMap("json", MediaType.APPLICATION_JSON);
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.ignoreAcceptHeader(true)
            .defaultContentType(MediaType.APPLICATION_JSON);
  }
  
  protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(new MappingJackson2HttpMessageConverter());
  }
}
