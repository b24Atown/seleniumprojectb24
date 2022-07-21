package com.cybertek.tests.day16_download_uploaded_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadTest extends TestBase {

    @Test
    public void fileDownloadTest(){
        driver.get(ConfigurationReader.getProperty("download.url"));
        WebElement somefile = driver.findElement(By.linkText("some-file.txt"));
        somefile.click();
        BrowserUtils.sleep(2);
        //verify that file is downloaded

        File file = new File(System.getProperty("user.home") + "/Downloads/some-file.txt");
        System.out.println("File exists = " + file.exists());

        Assert.assertTrue(file.exists(), "File download fail");
        //delete after verification complete
        file.delete();
    }

    @Test
    public void waitUntilDownloadTest() {
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement download = driver.findElement(By.linkText("5mb script.xml"));
        download.click();
        while (new File(System.getProperty("user.home") + "/Downloads/5mb script.xml").exists()==false){
            BrowserUtils.sleep(1);
        }
    }
}
