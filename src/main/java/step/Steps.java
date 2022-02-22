package step;

import static org.hamcrest.Matchers.*;

import java.util.List;

import org.hamcrest.Matchers;

import api.GetMethods;
import api.PostMethods;
import api.PutMethods;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.cucumber.datatable.DataTable;
import io.restassured.response.ValidatableResponse;

public class Steps {
	private static ValidatableResponse response = null;
	
	@Dado("^que executei o metodo GET para todos os comentarios$")
	public static void getComentarios() throws Throwable {
		response = GetMethods.getComments();
	}

	@Dado("^que executo o metodo POST para o user$")
	public void executo_o_metodo_POST_para_o_user(DataTable dataTable) {
		List<String> camposUser = dataTable.asLists().get(0);
		response = PostMethods.createUser(camposUser.get(0), camposUser.get(1), camposUser.get(2));
	}
	
	@Dado("que executo o metodo PUT para o user de id {int} alterando a lat para {string} e lng para {string}")
	public void alterar_user(Integer id, String lat, String lng) {
		response = PutMethods.updateLatLngUser(id, lat, lng);
	}
	
	@Dado("^que executei o metodo GET para o comentario \"([^\"]*)\"$")
	public static void getComentario(String name) throws Throwable {
		response = GetMethods.getComment(name);
	}
	
	@Quando("valido o status code igual a {int}")
	public void valido_o_status_code_igual_a(Integer statusCode) {
		response.statusCode(equalTo(statusCode));
	}
	
	@Entao("^email do autor do comentario deve ser igual a \"([^\"]*)\"$")
	public static void validarEmailComentario(String email) {
		response.body("[0].email.toString()", is(email));
	}
	
	@Entao("^id gerado para o usuario e valido$")
	public static void validarIdGerado() {
		response.body("id", notNullValue());
	}
	
	@Entao("valido lat igual a {string} e lng igual {string}")
	public void alterar_user(String lat, String lng) {
		response.body("address.geo.lat.toString()", is(lat));
		response.body("address.geo.lng.toString()", is(lng));
	}
}