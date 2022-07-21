package com.cybertek.tests.practice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calculator {

    public static void main(String[] args) {
        ////homework assignment - make selenium work for numbers more than 1 digit as well. so int num1 = 124, num2 = 90 etc. (will need loops, split).
        int num1 = 124, num2 = 90, result = num1+num2;
        String numberOne = Integer.toString(num1);
        String numberTwo = Integer.toString(num2);
        String resultofAdd = Integer.toString(result);



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.calculator.net";

        driver.get(url);
//<span onclick="r(1)" class="scinm">1</span>
        WebElement plus = driver.findElement(By.xpath("//span[text()='+']"));
        WebElement equals = driver.findElement(By.xpath("//span[text()='=']"));


        for (int i = 0; i<numberOne.length();i++){
            WebElement num = driver.findElement(By.xpath("//span[@onclick='r("+numberOne.charAt(i)+")']"));
            num.click();
        }
        plus.click();

        for (int i = 0; i < numberTwo.length();i++){
            WebElement nums = driver.findElement(By.xpath("//span[@onclick='r("+numberTwo.charAt(i)+")']"));
            nums.click();
        }
        equals.click();

        //<div id="sciOutPut">&nbsp;214</div>
        String result1 = driver.findElement(By.id("sciOutPut")).getText().trim();
        System.out.println(result);

        if(result1.equals(resultofAdd)){
            System.out.println("Pass: result is accurate");
        }else {
            System.out.println("Fail: result is inaccurate");
        }

    }
}
