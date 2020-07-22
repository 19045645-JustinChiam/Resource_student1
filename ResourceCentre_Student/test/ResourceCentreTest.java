import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void addCamcorderTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
	public void addChromebookTest() {
		//fail("Not yet implemented");
//<<<<<<< HEAD
//		// write your code here.
//=======
		// write your code here
		// Item list is not null, so that can add a new item
				assertNotNull("Test if there is valid ChromebookTest arraylist to add to", camcorderList);
				
				//Given an empty list, after adding 1 item, the size of the list is 1
				ResourceCentre.addCamcorder(camcorderList, cc1);		
				assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
				
				//The item just added is as same as the first item of the list
				assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
				
				//Add another item. test The size of the list is 2?
				ResourceCentre.addCamcorder(camcorderList, cc2);
				assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
//>>>>>>> branch 'master' of https://github.com/19045645-JustinChiam/Resource_student1.git
	}
	
	@Test
	public void retrieveAllCamcorderTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
		
		
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void retrieveAllChromebookTest() {
		// write your code here
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
		String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allChromebook);
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());
		allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB001", "ASUS Chromebook", "Yes", "", "Win 10");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB002", "HP Chromebook", "Yes", "", "Win 10");
		
		assertEquals("Check that ViewAllChromebook", testOutput, allChromebook);
	}

	@Test
	public void doLoanCamcorderTest() {
		//fail("Not yet implemented");
		// write your code here
		//test
	}
	
	@Test
	public void doLoanChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
	}
	
	@Test
	public void doReturnCamcorderTest() {
		//fail("Not yet implemented");
		// write your code here
		
	}
	@Test
	public void doReturnChromebookTest() {
		// Normal Condition hi
		chromebookList.get(0).setIsAvailable(false);
		ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
		ResourceCentre.returnChromeBook(chromebookList);
		assertTrue("When user enters the Asset tagNumber CB0011 to return the chromebook which "
				+ "was loan the system will update the table in which setIsAvailable is true and the due date will be an empty string "
				+ "and display the message Chromebook CB0011 Updated.", true);
		
		
		
		
		// Error Condition

		ResourceCentre.doReturnChromebook(chromebookList, "CB00567");
		ResourceCentre.returnChromeBook(chromebookList);
		assertFalse("When the user enters the Asset Tagnumber CB00567 to return the chromebook," + 
				"the system will display �Invalid asset tag� and returns to the main menu page.", false);
		

		
		
		//Boundary Condition
		//When user enters the Asset tagnumber CB0011 to return the chromebook which was not loaned made 
		//available the system will display �Invalid asset tag.�
		chromebookList.get(0).setIsAvailable(true);
		ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
		ResourceCentre.returnChromeBook(chromebookList);
		assertFalse("When user enters the Asset tagnumber CB0011 to return the chromebook which was not loaned made" + 
				"available the system will display �Invalid asset tag.", false);
		

		
		
		

		
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
