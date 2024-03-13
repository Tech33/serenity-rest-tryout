package starter.petstore.stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openapitools.model.Author;
import org.openapitools.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import starter.petstore.common.APIResources;
import starter.petstore.steps.GenericSteps;

import java.util.Locale;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static starter.petstore.hooks.Hooks.petUrl;
import static starter.petstore.steps.ActivityApiSteps.generateFullAuthorJsonBody;
import static starter.petstore.steps.PetStoreApiSteps.generateFullPetJsonBody;


public class PetStepDef{

//    Target ADD_TO_CART = Target.the("Google Search Box").located(By.cssSelector("//button[.='Add']"));

    @Steps
    GenericSteps genericSteps;

    Response res;

    String categoryName ;
    String petName;
    String tagName;

    private final SharedDataHolder sharedDataHolder ;

    @Autowired
    public PetStepDef(SharedDataHolder sharedDataHolder) {
        this.sharedDataHolder = sharedDataHolder;
    }

    @Given("I have a pet store API")
    public void iHaveAPetStoreAPI() {

        RestAssured.baseURI= petUrl;

        genericSteps.callEndpoint(RestAssured.baseURI);
    }

    @Given("the client uses the following url parameters:")
    public void theFollowingUrlParameters(Map<String, String> urlParameters) {
        genericSteps.setDecorateUrl(urlParameters);
    }

    @When("I call get end point for fetching pets and with status as {string}")
    public void iCallGetEndPointWithStatusAs(String status) {

        String url = String.format("%s%s%s", RestAssured.baseURI, APIResources.valueOf("searchPetStore").getValue(), "?status=" +status);
        res =  genericSteps.callEndpointHttpMethod(url,"GET","");
    }

    @Then("I should get the status code as {int}")
    public void iShouldGetTheStatusCodeAs(Integer statusCode) {
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

        generateFullAuthorJsonBody();

        String url = String.format("%s%s", RestAssured.baseURI, "/pet");
        res =  genericSteps.callEndpointHttpMethod(url,"POST",body);

    }

    @Then("New pet is created successfully")
    public void newPetIsCreatedSuccessfully() throws JsonProcessingException {

        Gson gson = new Gson();
        Pet responseObject = gson.fromJson(res.getBody().asString(), Pet.class);
        Author response = gson.fromJson(res.getBody().asString(), Author.class);
        assert( responseObject.getName().equalsIgnoreCase(petName));
        assertThat ( responseObject.getTags().get(0).getName(), equalTo(tagName));
        assertThat ( response.getId().toString(), equalTo("123"));

    }

    @Given("User have the petstore API")
    public void userHaveThePetstoreAPI() {

        RestAssured.baseURI= petUrl;
    }


    @When("User call {string} Request on the Pet {string}")
    public void userCallRequestOnThePet(String method, String endpoint) {

        String url = String.format("%s%s", RestAssured.baseURI,endpoint);
        res =  genericSteps.callEndpointHttpMethod(url,"GET","");
        sharedDataHolder.setResponse(res);
    }

    @Then("User should get the status code as {int} for Pet API")
    public void userShouldGetTheStatusCodeAsForPetAPI(Integer expectedStatus) {
        int actualStatus = res.getStatusCode();
        assertThat(actualStatus, Matchers.equalTo(expectedStatus));
    }

    @When("User call {string} Request on the Pet {string} with dynamically generated body")
    public void userCallRequestOnThePetWithDynamicallyGeneratedBody(String method, String endpoint) throws JsonProcessingException {

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        categoryName = fakeValuesService.regexify("[a-z]{10}");
        petName = fakeValuesService.regexify("[a-z]{10}");
        tagName = fakeValuesService.regexify("[a-z]{10}");

        String body = generateFullPetJsonBody(categoryName,petName,tagName);
        String url = String.format("%s%s", RestAssured.baseURI,endpoint);
        res =  genericSteps.callEndpointHttpMethod(url,"POST",body);
    }
}