package cinepolisTest;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.APIRequest;
import utils.CommonAssertion;
import utils.UniqueGenerator;

public class TicketplusFoodbookingTest extends BaseTest {
	String testCaseKey = "GC-TC29";
	Instant startTime = Instant.now();
	String status;

	   @Test

	    public void verifyticketandfoodbooking() throws IOException {
		   try {
		Map<String, String> Actualdata = ticketplusfoodbooking.verifycinemaa();
		Map<String, String> Actualfooddata = ticketplusfoodbooking.checkforFood();
		ticketplusfoodbooking.setpersonalDetails();
		String Expectedfoodname = Actualfooddata.get("foodText");
		String Expecteditemcount = Actualfooddata.get("pcount");
		String Expectedcartfoodname = Actualfooddata.get("Cfood");
		String Expectedcartproductcount = Actualfooddata.get("Citemcount");

		CommonAssertion.verifyEqual(Actualdata.get("date"), UniqueGenerator.getcurrentDate(), "Date mismatch");
		CommonAssertion.verifyEqual(Actualfooddata.get("foodText"), Expectedcartfoodname, "Foodname mismatch");
		CommonAssertion.verifyEqual(Actualfooddata.get("pcount"), Expectedcartproductcount, "food count mismatch");
		
		status ="Pass";
	}
		   catch (Exception e) {
	            status = "Fail";
	            System.out.println("Test Failed: " + e.getMessage());
	        }
		   Instant endTime = Instant.now();
	        int executionTime = (int) Duration.between(startTime, endTime).getSeconds();
	        APIRequest.updateExecutionStatus(testCaseKey, status, executionTime);
	        Assert.assertEquals(status, "Pass", "Test failed but marked as passed!");
	   }

}
