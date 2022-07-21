package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_ForgotPassword_xpath_css {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url= "http://practice.cybertekschool.com/forgot_password";
        driver.get(url);

        //<a class="nav-link" href="/">Home</a> (link)
        WebElement home = driver.findElement(By.xpath("//a[@class = 'nav-link']"));
        //<h2>Forgot Password</h2>
        WebElement forgotPassword = driver.findElement(By.xpath("//h2[.= 'Forgot Password']"));
        //<label for="email">E-mail</label>
        WebElement email = driver.findElement(By.xpath("//label[text()='E-mail']"));
        //<input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required="">
        WebElement emailInput = driver.findElement(By.xpath("//input[@name ='email']"));
        //<i class="icon-2x icon-signin">Retrieve password</i>
        WebElement retrievePassword = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        //<a target="_blank" href="https://cybertekschool.com/">Cybertek School</a>
        WebElement cyberTekButton = driver.findElement(By.xpath("//a[@target='_blank' ]"));

        System.out.println("homeLink = " + home.isDisplayed());
        System.out.println("forgotPassword = " + forgotPassword.isDisplayed());
        System.out.println("email = " + email.isDisplayed());
        System.out.println("emailInput = " + emailInput.isDisplayed());
        System.out.println("retrievePassword = " + retrievePassword.isDisplayed());
        System.out.println("cyberTekButton = " + cyberTekButton.isDisplayed());

        driver.quit();




    }
}
