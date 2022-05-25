package JUnitPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q10_Iframe extends TasteBase {
    @Test
    public void test01() throws InterruptedException {

        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // web sitesini maximize yapin
        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//img[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        WebElement secondEmoji= driver.findElement(By.xpath("(//img[@class='emoji'])[2]"));
        secondEmoji.click();
        // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> emojiOgeler = driver.findElements(By.xpath("//div[@id='nature']"));
        emojiOgeler.stream().forEach(t-> t.click());
        Thread.sleep(3000);
        // parent iframe e geri donun
        driver.switchTo().parentFrame();

        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> textList = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String> text = new ArrayList<>(Arrays.asList("Bir", "iframe" , "sorusu", "bu", "kadar", "eglenceli", "olabilir","sizce de ", "oyle degil mi ?", "",""));
        for (int i=0; i< textList.size();i++){
            textList.get(i).sendKeys(text.get(i));
        }
        Thread.sleep(3000);

        //  apply button a basin
        driver.findElement(By.xpath("//button[@id='send']")).click();
    }



    }
