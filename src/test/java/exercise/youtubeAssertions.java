import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class youtubeAssertions {

  static WebDriver driver;

  @BeforeClass
    public static void setup() {
      WebDriverManager.chromedriver().setup();
      driver= new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
  }
  @AfterClass
    public static void tearDown() {
     // driver.close();
  }
  @Test
  public void titleTest() {
      driver.get("https://www.youtube.com");
      // titleTest => Sayfa başlığının "YouTube" tr oldugunu test edin
      String pageTitle = driver.getTitle();
      String expectedTitle = "YouTube";
      Assert.assertEquals("title test FAILED",pageTitle,expectedTitle);
    }
  @Test
    public void image() {
      // imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin


  }


}


















