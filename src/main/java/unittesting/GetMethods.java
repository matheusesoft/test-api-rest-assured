package unittesting;

import com.hp.lft.report.Reporter;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class GetMethods {

	public static ValidatableResponse getLivro(String nome) throws Throwable {
		ApiBaseTest.setupRequisitions();
		ValidatableResponse res = RestAssured.given().when().get(ApiBaseTest.rotas.get("livros")+"?nome={nome}", nome).then();
		Reporter.reportEvent(res.extract().response().body().prettyPrint(), res.extract().response().getStatusLine());
		return res;
	}
	
	public static ValidatableResponse getLivros() throws Throwable {
		ApiBaseTest.setupRequisitions();
		ValidatableResponse res = RestAssured.given().when().get(ApiBaseTest.rotas.get("livros-lista-todos")).then();
		Reporter.reportEvent(res.extract().response().body().prettyPrint(), res.extract().response().getStatusLine());
		return res;
	}

}