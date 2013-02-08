package json;

import static org.junit.Assert.*;

import hibernateEntities.FormFields;
import hibernateEntities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericEntity;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * @author Zhe Wei
 * 
 */
public class FormFieldsServiceTest {

	@Test
	public void test_1() {
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://localhost:8080/CharityWare/REST/formFieldsService/json/formFields/1");

		String rawJson = driver.getPageSource(); //get the source of the last loaded page,
												 //a representation of the underlying DOM
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		System.out.println(rawJson);
		// {"1":["Name","Text","String","true"],"2":["Surname","Text","String","true"],"3":["Gender","Text","String","true"],"7":["Hometown","Text","String","true"]}
		// field_id : [field_label, field_type, field_dataType, isActive]
		

		Map<Integer,List<String>> map = gson.fromJson(rawJson, Map.class);
		// GenericEntity is in jersey-core-1.17.jar

		String expected1 = "Name";
		String expected2 = "Text";
		String expected3 = "String";
		String expected4 = "true";
		
		// map.get(new Integer(1)) doesnt work, but map.get("1") does, why?????
		assertEquals(expected1, map.get("1").get(0));
		assertEquals(expected2, map.get("2").get(1));
		assertEquals(expected3, map.get("3").get(2));
		assertEquals(expected4, map.get("7").get(3));
	}
	
	@Test
	public void test_2() {
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://localhost:8080/CharityWare/REST/formFieldsService/json/formFields/2");

		String rawJson = driver.getPageSource();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		System.out.println(rawJson);
		// {"4":["Age","Text","String","true"],"8":["Ethnicity","Text","String","true"]}
		// field_id : [field_label, field_type, field_dataType, isActive]
		

		Map<Integer,List<String>> map = gson.fromJson(rawJson, Map.class);

		String expected1 = "Age";
		String expected2 = "Ethnicity";


		assertEquals(expected1, map.get("4").get(0));
		assertEquals(expected2, map.get("8").get(0));
	}
	
}