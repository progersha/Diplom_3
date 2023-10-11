package org.praktikum.api;

import io.restassured.response.ValidatableResponse;
import org.praktikum.StellarburgersHttpClient;
import org.praktikum.api.Token;

public class RegisterUser extends StellarburgersHttpClient {

    User user;

    public RegisterUser(User user) {
        this.user = user;
    }

    public ValidatableResponse registerUser() {
        return doPostRequest(REGISTER_URL, user);
    }

    public String getAccessToken() {
        return registerUser().extract().body().as(Token.class).getAccessToken();
    }
}
