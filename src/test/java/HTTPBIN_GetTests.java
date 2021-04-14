import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class HTTPBIN_GetTests {

    @Test
    public void getBDD_test() {

        given().
                when().
                get("https://httpbin.org/get").
                then().
                assertThat().
                statusCode(200);
    }


    @Test
    public void get_test()
    {
        RestAssured.baseURI = "https://httpbin.org";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/get");

        Assert.assertEquals("Response status", 200, response.statusCode());
    }
}
