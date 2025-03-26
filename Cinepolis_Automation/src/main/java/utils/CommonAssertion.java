package utils;

import org.testng.Assert;

public class CommonAssertion {
	

		
		public static void validateTrue(boolean flag, String failedMSG) {
			
			Assert.assertTrue(flag, failedMSG);
		}
		
		
		public static void validateFalse(boolean flag, String failedMSG) {
			Assert.assertFalse(flag, failedMSG);
		}
		
		public static void verifyEqual(String actual, String expected, String failedMsg) {
			Assert.assertEquals(actual, expected, failedMsg);
		}
		
		
		public static void verifyEqualCollection() {
			
		}
	}

