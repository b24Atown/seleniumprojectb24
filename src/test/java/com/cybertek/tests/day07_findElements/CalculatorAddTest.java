package com.cybertek.tests.day07_findElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorAddTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.calculator.net";
        int num1 = 5, num2 = 3, expectedResult = 8;

        driver.get(url);
        //<span onclick="r(5)" class="scinm">5</span>

        WebElement num1Element = driver.findElement(By.xpath("//span[@onclick='r(5)']"));
        num1Element.click();
        //<span onclick="r('+')" class="sciop">+</span>
        WebElement plusElement = driver.findElement(By.xpath("//span[.='+']"));
        plusElement.click();
        WebElement num2Element = driver.findElement(By.cssSelector("span[onclick='r(3)']"));
        num2Element.click();
        WebElement equalElement = driver.findElement(By.xpath("//span[text()='=']"));
        equalElement.click();

        WebElement actualResult = driver.findElement(By.xpath("//div[@id='sciOutPut']"));

        System.out.println(num1 + " + " + num2 + " = " + actualResult.getText());
        String resultValue = actualResult.getText().trim();//had to trim  so we can use parseint  method. the gettext method above had an empty space printed so we had to get rid of it.
        int finalResult = Integer.parseInt(resultValue);

        if(finalResult == expectedResult){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        //driver.quit();
    }
}
