package starter.petstore.steps;

import com.google.gson.Gson;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.model.Author;
import starter.petstore.utils.Log;

public class ActivityApiSteps {

    public static String generateFullAuthorJsonBody() {

        Author author = Author.builder().id(10).idBook(10).firstName(JsonNullable.of("Saurabh")).lastName(JsonNullable.of("kakkar")).build();

        // Convert an object to JSON using Google Gson ObjectMapper

        String jsonPayload =  new Gson().toJson( author);

        // Print the JSON payload
        Log.info(jsonPayload);

        return jsonPayload;
    }
}
