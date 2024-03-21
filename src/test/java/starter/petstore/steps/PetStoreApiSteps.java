package starter.petstore.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.openapitools.model.Category;
import org.openapitools.model.Pet;
import org.openapitools.model.Tag;

import java.util.List;

public class PetStoreApiSteps {

    public static String generateFullPetJsonBody(Long id, String categoryName, String petName, String tagName) throws JsonProcessingException {
        // Create a new Pet object using the builder pattern

        // Create a Tag object
        Tag tag = new Tag(0L, tagName);
        Category category = new Category(0L, categoryName);

        Pet pet = Pet.builder()
                .id(123L) // Set the ID of the pet
                .name(petName) // Set the name of the pet
                .status(Pet.StatusEnum.AVAILABLE) // Set the status of the pet
                .tags(List.of(tag))
                .category(category)
                .build();

        // Convert the Pet object to JSON
        String jsonPayload =  new Gson().toJson(pet);

        // Print the JSON payload
//        Log.info("Pet JSON payload is " + jsonPayload);

//        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println("DEBUG:" +  objectMapper.writeValueAsString(pet));
//        return objectMapper.writeValueAsString(pet);

        return jsonPayload;
    }


}
