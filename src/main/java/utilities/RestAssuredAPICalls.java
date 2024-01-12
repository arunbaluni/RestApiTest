package utilities;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class RestAssuredAPICalls {
	public static RequestSpecification Request;

	public RestAssuredAPICalls() {
		Request = null;
	}

	public static void setRequestSpec(String url) {
		// Arrange (setup request)
		RequestSpecBuilder builder = new RequestSpecBuilder();
		String baseURL = ReadPropertiesUtils.GetBaseURL();
		builder.setBaseUri(baseURL);
		builder.setBasePath(url);
		String token = ReadPropertiesUtils.GetToken();
		builder.addHeader("Authorization", token);
		builder.setContentType(ContentType.JSON);
		RequestSpecification requestSpecification = builder.build();
		Request = RestAssured.given().spec(requestSpecification);
	}

	public static ResponseOptions<Response> PostOperationWithBody(String url, String body) {
		setRequestSpec(url);
		Request.body(body);
		return Request.post();
	}

	public static ResponseOptions<Response> PutOperationWithUserToken(String pathURL, String user_token_name,
			String userToken) {
		setRequestSpec(pathURL);
		Request.header(user_token_name, userToken);
		return Request.put();
	}

	public static ResponseOptions<Response> GetOperationWithUserToken(String pathURL, String user_token_name,
			String userToken) {
		setRequestSpec(pathURL);
		Request.header(user_token_name, userToken);
		return Request.get();
	}


}