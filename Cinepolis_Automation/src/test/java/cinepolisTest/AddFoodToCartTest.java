package cinepolisTest;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.APIRequest;
import utils.ApiPayload;
import utils.ApiUtils;
import utils.CommonAssertion;

public class AddFoodToCartTest extends BaseTest{
	String testCaseKey = "GC-TC30";
	Instant startTime = Instant.now();
    String status;
    String endPoint ="https://api-dev.gtentechnologies.com/api/v1/automation/update-test-step-status";
    String Token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwcm9qZWN0SWQiOiI3NWI5YjcwMi1iMjkyLTQ5MjUtODZiMy03MDMzYTFiNTI3OTQiLCJ1c2VySWQiOiI1OWQ1ZGZiYy01MTZlLTRiMDctODUwZC1kYTJhZmVmZmRkNjYiLCJpYXQiOjE3NDI5MTEzNzEsImV4cCI6MjA2NjkxMTM3MX0.S1jkA7OX54wMXfS8zAr2O6_9zAVTyHPTT5DXrwMWK-g";
	@Test
	
	public void verifyaddingFoodtoCart() throws IOException {
		String payLoad =ApiPayload.buildPayload("GC-TC30", "GC-C37", "Iteration 1", 1, "Pass", "Step Executed");
		ApiUtils.sendPUTRequest(ApiUtils.getCommonHeaders(Token), payLoad, endPoint);
	
		try {
		foodbookingpage.selectCinema();  
		Map<String, String> Actualdata = foodbookingpage.moveFoodtoCart();
		foodbookingpage.setpersonalDetails();
		String Expectedcartfoodname = Actualdata.get("cartfoodname");
		String Expectedcartfoodcount = Actualdata.get("productcount");
	
		CommonAssertion.verifyEqual(Actualdata.get("fooditemname"),Expectedcartfoodname, "Food name Mismatch");
		CommonAssertion.verifyEqual(Actualdata.get("pcount"), Expectedcartfoodcount, "Food count mismatch");
		
		status = "";
	}
		catch (Exception e) {
			status = "";
            System.out.println("Test Failed: " + e.getMessage());
        }
		
		Instant endTime = Instant.now();
	    int executionTime = (int) Duration.between(startTime, endTime).getSeconds();
	    APIRequest.updateExecutionStatus(testCaseKey, status, executionTime);
	    Assert.assertEquals(status, "Pass", "Test failed but marked as passed!");
	}
}
	
