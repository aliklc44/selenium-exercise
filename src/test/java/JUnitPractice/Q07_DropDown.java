package JUnitPractice;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Q07_DropDown extends TasteBase {

    @Test
    public void test01() {
        // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        //-->Task1 Find Dropdown on Multi Selection
        WebElement multiSelection = driver.findElement(By.xpath("//input[@id='justAnInputBox']"));
        Select select = new Select(multiSelection);

        //-->Task2 Find  all Dropdown Elements on page
        List<WebElement> kategori = driver.findElements(By.xpath("//input[@id='justAnInputBox']"));
        kategori.forEach(t-> System.out.println(t.getText()));

        //-->Task3 printout DropDown Elements' number

        //-->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6
    }
}
