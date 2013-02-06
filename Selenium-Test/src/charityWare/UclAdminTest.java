package charityWare;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UclAdminTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8081/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUclAdmin() throws Exception {
		driver.get(baseUrl + "/jscoverage.html");
		driver.findElement(By.id("location")).clear();
		driver.findElement(By.id("location")).sendKeys(
				"http://localhost:8081/uclAdmin.html");

		driver.findElement(By.id("openInFrameButton")).click();
		
		driver.switchTo().frame(driver.findElement(By.id("browserIframe")));

		WebElement myDynamicElement = (new WebDriverWait(driver, 1))
				.until(new ExpectedCondition<WebElement>() {
					@Override
					public WebElement apply(WebDriver d) {
						return d.findElement(By.id("tab_1"));
					}
				});

		driver.findElement(By.id("tab_1")).click();
		driver.findElement(By.id("tab_2")).click();
		driver.findElement(By.id("tab_3")).click();
		
		// Switch back to the main document
        driver.switchTo().defaultContent();
        
        JavascriptExecutor js = (JavascriptExecutor)driver;
        
        // First select the tab by running the relevant script
        js.executeScript("jscoverage_selectTab('summaryTab');");
        // Then update the coverage information
        js.executeScript("jscoverage_recalculateSummaryTab();");
        
        // Finally read the total coverage
        WebElement total = driver.findElement(By.xpath("//span[starts-with(@id, 'summaryTotal')]"));
        System.out.println("Total coverage:" + total.getText());
		
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alert.getText();
		} finally {
			acceptNextAlert = true;
		}
	}
}
