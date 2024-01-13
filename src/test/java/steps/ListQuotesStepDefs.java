package steps;

import java.util.ArrayList;
import java.util.Properties;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojo.Quote;
import pojo.QuotesPages;
import utilities.ReadPropertiesUtils;
import utilities.RestAssuredAPICalls;
import utilities.UserJsonData;

public class ListQuotesStepDefs {
	protected static String userTokenName = "User-Token";
	protected static String userSessionToken;
	protected ResponseOptions<Response> listQuotesApiResponse;

	@Given("Create a user session for {string}")
	public void create_a_user_session(String pathURL) {
		// Write code here that turns the phrase above into concrete actions
		userSessionToken = RestAssuredAPICalls.UserSessionToken(pathURL);
	}

	@When("User searches for quotes from {string}")
	public void user_searches_for_filtered_quotes_from(String pathURL) {
		listQuotesApiResponse = RestAssuredAPICalls.GetOperationWithUserToken(pathURL, ListQuotesStepDefs.userTokenName,
				ListQuotesStepDefs.userSessionToken);
	}

	@Then("User gets random list of quotes")
	public void user_gets_random_list_of_quotes() throws JsonMappingException, JsonProcessingException {
		
		//Code below is to deserialise the API response to check the Quotes
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		QuotesPages quotes = objectMapper.readValue(listQuotesApiResponse.getBody().asString(), QuotesPages.class);

		// Verify random list of quotes in a page is not more than 25
		Assert.assertTrue(quotes.getQuotes().size() <= 25);
		
		// Verify random quote body is not blank
		Assert.assertTrue("Quote should not be empty", !quotes.getQuotes().get(0).getBody().isEmpty());
	}

	@Then("User gets filtered list of quotes for {string} and {string}")
	public void user_gets_filtered_list_of_quotes(String filter, String type)
			throws JsonMappingException, JsonProcessingException {		
		
		//Code below is to deserialise the API response to check the Quotes
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		QuotesPages quotes = objectMapper.readValue(listQuotesApiResponse.getBody().asString(), QuotesPages.class);

		// Below code asserts for tag in search results should be same as tag searched by user

		if (type.contentEquals("tag")) {
			int tagCount = 0; // Temporary variable to check if searched tag is in list of tag in quote
			ArrayList<String> tagsList = quotes.getQuotes().get(1).getTags();
			for (String tagValue : tagsList) {
				if (tagValue.contains(filter)) {
					tagCount += 1;
				}
			}
			Assert.assertTrue(filter + " Filtered tag is not present in search results with tag", tagCount >= 1);
		}

		// Below code asserts for author in search results should be same as author searched by user
		if (type.contentEquals("author")) {
			String authorName = quotes.getQuotes().get(0).getAuthor();
			Assert.assertTrue(authorName + " searched is different than filtered author searched " + filter , authorName.contains(filter));
		}
		
		// Below code asserts for URL for quote saved by me as user 
		if (type.contentEquals("user")) {
			String quoteUrlSaved = "https://favqs.com/quotes/marcus-aurelius/27612-we-ought-to-d-";
			String quoteURL = quotes.getQuotes().get(0).getUrl();
			Assert.assertTrue("Quote favorited by user not shown" + filter , quoteURL.contains(quoteUrlSaved));
		}		
	}

}
