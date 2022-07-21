package com.cybertek.tests.practice.day09;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class actionsClass extends TestBase {

    //TC #15: Hover Test
    //1. Go to http://practice.cybertekschool.com/hovers
    //2. Hover over to first image
    //3. Assert:
    //a. “name: user1” is displayed
    //4. Hover over to second image
    //5. Assert:
    //a. “name: user2” is displayed
    //6. Hover over to third image
    //7. Confirm:
    //a. “name: user3” is displayed
    @Test
    public void hoverTest() {
        driver.get("http://practice.cybertekschool.com/hovers ");
        actions.moveToElement(hoverOnImage(1)).perform();
        WebElement name1 = driver.findElement(By.xpath("//h5[.='name: user1']"));
        Assert.assertTrue(name1.isDisplayed());
        actions.moveToElement(hoverOnImage(2)).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='name: user2']")).isDisplayed());
        actions.moveToElement(hoverOnImage(3)).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='name: user3']")).isDisplayed());

    }
    //TC #17: Context Click – HOMEWORK
    //1. Go to https://the-internet.herokuapp.com/context_menu
    //2. Right click to the box.
    //3. Alert will open.
    //4. Accept alert
    //No assertion needed for this practice.

    @Test
    public void contextClick(){
        driver.get("https://the-internet.herokuapp.com/context_menu ");
        WebElement box = driver.findElement(By.cssSelector("#hot-spot"));
        actions.contextClick(box).perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    //TC #16: Hover Test
    //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
    //2. Drag and drop the small circle to bigger circle.
    //3. Assert:
    //-Text in big circle changed to: “You did great!”
    @Test
    public void hoverTest23(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index ");
        WebElement sourceCircle = driver.findElement(By.id("draggable"));
        WebElement targetCircle = driver.findElement(By.id("droptarget"));
        actions.dragAndDrop(sourceCircle,targetCircle).perform();
        Assert.assertEquals(targetCircle.getText(),"You did great!");

    }

    @Test
    public void brows(){
        driver.get("https://www.google.ca");
    }


    public static WebElement hoverOnImage(int id){
        return Driver.getDriver().findElement(By.xpath("(//img[@alt='User Avatar'])["+id+"]"));
    }

}
