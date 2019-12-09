package step;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.sun.xml.xsom.impl.scd.Iterators.Map;

import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import unittesting.ApiBaseTest;
import unittesting.DeleteMethods;
import unittesting.GetMethods;
import unittesting.PostMethods;

public class LeanFtStepDefinitions {
	private static ValidatableResponse response = null;
	
	@Dado("^que executei o metodo DELETE para limpar toda a base$")
	public static void limparBase() throws Throwable {
		DeleteMethods.deleteAll();
	}

	@Quando("^executo o metodo GET para todos os livros$")
	public static void getAPI() throws Throwable {
		response = GetMethods.getLivros();
	}

	@Quando("^executo o metodo POST para os livros$")
	public static void postCriarLivros(DataTable livros) throws Throwable {
		List<List<String>> listaLivros = livros.asLists();
		listaLivros = listaLivros.stream().collect(Collectors.toList());
		listaLivros.remove(0); //remover o cabeçalho do DataTable
		PostMethods.createLivros(listaLivros);
	}
	
	@Quando("^executo o metodo POST para os autores$")
	public static void postCriarAutores(DataTable autores) throws Throwable {
		List<List<String>> listaAutores = autores.asLists();
		listaAutores = listaAutores.stream().collect(Collectors.toList());
		listaAutores.remove(0); //remover o cabeçalho do DataTable
		PostMethods.createAutores(listaAutores);
	}
	
	@Quando("^executo o metodo POST para as categorias$")
	public static void postCriarCategorias(DataTable categorias) throws Throwable {
		List<List<String>> listaCateogrias = categorias.asLists();
		listaCateogrias = listaCateogrias.stream().collect(Collectors.toList());
		listaCateogrias.remove(0); //remover o cabeçalho do DataTable
		PostMethods.createCategorias(listaCateogrias);
	}
	
	@Dado("^que executei o metodo GET para o livro \"([^\"]*)\"$")
	public static void getLivro(String livro) throws Throwable {
		response = GetMethods.getLivro(livro);
	}
	
	@Quando("^validar esquema do JSON \"([^\"]*)\"$")
	public static void valiarEsquema(String rota) throws Throwable {
		switch (rota) {
		case "livro":
			response.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonSchemaLivro.json"));
			break;
		}
	}
	
	@Entao("^valido que o livro \"([^\"]*)\" foi criado com o autor \"([^\"]*)\" e a categoria \"([^\"]*)\"$")
	public static void validarLivroAutorCategoria(String livro, String autor, String categoria) throws Throwable {
		response.body("find{it.nome == '"+livro+"'}.autor.nome.toString()", is(autor));
		response.body("find{it.nome == '"+livro+"'}.categoria.nome.toString()", is(categoria));
	}
	
	@Entao("^valido que o preço do livro \"([^\"]*)\" tem faixa entre \"([^\"]*)\" e \"([^\"]*)\"$")
	public static void validarFaixaPreco(String livro, String valMin, String valMax) throws Throwable {
		response.body("findAll{it.preco >= "+valMin+" && it.preco <= "+valMax+"}.nome.toList()", hasItem(livro));
	}
	
	@Entao("^valido que o livro \"([^\"]*)\" tem estoque abaixo de \"([^\"]*)\"$")
	public static void validarEstoqueLivro(String livro, String valorEstoque) throws Throwable {
		response.body("find{it.nome == '"+livro+"'}.quantidadeEmEstoque.toInteger()", Matchers.lessThan(Integer.valueOf(valorEstoque)));
	}
	
	@Test
	public void teste() throws Throwable {
		String nome =  "O Menino Maluquinho";
		ApiBaseTest.setupRequisitions();
		RestAssured.given().when().get(ApiBaseTest.rotas.get("livros")+"?nome={nome}", "O Menino Maluquinho").then().extract().response().body().prettyPrint();
	}
	
}