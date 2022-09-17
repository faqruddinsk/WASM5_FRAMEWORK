package V_tiger;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
@Test(priority =0)
public void createCustomer() {
	System.out.println("--customer created--");
}

@Test(invocationCount =3)
public void modifyCustomer() {
	
	System.out.println("--modify customer--");

}

@Test(enabled =false)
public void deleteCustomer() {
	System.out.println("--deleted customer---");
}
@Test(dependsOnMethods ="createCustomer")
public void productAdded() {
	System.out.println("-----product added sucessfully----");
}
}
