package html_form_test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class negative_form_test {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "D:\\test_enviroment\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://s.codepen.io/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled2() throws Exception {
    driver.get(baseUrl + "/JennyGeryak/debug/qqXrBJ/LQMExVzXjeJk");
    driver.findElement(By.name("fullname")).clear();
    driver.findElement(By.name("fullname")).sendKeys("Jane Geryak");
    new Select(driver.findElement(By.name("day"))).selectByVisibleText("6");
    new Select(driver.findElement(By.name("month"))).selectByVisibleText("April");
    new Select(driver.findElement(By.name("year"))).selectByVisibleText("1997");
    driver.findElement(By.id("female")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("janegeryak@gmail.com");
    driver.findElement(By.cssSelector("input[type=\"tel\"]")).clear();
    driver.findElement(By.cssSelector("input[type=\"tel\"]")).sendKeys("0999043098");
    driver.findElement(By.id("music")).click();
    driver.findElement(By.id("books")).click();
    driver.findElement(By.name("about_me")).clear();
    driver.findElement(By.name("about_me")).sendKeys("some information about me");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
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
  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}