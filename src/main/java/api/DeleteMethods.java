package api;

import static io.restassured.RestAssured.given;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import io.restassured.response.ValidatableResponse;

public class DeleteMethods {

	
	public static void deleteLivro(int idLivro) throws ReportException {
		ApiBaseTest.setupRequisitions();	
		
		ValidatableResponse res = given().when().delete(ApiBaseTest.livros+"/"+idLivro).then();
		Reporter.reportEvent("Livro deletado:"+res.extract().response().body().prettyPrint(), res.extract().response().getStatusLine());
	}
	
	public static void deleteLivro(String nome) throws Throwable {
		ApiBaseTest.setupRequisitions();	
		ValidatableResponse resGet = GetMethods.getLivro(nome);
		String idLivro = resGet.extract().response().body().jsonPath().getString("idLivro");
		ValidatableResponse res = given().when().delete(ApiBaseTest.livros+"/"+idLivro).then();
		Reporter.reportEvent("Livro deletado:"+res.extract().response().body().prettyPrint(), res.extract().response().getStatusLine());
	}
	
	public static void deleteAll() throws Throwable {
		ApiBaseTest.setupRequisitions();	
		given().when().delete(ApiBaseTest.limparTudo).then();
	}
	
}