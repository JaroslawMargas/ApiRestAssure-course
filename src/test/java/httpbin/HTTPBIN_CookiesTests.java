package httpbin;

import io.restassured.http.Cookies;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HTTPBIN_CookiesTests  {


    @Test
    public void cookieGetStatus_test() {

        given().log().all()
                .when()
                .get("https://httpbin.org/cookies")
                .then()
                .assertThat()
                .statusCode(200);

    }

    @Test
    public void cookieQueryStatus_test() {

        given().log().all()
                .queryParam("freeform", "456")
                .redirects().follow(true)
                .expect().statusCode(200)
                .when()
                .get("https://httpbin.org/cookies").getDetailedCookies();


    }

    @Test
    public void cookiePathCheckCookie_test() {

        Cookies cookies = given().log().all()
                .pathParam("name", "freeform_path")
                .pathParam("value","123_path")
                .redirects().follow(false)
                .expect().statusCode(302)
                .when()
                .get("https://httpbin.org/cookies/set/{name}/{value}")
                .getDetailedCookies();

        Assert.assertEquals("123_path", cookies.get("freeform_path").getValue());

    }

}
