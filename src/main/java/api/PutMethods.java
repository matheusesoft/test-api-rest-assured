package api;

import static io.restassured.RestAssured.given;

import io.restassured.response.ValidatableResponse;

public class PutMethods {

	public static ValidatableResponse updateLatLngUser(int idUser, String lat, String lng) {
		ApiBaseTest.setupRequisitions();
		String userJson = RepositoryJSON.updateLatLngUser(lat, lng);
		return given().body(userJson.toString()).when().put(ApiBaseTest.users+"/"+idUser).then();
	}

}