package com.cybertek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableUtils {

    public static boolean verifyOrder(WebDriver driver,String name){

        WebElement sd = driver.findElement(By.xpath("//table[@id='table1']"));
        return sd.getText().contains(name);
    }

    public static void printNamesAndEmails (WebDriver driver){
        List <WebElement> names = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        List <WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));

        for (int i = 0; i<names.size();i++){
            System.out.println("Name"+ (i+1) + ": " + names.get(i).getText() + ", Email" + (i+1) + ": " + emails.get(i).getText());
        }
    }

    public static String getCellData(WebDriver driver, String tableXpath, int row, int column){
        String x = tableXpath + "/tbody/tr["+row+"]/td["+column+"]";
        WebElement elem = driver.findElement(By.xpath(x));
        return  elem.getText();
    }
}
