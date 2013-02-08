package hibernateManagers;

import static org.junit.Assert.*;

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

public class FilledFormManagerTest {

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
	public void testFilledFormManager() {
		String actual = FilledFormManager.getRecordsData();
		String expected = "[[\"amartin\",2],[\"asood\",2],[\"iblue\",4],[\"mnajim\",3],[\"wbalasundaram\",2],[\"yfarrugia\",5]]";
		System.out.println(actual);
		assertEquals(expected, actual);
	}

}
