package com.cybertek.tests.day07_findElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorAddTestV2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.calculator.net";
        int num1 = 7, num2 = 5, expectedResult = num1+num2;

        driver.get(url);
        //<span onclick="r(7)" class="scinm">7</span>
        System.out.println("//span[.='7']");
        WebElement num1Element = driver.findElement(By.xpath("//span[.='"+num1+"']"));
        WebElement num2Element = driver.findElement(By.cssSelector("span[onclick='r("+num2+")']")); //span[onclick='r(5)']
        //reason why we did it with the variable is because everything is the same on this page so we can make it dynamic and only have to change the variable for it to all work. The only thing changing is onclick.
        WebElement plusSign = driver.findElement(By.xpath("//span[.='+']"));
        WebElement equalSign = driver.findElement(By.xpath("//span[.='=']"));

        num1Element.click();
        plusSign.click();
        num2Element.click();
        equalSign.click();

        WebElement result = driver.findElement(By.xpath("//div[@id='sciOutPut']"));
        String actualResult = result.getText().trim();
        int finalResult = Integer.parseInt(actualResult);
        System.out.println(finalResult);

        if(finalResult==expectedResult){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        driver.quit();

        //homework assignment - make selenium work for numbers more than 1 digit as well. so int num1 = 124, num2 = 90 etc. (will need loops, split).

    }
}
