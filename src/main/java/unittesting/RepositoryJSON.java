package unittesting;

import java.util.HashMap;
import java.util.Map;

public class RepositoryJSON {	
	
	public static String getCreateLivroJson(String nome, String quantidadeDePaginas, String dataDeLancamento, String autorNome, String categoriaNome, int quantidadeEmEstoque, double preco, String isbn) {
		String createLivroJson = ""
				+ "{" + 
				"        \"nome\": \""+nome+"\"," + 
				"        \"quantidadeDePaginas\": "+quantidadeDePaginas+"," + 
				"        \"dataDeLancamento\": \""+dataDeLancamento+"\"," + 
				"        \"autor\": {" + 
				"            \"nome\": \""+autorNome+"\"" + 
				"        }," + 
				"        \"categoria\": {" + 
				"            \"nome\": \""+categoriaNome+"\"" + 
				"        }," + 
				"        \"quantidadeEmEstoque\": "+quantidadeEmEstoque+"," + 
				"        \"preco\": "+preco+"," + 
				"        \"isbn\": \""+isbn+"\"" + 
				"    }";
		return createLivroJson;
	}	
	
	public static String getCreateAutorJson(String nome, String email, String dataDeNascimento, String sobre) {
		String createAutorJson = ""
				+ "	{" + 
				"      \"nome\": \""+nome+"\"," + 
				"      \"email\": \""+email+"\"," + 
				"      \"dataDeNascimento\": \""+dataDeNascimento+"\"," + 
				"      \"sobre\": \""+sobre+"\"" + 
				"	}";
		return createAutorJson;
	}	
	
	public static String getCreateCategoriaJson(String nome, String descricao) {
		String createCategoriaJson = ""
				+ "	{" + 
				"      \"nome\": \""+nome+"\"," + 
				"      \"descricao\": \""+descricao+"\"" + 
				"	}";
		return createCategoriaJson;
	}	
}