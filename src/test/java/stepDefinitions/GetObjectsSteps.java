package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

public class GetObjectsSteps {
    private Response response;

    @Given("que estou preparado para fazer uma requisição GET")
    public void prepararRequisicaoGET() {
        RestAssured.baseURI = "https://api.restful-api.dev";
    }

    @When("eu busco os objetos com os IDs 3, 5 e 10")
    public void buscarObjetosPorIds() {
        response = RestAssured
            .given()
            .queryParam("id", 3)
            .queryParam("id", 5)
            .queryParam("id", 10)
            .when()
            .get("/objects");
    }

    @Then("a resposta deve conter os objetos com os IDs 3, 5 e 10")
    public void verificarRespostaComIds() {
        response.then().statusCode(200);
        List<Integer> idsRetornados = response.jsonPath().getList("id", Integer.class);

        Assert.assertTrue(idsRetornados.contains(3));
        Assert.assertTrue(idsRetornados.contains(5));
        Assert.assertTrue(idsRetornados.contains(10));
    }

    @When("eu busco o objeto com o ID 7")
    public void buscarObjetosPorId() {
        response = RestAssured
                .given()
                .queryParam("id", 7)
                .when()
                .get("/objects");
    }

    @Then("a resposta deve conter o objeto com o ID 7")
    public void verificacaoRespostaComId() {
        response.then().statusCode(200);
        List<Integer> idsRetornados = response.jsonPath().getList("id", Integer.class);

        Assert.assertTrue(idsRetornados.contains(7));
    }
}
