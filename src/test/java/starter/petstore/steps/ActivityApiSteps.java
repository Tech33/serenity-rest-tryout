package starter.petstore.steps;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.model.Author;

@Slf4j
public class ActivityApiSteps {

    public static String generateFullAuthorJsonBody() {

        Author author = Author.builder().id(10).idBook(10).firstName(JsonNullable.of("Saurabh")).lastName(JsonNullable.of("kakkar")).build();

        // Convert an object to JSON using Google Gson ObjectMapper

        String jsonPayload =  new Gson().toJson(author);

        // Print the JSON payload
        log.info(jsonPayload);

        return jsonPayload;
    }
}
