import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YanlisEmailTesti {

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
       driver.close();
    }

    @Test
    public void test01() {
        //1.
        //http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php ");

        //Sign in butonuna basalim
        driver.findElement(By.xpath("// a[@class='login']")).click();

        //Email kutusuna @isareti olmayan bir mail yazip enter’a
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("kılıcgmail.com" + Keys.ENTER);
        //bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        WebElement uyari = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(uyari.isDisplayed());


    }











    }

