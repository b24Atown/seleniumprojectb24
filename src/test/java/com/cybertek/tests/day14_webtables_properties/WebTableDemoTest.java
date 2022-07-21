package com.cybertek.tests.day14_webtables_properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTableDemoTest {

    String url = "http://practice.cybertekschool.com/tables";
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void readFromTableTest() {
        // print table data as a single String, not so common but useful sometimes.
        WebElement table1 = driver.findElement(By.id("table1"));
        System.out.println("Table 1 text = " + table1.getText());
        //this would be useful if all you wanted to do is verify smith john for example is in the table somewhere
        Assert.assertTrue(table1.getText().contains("Smith John"));
        //print all column names
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));
        for (WebElement eachColumn: columnNames){
            System.out.println("Column name - " + eachColumn.getText());
        }
        System.out.println("Column count = " + columnNames.size());

        //print first cool and first cell data
        WebElement firstRowCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]"));
        System.out.println("FirstRowCell = " + firstRowCell.getText());
        System.out.println("col 1 , row 4 = " + getCellData(1,4));
        System.out.println("col 3 , row 3 = " + getCellData(3,3));
    }

    public String getCellData(int row, int col){
      return driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+row+"]/td["+col+"]")).getText();

    }

    @Test
    public void getAllColumnData(){
        //print all names
        List<WebElement> names = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        List<WebElement> emails =driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
        for (int i = 0; i<names.size();i++){
            System.out.println(i+1 + " - " + names.get(i).getText() + " " + emails.get(i).getText());
        }
    }

    @Test
    public void printAllTableDataTests(){
        //get rows count and assign to rowsCount
        int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        int columnCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();
        for (int i = 1; i<=rowCount;i++){
            for (int j = 1; j<=columnCount; j++){
                String value = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.println("value = " + value);
            }
        }
    }

    @Test
    public void readingNeighborCell(){
        WebElement johnEmail = driver.findElement(By.xpath("//table[@id='table1']//td[.='John']/following-sibling::td[1]"));
        System.out.println("John's email = " + johnEmail.getText());
        WebElement johnsLastName = driver.findElement(By.xpath("//table[@id='table1']//td[.='John']/preceding-sibling::td[1]"));
        System.out.println("Last name = " + johnsLastName.getText());
    }
}
