package api;

import static io.restassured.RestAssured.given;

import io.restassured.response.ValidatableResponse;

public class PostMethods {

	public static ValidatableResponse createUser(String name, String username, String email) {
		ApiBaseTest.setupRequisitions();
		String userJson = RepositoryJSON.getCreateUser(name, username, email);
		return given().body(userJson.toString()).when().post(ApiBaseTest.users).then();
	}

}