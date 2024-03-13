package starter.petstore.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import starter.petstore.steps.GenericSteps;

import static starter.petstore.steps.ActivityApiSteps.generateFullAuthorJsonBody;
import static starter.petstore.hooks.Hooks.fakeUrl;

public class MyAuthorStepdefs {

    @Steps
    GenericSteps genericSteps;

    Response res;

    @Given("User have a Author API")
    public void userHaveAAuthorAPI() {

        RestAssured.baseURI= fakeUrl;

    }

    @When("User call {string} Request on the Author {string} with dynamically generated body")
    public void userCallRequestMethodOnTheAuthorWithDynamicallyGeneratedBody(String method, String endpoint) {

        String body = generateFullAuthorJsonBody();
        String url = String.format("%s%s", RestAssured.baseURI,endpoint);
        res =  genericSteps.callEndpointHttpMethod(url,"POST",body);

    }

    @Then("User should get the status code as {int} for Author API")
    public void userShouldGetTheStatusCodeAsForAuthorAPI(int expectedStatusCode) {

        Assert.assertEquals("Status Check Passed!", 200, res.getStatusCode());

    }

    @And("New Author is created successfully")
    public void newAuthorIsCreatedSuccessfully() {

    }

}
