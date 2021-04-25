package com.selenium.coursework.yahoopages;

import com.selenium.coursework.utils.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}