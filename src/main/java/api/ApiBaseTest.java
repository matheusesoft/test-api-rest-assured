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
	
	public static String comments = "comments";
	public static String users = "users";
	
	public static void setupRequisitions() {
		RequestSpecBuilder req = new RequestSpecBuilder();
		req.log(LogDetail.ALL);
		req.setContentType(ContentType.JSON);
		req.setAccept(ContentType.JSON);
		req.setRelaxedHTTPSValidation();
		req.setBaseUri("https://jsonplaceholder.typicode.com/");

		reqSpec = req.build();

		ResponseSpecBuilder res = new ResponseSpecBuilder();
		res.log(LogDetail.ALL);
		resSpec = res.build();

		RestAssured.requestSpecification = reqSpec;
		RestAssured.responseSpecification = resSpec;
		RestAssured.config = RestAssuredConfig.newConfig()
				.jsonConfig(JsonConfig.jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.BIG_DECIMAL));

	}

}
