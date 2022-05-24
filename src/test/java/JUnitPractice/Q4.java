package JUnitPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q4 {

    /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted

    1.method : createButtons(100)
    2.deleteButtonsAndValidate()
 */
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown() {
      //  driver.close();
    }
    @Test
    public void test01() {
        driver.get("https://he-internet.herokuapp.com/add_remove_elements/");

            // click on the "Add Element" button 100 times
            createButtons(100);
            // write a function that takes a number, and clicks the "Delete" button
            deleteButtonsAndValidate();
        }

        private void deleteButtonsAndValidate() {
            int silinecekDeleteSayisi = 100;
            while (silinecekDeleteSayisi > 0) {
                driver.findElement(By.xpath("(//button[@onclick='deleteElement()'])[" + silinecekDeleteSayisi + "]")).click();
                silinecekDeleteSayisi--;
            }
            System.out.println(100 - (driver.findElements(By.xpath("(//button[@class='added-manually'])")).size()) + " tane delete tusu silindi");
        }

        private void createButtons(int x) {
            WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
            for (int i = 0; i <= 99; i++) {
                addElementButton.click();
            }
        }
    }


