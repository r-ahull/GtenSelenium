package utils;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class APIRequest{

	private static final String BASE_URL = "https://api-dev.gtentechnologies.com/api/v1/projects/automation/update-test-status"; 
    private static final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwcm9qZWN0SWQiOiI3NWI5YjcwMi1iMjkyLTQ5MjUtODZiMy03MDMzYTFiNTI3OTQiLCJ1c2VySWQiOiI1OWQ1ZGZiYy01MTZlLTRiMDctODUwZC1kYTJhZmVmZmRkNjYiLCJpYXQiOjE3NDI5MTEzNzEsImV4cCI6MjA2NjkxMTM3MX0.S1jkA7OX54wMXfS8zAr2O6_9zAVTyHPTT5DXrwMWK-g"; 
    private static final String TEST_CYCLE = "GC-C37";
    private static final String ITERATION = "Iteration 1";
    private static final String STEP_STATUS_URL = "https://api-dev.gtentechnologies.com/api/v1/automation/update-test-step-status";
    public static void updateExecutionStatus(String testCaseKey, String status, int executionTime) {
        try {
            JSONObject requestBody = new JSONObject();
            JSONArray testCasesArray = new JSONArray();

            JSONObject testCaseObject = new JSONObject();
            testCaseObject.put("testcaseKey", testCaseKey);
            testCaseObject.put("status", status);
            testCaseObject.put("executionTime", executionTime);

            testCasesArray.put(testCaseObject);
            requestBody.put("testcases", testCasesArray);
            requestBody.put("testcycle", TEST_CYCLE);
            requestBody.put("iteration", ITERATION);

            RequestSpecification request = RestAssured.given()
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + API_KEY) 
                    .body(requestBody.toString());

            io.restassured.response.Response response = request.put(BASE_URL);

            System.out.println("Response Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody().asString());

            if (response.getStatusCode() == 200) {
                System.out.println("✅ Execution status updated successfully for Test Case: " + testCaseKey);
            } else {
                System.out.println("❌ Failed to update execution status: " + response.getStatusLine());
            }
        } catch (Exception e) {
            System.out.println("⚠️ API Error: " + e.getMessage());
        }
    }
    private static final String BASEURL = "https://api-dev.gtentechnologies.com/api/v1/automation/update-test-step-status";
    private static final String AUTH_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwcm9qZWN0SWQiOiI3NWI5YjcwMi1iMjkyLTQ5MjUtODZiMy03MDMzYTFiNTI3OTQiLCJ1c2VySWQiOiI1OWQ1ZGZiYy01MTZlLTRiMDctODUwZC1kYTJhZmVmZmRkNjYiLCJpYXQiOjE3NDI5MTEzNzEsImV4cCI6MjA2NjkxMTM3MX0.S1jkA7OX54wMXfS8zAr2O6_9zAVTyHPTT5DXrwMWK-g";

    public static void updateTestStepStatus(String testCaseKey, String testCycle, String iteration, List<Map<String, Object>> steps) {
        try {
            JSONObject requestBody = new JSONObject();
            requestBody.put("testcaseKey", testCaseKey);
            requestBody.put("testcycle", testCycle);
            requestBody.put("iteration", iteration);

            JSONArray stepsArray = new JSONArray();
            for (Map<String, Object> step : steps) {
                JSONObject stepObj = new JSONObject(step);
                stepsArray.put(stepObj);
            }
            requestBody.put("steps", stepsArray);

            HttpUtils.sendPutRequest(BASE_URL, requestBody.toString(), AUTH_TOKEN);
        } catch (Exception e) {
            System.out.println("Error updating test step status: " + e.getMessage());
        }
    }
}
