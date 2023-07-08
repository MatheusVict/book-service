package br.com.erudio.bookservice.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
        info = @Info(
                title = "Book Service API",
                description = "Documentation of Book Service API",
                version = "v1.0"
        )
)
public class OpenApiConfiguration {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
            .components(new Components())
            .info(getInfo());
  }

  private io.swagger.v3.oas.models.info.Info getInfo() {
    return new io.swagger.v3.oas.models.info.Info()
            .title("Book Service API")
            .version("v1.0")
            .license(getLicense());
  }

  private License getLicense() {
    return new License()
            .name("Apache2.0")
            .url("http://www.apache.org/licenses/LICENSE-2.0");
  }
}
