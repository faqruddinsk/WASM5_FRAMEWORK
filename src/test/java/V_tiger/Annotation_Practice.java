package V_tiger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotation_Practice {
@BeforeSuite
public void bfrsuite() {
	System.out.println("before suite");
}
@BeforeClass
public void bfrclass() {
	System.out.println("before class");
}
@BeforeMethod
public void bfrmethod() {
	System.out.println("before method");
}
@Test
public void test1() {
	System.out.println("test-1");
}
@Test
public void test2() {
	System.out.println("test-2");
}


@AfterMethod
public void aftmetho() {
	System.out.println("after method");
}
@AfterClass
public void aftclass() {
	System.out.println("after class");
}
@AfterSuite
public void aftsuite() {
	System.out.println("after suite");
}
}
