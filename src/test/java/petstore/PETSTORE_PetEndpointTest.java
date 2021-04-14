package petstore;

import ApiData.Category;
import ApiData.Pet;
import ApiData.Tag;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PETSTORE_PetEndpointTest {

    @Test
    public void PETSTORE_Post_Test() {
//        {
//            "id": 0,   <-- string
//            "category": { "id": 0, "name": "string" }, <-- object
//            "name": "doggie", <-- string
//            "photoUrls": ["string"], <-- array of string
//            "tags": [ <-- array of object
//            {
//                "id": 0,
//                "name": "string"
//            }
//            ],
//            "status": "available" <-- string
//        }

        Long id = 0L;
        Category category = new Category("Category name", 0);
        String name = "doggie";
        String[] photoUrls = new String[]{"https://petstore.swagger.io/1.jpg"};
        Tag[] tags = new Tag[1];
        tags[0]= new Tag(0, "string");
        String status = "available";

        Pet pet = new Pet(id,category,name,photoUrls,tags,status);

        // convert Pet object to Json
        String jsonPet = pet.toJSON();


        Response response = given().log().all().accept("application/json")
                .contentType( "application/json")
                .body(jsonPet)
                .expect().statusCode(200)
        .when().post("https://petstore.swagger.io/v2/pet");

        response.jsonPath().get("SuccessCode");
        Assert.assertEquals( "Correct Success code was returned", "doggie", response.jsonPath().get("name"));
    }
}
