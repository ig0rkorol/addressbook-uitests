package com.dreamfactory.addressbook.uitests.http;

import com.dreamfactory.addressbook.uitests.messages.ValidationMessages;
import com.dreamfactory.addressbook.uitests.model.User;
import com.jayway.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.dreamfactory.addressbook.uitests.config.ConfigProperties.REGISTER_API_URL;
import static com.jayway.restassured.RestAssured.given;

public class RestClient {
    private static final Logger logger = LoggerFactory.getLogger(RestClient.class);

    public static Response registerUser(User user){
        logger.info("Register endpoint is {}", REGISTER_API_URL);
        logger.info("User data is {}", user.convertToXwwwForm());
        Response response =
        given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body(user.convertToXwwwForm())
        .when()
            .post(REGISTER_API_URL);
        return response;
    }

    public static boolean isUserExists(User user){
        Response response = RestClient.registerUser(user);
        String respMessage = response.jsonPath().getString("error.context.email");
        logger.info("Response message is '{}', code is {}", respMessage, response.getStatusLine());
        return respMessage.toUpperCase().contains(ValidationMessages.EMAIL_ALREADY_USED.toUpperCase());
    }

}
