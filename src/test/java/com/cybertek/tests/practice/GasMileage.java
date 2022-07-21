package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GasMileage {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.calculator.net ";
        driver.get(url);
        //<input type="text" name="calcSearchTerm" id="calcSearchTerm" class="inlongest" onkeyup="return calcSearch();" onfocus="document.onkeydown=null;">
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='calcSearchTerm']"));
        searchBox.sendKeys("gas mileage");
        //<a href="/gas-mileage-calculator.html">Gas Mileage Calculator</a>
        WebElement gasMil = driver.findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
        gasMil.click();
        String expectedTitle = "Gas Mileage Calculator";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Pass: title verification successufl");
        }else {
            System.out.println("Fail: title verification failed");
        }
        //<h1>Gas Mileage Calculator</h1>
        WebElement label = driver.findElement(By.tagName("h1"));
        System.out.println(label.isDisplayed());

        //<input type="text" name="mucodreading" id="mucodreading" value="18900" class="inlong" onkeyup="iptfieldCheck(this, 'r', 'pn');">

        WebElement currOdomReading = driver.findElement(By.name("mucodreading"));
        currOdomReading.clear();
        currOdomReading.sendKeys("7925");
//<input type="text" name="mupodreading" id="mupodreading" value="18300" class="inlong" onkeyup="iptfieldCheck(this, 'r', 'pn');">
        WebElement prevOdomReading = driver.findElement(By.cssSelector("input[name='mupodreading']"));
        prevOdomReading.clear();
        prevOdomReading.sendKeys("7550");
        //<input type="text" name="mugasputin" id="mugasputin" value="50" class="inlong" onkeyup="iptfieldCheck(this, 'r', 'pn');">
        WebElement gasAdded = driver.findElement(By.id("mugasputin"));
        gasAdded.clear();
        gasAdded.sendKeys("16");
        //<input type="text" name="mugasprice" id="mugasprice" value="1" class="inlong indollar" onkeyup="iptfieldCheck(this, '', 'pn');">
        WebElement gasPrice = driver.findElement(By.xpath("//input[@name='mugasprice']"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");
        //<input type="image" src="//d26tpo4cm8sb6k.cloudfront.net/img/svg/calculate.svg" value="Calculate" alt="Calculate" style="margin-top:10px;">
        WebElement calculateButton = driver.findElement(By.xpath("//*[@id='metric']/tbody/tr[5]/td/input"));
        calculateButton.click();

        //<p class="verybigtext" style="padding-top:10px;">Gas mileage: <font color="green"><b>23.44 km/L  or 4.27  L/100 km </b></font> <span class="bigtext">(55.13 mpg)</span></p>
        String value = driver.findElement(By.xpath("//p[@class='verybigtext']")).getText();
        System.out.println(value);



    }
}
