package utils;

public class ApiPayload {
	
	public static String buildPayload(String testcaseKey, String testcycle, String iteration, int sNo, String status, String actualResult) {
        return "{"
                + "\"testcaseKey\": \"" + testcaseKey + "\","
                + "\"testcycle\": \"" + testcycle + "\","
                + "\"iteration\": \"" + iteration + "\","
                + "\"steps\": ["
                + "{"
                + "\"sNo\": " + sNo + ","
                + "\"status\": \"" + status + "\","
                + "\"actualResult\": \"" + actualResult + "\""
                + "}"
                + "]"
                + "}";
    }
}
