package com.cybertek.tests.practice.bestbuy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BestBuy {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://www.bestbuy.ca");
        //<input type="search" class="textField_XaJoz" data-automation="x-search-input" autocomplete="off" name="search" value="" placeholder="Search Best Buy" aria-label="Search Best Buy">
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
        searchBox.sendKeys("PS5 Console" + Keys.ENTER);
       // <div class="productItemName_3IZ3c" itemprop="name" data-automation="productItemName">PlayStation 5 Console</div>
        Thread.sleep(2000);
        WebElement ps5 = driver.findElement(By.xpath("//div[@class='productItemName_3IZ3c']"));
        ps5.click();
        //<button class="button_E6SE9 primary_1oCqK addToCartButton_3xB7V addToCartButton regular_1jnnf" type="submit"><span class="content_3Dbgg" tabindex="-1"><div class="addToCartLabel_YZaVX"><svg class="black_3d_RE cartIcon_2K5oG icon_q2ZYd" viewBox="0 0 32 32"><path d="M26.8,26.22a1.91,1.91,0,1,1-1.91-1.95h.17a1.72,1.72,0,0,1,1.74,2Zm-15.15,2a2,2,0,1,1,1.9-2A1.93,1.93,0,0,1,11.65,28.17Zm-1.3-8.59h16.1a.91.91,0,0,0,.87-.7L30,7.51a1,1,0,0,0-.17-.78.9.9,0,0,0-.71-.35H10.39a.92.92,0,0,0,0,1.84H28l-2.23,9.53H10.35l-.18,0-3.23-15A.91.91,0,0,0,6.06,2H2.9a.92.92,0,0,0,0,1.83H5.34L8.47,18.39a3.27,3.27,0,0,0,.33,5.45A3.8,3.8,0,0,0,8,26.22a3.7,3.7,0,1,0,7.39,0,3.82,3.82,0,0,0-.55-2h7a3.82,3.82,0,0,0-.54,2,3.7,3.7,0,1,0,7.39,0A3.57,3.57,0,0,0,27.05,23a4,4,0,0,0-2.06-.6H10.35a1.43,1.43,0,0,1,0-2.85Z"></path></svg>Add to Cart</div></span></button>
        Thread.sleep(2000);
        WebElement addToCart = driver.findElement(By.xpath("//img[@alt='PlayStation 5 DualSense Wireless Controller - White']"));
        addToCart.click();
    }
}
