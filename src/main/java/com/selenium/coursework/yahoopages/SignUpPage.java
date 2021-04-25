package com.selenium.coursework.yahoopages;

import com.selenium.coursework.utils.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BaseDriver {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "usernamereg-firstName")
    private WebElement firstNameInputField;

    @FindBy(id = "usernamereg-lastName")
    private WebElement lastNameInputField;

    @FindBy(id = "usernamereg-yid")
    private WebElement emailInputField;

    @FindBy(id = "usernamereg-phone")
    private WebElement phoneNumberInputField;

    @FindBy(id = "usernamereg-password")
    private WebElement passwordInputField;

    @FindBy(id = "usernamereg-month")
    private WebElement selectBirthMonth;

    @FindBy(css = "#usernamereg-day")
    private WebElement birthDayInput;

    @FindBy(css = "#usernamereg-year")
    private WebElement birthYearInput;

    @FindBy(css = "#usernamereg-freeformGender")
    private WebElement genderInputField;

    @FindBy(id = "reg-error-yid")
    private WebElement emailErrMsg;

    @FindBy(id = "reg-error-password")
    private WebElement passErrMsg;

    @FindBy(id = "reg-error-phone")
    private WebElement phErrMsg;

    @FindBy(id = "reg-error-birthDate")
    private WebElement bDayErrMsg;


    public WebElement emailInputField() {
        return emailInputField;
    }
    public WebElement firstNameInputField() {
        return firstNameInputField;
    }
    public WebElement lastNameInputField() {
        return lastNameInputField;
    }
    public WebElement phoneNumberInputField() {
        return phoneNumberInputField;
    }
    public WebElement passwordInputField() {
        return passwordInputField;
    }
    public WebElement selectBirthMonth() {
        Select list = new Select(selectBirthMonth);
        list.selectByValue("7");
        return selectBirthMonth;
    }
    public WebElement birthDayInput() {
        return birthDayInput;
    }
    public WebElement birthYearInout() {
        return birthYearInput;
    }
    public WebElement genderInputField() {
        return genderInputField;
    }
    public WebElement getEmailErrMsg(){
        return emailErrMsg;
    }
    public WebElement getPassErrMsg(){
        return passErrMsg;
    }
    public WebElement getPhErrMsg(){
        return phErrMsg;
    }
    public WebElement getBDayErrMsg(){
        return bDayErrMsg;
    }

}
