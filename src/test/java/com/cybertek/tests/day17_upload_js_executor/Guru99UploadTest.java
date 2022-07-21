package com.cybertek.tests.day17_upload_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guru99UploadTest extends TestBase {

    @Test
    public void guru99UploadTest(){
        driver.get(ConfigurationReader.getProperty("guru99upload.url"));
        WebElement chooseFile = driver.findElement(By.id("uploadfile_0"));
        chooseFile.sendKeys(System.getProperty("user.home") + "/Downloads/some-file.txt");
        WebElement acceptTerms = driver.findElement(By.id("terms"));
        acceptTerms.click();
        WebElement sublitFile = driver.findElement(By.id("submitbutton"));
        sublitFile.click();
        //verify upuload successful by checking for "1 file
        //has been successfully uploaded." msg
        BrowserUtils.sleep(1);
        WebElement uploadMSG = driver.findElement(By.id("res"));
        Assert.assertEquals(uploadMSG.getText(),"1 file\nhas been successfully uploaded.");
    }

}
