/**
 * 
 */
package json;

import static org.junit.Assert.*;
import hibernateEntities.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.google.gson.Gson;

/**
 * @author shounoy
 * 
 */
public class CharityDBUserNameTest {

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
		driver.get("http://localhost:8080/TEST_CharityWare/REST/charityLogin/CharityDB/hibernate.cfg.xml/userName/amartin");

		String rawJson = driver.getPageSource();
		Gson gson = new Gson();
		
		System.out.println(rawJson);
		
		User user = gson.fromJson(rawJson, User.class);
		System.out.println("aaa" + user.getUser_id());
		
//		Categories cotegories = gson.fromJson(rawJson, Categories.class);
//
//		categories.getCategories().get(0).getCategId();
//		categories.getCategories().get(0).getCategType();
	}

}