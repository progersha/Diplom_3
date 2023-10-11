package org.praktikum.api;

import io.restassured.response.ValidatableResponse;
import org.praktikum.StellarburgersHttpClient;

public class LoginUser extends StellarburgersHttpClient {
    User user;

    public LoginUser(User user) {
        this.user = user;
    }

    public ValidatableResponse loginUser() {
        User loginData = new User(user.getEmail(), user.getPassword());
        return doPostRequest(LOGIN_URL, loginData);
    }

    public String getAccessToken() {
        return loginUser().extract().body().as(Token.class).getAccessToken();
    }

    public void deleteUser() {
        doDeleteRequest(AUTH_URL, getAccessToken());
    }
}
