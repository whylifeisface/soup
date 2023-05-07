package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {


    private List<Parameter> jwtToken() {

        String jwt = "Bearer {jwt}";

        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        // 声明 key
        tokenPar.name("Authorization")
                // 文字说明
                .description("jwt令牌")
                // 类型为字符串
                .modelRef(new ModelRef("string"))
                // 参数形式为 header 参数
                .parameterType("header")
                // 默认值
                .defaultValue(jwt)
                // 是否必须
                .required(false);
        pars.add(tokenPar.build());
        return pars;
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalOperationParameters(jwtToken())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                //创建
                .build()
                .securityContexts(securityContexts())
                .securitySchemes(SecruitySchemes());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot-Swagger2集成")
                .description("springboot | swagger")
                // 作者信息
                .contact(new Contact("kacen", "http:localhost:8081/doc.html", "abc@qq.com"))
                .version("0.0.1")
                .build();
    }
    private List<ApiKey> SecruitySchemes(){
        List<ApiKey> arrayList = new ArrayList<>();
        ApiKey key = new ApiKey("Authorization", "Authorization", "Header");
        arrayList.add(key);
        return arrayList;
    }
    private List<SecurityContext> securityContexts(){
        List<SecurityContext> list = new ArrayList<>();
        list.add(getByPath("/hello/.*"));
        return list;
    }

    private SecurityContext getByPath(String s) {
        return SecurityContext.builder().securityReferences(defalutAuth())
                .forPaths(PathSelectors.regex(s)).build();

    }

    private List<SecurityReference> defalutAuth() {
        List<SecurityReference> list = new ArrayList<>();
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        list.add(new SecurityReference("Authorization",authorizationScopes));
        return list;
    }

}
