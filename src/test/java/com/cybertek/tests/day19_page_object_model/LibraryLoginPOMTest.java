package com.cybertek.tests.day19_page_object_model;

import com.cybertek.pages.BookManagementPage;
import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LibraryLoginPOMTest extends TestBase {

    @Test
    public void invalidCredentialsTest(){
        driver.get(ConfigurationReader.getProperty("library.url"));
        LibraryLoginPage  loginPage = new LibraryLoginPage();
        loginPage.email.sendKeys("invalid_email@gmail.com");
        loginPage.password.sendKeys("randompwd12");
        loginPage.signInBtn.click();
        Assert.assertTrue(loginPage.errorMsg.isDisplayed());
    }

    @Test
    public void positiveLoginTest(){
        driver.get(ConfigurationReader.getProperty("library.url"));
        LibraryLoginPage loginPage = new LibraryLoginPage();
        loginPage.email.sendKeys(ConfigurationReader.getProperty("library3.student.email"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("library3.student.password"));
        loginPage.signInBtn.click();

        BrowserUtils.sleep(2);
        BookManagementPage bookManagementPage = new BookManagementPage();
        bookManagementPage.isCurrentPage();
        Assert.assertTrue(bookManagementPage.bookManagementHeader.isDisplayed());
    }
}
