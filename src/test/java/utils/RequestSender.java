package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class RequestSender {

    public static <T, Y> T sendPostRequest(final String uri, final String accessToken, final String path,
                                           final Y body, final TypeReference<T> type) {
        if ("".equals(accessToken)) {
            return
                    given().
                            baseUri(uri).
                            accept(ContentType.JSON).
                            contentType(ContentType.JSON).
                            body(body).
                            when().
                            post(path).
                            then().statusCode(200).extract().body().as(type.getType());
        } else {
            return
                    given().
                            baseUri(uri).
                            accept(ContentType.JSON).
                            contentType(ContentType.JSON).
                            header("x-auth-token", accessToken).
                            body(body).
                            when().
                            post(path).
                            then().statusCode(200).extract().body().as(type.getType());
        }
    }

    public static <T> T sendGetRequest(final String uri, final String accessToken, final String path,
                                       final TypeReference<T> type) {
        return
                given().
                        baseUri(uri).
                        accept(ContentType.JSON).
                        contentType(ContentType.JSON).
                        header("x-auth-token", accessToken).
                        when().
                        get(path).
                        then().statusCode(200).extract().body().as(type.getType());

    }
}
