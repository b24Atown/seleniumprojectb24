package com.cybertek.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OfficeUtils {

    static Alert alert;

    public static WebElement getLink(String str){
        return Driver.getDriver().findElement(By.partialLinkText(str));
    }

    public static int addProduct(String category, String product){
        getLink(category).click();
        getLink(product).click();
        //getting the products price
        WebElement priceContainer = Driver.getDriver().findElement(By.xpath("//h3"));
        int productsPrice = Integer.parseInt(priceContainer.getText().substring(1,4));
        //click on add to cart
        getLink("Add to cart").click();
        BrowserUtils.sleep(2);
        alert = Driver.getDriver().switchTo().alert(); //initialize alert method
        alert.accept();
        //going back to homepage
        getLink("Home").click();
        return productsPrice;

    }

    public static int removeProduct(String product){
        int productPrice = 0;
        productPrice+= Integer.parseInt(Driver.getDriver().findElement(By.xpath("//table//tr/td[contains(.,'"+product+"')]/../td[3]")).getText());
        Driver.getDriver().findElement(By.xpath("//table//tr/td[contains(.,'"+product+"')]/..//td[.='Delete']/a")).click();
        return productPrice;
    }


}
