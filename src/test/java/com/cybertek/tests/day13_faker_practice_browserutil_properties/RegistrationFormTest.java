package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RegistrationFormTest extends RegistrationFormTestBase{

    Faker faker = new Faker();

    @Test
    public void formTest(){
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys(faker.name().lastName());

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys(faker.name().lastName().replace(".",""));

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(faker.internet().password());

        WebElement mobile = driver.findElement(By.name("phone"));
        mobile.sendKeys(faker.phoneNumber().cellPhone().replace("(","").replace(")","").replace(".","-"));

        WebElement gender = driver.findElement(By.xpath("//*[@value='male']"));
        gender.click();

        WebElement birthday = driver.findElement(By.name("birthday"));
        birthday.sendKeys("01/01/2019");

        Select department = new Select(driver.findElement(By.name("department")));
        department.selectByIndex(faker.number().numberBetween(1,8));

        Select jobtitle = new Select(driver.findElement(By.name("job_title")));
        jobtitle.selectByIndex(faker.number().numberBetween(1,8));

        List<WebElement> languages = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement each: languages){
            each.click();
        }

        WebElement signup = driver.findElement(By.id("wooden_spoon"));
        signup.click();

        Assert.assertEquals(driver.findElement(By.tagName("h4")).getText(),"Well done!");
        Assert.assertTrue(driver.findElement(By.tagName("h4")).isDisplayed());//could be different wording so were checking that it just displays

    }

}
