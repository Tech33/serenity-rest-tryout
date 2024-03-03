//package starter.petstore.stepdefs;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.github.javafaker.service.FakeValuesService;
//import com.github.javafaker.service.RandomService;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import net.serenitybdd.core.di.SerenityInfrastructure;
//import net.serenitybdd.core.steps.UIInteractions;
//import net.serenitybdd.screenplay.Actor;
//import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
//import net.serenitybdd.screenplay.actions.Enter;
//import net.serenitybdd.screenplay.actions.Open;
//import net.serenitybdd.screenplay.annotations.CastMember;
//import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
//import net.serenitybdd.screenplay.rest.interactions.Get;
//import net.serenitybdd.screenplay.rest.interactions.Post;
//import net.serenitybdd.screenplay.ui.InputField;
//import net.thucydides.model.util.EnvironmentVariables;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.Locale;
//
//import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
//import static org.hamcrest.Matchers.equalTo;
//import static starter.petstore.core.PetStoreRequstBodySvc.generateFullPetJsonBody;
//
//
//public class StepDefs extends UIInteractions {
//
////    Target ADD_TO_CART = Target.the("Google Search Box").located(By.cssSelector("//button[.='Add']"));
//
//    EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();
//    String theRestApiBaseUrl = this.environmentVariables.getProperty("restapi.baseurl");
//
//    String categoryName ;
//    String petName;
//    String tagName;
//
//    @CastMember
//    Actor I;
//
//    Actor uiUser;
//
//    @Given("I have a pet store API")
//    public void iHaveAPetStoreAPI() {
//        I = Actor.named("I the caller of the API")
//                .whoCan(CallAnApi.at(theRestApiBaseUrl));
//    }
//
//    @When("I call get end point for fetching pets and with status as {string}")
//    public void iCallGetEndPointWithStatusAs(String status) {
//        I.attemptsTo(
//                Get.resource("/pet/findByStatus?status="+status)
//        );
//
//
//    }
//
//    @Then("I should get the status code as {int}")
//    public void iShouldGetTheStatusCodeAs(Integer statusCode) {
//        I.should(
//                seeThatResponse("The Status code is : ", response -> response.statusCode(statusCode))
//        );
//    }
//
//    @When("I create a new pet with body")
//    public void createANewPetWithBody() throws JsonProcessingException {
//        FakeValuesService fakeValuesService = new FakeValuesService(
//                new Locale("en-GB"), new RandomService());
//
//        categoryName = fakeValuesService.regexify("[a-z]{10}");
//        petName = fakeValuesService.regexify("[a-z]{10}");
//        tagName = fakeValuesService.regexify("[a-z]{10}");
//
////        String body = generateCreateNewPetBodyWithCategoryNameAndTagNameAs(categoryName, petName, tagName);
//        String body = generateFullPetJsonBody(categoryName,petName,tagName);
//
////        RestAssured.baseURI = "https://petstore.swagger.io/v2";
//        // Send POST request
////        Response response = RestAssured.given()
////                .contentType(ContentType.JSON)
////                .body(body)
////                .post("/pet");
//
//        // Verify response
////        response.then().statusCode(200); // Assuming 200 is the success status code
////        System.out.println("Response: " + response.getBody().asString());
//
////        SerenityRest.given().header("Content-Type", "application/json").body(body).when().post("/pet");
//
//
//
//        I.attemptsTo(
//                Post.to("/pet")
//                        .with(request -> request.header("Content-Type", "application/json")
//                                .body(body))
//        );
//    }
//
//    @Then("New pet is created successfully")
//    public void newPetIsCreatedSuccessfully() throws JsonProcessingException {
//        I.should(
//                seeThatResponse("New pet is created  ", response -> response
//                        .body("name", equalTo(petName))
//                        .body("category.name", equalTo(categoryName))
//                        .body("tags[0].name", equalTo(tagName))
//        ));
//    }
//
//    // UI Steps
//    @Given("I have browser open")
//    public void i_have_browser_open() {
//        uiUser = Actor.named("uiUser").whoCan(BrowseTheWeb.with(new ChromeDriver()));
//        uiUser.attemptsTo(
//                Open.url("https://google.com")
//        );
//    }
//    @When("I search for {string} in google")
//    public void i_search_for_in_google(String string) {
//        uiUser.attemptsTo(
//                Enter.theValue("string").into(InputField.withNameOrId("q")).thenHit(Keys.ENTER)
//        );
//    }
//    @Then("I should see the search results")
//    public void i_should_see_the_search_results() {
//
//    }
//
//}
