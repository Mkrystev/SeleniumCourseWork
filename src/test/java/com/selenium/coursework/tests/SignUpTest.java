package com.selenium.coursework.tests;

import com.opencsv.exceptions.CsvException;
import com.selenium.coursework.base.TestUtils;
import com.selenium.coursework.utils.CsvReader;
import com.selenium.coursework.yahoopages.HomePage;
import com.selenium.coursework.yahoopages.LoginPage;
import com.selenium.coursework.yahoopages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class SignUpTest extends TestUtils {

    @DataProvider(name = "signUp-invalidData-file")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/signUp-invalidData.csv");

    }

    @Test(dataProvider = "signUp-invalidData-file")
    public void negativeDataRegistration(String firstName, String lastName, String emailAddress, String phNumber, String pass, String day, String year, String gender) {


        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 15);

        homePage.cookieWindow().click();
        homePage.signInBtn().click();
        loginPage.createAccBtn().click();

        //Populating the data from the CSV

        signUpPage.firstNameInputField().sendKeys(firstName);
        signUpPage.lastNameInputField().sendKeys(lastName);
        signUpPage.emailInputField().sendKeys(emailAddress);
        signUpPage.passwordInputField().sendKeys(pass);
        signUpPage.phoneNumberInputField().sendKeys(phNumber);


        Select list = new Select(signUpPage.selectBirthMonth());
        list.selectByValue("7");

        signUpPage.birthDayInput().sendKeys(day);
        signUpPage.birthYearInout().sendKeys(year);
        signUpPage.genderInputField().sendKeys(gender);

        String emailMsg = driver.findElement(By.id("reg-error-yid")).getText();
        String passMsg = driver.findElement(By.id("reg-error-password")).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reg-error-phone")));
        String phoneMsg = driver.findElement(By.id("reg-error-phone")).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reg-error-birthDate")));
        String bDayMsg = driver.findElement(By.id("reg-error-birthDate")).getText();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(emailMsg, "That email address is too short, please use a longer one.");
        softAssert.assertEquals(passMsg, "Your password isn’t strong enough, try making it longer.");
        softAssert.assertEquals(phoneMsg, "That doesn’t look right, please re-enter your phone number.");
        softAssert.assertEquals(bDayMsg, "That doesn’t look right, please re-enter your birthday.");

        System.out.println("Wait for execution.");
        softAssert.assertAll();
    }
}
