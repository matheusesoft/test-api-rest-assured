package api;

import static io.restassured.RestAssured.given;

import java.util.List;
import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import io.restassured.response.ValidatableResponse;

public class PostMethods {

	public static void createLivro(String nome, String quantidadeDePaginas, String dataDeLancamento, String autorNome,
			String categoriaNome, int quantidadeEmEstoque, double preco, String isbn) throws ReportException {
		ApiBaseTest.setupRequisitions(201);

		String livroJson = RepositoryJSON.getCreateLivroJson(nome, quantidadeDePaginas, dataDeLancamento, autorNome,
				categoriaNome, quantidadeEmEstoque, preco, isbn);

		ValidatableResponse res = given().body(livroJson.toString()).when().post(ApiBaseTest.adicionarLivro)
				.then();
		Reporter.reportEvent("Livro gerado : " + res.extract().response().body().prettyPrint(),
				res.extract().response().getStatusLine());
	}

	public static void createLivros(final List<List<String>> listaLivros) throws ReportException {
		ApiBaseTest.setupRequisitions(200);

		String livrosJson = "[";
		for (int i = 0; i < listaLivros.size(); i++) {
			List<String> list = listaLivros.get(i);
			livrosJson += RepositoryJSON.getCreateLivroJson(list.get(0), list.get(1), list.get(2), list.get(3),
					list.get(4), Integer.valueOf(list.get(5)), Double.valueOf(list.get(6)), list.get(7));
			if(i<listaLivros.size()-1) {
				livrosJson += ",";
			}
		}
		livrosJson += "]";

		ValidatableResponse res = given().body(livrosJson.toString()).when()
				.post(ApiBaseTest.adicionarLivros).then();

		Reporter.reportEvent("Livros gerados: " + res.extract().response().body().prettyPrint(),
				res.extract().response().getStatusLine());
	}

	public static void createAutores(final List<List<String>> listaAutores) throws ReportException {
		ApiBaseTest.setupRequisitions(201);
		
		String autorJson;
		for (List<String> list : listaAutores) {
			autorJson = RepositoryJSON.getCreateAutorJson(list.get(0), list.get(1), list.get(2), list.get(3));
			ValidatableResponse res = given().body(autorJson.toString()).when().post(ApiBaseTest.adicionarAutor).then();
			Reporter.reportEvent("Autor gerado: " + res.extract().response().body().prettyPrint(), res.extract().response().getStatusLine());
		}

	}
	
	public static void createCategorias(final List<List<String>> listaCategorias) throws ReportException {
		ApiBaseTest.setupRequisitions(201);
		
		String categoriaJson;
		for (List<String> list : listaCategorias) {
			categoriaJson = RepositoryJSON.getCreateCategoriaJson(list.get(0), list.get(1));
			ValidatableResponse res = given().body(categoriaJson.toString()).when().post(ApiBaseTest.adicionarCategoria).then();
			Reporter.reportEvent("Categoria gerada: " + res.extract().response().body().prettyPrint(), res.extract().response().getStatusLine());
		}

	}

}