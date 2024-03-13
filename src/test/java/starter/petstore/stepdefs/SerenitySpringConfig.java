package starter.petstore.stepdefs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"starter.petstore.stepdefs"})
public class SerenitySpringConfig {
    // Define any additional Spring beans if needed
}
