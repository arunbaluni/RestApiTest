package steps;

import io.cucumber.java.Before;
import utilities.RestAssuredAPICalls;

public class TestInitialize {

	@Before
	public void TestSetup() {
		RestAssuredAPICalls restAssuredAPICalls = new RestAssuredAPICalls();
	}
	
}
