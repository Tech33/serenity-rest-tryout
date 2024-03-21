package starter.petstore.runner;


//@RunWith(CucumberWithSerenity.class)
//@CucumberOptions(
//        features = "classpath:features",
//        glue = "starter.petstore.stepdefs",
//        tags = "@api121"
//)
//public class RunTest extends Hooks {
//}

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import starter.petstore.hooks.Hooks;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(

        features = {"classpath:features"},
        glue = {"starter.petstore.stepdefs"},
        tags = "@api2",
        plugin =
                {
                        "pretty",
                        "html:target/cucumber-report/cucumber.html",
                        "json:target/cucumber-report/cucumber.json",
                        "junit:target/cucumber-report/cucumber.xml",
                      //  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:reports/extent-report.html"
                },
        dryRun=false,
        monochrome = true
        //strict = true
)
public class RunCucumberIT extends Hooks {

}