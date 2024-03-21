package starter.petstore.common;

import lombok.Getter;

@Getter
public enum APIResources {

    oAuthAPI("/auth/oauth/v2/token"),
    searchPetStore( "/pet/findByStatus");

    private final String value;

    APIResources(String envValue)
    {
        this.value = envValue;
    }

/*    public String getValue() {
        return value;
    }*/
}