package api;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class GetMethods {

	public static ValidatableResponse getComment(String name) throws Throwable {
		ApiBaseTest.setupRequisitions();
		return RestAssured.given().when().get(ApiBaseTest.comments+"?name={nome}", name).then();
	}
	
	public static ValidatableResponse getComments() throws Throwable {
		ApiBaseTest.setupRequisitions();
		return RestAssured.given().when().get(ApiBaseTest.comments).then();
	}

}