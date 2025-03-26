package cinepolisTest;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.APIRequest;
import utils.CommonAssertion;
import utils.TestProperties;
import utils.UniqueGenerator;

public class CinepolicinemaTest extends BaseTest {
	String testCaseKey = "GC-TC28";
	Instant startTime = Instant.now();
	String status;

	@Test
	public void verifycinematest() throws IOException {
		try {

		String Actualdate = bookticket.verifycinema();
	     Map<String, String> Actualseatdata = bookticket.verifyseatselection();
		Map<String, String> Actualmoviename = bookticket.verifymoviename();
		bookticket.setpersonalDetails();
		String Expectedmoviename = Actualmoviename.get("cartmoviename");
		String ExpectedSeatname =Actualmoviename.get("cartseatname");
		String Expecteddate = Actualseatdata.get("fDate");
		
		
		CommonAssertion.verifyEqual(Actualseatdata.get("fDate"),Expecteddate, "Date Mismatch");
		CommonAssertion.verifyEqual(Actualseatdata.get("moviename"), Expectedmoviename, "Movie name mismatch");
		CommonAssertion.verifyEqual(Actualseatdata.get("seatname"), ExpectedSeatname, "seat name mismatch");
		
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
