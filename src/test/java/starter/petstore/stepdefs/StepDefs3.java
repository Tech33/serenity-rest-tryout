package starter.petstore.stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.Assert;

import java.util.Locale;

import static starter.petstore.core.PetStoreRequstBodySvc.generateFullPetJsonBody;


public class StepDefs3 extends UIInteractions {

//    Target ADD_TO_CART = Target.the("Google Search Box").located(By.cssSelector("//button[.='Add']"));

    EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();
    String theRestApiBaseUrl = this.environmentVariables.getProperty("restapi.baseurl");

    Response res;

    String categoryName ;
    String petName;
    String tagName;

    @Given("I have a pet store API")
    public void iHaveAPetStoreAPI() {
/*        I = Actor.named("I the caller of the API")
                .whoCan(CallAnApi.at(theRestApiBaseUrl));*/

        RestAssured.baseURI= environmentVariables.getProperty("restapi.baseurl");

    }

    @When("I call get end point for fetching pets and with status as {string}")
    public void iCallGetEndPointWithStatusAs(String status) {
/*        I.attemptsTo(
                Get.resource()
        );*/

        res =  SerenityRest.rest().given()
                .when()
                .get("/pet/findByStatus?status="+status);
    }

    @Then("I should get the status code as {int}")
    public void iShouldGetTheStatusCodeAs(Integer statusCode) {
//        I.should(
//                seeThatResponse("The Status code is : ", response -> response.statusCode(statusCode))
//        );

        Assert.assertEquals("Status Check Passed!", 200, res.getStatusCode());
    }

    @When("I create a new pet with body")
    public void createANewPetWithBody() throws JsonProcessingException {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        categoryName = fakeValuesService.regexify("[a-z]{10}");
        petName = fakeValuesService.regexify("[a-z]{10}");
        tagName = fakeValuesService.regexify("[a-z]{10}");

//        String body = generateCreateNewPetBodyWithCategoryNameAndTagNameAs(categoryName, petName, tagName);
        String body = generateFullPetJsonBody(categoryName,petName,tagName);

//        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        // Send POST request
         res = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(body)
                .post("/pet");

        // Verify response
//        response.then().statusCode(200); // Assuming 200 is the success status code
//        System.out.println("Response: " + response.getBody().asString());

//        SerenityRest.given().header("Content-Type", "application/json").body(body).when().post("/pet");



//        I.attemptsTo(
//                Post.to("/pet")
//                        .with(request -> request.header("Content-Type", "application/json")
//                                .body(body))
        //);
    }

    @Then("New pet is created successfully")
    public void newPetIsCreatedSuccessfully() throws JsonProcessingException {
//        I.should(
//                seeThatResponse("New pet is created  ", response -> response
//                        .body("name", equalTo(petName))
//                        .body("category.name", equalTo(categoryName))
//                        .body("tags[0].name", equalTo(tagName))
//        ));


    }

}
