package starter.petstore.runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import starter.petstore.hooks.Hooks;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "starter.petstore.stepdefs",
        tags = "@api121"
)
public class RunTest extends Hooks {
}
