import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TrendyolCepTlfArama {



     //a.google web sayfasına gidin. https://www.trendyol.com/
    //b. Search(ara) “lenovo”
    //C. İlk resme tıklayın

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.trendyol.com");
       WebElement aramaKutusu = driver.findElement(By.className("search-box"));
       aramaKutusu.sendKeys("cep telefonu" + Keys.ENTER);



    }
}
