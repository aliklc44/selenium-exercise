package exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class WindowHandle2 extends TasteBase{
    /*
    Tests package’inda yeni bir class olusturun: WindowHandle2
● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
doğrulayın.
     */
    @Test
    public void test01() {
        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.xpath("//h3"));
        String expectedText = "Opening a new window";
        String actualText = text.getText();
        Assert.assertEquals(expectedText,actualText);

        // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        String ilkSayfaWindowHandleDegeri = driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandleDegeri);


        // ● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@target='_blank']")).click();

        Set<String> handleSeti = driver.getWindowHandles();
        System.out.println(handleSeti);
        String ikinciSayfaWindowHandleDegeri = "";

        for (String each:handleSeti
        ) {
            if(!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;

                driver.switchTo().window(ikinciSayfaWindowHandleDegeri);

        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedYeniTitle = "New Window";
        String actualYeniTitle = driver.getTitle();
        Assert.assertEquals(expectedYeniTitle,actualYeniTitle);

        // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement textYeni = driver.findElement(By.xpath("(//*[text()='New Window'])[2]"));
        String expectedYeniText = "New Window";
        String actualYeniText = textYeni.getText();
        Assert.assertEquals(expectedYeniText,actualYeniText);

        // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        //doğrulayın.


                driver.switchTo().window(ilkSayfaWindowHandleDegeri);

                expectedTitle = "The Internet";
                actualTitle = driver.getTitle();
                Assert.assertEquals(expectedTitle,actualTitle);


            }

        }






    }
}
