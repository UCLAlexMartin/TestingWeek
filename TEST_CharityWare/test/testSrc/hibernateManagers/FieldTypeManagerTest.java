package hibernateManagers;

import static org.junit.Assert.*;

import hibernateEntities.FieldType;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ConnectionManager.class })
public class FieldTypeManagerTest {

	private static final FieldType FieldType = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Configuration config = new AnnotationConfiguration();
		config.configure(new File(
				".\\test\\testSrc\\resources\\hibernate.cfg.xml"));
		SessionFactory factory = config.buildSessionFactory();
		Session hibernateSession = factory.openSession();

		ConnectionManager.setFactory(factory);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		new FieldTypeManager();
		FieldType expected = new FieldType();
		expected.setField_type("Text");
		expected.setField_dataType("String");
		FieldType actual= FieldTypeManager.getFieldType(1);
		assertEquals(expected.getField_type(),actual.getField_type());
		assertEquals(expected.getField_dataType(),actual.getField_dataType());
	}

}
