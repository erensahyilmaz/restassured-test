import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
public class RestAssuredTest {
@Test
public void testPost1() {
    System.out.println("1.POST Test çalıştı.");
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

    String requestBody = """
        {
          "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
          "body": "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto",
          "userId": 1
        }
        """;

    Response response = RestAssured
            .given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .log().all()
            .when()
                .post("/posts");

    response
        .then()
            .log().body()
            .statusCode(201)
            .contentType("application/json")
            .body("id", notNullValue())
            .body("userId", equalTo(1))
            .time(lessThan(1000L));
    System.out.println("1.POST Yanıt süresi: " + response.time() + " ms");
}
@Test
public void testPost2(){
    System.out.println("2.POST Test çalıştı.");
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    String newAdd = """
        {
        "title": "foo",
        "body": "bar",
        "userId": 1
        }
        """;

    Response response = RestAssured
        .given()
            .header("Content-type", "application/json")
            .body(newAdd)
        .when()
            .post("/posts")
        .then()
            .log().body()
            .statusCode(201)
            .time(lessThan(1000L))
            .contentType("application/json")
            .body("title", equalTo("foo"))
            .body("body", equalTo("bar"))
            .body("id", notNullValue())
            .body("userId", equalTo(1))
            .extract().response();
    System.out.println("2. POST Yanıt süresi: " + response.time() + " ms");
}
@Test
public void testGetPostById(){
    System.out.println("GET testi çalıştı.");
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    Response response = given()
        .header("Accept","application/json")
        .log().all()
    .when()
        .get("/posts/1");
    response.then()
        .log().body()
        .statusCode(200)
        .contentType("application/json")
        .body("id", equalTo(1))
        .body("userId", notNullValue())
        .body("title", not(emptyOrNullString()))
        .time(lessThan(2000L)); // 2 saniyenin altında mı?   
    System.out.println("Yanıt süresi (GET): " + response.time() + " ms");     
}
}