package api;

public class RepositoryJSON {	
	
	public static String getCreateUser(String name, String username, String email) {
		String createUserJson = ""
				+ " {" + 
				"    \"name\": \""+name+"\"," + 
				"    \"username\": \""+username+"\"," + 
				"    \"email\": \""+email+"\"," + 
				"    \"address\": {" + 
				"      \"street\": \"Kulas Light\"," + 
				"      \"suite\": \"Apt. 556\"," + 
				"      \"city\": \"Gwenborough\"," + 
				"      \"zipcode\": \"92998-3874\"," + 
				"      \"geo\": {" + 
				"        \"lat\": \"-37.3159\"," + 
				"        \"lng\": \"81.1496\"" + 
				"      }" + 
				"    }," + 
				"    \"phone\": \"1-770-736-8031 x56442\"," + 
				"    \"website\": \"hildegard.org\"," + 
				"    \"company\": {" + 
				"      \"name\": \"Romaguera-Crona\"," + 
				"      \"catchPhrase\": \"Multi-layered client-server neural-net\"," + 
				"      \"bs\": \"harness real-time e-markets\"" + 
				"    }" + 
				"  }";
		return createUserJson;
	}	
	
	public static String updateLatLngUser(String lat, String lng) {
		String updateJson = ""
				+ " {" + 
				"    \"address\": {" + 
				"      \"geo\": {" + 
				"        \"lat\": \""+lat+"\"," + 
				"        \"lng\": \""+lng+"\"" + 
				"      }" + 
				"    }" + 
				"  }";
		return updateJson;
	}	
	
}