package th.ac.hcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@ComponentScan(basePackages="th.ac.hcu")
@SpringBootApplication
@EnableSwagger2
@Import(value = { springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class })
public class SafeKeepApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SafeKeepApplication.class, args);
	}
	
	@Bean
	public Docket theApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("appName")
            .description("myApp")
            .version("0.0.1")
            .build();
    }
	
}
