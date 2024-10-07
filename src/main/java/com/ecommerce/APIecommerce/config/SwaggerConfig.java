package com.ecommerce.APIecommerce.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static java.util.Collections.singletonList;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo getApiInfo() {
        Contact contact = new Contact("Seba", "https://ironnetta.github.io/", "delaet.sebastien22@gmail.com");
        return new ApiInfoBuilder()
                .title("Ecommerce API")
                .description("Documentation Ecommerce api")
                .version("1.0.0")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }

    @Bean
    public Docket productApi() {
        return new Docket(SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ecommerce.APIecommerce"))
                .paths(PathSelectors.any())
                .build();
    }
}

