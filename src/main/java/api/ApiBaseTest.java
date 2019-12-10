package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.JsonConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiBaseTest {

	public static RequestSpecification reqSpec;
	public static ResponseSpecification resSpec;
	
	public static String livros = "livros";
	public static String adicionarLivro = "livros/adiciona";
	public static String adicionarLivros = "livros/adiciona/todos";
	public static String listarLivros = "livros/lista/todos";
	public static String adicionarAutor = "autores";
	public static String adicionarCategoria = "categorias";
	public static String limparTudo = "livros/delete/all/cascade";
	
	public static void setupRequisitions(int code) {
		RequestSpecBuilder req = new RequestSpecBuilder();
		req.log(LogDetail.ALL);
		req.setContentType(ContentType.JSON);
		req.setAccept(ContentType.JSON);
		req.setRelaxedHTTPSValidation();
		req.setBaseUri("http://127.0.0.1:8080/");

		reqSpec = req.build();

		ResponseSpecBuilder res = new ResponseSpecBuilder();
		res.expectStatusCode(code);
		res.log(LogDetail.ALL);
		resSpec = res.build();

		RestAssured.requestSpecification = reqSpec;
		RestAssured.responseSpecification = resSpec;
//		RestAssured.proxy("10.240.58.39", 8080);
		RestAssured.config = RestAssuredConfig.newConfig()
				.jsonConfig(JsonConfig.jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.BIG_DECIMAL));

	}
	
	public static void setupRequisitions() {
		setupRequisitions(200);
	}

}
