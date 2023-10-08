package org.praktikum.api;

import io.restassured.response.ValidatableResponse;
import org.praktikum.StellarburgersHttpClient;
import org.praktikum.api.User;

public class DeleteUser extends StellarburgersHttpClient {

    User user;

    public DeleteUser(User user) {
        this.user = user;
    }

    public ValidatableResponse deleteUser(String token) {
        return doDeleteRequest(AUTH_URL, token);
    }
}
