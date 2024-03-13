package starter.petstore.stepdefs;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component @Getter @Setter
public class SharedDataHolder {

    private String variable;
    private Response response;

}

