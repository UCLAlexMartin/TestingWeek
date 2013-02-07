/**
 * 
 */
package hibernateManagers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hibernateEntities.*;

/**
 * @author Alex
 *
 */
public class ConnectionManagerV2Test {
	
	public ConnectionManagerV2 TestManager;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		TestManager = new ConnectionManagerV2();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	/**
	 * Test that the getter and setter methods are working.
	 */
	public void testGetSet() {
		String ConfName = "hibernate.cfg.xml";
		TestManager.setDBConfname("hibernate.cfg.xml");		
		assertEquals("Getter and Setter working",ConfName,TestManager.getDBConfname());
	}
	
	@Test
	/**
	 * Test that the get table statement is working.
	 */
	public void testGetTable() {
		TestManager.setDBConfname("hibernate.cfg.xml");	
		ArrayList<User> Alex = (ArrayList<User>)TestManager.getTable("User");
		assertNotNull("Get Table Working",Alex);
	}
		

	

}
