/**
 * 
 */
package json;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import hibernateEntities.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author shounoy
 * 
 */
public class EventServiceTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://localhost:8080/CharityWare/REST/eventService/json/events");

		String rawJson = driver.getPageSource();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		System.out.println(rawJson);
		Map<String, ArrayList<String>> map = gson.fromJson(rawJson, Map.class);
		System.out.println(map.values());
		System.out.println(map.keySet());

		String actualInt = "4";
		String expected = "Hope Carnival Party";
				
		assertEquals(expected, map.get(actualInt).get(1));

	}

}
