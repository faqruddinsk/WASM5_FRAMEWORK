package Vtiger_Practice;

import org.apache.hc.core5.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice {
	
@Test
	public void assertPracticeTest() {
		System.out.println("==step-1 ==");
		System.out.println("==step-2 ==");
		Assert.assertEquals(false, true);
		System.out.println("==step-3 ==");
		Assert.fail();
		System.out.println("==step-4 ==");
		System.out.println("==step-5 ==");
	}

@Test
public void assertPracticeTest2() {
	SoftAssert sa=new SoftAssert();
	System.out.println("=Test 2 of step-1 ==");
	System.out.println("=Test 2 of step-2 ==");
	sa.assertEquals(0, 0);
	System.out.println("=Test 2 of step-3 ==");
	System.out.println("=Test 2 of step-4 ==");
	sa.assertEquals("ab", "ba");
	System.out.println("=Test 2 of step-5 ==");
	sa.assertAll();
}


}
