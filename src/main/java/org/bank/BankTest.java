package org.bank;
import Core.BrowserHelper;
import Core.ReadDataFromExcel;
import Searchpage.AddCustomerPage;
import Searchpage.Customerpage;
import Searchpage.OpenAccountPage;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.acl.Group;
import java.util.List;

import static java.sql.Types.NUMERIC;
import static org.codehaus.groovy.syntax.Types.STRING;


public class BankTest {

    //public static void main(String[] args) throws InterruptedException {
@Test
    public void testingFirefox() throws IOException, InterruptedException {
        ReadDataFromExcel RD1= new ReadDataFromExcel();

        BrowserHelper B1 =new BrowserHelper();
        WebDriver driver =B1.firefox();
        AddCustomerPage a1= new AddCustomerPage(driver);
        a1.AddCustomer(RD1.ReadData(0), RD1.ReadData(1), RD1.ReadData(2));
        a1.AddCustomer(RD1.ReadData(3), RD1.ReadData(4), RD1.ReadData(5));
        a1.AddCustomer(RD1.ReadData(6), RD1.ReadData(7), RD1.ReadData(8));

    List<WebElement> links = driver.findElements(By.tagName("link"));

    System.out.println("Total links are: "+links.size());
    for (WebElement link: links) {
        System.out.println("Links are: "+link.getAttribute("href"));
    }

  }
    }







