package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredAPICalls;
import utilities.UserJsonData;
import org.junit.Assert;

public class FavQuoteStepDefs {
	protected static String userTokenName = "User-Token";
	protected static String userSessionToken;
	protected ResponseOptions<Response> favQuoteApiResponse;

	@Given("Create a user session for {string} with {string} and {string}")
	public void create_a_user_session_for_with_and(String pathURL) {
		// Write code here that turns the phrase above into concrete actions
		userSessionToken = RestAssuredAPICalls.UserSessionToken(pathURL);
	}

	@When("User sets quote {string} to favorite")
	public void user_sets_quote_to_favorite(String pathURL) {
		// Write code here that turns the phrase above into concrete actions
		favQuoteApiResponse = RestAssuredAPICalls.PutOperationWithUserToken(pathURL, FavQuoteStepDefs.userTokenName,
				FavQuoteStepDefs.userSessionToken);
	}

	@Then("favorite is marked {string} in API response for quote")
	public void favorite_is_marked_in_api_response(String favoriteAdded) {
		// Write code here that turns the phrase above into concrete actions
		if (favoriteAdded.equals("true")) {
			String isFavoriteSetTrue = favQuoteApiResponse.getBody().jsonPath().getString("user_details.favorite");
			Assert.assertEquals(isFavoriteSetTrue, "true");
		} else {
			Assert.assertTrue(Integer.toString(favQuoteApiResponse.getStatusCode())!="200");
		}
	}
	
	

	@Then("favorite is set {string} in API response for quote")
	public void favorite_is_unmarked_in_api_response(String favorite) {
		// Write code here that turns the phrase above into concrete actions
		if (favorite.equals("false")) {
			String isFavoriteSetTrue = favQuoteApiResponse.getBody().jsonPath().getString("user_details.favorite");
			Assert.assertEquals(isFavoriteSetTrue, "false");
		} else {
			Assert.assertEquals(Integer.toString(favQuoteApiResponse.getStatusCode()), favorite);
		}
	}
}
