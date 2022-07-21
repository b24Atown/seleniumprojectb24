package com.cybertek.tests.practice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.amazon.ca";
        driver.get(url);
        String title = driver.getTitle();
        System.out.println(title);
        String webUrl = driver.getCurrentUrl();
        System.out.println(webUrl);
        //<a href="/Best-Sellers-generic/zgbs/?ref_=nav_cs_bestsellers_5e07a0361d744326ae799da4b354adca" class="nav-a  " tabindex="0" data-csa-c-type="link" data-csa-c-slot-id="nav_cs_0" data-csa-c-content-id="nav_cs_bestsellers_5e07a0361d744326ae799da4b354adca" data-csa-c-id="nwx5e6-4sq3wq-xcgrcu-bte0eh">Best Sellers</a>
        Thread.sleep(2000);
        WebElement bestSeller = driver.findElement(By.linkText("Best Sellers"));
        bestSeller.click();
        //<img alt="Ships from Canada- Pack of 50 Disposable Face Masks, 3-Ply, Ear Loop. Protective, breathable, dust-proof, 3 layer mask. Non-M" src="https://images-na.ssl-images-amazon.com/images/I/61Pi-xruMeL._AC_UL675_SR675,480_.jpg" class="a-dynamic-image p13n-sc-dynamic-image p13n-product-image" height="160px" data-a-dynamic-image="{&quot;https://images-na.ssl-images-amazon.com/images/I/61Pi-xruMeL._AC_UL225_SR225,160_.jpg&quot;:[225,160],&quot;https://images-na.ssl-images-amazon.com/images/I/61Pi-xruMeL._AC_UL450_SR450,320_.jpg&quot;:[450,320],&quot;https://images-na.ssl-images-amazon.com/images/I/61Pi-xruMeL._AC_UL675_SR675,480_.jpg&quot;:[675,480]}" style="max-width:225px;max-height:160px">
        WebElement pack = driver.findElement(By.xpath("//img[@class='a-dynamic-image p13n-sc-dynamic-image p13n-product-image']"));
        pack.click();
        // <span id="productTitle" class="a-size-large product-title-word-break">
        String otherTitle = driver.findElement(By.id("productTitle")).getText();
        System.out.println(otherTitle);





    }
}
