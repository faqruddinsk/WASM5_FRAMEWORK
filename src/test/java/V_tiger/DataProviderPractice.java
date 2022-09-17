package V_tiger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
@Test(dataProvider="data")
public void addProductToCart(String name,String model,int price,String feature,int qty ) {
	System.out.println(name+"-"+model+"-"+price+"-"+feature+"-"+qty);
}

@DataProvider
public Object[][] data(){
	                     //row//column
	Object[][] d=new Object[4][5];
	
	d[0][0]="samsung";
	d[0][1]="a65";
	d[0][2]=4000;
	d[0][3]="display";
	d[0][4]=12;
	
	d[1][0]="vivo";
	d[1][1]="s1pro";
	d[1][2]=8000;
	d[1][3]="camera";
	d[1][4]=11;
	
	d[2][0]="i-phone";
	d[2][1]="13 pro";
	d[2][2]=21000;
	d[2][3]="processer";
	d[2][4]=21;
	
	d[3][0]="oppo";
	d[3][1]="a5";
	d[3][2]=40200;
	d[3][3]="games";
	d[3][4]=7;
	
	return d;
	
}
}
