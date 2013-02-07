package json;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FieldSelectionServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://localhost:8080/CharityWare/REST/fieldSelectionService/json/selectionValues/1");

		String rawJson = driver.getPageSource();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		System.out.println(rawJson);
		List<String> actual = gson.fromJson(rawJson, List.class);

		String expected = "Male";
				
		assertEquals(expected, actual.get(0));

	}

}
