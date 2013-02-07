/**
 * 
 */
package hibernateManagers;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
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
		Configuration config = new AnnotationConfiguration();
		config.configure(new File(
				".\\test\\testSrc\\resources\\hibernate.cfg.xml"));
		
		SessionFactory factory = config.buildSessionFactory();
		Session hibernateSession = factory.openSession();

		TestManager.setFactory(factory);
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
	 * Test that the getter and setter methods are working.
	 */
	public void testSessionBranch() {
		ConnectionManagerV2 TestManager2 = new ConnectionManagerV2();
		TestManager2.setFactory(null);
		TestManager2.setDBConfname("hibernate.cfg.xml");		
		ArrayList<User> Alex = (ArrayList<User>)TestManager2.getTable("User");
		assertNotNull("Session branch 2",Alex);
		}
	
	@Test
	/**
	 * Test that the get table statement is working.
	 */
	public void testGetTable() {
		ArrayList<User> Alex = (ArrayList<User>)TestManager.getTable("User");
		assertNotNull("Get Table Working",Alex);
	}
		

	

}
