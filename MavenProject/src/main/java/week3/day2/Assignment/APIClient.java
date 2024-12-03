package week3.day2.Assignment;

public class APIClient {
	
	public void sendRequest(String endpoint) {
		System.out.println("Request with endpoint: " + endpoint + " sent successfully");
	}
	
	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
		if(requestStatus)
			System.out.println("Request with endpoint: " + endpoint + "\nand body: \n" + requestBody + "\nsent successfully");
		else
			System.out.println("Request failed");
	}
	
	public static void main(String[] args) {
		APIClient client = new APIClient();
		client.sendRequest("/user/1");
		client.sendRequest("/user/2", "{ user: 2, firstName:john, lastName:doe }", true);
	}
}
