package httpbin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

@RunWith(Parameterized.class)
public class HTTPBIN_StatusCodes_Param_Tests {

    private final String value;
    private final String expected;

    public HTTPBIN_StatusCodes_Param_Tests(String value, String expected) {
        this.value = value;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{{"200", "200"}, {"300", "300"}, {"400", "400"}});
    }

    @Test
    public void testSearch() {
        given().log().all().
                pathParam("codes",value).
                when().
                get("https://httpbin.org/status/{codes}").
        then().assertThat().
        statusCode(Integer.parseInt(expected));
    }

}
