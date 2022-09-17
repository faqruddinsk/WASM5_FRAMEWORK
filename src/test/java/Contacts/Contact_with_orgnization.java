package Contacts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Vtiger.GenericUtility.BaseClass;
import VtigerObjectRepository.ContactsInfoPage;
import VtigerObjectRepository.ContactsPage;
import VtigerObjectRepository.CreateNewContactPage;
import VtigerObjectRepository.CreateNewOrganizationPage;
import VtigerObjectRepository.HomePage;
import VtigerObjectRepository.OrganizationInfoPage;
import VtigerObjectRepository.OrganizationsPage;

/**
 * @author shaik
 */
@Listeners(Vtiger.GenericUtility.ListenerImplementation.class)
public class Contact_with_orgnization extends BaseClass{
	
	@Test
public void createContactWithOrgTest() throws Throwable {
	
	//step-2: read all required data
	String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 3);
	String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 2)+jUtil.getRandomNumber();
	
	
	//navigate to organization
	HomePage hp=new HomePage(driver);
	hp.clickOnOrgLink();
	Reporter.log("--clicked on organization--");
	
	//click on create organization link
	OrganizationsPage org=new OrganizationsPage(driver);
	org.clickOnCreateNewOrgImg();
	Reporter.log("--clicked on New-org-img--");
	
	//create new organization and save it
	CreateNewOrganizationPage cro=new CreateNewOrganizationPage(driver);
	cro.craeteNewOrg(ORGNAME);
	Reporter.log("---organization successfully created---");
	
	//validate 
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String orgheadertext = oip.getOrgHeader();
    /* if(orgheadertext.contains(ORGNAME)) {
    	 System.out.println("orgnization created");
     }else {
    	 System.out.println("not created organization");
     }*/
	//Assert.fail();
	Assert.assertEquals(orgheadertext.contains(ORGNAME), true);
	
	//navigate to contacts
     hp.clickOnContactLink();
     Reporter.log("--navigate to contacts---");
     
     //click on create new contact imp
     ContactsPage cp=new ContactsPage(driver);
     cp.clickOnCreateNewContImg();
     Reporter.log("--clicked on new contact img--");
    
     //create new contact with org name
     CreateNewContactPage cnp=new CreateNewContactPage(driver);
     cnp.createNewContact(LASTNAME, ORGNAME, driver);
     Reporter.log("--contact created successfully---");
     
     
     //validation
     ContactsInfoPage cip=new ContactsInfoPage(driver);
    String contactheadertext = cip.getContactHeader();
    /* if(contactheadertext.contains(LASTNAME)) {
    	 System.out.println("test case pass"); 
     }else {
    	 System.out.println("fail");
     }*/
    Assert.assertTrue(contactheadertext.contains(LASTNAME));
     	
}
}
