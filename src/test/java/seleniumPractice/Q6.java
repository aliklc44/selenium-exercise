package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q6 {
      /*
    // ...Exercise6...
    1.  https://id.heroku.com/login sayfasina gidin
    2.  Bir mail adersi giriniz
    3.  Bir password giriniz
    4.  Login butonuna tiklayiniz
    5.  "There was a problem with your login." texti gorunur ise
    6.  "kayit yapilamadi" yazdiriniz
    8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
    9.  Tum sayfalari kapatiniz

     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1.  https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");
        //2.  Bir mail adersi giriniz
        WebElement emailTextBox=driver.findElement(By.xpath("//input[@class='form-control']"));
        emailTextBox.sendKeys("abcdfgh@gmail.com");
        //3.  Bir password giriniz
        WebElement passwordBox= driver.findElement(By.xpath("//input[@autocomplete='off']"));
        passwordBox.sendKeys("123456asd");
        //4.  Login butonuna tiklayiniz
        WebElement loginButonu=driver.findElement(By.xpath("//button[@name='commit']"));
        loginButonu.submit();
        //5.  "There was a problem with your login." texti gorunur ise
        //6.  "kayit yapilamadi" yazdiriniz
        //8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        //9.  Tum sayfalari kapatiniz
        WebElement gorunenText=driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        if (gorunenText.isDisplayed()){
            System.out.println("kayit yapilamadi");
        }else{
            System.out.println("kayit yapildi");
        }
        driver.close();
    }
}
