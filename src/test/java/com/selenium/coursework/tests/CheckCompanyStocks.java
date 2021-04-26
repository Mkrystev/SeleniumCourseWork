package com.selenium.coursework.tests;

import com.opencsv.exceptions.CsvException;
import com.selenium.coursework.base.TestUtils;
import com.selenium.coursework.utils.CsvReader;
import com.selenium.coursework.yahoopages.FinanceStatistic;
import com.selenium.coursework.yahoopages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CheckCompanyStocks extends TestUtils {

    @DataProvider(name = "companyStocks-file")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/stocksCompany-dataProvider.csv");

    }

    @Test(dataProvider = "companyStocks-file")
    public void checkStatsForCompanyStocks(String companyName, String devP, String mrqP) {
        HomePage homePage = new HomePage(driver);
        FinanceStatistic amzApl = new FinanceStatistic(driver);
        WebDriverWait wait = new WebDriverWait(driver, 15);


        homePage.cookieWindowClick();
        homePage.searchField().sendKeys(companyName);
        homePage.searchBtnClick();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(amzApl.dividendAndYield()));

        String devs = amzApl.dividendAndYield().getText();
        amzApl.statistics().click();

        wait.until(ExpectedConditions.visibilityOf(amzApl.priceBook()));
        String mrq = amzApl.priceBook().getText();


        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(mrq, mrqP);
        softAssert.assertEquals(devs, devP);
        softAssert.assertAll();

        System.out.println("Test is executing.");


    }
}
