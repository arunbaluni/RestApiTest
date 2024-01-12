package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class UserJsonData {
	public UserJsonData() {
	}
	
public static String getUserJsonData(String login, String password) throws Exception {
	// Create Object Mapper
	ObjectMapper objectMapper = new ObjectMapper();
	
	// Create ObjectNode for User
	ObjectNode userNode = objectMapper.createObjectNode();
	
	userNode.put("login", login);
	userNode.put("password", password);
	
	ObjectNode rootNode = objectMapper.createObjectNode();
	rootNode.set("user", userNode);
	
	String jsonString = objectMapper.writeValueAsString(rootNode);
	return jsonString;
	
}
}
