package JUnitPractice;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Q08_ExplicitlyWait extends TasteBase{
    @Test
    public void test01() {


    //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
    //maximize the window
    //click on action dialog button
        driver.findElement(By.xpath("//button[@id='action']")).click();
    //if need use explicitly wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@type='button']"))));
        WebElement textMesaj = driver.findElement(By.xpath("//p[@class='text-info']"));
        Assert.assertTrue(textMesaj.isDisplayed());

    //click on the ok button
        driver.findElement(By.xpath("//button[@type='button']")).click();

    //accept the alert message
        driver.switchTo().alert().accept();


    }

}


