package com.nsoft.godfather.k8s.workshop.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

/**
 * SpringFoxConfiguration
 */
@Configuration
@EnableSwagger2
public class SpringFoxConfiguration {
    @Bean
    public Docket recordApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.nsoft.godfather.k8s.workshop.rest.resource"))
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Todo list service", "An example project prepared for Godfather K8S workshop", "V1", "",
                new Contact("Nikola Rakić", "https://github.com/nzrakic/",
                        "nzrakic@gmail.com"),
                "", "", Collections.emptyList());
    }
}