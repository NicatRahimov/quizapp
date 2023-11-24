package az.coders.quizapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {



    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info().title("OPEN API TITLE").version("1.0.0"));
    }

    @Bean
    public GroupedOpenApi httpApi() {
        return GroupedOpenApi.builder()
                .group("http")
                .pathsToMatch("/**")
                .build();
    }









//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("az.coders.quizapp"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiEndPointsInfo(){
//        return new ApiInfoBuilder()
//                .title("Learning swagger")
//                .description("Quiz app haqqinda melumat")
//                .contact(new Contact("Nicat Rahimov","URL.com","nijatrahimov9@gmail.com"))
//                .license("Apache 2.0")
//                .licenseUrl("license url")
//                .version("1.12.2")
//                .termsOfServiceUrl("TERMS OF SERVICE URL")
//                .build();
//    }
}
