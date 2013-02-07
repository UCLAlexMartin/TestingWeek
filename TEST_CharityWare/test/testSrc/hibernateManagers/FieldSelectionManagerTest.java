package hibernateManagers;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Zhe Wei
 *
 */
public class FieldSelectionManagerTest {

	@Before
	public void setUp() throws Exception {
		Configuration config = new AnnotationConfiguration();
		config.configure(new File(
				".\\test\\testSrc\\resources\\hibernate.cfg.xml"));
		SessionFactory factory = config.buildSessionFactory();
		Session hibernateSession = factory.openSession();

		ConnectionManager.setFactory(factory); 
		// cannot be changed to ConnectionManagerV2, no such method
	}
	@Test
	public void testGetValuesFirst() {
		Integer field_id = new Integer(1);
		ArrayList<String> result = FieldSelectionManager.getValues(field_id);
		
		assertEquals("Male",result.get(0)); 
	}	
	
	@Test
	public void testGetValuesSecond() {
		Integer field_id = new Integer(3);
		ArrayList<String> result = FieldSelectionManager.getValues(field_id);
		
		assertEquals("American Indian",result.get(0)); 
	}
	
	@Test
	public void testGetValuesLast() {
		Integer field_id = new Integer(15);
		ArrayList<String> result = FieldSelectionManager.getValues(field_id);
		
		assertEquals("NA",result.get(0)); 
	}	
}
