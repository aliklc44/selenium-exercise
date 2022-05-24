package exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;

public class WindowHandle extends TasteBase {

    /*
    ● Yeni bir class olusturun: WindowHandle
● Amazon anasayfa adresine gidin.
● Sayfa’nin window handle degerini String bir degiskene atayin
● Sayfa title’nin “Amazon” icerdigini test edin
● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
● Sayfa title’nin “Walmart” icerdigini test edin
● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
     */
    @Test
    public void test01() {
        // ● Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");

        // ● Sayfa’nin window handle degerini String bir degiskene atayin
        String ilkSayfaWindowHandleDegeri = driver.getWindowHandle();

        // ● Sayfa title’nin “Amazon” icerdigini test edin
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // ● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        String ikinciSayfaWindowHandleDegeri = driver.getWindowHandle();

        // ● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String expectedIkinciTitle = "TECHPROEDUCATION";
        String actualIkinciTitle = driver.getTitle();

        // ● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.walmart.com");
        String ucuncuSayfaWindowHandleDegeri = driver.getWindowHandle();

        // ● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        WebElement logoTest = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoTest.isDisplayed());


    }

}
