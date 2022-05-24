import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {

    public static void main(String[] args) {
 /*Main method oluşturun ve aşağıdaki görevi tamamlayın.
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
        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com ");

        // Sign in butonuna basin
        WebElement signInButon=driver.findElement(By.id("sign-in"));
        signInButon.click();

        //  c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailTextBox=driver.findElement(By.name("session[email]"));

        WebElement passwordTextBox=driver.findElement(By.id("session_password"));

        WebElement signInButton=driver.findElement(By.name("commit"));

        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //        i. Username : testtechproed@gmail.com
        //        ii. Password : Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        signInButton.click();

        //  e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        String expectedKullniciAdi = "testtechproed@gmail.com";
        WebElement actualKullaniciAdi = driver.findElement(By.className("navbar-text"));
        System.out.println(actualKullaniciAdi.getText());
        if(expectedKullniciAdi.equals(actualKullaniciAdi.getText())){
            System.out.println("istenen kullanici adi PASSED");
        }else{
            System.out.println("istenen kullanici adi FAILED");
        }

       // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement addressesText = driver.findElement(By.linkText("Addresses"));
        WebElement signOutText = driver.findElement(By.linkText("Sign out"));

        if(addressesText.isDisplayed()){
            System.out.println("addresses testi PASSED");
        }else{
            System.out.println("addresses testi FAILED");
        }
        if(signOutText.isDisplayed()){
            System.out.println("signout testi PASSED");
        }else{
            System.out.println("signout testi FAILED");
        }

        //3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("linklerListesi = " + linklerListesi.size());

        for (WebElement each:linklerListesi
             ) {
            System.out.println(each.getText());

        }
        driver.close();


// yeni





    }
}
