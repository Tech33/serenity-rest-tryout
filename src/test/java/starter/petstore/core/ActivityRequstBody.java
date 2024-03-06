package starter.petstore.core;

import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.model.Author;

import static starter.petstore.core.common.toJson;

public class ActivityRequstBody {

    public static String generateFullAuthorJsonBody() {


        Author author = Author.builder().id(10).idBook(10).firstName(JsonNullable.of("Saurabh")).lastName(JsonNullable.of("kakkar")).build();

        // Convert an object to JSON using Jackson ObjectMapper

        String jsonPayload = toJson( author);

        // Print the JSON payload
        System.out.println(jsonPayload);

        return jsonPayload;
    }

}