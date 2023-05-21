package com.customer.servicecustomers.config;

import java.lang.annotation.Annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.customer.servicecustomers.controllers.CustomerController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

 @SuppressWarnings("unchecked")
 @Bean
 Docket api() {
  return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors
		  .withClassAnnotation((Class<? extends Annotation>) CustomerController.class))
		  .paths(PathSelectors.any())
		  .build();
 }
} 