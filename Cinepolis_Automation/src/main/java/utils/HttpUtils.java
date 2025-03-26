package utils;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

	    public static void sendPutRequest(String urlString, String jsonBody, String authToken) {
	        HttpURLConnection connection = null;
	        try {
	            URL url = new URL(urlString);
	            connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("PUT");
	            connection.setRequestProperty("Content-Type", "application/json");
	            connection.setRequestProperty("Authorization", "Bearer " + authToken);
	            connection.setDoOutput(true);

	          
	            try (OutputStream os = connection.getOutputStream()) {
	                byte[] input = jsonBody.getBytes("utf-8");
	                os.write(input, 0, input.length);
	            }

	            
	            int responseCode = connection.getResponseCode();
	            if (responseCode == 200) {
	                System.out.println("✅ Test Step Status Updated Successfully");
	            } else {
	                System.out.println("❌ Failed to update test step status. Response Code: " + responseCode);
	            }

	        } catch (Exception e) {
	            System.out.println("❌ Error in API Request: " + e.getMessage());
	        } finally {
	            if (connection != null) {
	                connection.disconnect();
	            }
	        }
	    }
	}

