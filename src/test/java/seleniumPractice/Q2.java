package seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {

    //  ...Exercise2...
//  1-driver olusturalim
//  2-java class'imiza chromedriver.exe'yi tanitalim
//  3-driver'in tum ekrani kaplamasini saglayalim
//  4-driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
//    söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
//  5-"sahibinden.com" adresine gidelim
//  6-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
//  7-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
//  8-Ardindan "gittigidiyor.com" adresine gidelim
//  9-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini
//    kontrol edelim
//  10-Bi onceki web sayfamiza geri donelim
//  11-sayfayi yenileyelim
//  12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
//  13-En son adim olarak butun sayfalarimizi kapatmis olalim

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  5-"sahibinden.com" adresine gidelim
        driver.get("https://www.sahibinden.com");
        Thread.sleep(10000);

        //  6-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
        String sahibindeTitle = driver.getTitle();
        System.out.println("sahibindeTitle : " + sahibindeTitle);

        String sahibindenUrl = driver.getCurrentUrl();
        System.out.println("sahibindenUrl : " + sahibindenUrl);

        //  7-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        if(sahibindeTitle.contains("Oto") && sahibindenUrl.contains("Oto")){
            System.out.println("oto yazisi vardir");
        }else{
            System.out.println("oto yazisi yoktur");

            //  8-Ardindan "gittigidiyor.com" adresine gidelim
            driver.get("https://gittigidiyor.com");
            System.out.println(driver.getTitle());

            //  9-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini
//    kontrol edelim
            boolean isTrue = driver.getTitle().contains("Sitesi");
            if(isTrue) System.out.println("Test PASSED");
            else System.out.println("Test FAILED");

            //  10-Bi onceki web sayfamiza geri donelim
             driver.navigate().back();

            //  11-sayfayi yenileyelim
             driver.navigate().refresh();

            //  12-Daha sonra web sayfamiza tekrar donelim
             driver.navigate().forward();

             // ve oldugumuz sayfayi kapatalim
             driver.close();

            //  13-En son adim olarak butun sayfalarimizi kapatmis olalim
             driver.quit();

        }

    }
}
