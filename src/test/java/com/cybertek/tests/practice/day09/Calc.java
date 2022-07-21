package com.cybertek.tests.practice.day09;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Calc extends TestBase {

    @Test
    public void calcuTest(){
        driver.get("https://www.calculator.net");
        //add 124 + 432
        String firstNum = "124";
        String secondNum = "432";

        WebElement plus = driver.findElement(By.xpath("//span[.='+']"));
        WebElement equal = driver.findElement(By.xpath("//span[.='=']"));
        numbertoManipulate(firstNum);
        plus.click();
        numbertoManipulate(secondNum);
        equal.click();

        String result = driver.findElement(By.cssSelector("#sciOutPut")).getText();
        System.out.println(result.trim());
    }

    public static void numbertoManipulate(String one){
        for (int i = 0; i<one.length();i++){
            Driver.getDriver().findElement(By.xpath("//span[.='"+one.charAt(i)+"']")).click();
        }
    }
}
