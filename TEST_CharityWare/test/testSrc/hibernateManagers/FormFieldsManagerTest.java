package hibernateManagers;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

public class FormFieldsManagerTest {

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
		new FormFieldsManager();
		Map<Integer,List<String>> expected = new TreeMap<Integer,List<String>>();
		ArrayList<String> dataArray1 = new ArrayList<String>();
		dataArray1.add("Age");
		dataArray1.add("Text");
		dataArray1.add("String");
		dataArray1.add("true");
		expected.put(4, dataArray1);
		ArrayList<String> dataArray2 = new ArrayList<String>();
		dataArray2.add("Ethnicity");
		dataArray2.add("Text");
		dataArray2.add("String");
		dataArray2.add("true");
		expected.put(8, dataArray2);		
		Map<Integer,List<String>> actual = FormFieldsManager.retrieve(2);
		assertEquals(expected, actual);
	}

}
