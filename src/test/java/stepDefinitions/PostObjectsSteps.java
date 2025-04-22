package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class PostObjectsSteps {

    private Response response;

    @Given("que estou preparado para fazer uma requisição POST")
    public void prepararRequisicaoPOST() {
        RestAssured.baseURI = "https://api.restful-api.dev";
    }

    @When("eu envio os dados com o objeto Gal teste")
    public void enviarDados() {
        String corpoJson = "{"
                + "\"name\": \"Gal teste\","
                + "\"data\": {"
                +     "\"year\": 2019,"
                +     "\"price\": 1849.99,"
                +     "\"CPU model\": \"Intel Core i9\","
                +     "\"Hard disk size\": \"1 TB\""
                + "}"
                + "}";

        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(corpoJson)
                .when()
                .post("/objects");
    }

    @Then("a resposta deve conter o status 200 e o nome \"Gal teste\"")
    public void verificarResposta() {
        response.then().statusCode(200);

        String nomeRetornado = response.jsonPath().getString("name");
        Assert.assertEquals("Gal teste", nomeRetornado);
    }

    @When("eu envio os dados com o objeto 2020")
    public void enviarDado() {
        String corpoJson = "{"
                + "\"name\": \"Gal teste\","
                + "\"data\": {"
                +     "\"year\": 2020,"
                +     "\"price\": 1849.99,"
                +     "\"CPU model\": \"Intel Core i9\","
                +     "\"Hard disk size\": \"1 TB\""
                + "}"
                + "}";

        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(corpoJson)
                .when()
                .post("/objects");
    }

    @Then("a resposta deve conter o status 200 e o ano 2020")
    public void verificarRespostas() {
        response.then().statusCode(200);

        String anoRetornado = response.jsonPath().getString("data.year");
        Assert.assertEquals("2020", anoRetornado);
    }

    @When("eu envio dados inválidos para o endpoint")
    public void enviarDadosInvalidos(){
        String corpoJson = "{"
                + "\"name\": \"Gal teste\","
                + "}";

        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(corpoJson)
                .when()
                .post("/objects");
    }

    @When("a resposta deve conter o status 400")
    public void validarStatus400(){
        response.then().statusCode(400);
    }

}
