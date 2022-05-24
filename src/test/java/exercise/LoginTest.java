package exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends TasteBase {

    /*
a. http://a.testaddressbook.com adresine gidiniz.
b. Sign in butonuna basin
c. email textbox,password textbox, and signin button elementlerini locate ediniz..
d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:

i. Username : testtechproed@gmail.com
ii. Password : Test1234!

e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).

3. Sayfada kac tane link oldugunu bulun.
     */

    @Test
    public void test01() {
        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        // b. Sign in butonuna basin
        driver.findElement(By.id("sign-in")).click();

       // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //
        //i. Username : testtechproed@gmail.com
        //ii. Password : Test1234!
        WebElement email = driver.findElement(By.id("session_email"));
        email.sendKeys("testtechproed@gmail.com");
        WebElement password = driver.findElement(By.id("session_password"));
        password.sendKeys("Test1234!");
        driver.findElement(By.xpath("//input[@name='commit']")).click();

        // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        
        // 1.Yol
        String expectedUserId = "testtechproed@gmail.com";
        String actualUserId = driver.getTitle();
        // 2.Yol
        WebElement actualKullaniciAdi = driver.findElement(By.xpath("//span[@class='navbar-text']"));
        Assert.assertTrue(actualKullaniciAdi.isDisplayed());


        // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement addressesText = driver.findElement(By.xpath("//a[@data-test='addresses']"));
        Assert.assertTrue(addressesText.isDisplayed());
        WebElement signOutText = driver.findElement(By.xpath("//a[@data-test='sign-out']"));
        Assert.assertTrue(signOutText.isDisplayed());

        // 3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println(linklerListesi.size());
        linklerListesi.forEach(t-> t.getText());




    }
}
