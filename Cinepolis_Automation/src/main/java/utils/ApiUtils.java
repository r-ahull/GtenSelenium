package utils;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {

	public static Response sendPUTRequest(Map<String, Object> headers, String body, String endpoint) {
		RequestSpecification request = RestAssured.given();
		request.headers(headers);
		request.body(body);
		return request.put(endpoint);
	}
	
	public static Map<String, Object> getCommonHeaders(String token) {
		Map<String, Object> header = new HashMap<>();
		header.put("Authorization", "Bearer " + token);
		header.put("Connection", "keep-alive");
		header.put("Cache-Control", "no-cache");
		header.put("Accept", "*/*");
		header.put("Content-Type", "application/json");
		return header;
	}
}
